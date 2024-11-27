const { createApp } = Vue;
createApp({
  data() {
    return {
      posts: [],
    };
  },
  methods: {
    fetchData() {
      fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "GET",
      })
        .then((res) => {
          if (!res.ok) throw new Error("네트워크 오류");
          return res.json();
        })
        .then((data) => {
          this.posts = data.slice(0, 10);
        })
        .catch((err) => {
          console.error("fetchData 오류 : " + err);
        });
    },
    clearData() {
      this.posts = [];
    },
  },
}).mount("#app");
