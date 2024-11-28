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

const { createApp } = Vue;
const { createRouter, createWebHistory } = VueRouter;

const routes = [
  { path: "/", component: AllData },
  { path: "/busers", component: BuserData },
  { path: "/jikwons", component: JikwonData },
  { path: "/gogeks", component: GogekData },
];

//라우터 생성
const router = VueRouter.createRouter({
  //Hash 기반 라우팅 방식 사용
  history: VueRouter.createWebHashHistory(),
  routes, //라우터 설정 적용
});

const app = Vue.createApp({});
app.use(router); //view application에 router 등록
app.mount("#app");
