
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
            calculateR2(); // 회귀분석 모델 성능 확인
        }); //모델 생성
    }else{
        predictDisplay(); //모델을 이용해서 예측값을 화면에 출력
    }
}

async function initModel() {
    //모델 초기화
    model = tf.sequential();
    model.add(tf.layers.dense({unit:1, inputShape:[1]})); //dense : 완전 연결층, unit : 출력 뉴런의 수, inputShape : 입력 데이터의 형태
    model.complie({loss: 'meanSquaredError', optimizer: 'sgd'}); //평균 제곱오차를 사용해서 손실을 계산하고, 확률적 경사하강법을 사용해서 최적화한다. => 회귀분석에서 adam도 많이 사용한다. adma은 sdg의 개량된 버전이다.

    //학습 데이터 초기화 : 표본으로 학습
    xs = tf.tensor2d([1,2,3,4,5,6,7,8,9,10], [10,1]);  //10행 1열 2차원 텐서 생성, 첫번째 변수 (독립변수, x)
    ys = tf.tensor1d([1,0,5,4,6,8,4,8,9,12]);  //10행 1열 1차원 텐서 생성, 첫번째 변수 (종속변수, y)

    await model.fit(xs, ys, {epochs: 100}); //학습 시작, 500번 반복, 학습 실행 후 최적의 모델 생성 y=wx+b
}

function predictDisplay(){
    const inputValue = parseFloat(document.getElementById('inputValue').value);

    if(isNaN(inputValue)){
        document.getElementById('showResult').innerText = '숫자를 입력하세요';
        return;
    }
    //모델을 사용해서 예측
    model.predictDisplay(tf.tensor2d([inputValue], [1,1])).print(); //예측값 출력
    
}

function calculateR2(){

}
