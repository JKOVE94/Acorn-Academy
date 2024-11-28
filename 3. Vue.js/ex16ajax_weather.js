const { createApp } = Vue;

createApp({
  data() {
    return {
      weather: null,
    };
  },
  methods: {
    fetchData() {
      axios
        .get(
          `https://api.open-meteo.com/v1/forecast?latitude=37.500725285&longitude=127.036600396&current_weather=true`
        )
        .then((res) => {
          this.weather = res.data.current_weather;
        })
        .catch((err) => {
          console.log("fetch err : " + err);
        });
    },
    clearData() {
      this.libraries = [];
    },
  },
}).mount("#app");
