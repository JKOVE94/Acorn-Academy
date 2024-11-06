//페이지가 로드되자 마자 리스트를 출력
document.addEventListener('DOMContentLoaded',()=>{list()})
 
//----------------- 이동과 관련된 함수들 ------------------

//Insert에서 List로 탭 이동	
const insertToList = () =>{
	const listli = document.getElementById('list-tab');
    const listcont = document.getElementById('list');
    const insertli = document.getElementById('insert-tab');
    const insertcont = document.getElementById('insert');
	
	//기존 탭 => 탭 select false, 내용 fade
    insertli.setAttribute('aria-selected','false');
    insertli.setAttribute('class','nav-link');
    insertcont.setAttribute('class','tab-pane fade');
	//이동 탭 => 탭 select true, 내용 active show
    listli.setAttribute('aria-selected', 'true');
    listli.setAttribute('class','nav-link active');
    listcont.setAttribute('class', 'tab-pane fade active show');   
}

//List에서 Update로 탭 이동
const listToUpdate = () =>{
	const listli = document.getElementById('list-tab');
    const listcont = document.getElementById('list');
    const updateli = document.getElementById('update-tab');
    const updatecont = document.getElementById('update');
	//기존 탭 => 탭 select false, 내용 fade
    listli.setAttribute('aria-selected','false');
    listli.setAttribute('class','nav-link');
    listcont.setAttribute('class','tab-pane fade');
	//이동 탭 => 탭 select true, 내용 active show
    updateli.setAttribute('aria-selected', 'true');
    updateli.setAttribute('class','nav-link active');
    updatecont.setAttribute('class', 'tab-pane fade active show');   
}

//Update에서 List로 탭 이동
const updateToList = () =>{
	const listli = document.getElementById('list-tab');
    const listcont = document.getElementById('list');
    const updateli = document.getElementById('update-tab');
    const updatecont = document.getElementById('update');
	
	//기존 탭 => 탭 select false, 내용 fade
    updateli.setAttribute('aria-selected','false');
    updateli.setAttribute('class','nav-link');
    updatecont.setAttribute('class','tab-pane fade');
	//이동 탭 => 탭 select true, 내용 active show
    listli.setAttribute('aria-selected', 'true');
    listli.setAttribute('class','nav-link active');
    listcont.setAttribute('class', 'tab-pane fade active show');   
}

//List에서 Delete로 탭 이동
const listToDelete = () =>{
	const listli = document.getElementById('list-tab');
    const listcont = document.getElementById('list');
	const deleteli = document.getElementById('delete-tab');
	const delcont = document.getElementById('delete');
   
	//기존 탭 => 탭 select false, 내용 fade
    listli.setAttribute('aria-selected','false');
    listli.setAttribute('class','nav-link');
    listcont.setAttribute('class','tab-pane fade');
	//이동 탭 => 탭 select true, 내용 active show
    deleteli.setAttribute('aria-selected', 'true');
    deleteli.setAttribute('class','nav-link active');
    delcont.setAttribute('class', 'tab-pane fade active show');   
}

//Delete에서 List로 탭 이동
const deleteToList = () =>{
	const listli = document.getElementById('list-tab');
    const listcont = document.getElementById('list');
	const deleteli = document.getElementById('delete-tab');
	const delcont = document.getElementById('delete');
   
	//기존 탭 => 탭 select false, 내용 fade
    deleteli.setAttribute('aria-selected','false');
    deleteli.setAttribute('class','nav-link');
    delcont.setAttribute('class','tab-pane fade');
	//이동 탭 => 탭 select true, 내용 active show
    listli.setAttribute('aria-selected', 'true');
    listli.setAttribute('class','nav-link active');
    listcont.setAttribute('class', 'tab-pane fade active show');   
}

//----------------- 이동과 관련된 함수들 ------------------


//----------------- CRUD와 관련된 함수들 ------------------
  
  //READ
  const list = () =>{
        const listTarget = document.getElementById('sanglist');
        let str1='';
        fetch('/sangpum',{method:'GET'})
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
            str1+="<table class='table'><tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th><th>수정</th><th>삭제</th></tr>"
            datas.forEach(idx=>{
                str1+="<tr>"
                str1+="<td>"+idx.code+"</td>"
                str1+="<td>"+idx.sang+"</td>"
                str1+="<td>"+idx.su+"</td>"
                str1+="<td>"+idx.dan+"</td>"
				//수정을 눌렀을 때 수정탭으로 이동할 수 있는 upProcess() 함수
                str1+=`<td> <a href="#" onclick="upProcess(${idx.code})">수정</a> </td>`
				//삭제를 눌렀을 때 삭제탭으로 이동할 수 있는 delProcess() 함수
                str1+=`<td> <a href="#" onclick="delProcess(${idx.code})">삭제</a> </td>`
                str1+="</tr>"
            })
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