const { createApp } = Vue;
createApp({
  data() {
    return {
      season: false,
      myVisible: false,
      count: 0,
    };
  },
  methods: {
    addFunc() {
      return this.count++;
    },
    descFunc() {
      if (this.count > 0) {
        return this.count--;
      }
    },
    resetFunc() {
      return (this.count = 0);
    },
  },
}).mount("#app");
