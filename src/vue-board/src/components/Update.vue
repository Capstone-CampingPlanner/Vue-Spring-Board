<template>
  <div>
    <h1>게시글 수정</h1>
    <button @click="list" style="float: left;">목록</button>
    <!--    <button @click=" "  style="float: left;">이전글</button>-->
    <!--    <button @click=" " style="float: left;">다음글</button>-->
    <form>
      <table class="tbAdd">

        <tr>
          <th>글쓴이</th>
          <td><input type="text" v-model="writer_code" placeholder="글쓴이" readonly/></td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" v-model="title" ref="subject" placeholder="제목"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea v-model="content" placeholder="내용을 입력하세요."/></td>
        </tr>

      </table>

    </form>
  </div>
  <div class="btnWrap">
    <button @click="list" class="btn" style="float: left;">취소</button>
    <button @click="update" type="submit" class="btnAdd btn">수정</button>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Update",
  data() {
    return {
      writer_code: '',
      title: '',
      content: '',
    }
  },
  created() {
    this.writer_code = this.$route.query.writer_code;
    this.title = this.$route.query.title;
    this.content = this.$route.query.content;
  },


  methods: {
    update() {
      this.id = this.writer_code;
      const data = {
        writer_code: this.writer_code,
        title: this.title,
        content: this.content
      }
      console.log(data);
      if (confirm("수정하시겠습니까?")) {
        axios.put('http://localhost:8090/api/update/' + this.id, data)
            .then((res) => {
              console.log("수정되었습니다.", res.data)
              alert("수정되었습니다.")
              this.$router.push({
                path: '/Read'
              })
            })
            .catch((error) => {
              console.log(error)
            })

      }
    },

    list(){
      this.$router.push({
        path: '/Read'
      })
    }
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