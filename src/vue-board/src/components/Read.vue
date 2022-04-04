<template>
  <div>
    <h2>게시판 리스트</h2>

        <div class="listWrap">
          <table class="tbList">
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
    <button @click="write">글쓰기</button>

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

.searchWrap{border:1px solid #888; border-radius:5px; text-align:center; padding:20px 0; margin-bottom:40px;}
.searchWrap input{width:60%; height:36px; border-radius:3px; padding:0 10px; border:1px solid #888;}
.searchWrap .btnSearch{display:inline-block; margin-left:10px;}

</style>