document.addEventListener("DOMContentLoaded", () => {
	const target= document.querySelector(".gallery");
	fetch('/getinfo',{method:"GET"})
	.then(res => {
		if(!res.ok) throw new Error('전체자료 가져오기 에러');
		else return res.json();
	})
	.then(data=>{
		const dto = data.datas;
		let str="";
		dto.forEach(idx=>{
			str+="<div class='photo'>";
			str+=`<h3>${idx.sang}</h3>`;
			str+=`<img src="${idx.path}" data-bs-toggle="tooltip" data-bs-title="<b>상품코드 : </b> ${idx.code}<br/>`;
			str+= `<b>수량 : </b>${idx.code}<br/><b>단가 : </b>${idx.dan}<br/><b>설명 : </b>${idx.about}" data-bs-html="true"  data-bs-placement="right"/>`
			str+="</div>";
		})
		target.innerHTML=str;
		
	const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
	const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
	})
})
