const { createApp } = Vue;
const abasic = createApp({});

abasic.component("hello", {
  //hello 컴포넌트를 전역으로 등록
  template: "<h1>{{title}}</h1>", //HTML markup을 구성하는 부분이 template이다.
  data() {
    return {
      title: "안녕!", //데이터는 해당 컴포넌트에서만 사용 가능
    };
  },
});
abasic.mount("#abasic");

const abasic2 = createApp({});
abasic2.component("World", {
  template:
    '<h3>{{title}}<button @click="changeTitle">타이틀 변경</button></h3>', //HTML markup을 구성하는 부분이 template이다.
  data() {
    return {
      title: "반가워!", //데이터는 해당 컴포넌트에서만 사용 가능
    };
  },
  methods: {
    changeTitle() {
      //data안에 있는 변수를 접근하기 위해서는 this를 사용해야 한다.
      this.title = "오늘은 뷰 구경하는 날!";
    },
  },
});
abasic2.mount("#abasic2");

//-----------------------------------------------------------

//전역 컴포넌트를 등록하는 공용 컴포넌트 정의
const myGloablComponent = {
  template: "<b>전역 컴포넌트 등록되었습니다</b><br/>",
};
const appli = Vue.createApp({
  components: {
    "my-global-component": myGloablComponent, //전역 컴포넌트 등록
    "my-local-component": {
      template: "<span>지역 컴포넌트 등록1</span><br/>",
    },
  },
});
appli.mount("#app");

const appli2 = Vue.createApp({
  components: {
    "my-global-component": myGloablComponent, //전역 컴포넌트 등록
    "my-local-component": {
      template: "<span>지역 Component 등록2</span><br/>",
    },
  },
});
appli2.mount("#app2");

const appli3 = Vue.createApp({
  components: {
    "my-global-component": myGloablComponent, //전역 컴포넌트 등록
    "my-local-component": {
      template: "<span>지역 Component 등록3 (세번째)</span><br/>",
    },
  },
});
appli3.mount("#app3");
