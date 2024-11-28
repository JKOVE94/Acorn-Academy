//직원자료 컴포넌트
const JikwonData = {
  template: `
    <div>
        <h2>직원자료</h2>
        <table v-if="jikwonData.length">
            <thead>
                <tr>
                    <th>직원번호</th>
                    <th>직원명</th>
                    <th>직급</th>
                    <th>연봉</th>
                    <th>입사일</th>
                    <th>성별</th>
                    <th>평가등급</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="data in jikwonData" :key="data.jikwonno">
                    <td>{{data.jikwonno}}</td>
                    <td>{{data.jikwonname}}</td>
                    <td>{{data.jikwonjik}}</td>
                    <td>{{data.jikwonpay}}</td>
                    <td>{{data.jikwonibsail.slice(0,10)}}</td>
                    <td>{{data.jikwongen}}</td>
                    <td>{{data.jikwonrating}}</td>
                </tr>
            </tbody>
        </table>
        <p v-else>데이터가 없네요</p>
    </div>
  `,
  data() {
    return {
      jikwonData: [],
    };
  },
  mounted() {
    axios
      .get("http://localhost/jikwons")
      .then((res) => {
        this.jikwonData = res.data;
        console.log(res.data);
      })
      .catch((err) => {
        console.log("err :" + err);
      });
  },
};

export default JikwonData;