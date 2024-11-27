const { createApp } = Vue;

createApp({
  data() {
    return {
      list: ["커피", "콜라", "사이다", "무알콜맥주"],
      objArray: [
        { name: "부산", taketime: "5시간" },
        { name: "속초", taketime: "4시간" },
        { name: "춘천", taketime: "2시간" },
      ],
      myArr: ["일", "이", "삼", "사", "오"],
      numArr: [1, 2, 3, 4, 5],
    };
  },
  methods: {
    addList() {
      this.myArr.push("추가");
    },
    addListIndex(idx) {
      this.myArr.splice(idx, 0, "삽입");
    },
    changeList(idx) {
      // this.myArr.splice(idx, 1, "수정");
      this.myArr[idx] = "수정";
    },
    removeList(idx) {
      this.myArr.splice(idx, 1);
    },
  },
  computed: {
    oddNumArr() {
      return this.numArr.filter((num) => num % 2 === 1);
    },
    evenNumArr() {
      return this.numArr.filter((num) => num % 2 === 0);
    },
  },
}).mount("#app");
