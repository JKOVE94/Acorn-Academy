document.addEventListener("DOMContentLoaded", () => {
	const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
	const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	
	const target= documnet.querySelector(".photo");
	
	document.getElementById('test').addEventListener('click',()=>{
	alert('a')
		
	})
	
	
	fetch('/getinfo')
	.then(res => {
		if(!res.ok) throw new Error('전체자료 가져오기 에러');
		else return res.json();
	})
	.then(data=>{
		const dto = data.datas;
		let str="test";
		target.innerText=str;
		
	})
})

const mouseover = element => {
	const code = element.dataset.value;
	const target= document.getElementById(code);
	fetch(`getinfo/${code}`, { method: 'GET' })
		.then(res => {
			if (!res.ok) throw new Error('정보 가져오기 에러');
			else {
				return res.json();
			}
		})
		.then(datas => {
			const dto = datas.data;
			let str = `<div> <strong>코드 :</strong> ${dto.code}<br/>`;
			str+=`<strong>상품명 :</strong> ${dto.sang}<br/>`;
			str+=`<strong>수량 : </strong>${dto.su}<br/>`;
			str+=`<strong>단가 : </strong>${dto.dan}<br/>`;
			str+=`<strong>사진 설명 : </strong>${dto.sajinList[0].about}<br/>`;
			target.innerHTML=str;
			
		})
		.catch(error => {
			console.log('에러발생 :' + error)
	})
}


const mouseout = element => {
	const code = element.dataset.value;
	const target= document.getElementById(code);
	target.innerHTML="";
}