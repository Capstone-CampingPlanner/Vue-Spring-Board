import Vue from 'vue'
import VueRouter from 'vue-router'
import List from '@/components/board/List'             //게시판 리스트 컴포넌트 호출
import HelloWorld from "@/components/HelloWorld";   //메인 컴포넌트 호출
import Write from '@/components/board/Write';  //게시판 리스트 컴포넌트 호출
import Detail from '@/components/Detail';
import Create from '@/components/Create';
import Read from "@/components/Read";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld
  },
  {
    path:'/board/list'
    ,name:List
    ,component:List
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
  },
  {
    path:'/board/write',
    name:Write,
    component: Write
  },
  {
    path: '/detail/:contentId',
    name: 'Detail',
    component: Detail
  },
  {
    path: '/read',
    name: Read,
    component: Read
  },
  {
    path: '/create/:contentId?',
    name: 'Create',
    component: Create
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

