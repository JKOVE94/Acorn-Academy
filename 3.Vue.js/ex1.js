const { createApp } = Vue;
//vue에서는 기본 data나 methods, 라이프사이클 훅을 createApp() 객체 안에서 설정 할 수 있다.
createApp({
  data() {
    return {
      message1: "Hello World!",
      message2: "안녕 " + "반가워",
      message3: Math.random() * 9,
    };
  },
  //vue.js는 ViewModel 영역에 해당하는 객체를 생성할 때 methods 속성을 사용하여 메서드를 정의할 수 있다.
  methods: {
    updateMessage() {
      this.message1 = "Updated Hello World!";
      this.message2 = "뷰는 이런거야!";
      this.message3 = Math.random() * 9;
    },
  },
  //vue.js의 라이프 사이클 훅
  // 라이프사이클은 컴포넌트가 생성된 후 제거될 때 까지의 흐름을 말함 => 각 생명주기 마다 실행되는 함수를 라이프사이클 훅이라고 한다.

  beforeCreate() {
    // 인스턴스가 생성되고 나서 가장 처음으로 실행
    console.log("beforeCreate() 호출");
  },
  created() {
    // 인스턴스가 생성되고 나서 실행, 아직 화면요소에 인스턴스가 부착되기 전 실행
    console.log("created() 호출");
  },
  mounted() {
    // 인스턴스가 화면요소에 부착되고 나서 실행
    console.log("mounted() 호출");
  },
  beforeUpdate() {
    // 관찰하고 있는 데이터가 변경되고 가상돔을 이용해 화면이 갱신되기 전 실행
    console.log("beforeUpdate() 호출");
  },
  updated() {
    // 관찰하고 있는 데이터가 변경되고 가상돔을 이용해 화면이 갱신된 후 실행
    console.log("updated() 호출");
  },
}).mount("#app2");
