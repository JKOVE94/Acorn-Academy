import { Router } from "express";

const router = Router(); // Router 객체 생성

router.get('/', (req, res) => {
    res.send('반가워요! 고객님!')
})

export default router;