
//상관관계를 확인 하는 함수
function calcCorrelation(){ 
    //회귀분석을 위해서는 상관관계를 확인하는 것이 중요하다.
    //하나의 확률변수로 분산값을 구할 수 있지만, 두 확률변수의 상관관계를 확인하기 위해서는 공분산을 구해야 한다.
    const x = [1,2,3,4,5,6,7,8,9,10]; //확률변수 X
    const y = [1,0,5,4,6,8,4,8,9,12]; //확률변수 Y
    const correlation = ss.sampleCorrelation(x, y);
    console.log(`피어슨 상관계수 : ${correlation.toFixed(3)}`); //0.892 매우 강항 양의 상관관계
    //'인과 관계가 있다' 라는 판단이 들면 회귀분석을 통해 예측을 할 수 있다.
    //하지만 상관관계가 높다고 해서 인과관계가 있는 것은 아니다.
}

let model; //회귀분석 모델
let xs, ys; //학습 데이터


export function func(){
    calcCorrelation();
    
    if(!model) {
        initModel().then(() => {
            predictDisplay(); //모델을 이용해서 예측값을 화면에 출력
            calculateR2(); // 회귀분석 모델 성능 확인 => 결정계수 사용
            chart(); //차트 그리기
        }); //모델 생성
    }else{
        predictDisplay(); //모델을 이용해서 예측값을 화면에 출력
    }
}

async function initModel() {
    //모델 초기화
    model = tf.sequential();
    model.add(tf.layers.dense({units:1, inputShape:[1]})); //dense : 완전 연결층 (레이어 추가), unit : 출력 뉴런의 수, inputShape : 입력 데이터의 형태
    model.compile({loss: 'meanSquaredError', optimizer: 'sgd'}); //평균 제곱오차를 사용해서 손실을 계산하고, 확률적 경사하강법(sgd)을 사용해서 최적화한다. => 회귀분석에서 adam도 많이 사용한다. adma은 sdg의 개량된 버전이다.

    //학습 데이터 초기화 : 표본으로 학습
    xs = tf.tensor2d([1,2,3,4,5,6,7,8,9,10], [10,1]);  //10행 1열 2차원 텐서 생성, 첫번째 변수 (독립변수, x)
    ys = tf.tensor1d([1,0,5,4,6,8,4,8,9,12]);  //10행 1열 1차원 텐서 생성, 첫번째 변수 (종속변수, y)

    await model.fit(xs, ys, {epochs: 100}); //학습 시작, 100번 반복, 학습 실행 후 최적의 모델 생성 y=wx+b

    //학습된 가중치 (w)와 편향(b) 확인
    const weights = model.getWeights();
    const w = weights[0].dataSync();
    const b = weights[1].dataSync();
    console.log(`w : ${w}, b : ${b}`); //w : 1.0296987295150757, b : 0.11727637052536011
    // y= 1.0296987295150757 * newx + 0.11727637052536011
    const newx = 13.5435;
    console.log("미지의 새로운 x에 대한 예측결과 : ", 1.0296987295150757 * newx + 0.11727637052536011) //14.012214965820313 => 즉 알 수 없는 x에 대한 예측값을 구할 수 있다.
}

function predictDisplay(){
    const inputValue = parseFloat(document.getElementById('inputValue').value);

    if(isNaN(inputValue)){
        document.getElementById('showResult').innerText = '숫자를 입력하세요';
        return;
    }
    //모델을 사용해서 예측

    const pred = model.predict(tf.tensor2d([inputValue], [1, 1])); // 예측값 출력 (학습시의 모양 (tensor2d)와 동일하게 입력값 역시 맞춰줘야한다) => 1행 1열 2차원 텐서 생성
    const predValue = pred.dataSync()[0]; //dataSync: 텐서를 js 배열로 변환 (예측값을 가져온다)
    
    //예측결과 출력
    document.getElementById('showResult').innerText = `입력값: ${inputValue}, 예측값 : ${predValue.toFixed(2)}`;
}

