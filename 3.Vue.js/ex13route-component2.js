export default {
  data() {
    return {
      dan: 2,
      result: "",
    };
  },
  methods: {
    guguFunc() {
      let dan = this.dan;
      if (!isNaN(dan) && dan > 1) {
        //index를 기준으로 1~9까지의 값을 생성 => _는 사용하지 않는 변수
        this.result = Array.from(
          { length: 9 },
          (_, i) => `${dan} X ${i + 1} = ${dan * (i + 1)}`
        ).join("<br/>");
      } else {
        this.result = "올바른 숫자를 입력해주세요";
      }
    },
  },
  //menu2 Component
  template: `
    <div>
        <h2>구구단</h2>
        단 입력 후 확인 버튼을 눌러주세요<br/>
        <input @keyup.enter="guguFunc" v-model="dan" type="number" min="2" placeholder="단 입력" />
        <button @click="guguFunc">확인</button>
        <div v-html="result" style="margin-top:20px; color:blue"></div>
    </div>`,
};
