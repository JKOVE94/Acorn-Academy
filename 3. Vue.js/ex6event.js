const { createApp, ref } = Vue; //ref는 반응형 데이터 처리용
createApp({
  setup() {
    //데이터는 vue의 반응성에 의해 UI와 동기화되며 값이 변경되면 화면이 리렌더링됨
    const value1 = ref(0); //기본 데이터 타입을 ref로 감싸서 상태 변화를 추적할 수 있도록 함
    const value2 = ref(0);
    const result = ref(0);

    const calculate = (type) => {
      switch (type) {
        case "+":
          result.value = value1.value + value2.value;
          break;
        case "-":
          result.value = value1.value - value2.value;
          break;
        case "*":
          result.value = value1.value * value2.value;
          break;
        case "/":
          if (value2.value === 0) {
            alert("0으로 나눌 수 없습니다.");
            result.value = NaN;
            break;
          }
          result.value = value1.value / value2.value;
          break;
      }
    };
    return { value1, value2, result, calculate };
  },
}).mount("#app");
