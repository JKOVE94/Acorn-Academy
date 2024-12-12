import * as tf from 'https://esm.sh/@tensorflow/tfjs@latest';
import * as tfvis from 'https://esm.sh/@tensorflow/tfjs-vis@latest';
import * as ss from 'https://esm.sh/simple-statistics@7.7.0';

let model;

async function fetchHousingData(){
    console.log("데이터 로드 중");
    try{
        //csv 파일 읽기
        const response = await fetch('https://raw.githubusercontent.com/selva86/datasets/master/BostonHousing.csv');
        if(!response.ok){
            throw new Error(`데이터 읽기 실패 ${response.statusText}`); //에러 발생
        }
        const data =  await response.text();
        // console.log(data);
        const rows = data.split('\n').slice(1).filter(row => row.length >0); //첫번째 행 제거
        // console.log(rows);

        const parseData = rows.map(row => {
            const cols = row.split(',');
            return {
                rm: parseFloat(cols[5]), //방의 갯수 (x)
                medv: parseFloat(cols[13]) //주택 가격 (y)
        }})
        // console.log(parseData);
        return parseData;
    }catch(error){
        console.log(error);
        return [];
    }
    // console.log("데이터 로드 완료");
}

// 상관계수 
function calcCorrelation(x, y){
    const correlation = ss.sampleCorrelation(x, y);
    console.log(`피어슨 상관계수 : ${correlation.toFixed(3)}`);
}

export async function runAnalysis(){
    console.log("분석 시작");
    const data = await fetchHousingData();
    if(data.length === 0) {
        console.error("데이터 로드 실패");
        return;
    }
    const dataX = data.map(d => d.rm); //방의 갯수(rm)를 독립변수 x로 추출
    const dataY = data.map(d => d.medv); //주택 가격(medv)을 종속변수 y로 추출

    // console.log(dataX);
    calcCorrelation(dataX, dataY); //상관계수 확인 => 피어슨 상관계수 : 0.695 매우 높음

    //모델 학습
    //데이터를 텐서로 변환
    const tensorX = tf.tensor2d(dataX, [dataX.length, 1]);
    const tensorY = tf.tensor2d(dataY, [dataY.length, 1]); //종속변수는 1차원도 가능
    if(!model){
        model = tf.sequential();
        model.add(tf.layers.dense({units:1, inputShape: [1]}));
        model.compile({loss: 'meanSquaredError', optimizer: 'adam'});

        await model.fit(tensorX, tensorY, {epochs : 1000});

        //예측 수행
        const predictions = model.predict(tensorX).dataSync();
        // console.log(predictions);

        // 차트 표시
        createScatterPlot(dataX, dataY, predictions);

        // 예측 값 출력
        displayPrediction(dataY, predictions);
        document.getElementById("result-continer").style.display = "block";
        document.getElementById("start").style.display = "none";
    }
}

function createScatterPlot(dataX, dataY, predictions){
// 실제 데이터 (X, Y) 값을 객체 배열로 변환
    const actualValues = dataX.map(( x, i ) => ( { x: x, y: dataY[i] } ) );
    // 예측 데이터 (X, 예측 값) 값을 객체 배열로 변환
    const predictValues = dataX.map(( x, i ) => ( { x: x, y: predictions[i] } ) );
    
    // 'scatter-plot' div 선택
    const container = document.getElementById('scatter-plot');

    // TensorFlow.js의 시각화 라이브러리를 사용하여 산포도 그리기
    tfvis.render.scatterplot(container, {values: [actualValues, predictValues]}, 
        {
          xLabel: '숙소당 방 수 (RM)',
          yLabel: '주택의 중간 값 (MEDV)',
          height: 300,        // 그래프 높이 설정
          series: ['Actual', 'Predicted']   // 데이터 시리즈 레이블 설정 (실제값, 예측값)
    } );

}

function displayPrediction(actualYvalues, predictions){

    const predictList = document.getElementById("predictions-list");
    predictList.innerHTML = "";
    predictions.forEach((pred,index) => {
        const listitem = document.createElement('li');
        listitem.textContent = `실제값 : ${actualYvalues[index].toFixed(2)} / 예측값 : ${pred.toFixed(2)}`;
        predictList.appendChild(listitem);
    })
}

export async function predictPrice(){
    //입력된 미지의 방갯수에 대한 집 값 출력
    const roomsInput = document.getElementById("roomsInput").value;
    if(roomsInput && model){
        const inputTensor = tf.tensor2d([parseFloat(roomsInput)], [1,1]);
        const prediction = model.predict(inputTensor).dataSync();
        if(prediction <0){
            prediction = 0; //예측된 가격이 음수이면 실제값의 최소값을 입력 ... 0
        }
        else document.getElementById("singlePrediction").textContent = `예상 집 값 : ${prediction[0].toFixed(2)}`;
    }
    else{
        document.getElementById("roomsInput").textContent = "방의 갯수를 입력하세요";
    }
}


document.getElementById("showButton").addEventListener("click", runAnalysis);
document.getElementById("predictButton").addEventListener("click", predictPrice);