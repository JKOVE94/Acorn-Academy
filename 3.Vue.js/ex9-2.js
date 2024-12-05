(() => {
  const { createApp } = Vue;

  const app2 = createApp({
    data() {
      return {
        ypay: 0,
        busers: [
          { bunho: "10", irum: "총무부", junhwa: "111-1111" },
          { bunho: "20", irum: "영업부", junhwa: "111-2222" },
          { bunho: "30", irum: "전산부", junhwa: "111-3333" },
          { bunho: "40", irum: "관리부", junhwa: "111-4444" },
        ],
        cssStyleTest: {
          color: "blue",
          fontSize: "10px",
        },
      };
    },
  }).mount("#app2");
})();
