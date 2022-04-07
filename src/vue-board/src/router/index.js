
import { createWebHistory, createRouter } from 'vue-router'
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


