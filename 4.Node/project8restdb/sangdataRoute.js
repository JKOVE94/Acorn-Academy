import express from 'express';

//DB 처리
import {getAllSangdata, getSangdataByCode, createSangdata, updateSangdata, deleteSangdata } from './dbprocess.js';

const router = express.Router();

//READ ALL
router.get('/', async (req, res) => {
    try {
        const rows = await getAllSangdata();
        res.json(rows);
    } catch (error) {
        res.status(500).json({error: error.message});
    }
})

//READ ONE
router.get('/:code', async (req, res) => {
    const code =req.params.code;
    try {
        const rows = await getSangdataByCode(code);
        if(rows.length === 0) return res.status(404).json({error: "data not found"});
        res.json(rows[0]);
    } catch (error) {
        res.status(500).json({error: error.message});
    }
})

//CREATE
router.post('/', async (req, res) => {
    const {code, sang, su, dan} = req.body;
    try {
        const results = await createSangdata({code,sang,su,dan});
        res.status(201).json({id: results.insertId.toString(), code, sang, su, dan});
    } catch (error) {
        res.status(500).json({error: error.message});
    }
})

//UPDATE
router.put('/:code', async (req, res) => {
    const code =req.params.code;
    const {sang, su, dan} = req.body;
    try {
        const results = await updateSangdata(code,{sang, su, dan});
        if(results.affectedRows === 0) return res.status(404).json({error: 'update data not found'}); //affectedRows는 Update나 DELETE의 영향을 받은 행의 수를 반환
        res.json({code,sang,su,dan});
    } catch (error) {
        res.status(500).json({error: error.message});
    }
})

//DELETE
router.delete('/:code', async (req, res) => {
    const code = req.params.code;
    try {
        const result = await deleteSangdata(code);
        if(result.affectedRows === 0) return res.status(404).json({error: 'delete data not found'}); //affectedRows는 Update나 DELETE의 영향을 받은 행의 수를 반환
        res.json({message: 'data deleted'});
    } catch (error) {
        res.status(500).json({error: error.message});
    }
})

export default router;