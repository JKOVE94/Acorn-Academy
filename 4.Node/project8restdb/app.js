//메인

import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';
import sangRoute from './sangdataRoute.js';

const app = express();
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
    res.send('출발  /sangdata, /sagndata/1 ...');
})

app.use('/sangdata', sangRoute);

app.set('port', process.env.PORT || 3001);
const startServer = (app) => {
    app.listen(app.get('port'), () => {
        console.log(`서버 실행중 http://localhost:${app.get('port')}`);
    }).on('error', err => {
        console.error(`server failed to start : ${err.message}`)
        process.exit(1);
    });
}

startServer(app);