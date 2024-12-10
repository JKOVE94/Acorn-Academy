//DB Pooling 처리
import mariadb from 'mariadb';

export default mariadb.createPool({
    host: 'localhost',
    user: 'root',
    password: 'jkove1994',
    database: 'test',
    port: 3306,
    connectionLimit: 5,
    // bigIntAsNumber:true
});