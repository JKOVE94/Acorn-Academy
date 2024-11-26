const { createApp, ref } = Vue; //ref는 반응형 데이터를 생성하는 함수

createApp({
  setup() {
    //컴포넌트의 초기상태와 로직을 설정
    //ref로 감싸준 데이터는 반응형 데이터로 동작함 => 데이터 변경시 리렌더링
    const booklist = ref([
      { name: "자바의 이해", price: 25000 },
      { name: "파이썬 프로그래밍", price: 23000 },
      { name: "mariaDB", price: 35000 },
      { name: "React 완전정복", price: 37000 },
      { name: "Vue 만세", price: 21000 },
    ]);
    const selectedBooks = ref([]);
    return { booklist, selectedBooks };
  },
  computed: {
    totalPrice() {
      return this.selectedBooks.reduce((acc, book) => acc + book.price, 0);
    },
  },
}).mount("#app");
