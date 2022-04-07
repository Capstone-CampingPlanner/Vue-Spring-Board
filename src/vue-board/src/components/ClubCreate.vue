<template>
  <div>
    <h1>동호회 게시글 작성</h1>
    <button @click="list" style="float: left;">목록</button>

    <form>
      <table class="tbAdd">

        <tr>
          <th>제목</th>
          <td><input type="text" v-model="ctitle" ref="subject" placeholder="제목"/></td>
        </tr>
        <tr>
          <th>동호회 명</th>
          <td><input type="text" v-model="cwriter_code" placeholder="동호회 명"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea v-model="ccontent" placeholder="내용을 입력하세요."/></td>
        </tr>

      </table>

    </form>
  </div>
  <div class="btnWrap">
    <button @click="main" class="btn" style="float: left;">취소</button>
    <button type="submit" @click="index !== undefined ? update() : clubwrite()" class="btnAdd btn">{{index !== undefined ? '수정' : '작성'}}</button>

  </div>

</template>
<script>
import data from '@/data'
import axios from "axios";

export default {
  name: 'ClubCreate',
  data() {
    const index = this.$route.params.contentId;
    return {
      index: index,

      ctitle: '',
      cwriter_code: '',
      ccontent: '',
    }
  },
  methods: {


    clubwrite() {
      const data = {
        cwriter_code: this.cwriter_code,
        ctitle: this.ctitle,
        ccontent: this.ccontent
      }
      console.log(data);
      axios.post('http://localhost:8090/api/csignup', data)
          .then((res) => {
            console.log("성공" + res.data)
          })
          .catch((ex) => {
            console.log("fail", ex)
          })

    },

    update() {
      data[this.index].cwriter_code = this.cwriter_code
      data[this.index].ctitle = this.ctitle
      data[this.index].ccontent = this.ccontent
      this.$router.push({
        path: '/read'
      })
    },

    main() {
      this.$router.push({
        path: '/'
      })
    },
    list(){
      this.$router.push({
        path: 'Read'
      })
    },

  }
}
</script>

<style scoped>
.tbAdd{border-top:1px solid #888;}
.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0;}
.tbAdd td{padding:10px 10px; box-sizing:border-box;}
.tbAdd td input{width:100%; min-height:30px; box-sizing:border-box; padding:0 10px;}
.tbAdd td textarea{width:100%; min-height:300px; padding:10px; box-sizing:border-box;}
.btnWrap{text-align:center; margin:20px 0 0 0;}
.btnWrap a{margin:0 10px;}
.btnAdd {background:#43b984; text-align:center; margin:20px 0 0 0;}
.btnDelete{background:#f00;}

</style>