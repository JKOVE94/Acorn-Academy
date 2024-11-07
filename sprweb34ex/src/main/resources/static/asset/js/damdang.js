const logout = event =>{
	event.preventDefault();
	sessionStorage.removeItem("login")
	fetch('delCookie'); //쿠키 삭제
	location.href="/"
}

document.addEventListener('DOMContentLoaded', () => {
		document.getElementById('bsubmit').addEventListener('click', () => {
			const busername = document.querySelector('input[name="busername"]').value;
			const print = document.getElementById('printbuser');
			const print2 = document.getElementById('printgogek');
			const print3 = document.getElementById('last');
			const coordsp = print3.getBoundingClientRect();
			let str = "";
			fetch(`searchb?busername=${busername}`)
				.then(res => {
					if (!res.ok) {
						return new Error("res error");
					}
					else {
						return res.json();
					}
				})
				.then(response => {
					data = response.datas;
					if (1 === 0) {
						print.innerHTML = "<h3>잘못된 부서정보입니다. 다시 입력해주세요</h3>";
					}
					else {
						str += "<h2>" + data[0].jikbusername + " 직원 명부 </h2>"
						str += "<table class='table'><tr><th>직원번호</th><th>직원명</th><th>부서전화</th><th>직급</th><th>관리고객수</th></tr>";
						data.forEach(idx => {
							str += "<tr><td>" + idx.jiknum + "</td>";
							if (idx.jikdamgogek > 0) {
								str += "<td><a href='#' class='getinfo' data-jiknum='" + idx.jiknum + "' data-jikname='" + idx.jikname + "'>" + idx.jikname + "</a></td>";
							}
							else {
								str += "<td>" + idx.jikname + "</td>";
							}
							str += "<td>" + idx.jikbusertel + "</td>";
							str += "<td>" + idx.jikjik + "</td>";
							str += "<td>" + idx.jikdamgogek + "</td>";
							str += "</tr>"
							print.innerHTML = str;
							window.scrollTo(coordsp);

							const targetbtns = document.querySelectorAll('.getinfo');
							let str2 = '';
							targetbtns.forEach(targetbtn => {
								targetbtn.addEventListener('click', event => {
									const jiknum = targetbtn.getAttribute('data-jiknum');
									const jikname = targetbtn.getAttribute('data-jikname');
									fetch(`/damgo?jikwonno=${jiknum}`)
										.then(res => {
											if (!res.ok) {
												return new Error("고객 정보 출력 문제");
											}
											else {
												return res.json();
											}
										})
										.then(response => {
											const gogeks = response.datas;
											str2 = "";
											if (1 === 0) {
												print2.innerHTML = "<h3>잘못된 정보입니다. 다시 입력해주세요</h3>";
											}
											else {
												str2 += `<h2> ${jikname} 담당 고객 명부 </h2>`;
												str2 += "<table class='table'><tr><th>고객번호</th><th>고객명</th><th>고객전화</th></tr>";
												gogeks.forEach(idx => {
													str2 += "<tr><td>" + idx.gnum + "</td>";
													str2 += '<td data-toggle="tooltip" data-placement="top" title="주민등록번호 : '+idx.gjumin+'">' + idx.gname + '</td>';
													str2 += "<td>" + idx.gtel + "</td>";
													str2 += "</tr>"
													print2.innerHTML = str2;
												})
											}
												window.scrollTo({top:5000});
											const hovers = document.querySelectorAll('.event')
											hovers.forEach(hover => {
												hover.addEventListener('mouseover', event => {
													const jumin = hover.getAttribute('data-gjumin');
													alert(jumin);

												})
											})
										})
								})
							})
						})
					}
				})

				.catch(error => {
					print2.innerHTML=""
					print.innerHTML = "<h3>잘못된 부서정보입니다. 다시 입력해주세요</h3>";
				})
		})
	})