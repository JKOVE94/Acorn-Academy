const checklogin = () =>{
    const loginsession = sessionStorage.getItem('login');
    if(loginsession!=null){
        location.href="/damdanggogek"
    }
    else{
		const myModal = document.getElementById('myModal')
		const myInput = document.getElementById('myInput')

		myModal.addEventListener('shown.bs.modal', () => {
		  myInput.focus()
		})
		const loginbtn = document.getElementById('gologin')
		loginbtn.addEventListener('click',()=>{
			alert('a')
			
		})
    }
}

const movepage = () =>{
	location.href="/damdanggogek"
}
