//부서자료 컴포넌트
const BuserData = {
  template: `
    <div>
        <h2>부서자료</h2>
        <table v-if="buserData.length">
            <thead>
                <tr>
                    <th>부서번호</th>
                    <th>부서명</th>
                    <th>위치</th>
                    <th>전화번호</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="data in buserData" :key="data.buserno">
                    <td>{{data.buserno}}</td>
                    <td>{{data.busername}}</td>
                    <td>{{data.buserloc}}</td>
                    <td>{{data.busertel}}</td>
                </tr>
            </tbody>
        </table>
        <p v-else>데이터가 없네요</p>
    </div>
  `,
  data() {
    return {
      buserData: [],
    };
  },
  mounted() {
    axios
      .get("http://localhost/busers")
      .then((res) => {
        this.buserData = res.data;
        console.log(res.data);
      })
      .catch((err) => {
        console.log("err :" + err);
      });
  },
};

export default BuserData;