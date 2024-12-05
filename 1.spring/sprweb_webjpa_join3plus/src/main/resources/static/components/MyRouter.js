import AllData from './AllData.js'
import BuserData from './BuserData.js'
import GogekData from './GogekData.js'
import JikwonData from './JikwonData.js'

const { createApp } = Vue;
const { createRouter, createWebHashHistory } = VueRouter;

const routes = [
  { path: "/", component: AllData },
  { path: "/busers", component: BuserData },
  { path: "/jikwons", component: JikwonData },
  { path: "/gogeks", component: GogekData },
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