function calculateR2(){  // 결정계수 계산 
    // 예측값 계산
    const predictedYs = model.predict(xs).dataSync();

    // 실제 값과 예측값을 바탕으로 R² 계산
    // 결정계수는 회귀 모델이 종속변수를 얼마나 잘 설명하는지를 나타내는 통계적 척도!
    const actualYs = ys.dataSync();
    // reduce 함수는 배열의 각 요소를 순회하면서 누적 결과를 계산하는 데 사용된다. 
    // reduce 함수는 배열을 한 개의 값으로 줄이는 데 활용
    // actualYs(실제값) 배열의 평균값을 계산
    const meanY = actualYs.reduce((sum, val) => sum + val, 0) / actualYs.length;

    // 실제값과 평균값 간의 차이를 제곱하여 모두 더한 값으로, 데이터 전체 변동성을 나타낸다.
    const ssTotal = actualYs.reduce((sum, val) => sum + Math.pow(val - meanY, 2), 0);
    // 잔차 제곱합을 계산
    const ssResidual = actualYs.reduce((sum, val, index) => 
    sum + Math.pow(val - predictedYs[index], 2), 0);

    // 회귀 모델의 설명력 R²를 계산하는 식. 
    // 모델이 종속변수의 총 변동성을 얼마나 설명하는지를 나타내는 통계적 척도.
    const rSquared = 1 - ssResidual / ssTotal;

    // R² 결과 표시
    document.getElementById("r2").innerText = `rSquared:${rSquared.toFixed(3)}, 모델 설명력 (R²): ${(rSquared * 100).toFixed(1)}%`;
}

 

// 차트 관련  ---------------------
function getData() {
  // xs와 ys라는 두 개의 텐서에서 데이터를 가져와서 이를 가공한 후, 
  // 차트에 사용하기 위한 데이터 형식으로 변환하는 역할
  // dataSync()는 텐서의 모든 값을 동기적으로 가져와 자바스크립트 배열로 변환
  const dataX = xs.dataSync();
  const dataY = ys.dataSync();

  // dataX 배열을 기반으로 새로운 배열을 만든다. 
  // 이 배열은 map() 메서드를 통해 각 요소가 변환
  // map() 메서드는 dataX 배열의 각 요소에 대해 함수를 호출하고, 그 결과를 새 배열로 반환한다. 
  // 여기서 각 요소는 객체 { index: value, value: dataY[index] }로 변환된다.
  return Array.from(dataX).map((value, index) => {
    return { index: value, value: dataY[index] };
  });
}

function chart() {
  const data = getData(); // 학습 데이터를 가져옴

  // HTML에 고정된 차트를 렌더링할 컨테이너 선택
  const container = document.getElementById('chart-container');

  // 산점도 데이터 준비
  const scatterData = data.map(point => ({
      x: point.index, // x축 (독립변수)
      y: point.value  // y축 (종속변수)
  }));

  // 추세선 데이터 계산
  const trendlineData = calcTrendline(data);

  // 산점도와 추세선 함께 그리기
  tfvis.render.scatterplot(
      container, // 기존 visor가 아닌 고정된 div에 렌더링
      { 
          values: [scatterData, trendlineData], 
          series: ['Data', 'Trendline'] // 산점도와 추세선 이름 지정
      },
      {
          xLabel: '독립변수(X)',
          yLabel: '종속변수(Y)',
          height: 300,
          width: 500,
          seriesColors: ['blue', 'red'], // 데이터 점: 파란색, 추세선: 빨간색
          lineSeries: ['Trendline'], // 추세선을 직선으로 표시
          style: { lineWidth: 1 }
      }
  );
}

function calcTrendline(data) {
  // 데이터의 X와 Y 값을 분리
  const xValues = data.map(point => point.index);
  const yValues = data.map(point => point.value);

  // 평균 계산
  const meanX = xValues.reduce((sum, x) => sum + x, 0) / xValues.length;
  const meanY = yValues.reduce((sum, y) => sum + y, 0) / yValues.length;

  // 선형 회귀 계수 계산 (y = mx + b에서 m)
  const bunja = xValues.reduce((sum, x, i) => sum + (x - meanX) * (yValues[i] - meanY), 0);
  const bunmo = xValues.reduce((sum, x) => sum + Math.pow(x - meanX, 2), 0);
  
  const slope = bunja / bunmo; // 기울기 m
  const intercept = meanY - slope * meanX; // 절편 계산 (b)

  // 추세선 데이터를 X 범위에서 여러 점으로 생성
  // Math.min(...xValues) : 배열 xValues에서 가장 작은 값을 찾아 minX에 저장. 
  // Math.min은 숫자 중 최소값 반환하는 함수며, 
  // ... 연산자로 배열을 개별 요소로 펼쳐 Math.min에 전달한다.
  const minX = Math.min(...xValues);
  const maxX = Math.max(...xValues);
  const step = (maxX - minX) / 100;   // 100개의 점 생성

  const linePoints = [];
  for (let x = minX; x <= maxX; x += step) {
      linePoints.push({ x, y: slope * x + intercept });
  }

  return linePoints;
}