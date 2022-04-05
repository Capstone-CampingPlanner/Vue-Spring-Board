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
            <td>{{ List.title }}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td>{{ List.content }}</td>
          </tr>

        </table>
      </form>
    </div>
  </div>
    <div class="btnWrap">
      <button @click="list" class="btn" style="float: left;">목록</button>

      <button @click="updateData(List)" class="btn" style="float: left;">수정</button>
      <button @click="deleteData" class="btn" style="float: left;">삭제</button>

<!--      <button type="submit" @click="index !== undefined ? update() : write()" class="btnAdd btn">{{index !== undefined ? '수정' : '작성'}}</button>-->
  </div>
</template>

<script>
import axios from "axios"
import Read from "@/components/Read";
export default {
  name: 'View',
  data() {
    return {
      writer_code: '',
      title: '',
      content: '',
      List: [],
    }
  },
  created() {
    this.DataList();
  },

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
          .catch(error => {
            console.log("에러" + error)
          })

    },

    deleteData() {
      if (confirm("삭제하시겠습니까?")) {
        axios.delete('http://localhost:8090/api/deleteList/'+ this.id)
            .then((res) => {
              console.log("삭제되었습니다.", res)
              alert("게시글이 삭제되었습니다.")
              this.$router.push({
                name: Read
              })
            })
            .catch((err) => {
              console.log(err);
            })
      }

    },
    updateData(List) {
        console.log(List.writer_code, List.title, List.content);
        this.$router.push({
          path: `/update/${List.writer_code}`,
          query: {
            writer_code: List.writer_code,
            title: List.title,
            content: List.content
          }
        })

    },

    list() {
      this.$router.push({
        path: '/read'
      })
    }

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

.btn {
  margin: 10px;
}
</style>