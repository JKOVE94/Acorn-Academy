document.addEventListener('DOMContentLoaded',()=>{
	const toastTrigger = document.getElementById('liveToastBtn')
	const toastLiveExample = document.getElementById('liveToast')

	if (toastTrigger) {
	  const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
	  toastTrigger.addEventListener('click', () => {
	    toastBootstrap.show()
	  })
	}
})
const login = event =>{
	event.preventDefault();
	const jikwonno = document.getElementById('jikwonno').value;
	const jikwonname = document.getElementById('jikwonname').value;
	fetch(`logincheck?jikwonno=${jikwonno}&jikwonname=${jikwonname}`)
		.then(res=>{
			if(!res.ok){
				document.getElementById('liveToastBtn').click();
			}
			else {
				sessionStorage.setItem('login',true);
				location.href="/damdanggogek";
			}
		})
		.catch(err=>{
			console.log('login err : '+err);
			alert('로그인 실패');
	})
}