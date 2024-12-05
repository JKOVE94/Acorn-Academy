import ViewProduct from "./viewproduct.js"
//import AddProduct from "./addproduct.js"
//import EditProduct from "./editproduct.js"

const { createApp } = Vue;
const { createRouter, createWebHashHistory } = VueRouter;

const routes = [
  { path: "/", component: ViewProduct },
  //{ path: "/add", component: AddProduct },
  //{ path: "/edit/:code", component: EditProduct },
];

//라우터 생성
const router = VueRouter.createRouter({
  //Hash 기반 라우팅 방식 사용
  history: VueRouter.createWebHashHistory(),
  routes, //라우터 설정 적용
});

const app = Vue.createApp({});
app.use(router); //view application에 router 등록
app.mount("#app");
