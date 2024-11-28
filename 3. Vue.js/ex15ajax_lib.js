const { createApp } = Vue;

createApp({
  data() {
    return {
      libraries: [],
      xcord: "",
      ycord: "",
    };
  },
  methods: {
    fetchData() {
      axios
        .get(
          "http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTimeInfo/1/5/"
        )
        .then((res) => {
          this.libraries = res.data.SeoulLibraryTimeInfo.row;
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

var container = document.getElementById("map");
var options = {
  center: new kakao.maps.LatLng(33.450701, 126.570667),
  level: 3,
};

var map = new kakao.maps.Map(container, options);
