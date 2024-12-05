//전체자료 컴포넌트
const AllData = {
  template: `
    <div>
        <h2>전체자료</h2>
        <table v-if="allData.length">
            <thead>
                <tr>
                    <th>부서번호</th>
                    <th>부서명</th>
                    <th>직원명</th>
                    <th>관리고객명</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="data in allData" :key="data.jikwonno">
                    <td>{{data.buserno}}</td>
                    <td>{{data.busername}}</td>
                    <td>{{data.jikwonname}}</td>
                    <td>{{data.gogekname}}</td>
                </tr>
            </tbody>
        </table>
        <p v-else>데이터가 없네요</p>
    </div>
  `,
  data() {
    return {
      allData: [],
    };
  },
  mounted() {
    axios
      .get("http://localhost/joindata")
      .then((res) => {
        this.allData = res.data;
        console.log(res.data);
      })
      .catch((err) => {
        console.log("err :" + err);
      });
  },
};

export default AllData;