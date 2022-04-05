
import { createWebHistory, createRouter } from 'vue-router'
import List from '@/components/board/List'             //게시판 리스트 컴포넌트 호출
import HelloWorld from "@/components/HelloWorld";   //메인 컴포넌트 호출
import Create from '@/components/Create';
import Read from "@/components/Read";
import View from "@/components/View";
import Update from "@/components/Update";



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
    path: '/read',
    name: Read,
    component: Read
  },
  {
    path: '/create/:contentId?',
    name: 'Create',
    component: Create
  },
  {
    path: '/create',
    name: 'Create',
    component: Create
  },

  //상세페이지 추가
  {
    path:'/view/:writer_code',
    name:View,
    component:View
  },
  {
    path: '/update/:writer_code',
    name: Update,
    component: Update
  }



]

export const router = createRouter({
  history: createWebHistory(),
  routes
})


