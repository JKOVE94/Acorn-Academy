const { createApp } = Vue;

createApp({
  data() {
    return {
      datas: [],
    };
  },
  methods: {
    showFunc() {
      axios
        .get("http://localhost:8080/abcReact/test.jsp")
        .then((res) => {
          console.log(res.data);
          this.datas = res.data;
        })
        .catch((err) => {
          console.log("에러 :" + err);
        });
    },
  },
}).mount("#app");
