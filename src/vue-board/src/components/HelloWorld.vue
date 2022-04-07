<template>
  <div class="hello">
    <p>게시글 작성</p>
    <button @click="read">글쓰기</button>
    <p>게시글 리스트</p>
    <button @click="list">리스트</button>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  methods: {
    list() {
      this.$router.push({
        path: 'Read'
      })
    },
    read() {
      this.$router.push({
        path: 'Create'
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
