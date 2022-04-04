<template>
  <div>
    <H1>게시판 상세보기</H1>
    <div class="AddWrap">
      <form>
        <table class="tbAdd">
          <colgroup>
            <col width="15%" />
            <col width="*" />
          </colgroup>
          <tr>
            <th>글쓴이</th>
            <td>{{List.writer_code}}</td>
          </tr>
          <tr>
            <th>제목</th>
            <td>{{List.title}}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td>{{List.content}}</td>
          </tr>
<!--          <button @click="updateData">수정</button>-->
<!--          <button @click="deleteData(index)">삭제</button>-->

        </table>
      </form>
    </div>
  </div>
    <div class="btnWrap">
      <button @click="list" class="btn" style="float: left;">목록</button>

      <button @click="update" class="btn" style="float: left;">수정</button>
      <button @click="listd" class="btn" style="float: left;">삭제</button>
<!--      <button type="submit" @click="index !== undefined ? update() : write()" class="btnAdd btn">{{index !== undefined ? '수정' : '작성'}}</button>-->
  </div>
</template>

<script>
import data from "@/data";
import axios from "axios"
// import Read from "@/components/Read";
export default {
  name: 'View',
  data() {
    const index = this.$route.params.contentId;
    return {
      index: index,
      body: this.$route.query,
      // writer_code: '',
      // title: '',
      // content: '',
      List: [],
    }
  },
  created() {
    this.DataList();
  },
  props: {
    writer_code: {
      type: String,
      default: "",
    },
    title: {
      type: String,
      default: ""
    },
    content: {
      type: String,
      default: ""
    }
  },

  // mounted() {
  //   Read.getArticle(this.$route.params.id)
  //   .then((response) => {
  //     this.article = response.data;
  //   })
  //   .catch((e) => {
  //     console.log(e);
  //   });
  //   // this.article = this.$route.params.id;
  // },


  methods: {
    DataList() {
      this.id = this.$route.params.writer_code;
      console.log(this.id);
      axios.get('http://localhost:8090/api/myList/' + this.id)
        .then((res) => {
          console.log("내가 받은 데이터는", res.data)
          this.List = res.data;
          console.log(this.List.writer_code)
        })
        .catch(error =>{
          console.log("에러" + error)
        })

    },

    fnList() {
      delete this.body.num;
      this.$router.push({path: './read', query: this.body});
    },
    update() {
      data[this.index].writer = this.writer
      data[this.index].title = this.title
      data[this.index].content = this.content
      this.$router.push({
        path: '/read'
      })
    },

    deleteData() {
      data.splice(this.index, 1)
      this.$router.push({
        path: "/"
      })
    },
    updateData() {
      this.$router.push({
        name: 'Create',
        params: {
          contentId: this.index
        }
      })
    },

    list() {
      this.$router.push({
        path: '/read'
      })
    }
    ,
  }
}

</script>

<style scoped>
.tbAdd{border-top:1px solid #888;}
.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0; }
.tbAdd td{padding:10px 10px; box-sizing:border-box; text-align:left;}
.tbAdd td.txt_cont{height:300px; vertical-align:top;}
.btnWrap{text-align:center; margin:20px 0 0 0;}
.btnWrap a{margin:0 10px;}
.btnAdd {background:#43b984}
.btnDelete{background:#f00;}
</style>