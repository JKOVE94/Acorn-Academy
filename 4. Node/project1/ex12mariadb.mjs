// js로 remote db 연동
// 필요한 패키지(라이브러리)를 설치
// npm install mysql2
// npm install mariadb
// npm list mariadb

import mariadb from 'mariadb';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const dbpool = mariadb.createPool({
    host: '127.0.0.1',
    user: 'root',
    password: 'jkove1994',
    database: 'test',
    connectionLimit: 5, // 최대 5개의 커넥션
})

async function connectDb(){
    try {
        const conn = await dbpool.getConnection()
        console.log('DB연결 성공');
        return conn;
    } catch (error) {
        console.log('DB연결 실패 : '+error);
        process.exit(1); //프로그램 강제 종료 => process.exit(0) : 정상종료 [java : System.exit(0)] 
    }
}

async function selectData(conn){
    const query = 'SELECT * FROM sangdata';
    const rows = await conn.query(query);
    console.log("Select 결과 : ", rows);
}

async function insertData(conn, code, snag, su, dan){
    const query = 'INSERT INTO sangdata VALUES(?,?,?,?)';
    const result = await conn.query(query, [code, snag, su, dan]);
    console.log('Insert 결과 : ', result.affectedRows);
}

async function updateData(conn, code, su, dan){
    const query = 'UPDATE sangdata SET su=?, dan=? WHERE code=?';
    const result = await conn.query(query, [su, dan, code]);
    console.log('update 결과 : ', result.affectedRows);
}

async function deleteData(conn, code){
    const query = 'DELETE from sangdata WHERE code=?';
    const result = await conn.query(query, [code]);
    console.log('update 결과 : ', result.affectedRows);
}

(async function main(){
    const conn = await connectDb();
    try {
        //SELECT
        await selectData(conn);

        //INSERT
        // await insertData(conn, 10, '목도리', 5, 20000);

        //UPDATE
        // await updateData(conn, 10, 1, 22222)

        //DELETE
        await deleteData(conn, 10);
        
        //SELECT 한번더
        await selectData(conn);

    } catch (error) {
        console.log('DB처리 오류 : '+error);
    }finally{
        conn.release();
        console.log('connection 종료 성공');
    }
    //pool 종료
    try {
        await dbpool.end();
        console.log('pool 종료 성공');
    } catch (error) {
        console.log('pool 종료 오류 : '+error);
    }
})();