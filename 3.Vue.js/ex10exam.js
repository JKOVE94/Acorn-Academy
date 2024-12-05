const { createApp } = Vue;

const app = Vue.createApp({
  data() {
    return {
      inputData: {
        name: "",
        subject1: 0,
        subject2: 0,
        subject3: 0,
        total: 0,
      },
      entries: [],
    };
  },
  computed: {
    // 종속된 데이터가 변경될 때마다 다시 계산. 계산 결과 후 동일 요청에 대해 재계산을 안함. 성능 최적화
    // 특정 데이터를 이용해 파생 데이터를 계산할 때 이용
    totalSum() {
      // 모든 총점의 합 계산
      return this.entries.reduce((sum, entry) => sum + entry.total, 0);
    },
  },
  methods: {
    // 매번 호출될 때 마다 새로운 계산을 함
    // 결과를 cashing하지 않으므로 의도적인 새 값 계산을 하는 경우 사용
    // 단순 동작 또는 이벤트 처리용으로 적합. 계산보다는 이벤트 처리에 관심이 집중 됨
    addScore() {
      // 세 과목의 총점을 계산
      const total =
        this.inputData.subject1 +
        this.inputData.subject2 +
        this.inputData.subject3;
      this.entries.push({ ...this.inputData, total: total });
      this.inputData = {
        name: "",
        subject1: 0,
        subject2: 0,
        subject3: 0,
        total: 0,
      };
    },
  },
});

app.mount("#app");
