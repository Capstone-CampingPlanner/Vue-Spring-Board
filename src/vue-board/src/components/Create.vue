<template>
  <div>
    <h1>게시글 작성</h1>
    <button @click="list" style="float: left;">목록</button>
    <!--    <button @click=" "  style="float: left;">이전글</button>-->
    <!--    <button @click=" " style="float: left;">다음글</button>-->
    <form>
      <table class="tbAdd">

        <tr>
          <th>제목</th>
          <td><input type="text" v-model="title" ref="subject" placeholder="제목"/></td>
        </tr>
        <tr>
          <th>글쓴이</th>
          <td><input type="text" v-model="writer_code" placeholder="글쓴이"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea v-model="content" placeholder="내용을 입력하세요."/></td>
        </tr>

      </table>

    </form>
  </div>
  <div class="btnWrap">
    <button @click="main" class="btn" style="float: left;">취소</button>
    <button type="submit" @click="index !== undefined ? update() : write()" class="btnAdd btn">{{index !== undefined ? '수정' : '작성'}}</button>

  </div>


</template>
<script>
import data from '@/data'
import axios from "axios"
export default {
  name: 'Create',
  data() {
    const index = this.$route.params.contentId;
    return {
      index: index,
      // writer: index !== undefined ? data[index].writer : "",
      // title: index !== undefined ? data[index].title : "",
      // content: index !== undefined ? data[index].content : ""
      writer_code: '',
      title: '',
      content: ''
    }
  },
  methods: {
    write() {
      const data = {
        writer_code: this.writer_code,
        title: this.title,
        content: this.content
      }
      console.log(data);
      axios.post('http://localhost:8090/api/signup', data)
          .then((res) => {
            console.log("성공" + res.data)
          })
          .catch((ex) => {
            console.log("fail", ex)
          })
      // this.data.push({
      //   writer: this.writer,
      //   title: this.title,
      //   content: this.content,
      // })
      this.$router.push({
        path: '/Read'
      })

      if(!this.title) {       //제목 없다면 값 입력하라고 알려줌
        alert("제목을 입력해 주세요");
        this.$refs.title.focus();     //방식으로 선택자를 찾는다
        return;
      }
    },
    update() {
      data[this.index].writer = this.writer
      data[this.index].title = this.title
      data[this.index].content = this.content
      this.$router.push({
        path: '/read'
      })
    },
    list(){
      this.$router.push({
        path: 'Read'
      })
    },
    main(){
      this.$router.push({
        path: '/'
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