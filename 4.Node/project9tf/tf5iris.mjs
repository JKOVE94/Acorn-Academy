const IRIS_URL = "https://raw.githubusercontent.com/mwaskom/seaborn-data/master/iris.csv";

let model;

async function loadData(){
    const response = await fetch(IRIS_URL);
    const data = await response.text();
    //console.log(data);

    const lines = data.split("\n").slice(1);
    const features = [];  // 독립
    const labels = [];    // 종속

    lines.forEach(line => {
        const [sepalLength,sepalWidth,petalLength,petalWidth, species] = line.split(",");

        if(!species) return; // 마지막 빈 줄 건너뛰기
        features.push([parseFloat(sepalLength), parseFloat(sepalWidth), parseFloat(petalLength), parseFloat(petalWidth)]);
        // 꽃의 종류 : setosa, versicolor, virginica
        // One-hot encoding
        if(species === 'setosa') labels.push([1,0,0]);
        else if(species === 'versicolor') labels.push([0,1,0]);
        else if(species === 'virginica') labels.push([0,0,1]);
    });

    //console.log(features);
    //console.log(labels);
    return {
        features:tf.tensor2d(features),
        labels:tf.tensor2d(labels),
    };
}

async function trainModel(){
    // 로딩 메세지 표시
    document.getElementById("loading-message").style.display = 'block';

    const data = await loadData();

    // 텐서를 배열로 변환환
    const featuresArray = await data.features.arraySync();  // 비동기로 배열 변환환
    const labelsArray = await data.labels.arraySync();

    data.features.dispose();
    data.labels.dispose();

    // 모델
    model = tf.sequential();
    model.add(tf.layers.dense({inputShape:[4], units:16, activation:'relu'}));
    //model.add(tf.layers.dense({units:24, activation:'relu'}));
    //model.add(tf.layers.dense({units:16, activation:'relu'}));
    model.add(tf.layers.dense({units:3, activation:'softmax'}));

    model.compile({
        loss:"categoricalCrossentropy",
        optimizer:tf.train.adam(),
        metrics:['accuracy'],
    });

    const metricsContainer = {
        name:"학습 진행 상태",
        tab:'Training'
    };

    const callbacks = tfvis.show.fitCallbacks(metricsContainer, ["loss", "acc"], {
        height:200,
        callbacks:['onEpochEnd']
    });

    // 모델 학습
    const history = await model.fit(tf.tensor2d(featuresArray), tf.tensor2d(labelsArray),{
        epochs:100,
        batchSize:16,
        verbose:1,
        callbacks:callbacks  // tfvis 콜백 추가
    });
    console.log(history.history);

    document.getElementById("trainingStatus").innerText = `모델 학습 완료(정확도:${(history.history.acc.slice(-1)[0]*100).toFixed(2)}%)`

    // 로딩 메세지 숨기기
    document.getElementById("loading-message").style.display = 'none';

    // 모델 정보 시작화
    tfvis.show.modelSummary({name:"요약", tab:"모델정보"}, model);

    // 산점도 시각화
    visualizeScatterPlot(featuresArray, labelsArray);
}

async function predictSpecies(){
    if(!model){
        alert("모델이 학습되지 않음. 모델 학습 시작 버튼 클릭 ");
        return;
    }

    const sepalLength = parseFloat(document.getElementById("sepalLength").value);
    const sepalWidth = parseFloat(document.getElementById("sepalWidth").value);
    const petalLength = parseFloat(document.getElementById("petalLength").value);
    const petalWidth = parseFloat(document.getElementById("petalWidth").value);

    const inputTensor = tf.tensor2d([[sepalLength, sepalWidth, petalLength, petalWidth]]);
    const prediction = model.predict(inputTensor);

    const predictedIndex = prediction.argMax(-1).dataSync()[0];
    inputTensor.dispose();

    let species;
    if(predictedIndex === 0) species = 'setosa';
    else if(predictedIndex === 1) species = 'versicolor';
    else if(predictedIndex === 2) species = 'verginica';

    document.getElementById("prediction-result").innerText = `예측된 꽃 종류 : ${species}`;
}

function visualizeScatterPlot(featuresArray, labelsArray) {
    const classes = ['setosa', 'versicolor', 'virginica'];
    // 각 품종별 데이터 분리
    const seriesData = classes.map((className, classIndex) => {
        const values = featuresArray
            .map((feature, i) => {
                const label = labelsArray[i].indexOf(1);   // One-hot에서 클래스 인덱스 가져오기

                if (label === classIndex) {
                    return { x: feature[0], y: feature[2] };  // Sepal Length vs Petal Length
                }

                return null;
            })
            .filter(point => point !== null);    // 유효한 데이터만 필터링
        return { name: className, values };    // 시리즈 생성
    });

    // 시리즈 데이터와 색상 매핑의 길이를 검증
    console.log('Series Data:', seriesData);

    // Scatter Plot 렌더링

    tfvis.render.scatterplot(

        { name: 'Sepal Length vs Petal Length (품종별)' },

        { values: seriesData.map(series => series.values) }, // 데이터 시리즈의 values만 전달

        {
            xLabel: 'Sepal Length',
            yLabel: 'Petal Length',
            height: 400,
            seriesColors: ['red', 'yellow', 'blue'],   // 각 시리즈에 대해 색상 지정
        }
    );
}


document.getElementById("trainModel").addEventListener("click", trainModel);
document.getElementById("predictButton").addEventListener("click", predictSpecies);