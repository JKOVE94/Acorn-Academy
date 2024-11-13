function checkData() {
	if(frm.name.value ===""){
		alert("작성자를 입력하시오");
		frm.name.focus();
		return;
	}
	frm.submit();
}

function upData() {
	if(frm.pass.value === ""){
		alert("암호를 입력하시오");
		frm.name.focus();
		return;
	}
	
	else if(confirm("정말 수정할까요?")){
		if(passcheck.value === frm.pass.value){
			frm.submit();
		}
		else{
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
	}
}