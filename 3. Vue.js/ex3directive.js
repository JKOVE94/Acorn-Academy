const { createApp } = Vue;
createApp({
  data() {
    //반응형 객체 반환
    return {
      link: "https://www.google.com",
      imgSrc:
        "data:image/webp;base64,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",
      say: "이해가 잘 되고 있니?",
      aLinkToNaver: "<a href='https://www.naver.com'>네이버 페이지</a>",
      name: "신기해",
      a: "1", //문자열
      nai: 22, //숫자
      todos: [
        //배열
        { msg: "아침을 먹고" },
        { msg: "점심을 먹고" },
        { msg: "집에 가기" },
      ],
    };
  },
  methods: {
    sayFunc() {
      this.say = "vue의 지시어에 대한 이해를 묻는거야";
      return this.say;
    },
    changeName(e) {
      this.name = e.target.value;
    },
    changeA(e) {
      this.a = e.target.value;
    },
  },
  computed: {
    //계산된 property로 사용할 수 있는 함수 처럼 작동함
    // 함수와의 차이는 계산된 property가 의존하는 요소가 변경되면 값이 다시 평가됨
    b() {
      return this.a + 1;
    },
  },
}).mount("#app");
