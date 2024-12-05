const { createApp, ref } = Vue;
createApp({
  setup() {
    const newName = ref(""); //새로 입력할 이름
    const names = ref(["강나루", "강감찬"]);

    const addName = () => {
      //항상 이런 입력은 trim을 넣어주는것이 좋다.
      if (newName.value.trim() !== "") {
        names.value.push(newName.value.trim());
        newName.value = ""; //입력창 초기화
      }
    };
    const removeName = (idx) => {
      names.value.splice(idx, 1);
    };
    return { newName, names, addName, removeName };
  },
}).mount("#app");
