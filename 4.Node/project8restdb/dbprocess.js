//DB 처리
import pool from './db.js';

//전체자료 읽기
export const getAllSangdata = async () => {
    let conn, rows, sql;
    try {
        conn = await pool.getConnection();
        sql = 'SELECT * FROM sangdata';
        rows = await conn.query(sql);
        return rows;
    }
    catch(e){
        console.error(e);
    }
    finally {
        if (conn) conn.release();
    }
}

//한개 자료 읽기
export const getSangdataByCode = async (code) => {
    let conn, rows, sql;
    try {
        conn = await pool.getConnection();
        sql = 'SELECT * FROM sangdata WHERE code=?';
        rows = await conn.query(sql, [code]);
        return rows;
    }
    catch(e){
        console.error(e);
    }
    finally {
        if (conn) conn.release();
    }
}

//자료 추가
export const createSangdata = async ({code, sang, su, dan}) => {
    let conn, rows, sql;
    try {
        conn = await pool.getConnection();
        sql = 'INSERT INTO sangdata VALUES(?,?,?,?)';
        rows = await conn.query(sql, [code, sang, su, dan]);
        return rows;
    }
    catch(e){
        console.error(e);
    }
    finally {
        if (conn) conn.release();
    }
}


//자료 수정 
export const updateSangdata = async (code, {sang, su, dan}) => {
    let conn, rows, sql;
    try {
        conn = await pool.getConnection();
        sql = 'UPDATE sangdata SET sang=?, su=?, dan=? WHERE code=?';
        rows = await conn.query(sql, [sang, su, dan, code]);
        return rows;
    }
    catch(e){
        console.error(e);
    }
    finally {
        if (conn) conn.release();
    }
}

//자료 삭제 
export const deleteSangdata = async (code) => {
    let conn, rows, sql;
    try {
        conn = await pool.getConnection();
        sql = 'DELETE FROM sangdata WHERE code=?';
        rows = await conn.query(sql, [code]);
        return rows;
    }
    catch(e){
        console.error(e);
    }
    finally {
        if (conn) conn.release();
    }
}