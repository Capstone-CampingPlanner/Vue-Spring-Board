<template>
  <div>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <h2>게시판 리스트</h2>

        <div class="listWrap">
          <table class="table table-hover">

      <tr>
        <td style="font-size:20px; color: green;">글쓴이</td>
        <td style="font-size:20px; color: green;">제목</td>
        <td style="font-size:20px; color: green;">내용</td>
      </tr>

      <tr v-for="item in list" :key="item.id" :item="item" @click="detail(item)">
        <td>{{item.writer_code}}</td>
        <td>{{item.title}}</td>
        <td>{{item.content}}</td>
      </tr>
      <router-link to="{name: 'View', params: { writer_code:item.writer_code }}"></router-link>
          </table>

      <tr>
          <div id="btnWrap">
            <button type="button" class="btn btn-outline-primary" @click="write" style="float: right">글쓰기</button>
          </div>
      </tr>
          <div class="searchWrap">

          <input type="text" v-model="keyword" @keyup.enter="fnSearch" /><a href="javascript:;" @click="fnSearch" class="btnSearch btn">검색</a>

          </div>

    <li>
      <div id="divPaging">
        <div>◀</div>
        <div><b>1</b></div>
        <div>2</div>
        <div>3</div>
        <div>4</div>
        <div>5</div>
        <div>▶</div>
      </div>
    </li>
  </div>
</div>

</template>

<script>
import axios from "axios";


export default {
  name: 'Read',
  created() {
    this.fetchData()
  },
  data() {
    return {
      list: [],
      item: '',
    }
  },

  methods: {
    fetchData() {
      axios.get('http://localhost:8090/api/list')
          .then((res) => {
            console.log(res.data);
            this.list = res.data;
          })
          .catch((ex) =>{
            console.log("fail", ex)
          })
    },
    write() {
      this.$router.push({
        path: 'create'
      })
    },
    detail(item) {
      this.$router.push({
        path: `/view/${item.writer_code}`

      })
    },

    //
    fnSearch() { //검색
      this.paging.page = 1;
      this.fnGetList();
    }
    , fnPage(n) {//페이징 이
      if(this.page != n) {
        this.page = n;
        this.fnGetList();
      }
    },

  }
}

</script>

<style>


#divPaging {
  clear:both;
  margin:0 auto;
  width:220px;
  height:50px;
}

#divPaging > div {
  float:left;
  width: 30px;
  margin:0 auto;
  text-align:center;
}

.tbList th{border-top:1px solid #888;}
.tbList th, .tbList td{border-bottom:1px solid #eee; padding:5px 0;}
.tbList td.txt_left{text-align:left;}
.btnWrap{text-align:center; margin:20px 0 0 0;}
.btnWrap a{margin:0 10px;}
/*.btnAdd {background:#43b984}*/
/*.btnDelete{background:#f00;}*/

.searchWrap{border:1px solid #888; border-radius:5px; text-align:center; padding:20px 0; margin-bottom:40px;}
.searchWrap input{width:60%; height:36px; border-radius:3px; padding:0 10px; border:1px solid #888;}
.searchWrap .btnSearch{display:inline-block; margin-left:10px;}

.btn btn-outline-primary{color: #41b883}


</style>