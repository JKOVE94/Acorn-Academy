const { createApp } = Vue;

createApp({
  data() {
    return {
      number: 1,
      number2: 1,
      angle: 3,
      count: 0,
    };
  },
  methods: {
    rollDiceEvent() {
      this.number = Math.floor(Math.random() * 6 + 1);

      return this.number, this.count++;
    },
    rollDiceEvent2(para) {
      let num2 = Math.floor(Math.random() * parseInt(this.angle) + 1);
      this.number2 = num2;
      return this.number2, this.count++;
    },
  },
}).mount("#app");

const app2 = Vue.createApp({
  data() {
    return {
      message: "부모 컴포넌트에서 자식 컴포넌트로 전달할 메세지",
    };
  },
});

app2.component("child-component", {
  props: ["propsdata"], //부모로부터 propsdata라는 property를 받음
  template: "<span>{{propsdata}}<span>",
});

app2.mount("#app2");

const app3 = Vue.createApp({
  data() {
    return {
      msg: "",
    };
  },
  methods: {
    printText() {
      const logMessage = "이벤트 수신 성공";
      console.log(logMessage);
      this.msg = logMessage;
      return this.msg;
    },
  },
});

app3.component("child-component", {
  // 하위 컴포넌트
  template: '<button @click="showlog">하위 컴포넌트 버튼 클릭</button>',
  methods: {
    showlog() {
      this.$emit("show-log"); //보내는 컴포넌트에서는 .$emit()으로 이벤트를 발생시킴
    },
  },
});

/*vue의 컴포넌트 간 통신 방식
  - vue에서는 props와 $emit이 기본적인 통신 자원으로 활용된다.
  - props는 단방향 데이터를 흐름(부모 -> 자식)을 구현한다
  - $emit은 이벤트 기반 흐름 (자식 -> 부모)을 구현한다.
  */

app3.mount("#app3");
