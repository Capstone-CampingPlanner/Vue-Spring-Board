<template>
  <div>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
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

  <!--- 댓글 입력 폼 -->
  <div class="dap_ins">
<!--    <form action="reply_ok.php?idx=<?php echo $bno; ?>" method="post">-->
<!--      <input type="text" name="dat_user" id="dat_user" class="dat_user" size="15" placeholder="아이디">-->
<!--      <input type="password" name="dat_pw" id="dat_pw" class="dat_pw" size="15" placeholder="비밀번호">-->
      <div style="margin-top:30px; ">
        <textarea name="content" class="reply_content" id="re_content" ></textarea>
        <button id="rep_bt" class="re_bt">댓글</button>
      </div>

  </div>
  <div id="foot_box"></div>

  <!--- 댓글 불러오기 끝 -->

    <div class="btnWrap">
      <button type="button" class="btn btn-outline-primary" @click="list" style="float: left;">목록</button>

      <button type="button" class="btn btn-outline-primary" @click="updateData(List)" style="float: right;">수정</button>
      <button type="button" class="btn btn-outline-primary" @click="deleteData" style="float: right;">삭제</button>

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
.dap_ins {
  margin-top:50px;
}
.re_bt {
  position: absolute;
  width:100px;
  height:56px;
  font-size:16px;
  margin-left: 10px;
}

#re_content {
  width:700px;
  height: 56px;
}

#foot_box {
  height: 50px;
}

</style>