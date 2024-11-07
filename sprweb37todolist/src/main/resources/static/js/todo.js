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
 
//----------------- 팝업과 관련된 함수들 ------------------
const toast = () =>{
	const ttarget = document.getElementById('liveToast')
}


//----------------- 팝업과 관련된 함수들 ------------------


//----------------- CRUD와 관련된 함수들 ------------------
  
  //READ
  const list = () =>{
        const listTarget = document.getElementById('print');
        let str1='';
        fetch('/api',{method:'GET'})
        .then(res =>{
            if(!res.ok){
 			   	alert('a')
                throw new Error('서버 에러');
            }
            else {
            	return res.json();
            }
        })
        .then(datas =>{
            str1+="<table class='table'><tr><th>번호</th><th>제목</th><th>우선순위</th><th>완료 여부</th><th>수정</th><th>삭제</th></tr>"
            datas.forEach(idx=>{
                let complete = idx.completed?'완료':'예정';
                str1+="<tr>"
                str1+="<td>"+idx.id+"</td>"
                str1+="<td>"+idx.title+"</td>"
                str1+="<td>"+idx.order+"</td>"
                str1+="<td>"+complete+"</td>"
				//수정을 눌렀을 때 수정탭으로 이동할 수 있는 upProcess() 함수
                str1+=`<td> <a href="#update" data-bs-toggle="offcanvas" onclick="upProcess(${idx.id})">수정</a> </td>`
				//삭제를 눌렀을 때 삭제탭으로 이동할 수 있는 delProcess() 함수
                str1+=`<td> <a href="#" id="liveToastBtn" onclick="delProcess(${idx.id})">삭제</a> </td>`
                str1+="</tr>"
            })
            str1+="</table>"
            listTarget.innerHTML=str1;

        })
        .catch(err =>{
    		console.log("불러오기 에러"+err);
    	})
    }

    //UPDATE 탭으로 이동, 데이터 채우기
    const upProcess = code =>{
		listToUpdate();
		fetch(`/sangpum/${code}`)
		.then(res =>{
			if(!res.ok){
				throw new Error('데이터 하나 가져오기 에러');
			}
			else return res.json();
		})
		.then(data =>{
			//UPDATE의 input value 채우기
            document.getElementById('showucode').innerText=data.code;
			document.getElementById('ucode').value=data.code;
			document.getElementById('usang').value=data.sang;
			document.getElementById('usu').value=data.su;
			document.getElementById('udan').value=data.dan;
		})
    }
 
    
    //DELETE 탭으로 이동, 질문후 삭제 진행
    const delProcess = code =>{
		listToDelete();	 //delete 탭으로 이동
        const code1 = code; //list에서 받은 code 상수화
		
		//유저가 yes버튼을 눌렀을 떄 삭제 진행
        document.getElementById('dyes').onclick = () =>{
            fetch(`/sangpum/${code1}`,{method:'DELETE'})
            .then(res=>{
                if(!res.ok){
                    throw new Error('삭제 에러')
                }
                else {
                    deleteToList(); //DELETE 마치고 LIST로 이동
                    list(); //GET 요청
                }
            })
        }
		
		//유저가 no버튼을 눌렀을 때 메인 페이지로 이동
		document.getElementById('dno').onclick = () =>{
            deleteToList(); //DELETE를 진행하지 않고 list로 이동
            list(); //GET 요청
        }
	}
        
    //INSERT
    const input = event =>{
        event.preventDefault();
        const isang = document.getElementById('isang').value;
        const isu = document.getElementById('isu').value;
        const idan = document.getElementById('idan').value;
        const ijson= {'sang':isang,'su':isu,'dan':idan};
        fetch('/sangpum',{method:"POST", 
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(ijson)})
        .then(res=>{
            if(!res.ok){
                throw new Error('입력 오류');
            }
            else {
				insertToList(); //INSERT마치고 list로 이동
                list(); //GET 요청
            }
        })
    } 

    //UPDATE
    const update = event =>{
        event.preventDefault();
        const ucode = document.getElementById('ucode').value;
        const usang = document.getElementById('usang').value;
        const usu = document.getElementById('usu').value;
        const udan = document.getElementById('udan').value;
        const ujson= {'code':ucode,'sang':usang,'su':usu,'dan':udan};
        fetch('/sangpum',{method:"PUT", 
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(ujson)})
        .then(res=>{
            if(!res.ok){
                throw new Error('수정 오류');
            }
            else {
            	updateToList(); //UPDATE마치고 list로 이동
                list(); //GET 요청
            }
        })
    } 