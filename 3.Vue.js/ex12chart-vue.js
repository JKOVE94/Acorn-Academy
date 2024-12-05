const { createApp } = Vue;

createApp({
  data() {
    return {
      dataArray: datas,
    };
  },
  methods: {
    addFunc(index) {
      this.dataArray[index][1]++;
      this.updateChart();
    },
    subFunc(index) {
      if (this.dataArray[index][1] > 0) {
        this.dataArray[index][1]--;
        this.updateChart();
      }
    },
    updateChart() {
      drawFunc();
    },
  },
}).mount("#app");
