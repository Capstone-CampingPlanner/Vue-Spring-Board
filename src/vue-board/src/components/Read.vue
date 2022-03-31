<template>
  <div>
    <table>
      <tr>
        <td>글쓴이</td>
        <td>제목</td>
        <td>내용</td>
      </tr>
      <tr v-for="item in list" :key="item.id" :item="item" @click="detail(index)">
        <td>{{item.writer_code}}</td>
        <td>{{item.title}}</td>
        <td>{{item.content}}</td>
      </tr>
    </table>
    <button @click="write">글쓰기</button>


  </div>

</template>

<script>
// import data from '@/data'
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
    detail(index) {
      this.$router.push({
        name: 'Detail',
        params: {
          contentId: index
        }
      })
    }

  }
}
</script>