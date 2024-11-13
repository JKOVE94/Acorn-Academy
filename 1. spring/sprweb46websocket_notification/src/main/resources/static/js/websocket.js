let stompClient = null;

const connect = () => {
	// WebSocket Application Server는 Websocket의 Endpoint를 만들고, 클라이언트는 해당 Endpoint의 URI를 통해 서버와 소통
	let socket = new SockJS("/ws"); //ws, wss 스키마 사용 가능 => ws는 암호화 되지 않은 웹소켓 연결
	stompClient = Stomp.over(socket); //중계자 역할
	
	//connect()는 Sockjs와 stomp client를 이용하여 Spring Boot에서 구성한 /ws Endpoint에 연결함
	stompClient.connect({}, frame => {
		console.log('connect : '+ frame);
		
		stompClient.subscribe('/topic/notifications', noti =>{
			//도착한 메세지(noti)를 JSON으로 파싱
			let parseNoti = JSON.parse(noti.body);
			showNotifunc(parseNoti.type, parseNoti.message);
		});
	})
}

const sendRequest = () => {
	let fromUser =  document.querySelector('#fromUser')
	if(fromUser.value.trim() === ''){
		fromUser.focus();
		alert('사용자 이름 입력');
		return
	}	
	stompClient.send("/app/friend-request",{},fromUser.value)
}

const sendComment = () => {
	let fromUser =  document.querySelector('#fromUser')
		if(fromUser.value.trim() === ''){
			fromUser.focus();
			alert('사용자 이름 입력!');
			return
		}	
		stompClient.send("/app/comment",{},fromUser.value)
	
}

const sendLike = () => {
	let fromUser =  document.querySelector('#fromUser')
		if(fromUser.value.trim() === ''){
			fromUser.focus();
			alert('사용자 이름 입력!!');
			return
		}	
		stompClient.send("/app/like",{},fromUser.value)
	
}

const showNotifunc = (type, message) => {
	let notificationList = document.getElementById('notiShow');
	let li = document.createElement('li');
	if(type==='좋아요'){
		li.innerHTML = `${type} : ${message} ❤️`;
	}
	else {
		li.appendChild(document.createTextNode(`${type} : ${message}`))
	}	
	notificationList.appendChild(li);	
	
}

window.onload = connect;