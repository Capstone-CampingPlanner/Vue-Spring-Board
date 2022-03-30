 <template>
<div>
  <form>
  <input v-model="writer_code" placeholder="글쓴이"/>
  <input v-model="title" placeholder="제목"/>
  <textarea v-model="content" placeholder="내용"/>
  </form>
    <button type="submit" @click="index !== undefined ? update() : write()">{{index !== undefined ? '수정' : '작성'}}</button>
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
       axios.post('http://localhost:8090/api/signup',data)
       .then((res) => {
         console.log("성공" + res.data)
       })
       .catch((ex) =>{
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

     },
     update() {
       data[this.index].writer = this.writer
       data[this.index].title = this.title
       data[this.index].content = this.content
       this.$router.push({
         path: '/read'
       })

     },

   }
 }
 </script>