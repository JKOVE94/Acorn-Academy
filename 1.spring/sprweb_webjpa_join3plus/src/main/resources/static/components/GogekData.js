//고객자료 컴포넌트
const GogekData = {
  template: `
    <div>
        <h2>고객자료</h2>
        <table v-if="gogekData.length">
            <thead>
                <tr>
                    <th>고객번호</th>
                    <th>고객명</th>
                    <th>전화번호</th>
                    <th>주민등록번호</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="data in gogekData" :key="data.gogekno">
                    <td>{{data.gogekno}}</td>
                    <td>{{data.gogekname}}</td>
                    <td>{{data.gogektel}}</td>
                    <td>{{data.gogekjumin}}</td>
                </tr>
            </tbody>
        </table>
        <p v-else>데이터가 없네요</p>
    </div>
  `,
  data() {
    return {
      gogekData: [],
    };
  },
  mounted() {
    axios
      .get("http://localhost/gogeks")
      .then((res) => {
        this.gogekData = res.data;
        console.log(res.data);
      })
      .catch((err) => {
        console.log("err :" + err);
      });
  },
};

export default GogekData;