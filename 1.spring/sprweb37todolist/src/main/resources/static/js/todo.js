//페이지가 로드되자 마자 리스트를 출력
document.addEventListener('DOMContentLoaded',()=>{
    list()
 const toastTrigger = document.getElementById('liveToastBtn')
      const toastLiveExample = document.getElementById('liveToast')

      if (toastTrigger) {
        const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
        toastTrigger.addEventListener('click', () => {
          toastBootstrap.show()
        })
      }
})
 
//----------------- toast와 관련된 함수들 ------------------
const toast = () =>{
	document.getElementById('liveToastBtn').click();
}

//----------------- toast과 관련된 함수들 ------------------

//오프캔버스를 사용함으로 발생한 문제! input과 update의 name이 동일하다보니 checked 
const checkInput = word =>{
	const userinput = word;
	const completedInputs = document.querySelectorAll('input[name="completed"]');
	const items = [];
	completedInputs.forEach(input =>{
		if(userinput=='i'){ //사용자가 i를 입력했을떄
			if(/^i/.test(input.id)){ //id가 i로시작하는 경우
				items.push(input);
			}
		}
		else if(userinput=='u'){ //사용자가 u를 입력했을떄
			if(/^u/.test(input.id)){
				items.push(input);
			}
		}
	})
	
	let checked = items.find(e=>e.checked)
	return checked;
	
}


//----------------- CRUD와 관련된 함수들 ------------------
  
  //READ
  const list = () =>{
        const Nlist = document.getElementById('printN');
        const Ylist = document.getElementById('printY');
        let Nstr='';
        let Ystr='';
        fetch('/api',{method:'GET'})
        .then(res =>{
            if(!res.ok){
                throw new Error('서버 에러');
            }
            else {
            	return res.json();
            }
        })
        .then(datas =>{
			Nstr+="<h2>예정 항목</h2>"
            Nstr+="<table class='table'><tr><th>번호</th><th>제목</th><th>우선순위</th><th>완료 여부</th><th>수정</th><th>삭제</th></tr>"
			Ystr+="<h2>완료 항목</h2>"
            Ystr+="<table class='table'><tr><th>번호</th><th>제목</th><th>우선순위</th><th>완료 여부</th><th>수정</th><th>삭제</th></tr>"
            datas.forEach(idx=>{
				if(!idx.completed){
	                let complete = idx.completed?'완료':'예정';
	                Nstr+="<tr>"
	                Nstr+="<td>"+idx.id+"</td>"
	                Nstr+="<td>"+idx.title+"</td>"
	                Nstr+="<td>"+idx.order+"</td>"
	                Nstr+="<td>"+complete+"</td>"
					//수정을 눌렀을 때 수정탭으로 이동할 수 있는 upProcess() 함수
	                Nstr+=`<td> <a href="#update" data-bs-toggle="offcanvas" onclick="upProcess(${idx.id})">수정</a> </td>`
					//삭제를 눌렀을 때 삭제탭으로 이동할 수 있는 delProcess() 함수
	                Nstr+=`<td> <a href="#" onclick="delProcess(${idx.id})">삭제</a> </td>`
	                Nstr+="</tr>"
				}
				else{
					let complete = idx.completed?'완료':'예정';
	                Ystr+="<tr>"
	                Ystr+="<td>"+idx.id+"</td>"
	                Ystr+="<td>"+idx.title+"</td>"
	                Ystr+="<td>"+idx.order+"</td>"
	                Ystr+="<td>"+complete+"</td>"
					//수정을 눌렀을 때 수정탭으로 이동할 수 있는 upProcess() 함수
	                Ystr+=`<td> <a href="#update" data-bs-toggle="offcanvas" onclick="upProcess(${idx.id})">수정</a> </td>`
					//삭제를 눌렀을 때 삭제탭으로 이동할 수 있는 delProcess() 함수
	                Ystr+=`<td> <a href="#" onclick="delProcess(${idx.id})">삭제</a> </td>`
	                Ystr+="</tr>"
				}
            })
            Nstr+="</table><br/>"
            Nlist.innerHTML=Nstr;
            Ystr+="</table>"
            Ylist.innerHTML=Ystr;

        })
        .catch(err =>{
    		console.log("불러오기 에러"+err);
    	})
    } 
    
    //DELETE 토스트 버튼 활성화, 질문후 삭제 진행
    const delProcess = code =>{
		toast();
        const id = code; //list에서 받은 code 상수화
		
		//유저가 yes버튼을 눌렀을 떄 삭제 진행
        document.getElementById('dyes').onclick = () =>{
            fetch(`/api/${id}`,{method:'DELETE'})
            .then(res=>{
                if(!res.ok){
                    throw new Error('삭제 에러')
                }
                else {
                    list(); //GET 요청
                }
            })
        }
		
		//유저가 no버튼을 눌렀을 때 메인 페이지로 이동
		document.getElementById('dno').onclick = () =>{
			document.querySelector('button[aria-label="Close"]').click();
            list(); //GET 요청
        }
	}
        
    //INSERT
    const input = event =>{
        event.preventDefault();
        const title = document.getElementById('ititle').value;
        const order = document.getElementById('iorder').value;
        const completed = checkInput('i').value;
        const ijson= {"title":title,"order":order,"completed":completed};
        fetch('/api',{method:"POST", 
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(ijson)})
        .then(res=>{
            if(!res.ok){
                throw new Error('입력 오류');
            }
            else {
                list(); //GET 요청
				document.getElementById('iclose').click();
            }
        })
    } 
	
	//UPDATE , 데이터 채우기
	const upProcess = id =>{
		fetch(`/api/${id}`)
		.then(res =>{
			if(!res.ok){
				throw new Error('데이터 하나 가져오기 에러');
			}
			else return res.json();
		})
		.then(data =>{
			//UPDATE의 input value 채우기
	        document.getElementById('uid').value=data.id;
			document.getElementById('utitle').value=data.title;
			document.getElementById('uorder').value=data.order;
			if(data.completed==false){
				document.getElementById('ucompletedN').checked=true;	
			}
			else document.getElementById('ucompletedY').checked=true;
		})
	}

    //UPDATE
    const update = event =>{
        event.preventDefault();
        const uid = document.getElementById('uid').value;
        const utitle = document.getElementById('utitle').value;
        const uorder = document.getElementById('uorder').value;
        let ucompleted = checkInput('u').value;
        const ujson= {"title":utitle,"order":uorder,"completed":ucompleted};
		
        fetch(`/api/${uid}`,{method:"PATCH", 
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(ujson)})
        .then(res=>{
            if(!res.ok){
                throw new Error('수정 오류');
            }
            else {
                list(); //GET 요청
				document.getElementById('uclose').click();
            }
        })
    } 