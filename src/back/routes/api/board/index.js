const router = require('express').Router();
const dao = require('./dao');

router.get("/",dao.list);
router.post("/",dao.add);       //api/board post 방식으로 접근 시 모듈 실행

router.all('*',(req, res)=> {
    res.status(404).send({success:false, msg:'board unknown uri ${req.path}'});
})

module.exports = router;