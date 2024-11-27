let datas = [
  ["햄버거", 5],
  ["도너츠", 2],
  ["김밥", 7],
  ["핫도그", 1],
  ["호떡", 3],
];

// google.charts.load("현재 버전", { packages: ["패키지 이름"] });
google.charts.load("current", { packages: ["corechart"] });
//Google Chart가 로딩된 이후에 drawFunc 함수를 콜백함수로 호출
google.charts.setOnLoadCallback(drawFunc);

//google chart는 화살표함수로 적용할 수 없다.
function drawFunc() {
  let data = google.visualization.arrayToDataTable([
    ["종류", "개수"], //header 정의
    ...datas,
  ]);
  let options = { title: "먹고싶은 것", is3D: true };
  let chart = new google.visualization.PieChart(
    document.getElementById("chart_div")
  );
  chart.draw(data, options); //차트 그리기
}
