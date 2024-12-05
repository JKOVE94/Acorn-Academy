import Product from "./ex13route-component1.js";
import Gugudan from "./ex13route-component2.js";

//각 컴포넌트는 vue의 템플릿을 사용하여 HTML구조를 정의
const Home = {
  template: `
    <div>
        <h1>홈 페이지</h1>
        <p>페이지 방문을 환영합니다.</p>
    </div>`,
};
//menu1 Component
const Member = {
  template: `
    <div>
        <h1>회원 관리</h1>
        <p>회원님 사랑합니다</p>
    </div>`,
};
/*
//menu2 Component
const Product = {
  template: `
    <div>
        <h1>상품 관리</h1>
        <p>상품을 아껴쓰세요</p>
    </div>`,
};
*/

//라우터 설정 : router-link to="" 경로와 매핑되는 컴포넌트 정의
const routes = [
  { path: "/", component: Home },
  { path: "/mem", component: Member },
  { path: "/product", component: Product },
  { path: "/gugudan", component: Gugudan },
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
