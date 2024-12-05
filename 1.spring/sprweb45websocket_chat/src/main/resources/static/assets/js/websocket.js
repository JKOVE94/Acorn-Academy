let stompClient = null;

const connect = () => {
	// WebSocket Application Server는 Websocket의 Endpoint를 만들고, 클라이언트는 해당 Endpoint의 URI를 통해 서버와 소통
	let socket = new SockJS("/ws"); //ws, wss 스키마 사용 가능 => ws는 암호화 되지 않은 웹소켓 연결
	stompClient = Stomp.over(socket); //중계자 역할
	
	//connect()는 Sockjs와 stomp client를 이용하여 Spring Boot에서 구성한 /ws Endpoint에 연결함
	stompClient.connect({}, frame => {
		console.log('connect : '+ frame);
		
		stompClient.subscribe('/topic/public', message => {
			showMessage(JSON.parse(message.body));
		});
	})
}

const sendMessage = () => { //서버로 메세지 전송
	// 사용자가 입력한 메세지를 '/app/message'로 전송
	let nameInput = document.querySelector('#name');
	let messsageContent = document.querySelector('#message').value;
	
	// 이름 입력란에서 이름을 서버로 전송하고 비활성화
	if(!nameInput.disabled){
		stompClient.send('/app/chat.addUser',{}, JSON.stringify({sender:nameInput.value, type:'JOIN'}));
		nameInput.disabled = true;
	}
	
	//메세지가 있고 stompClient가 연결상태라면 메세지 서버로 전송
	if(messsageContent && stompClient){
		let chatMessage = {
			sender:nameInput.value,
			type:'CHAT',
			content:messsageContent
		}
		stompClient.send('/app/chat.sendMessage',{}, JSON.stringify(chatMessage));
		document.querySelector('#message').value="";
	}
}

const leaveChat = () =>{
	let nameInput = document.querySelector('#name');
	if(stompClient){
		stompClient.disconnect();
	}
	document.querySelector('#name').disabled = false;
	alert('채팅방 안녕! 세상의 미련과 굴레를 벗어던지고 행복을 찾아 떠납니다. 여러분도 행복하세요~')
}

const showMessage = message => {
	//수신된 메세지를 페이지에 표시
	let messageElement = document.createElement('li');
	
	//메세지의 타입에 따라 다른 메세지가 화면에 출력
	if(message.type === 'JOIN'){
		messageElement.classList.add('event-message');
		message.content = message.sender + '님 입장';
	}
	else if(message.type === 'LEAVE'){
		messageElement.classList.add('event-message');
		message.content = message.sender + '님 퇴장';
	}
	else{
		messageElement.classList.add('chat-message');
		
		let usernameElement = document.createElement('strong');
		usernameElement.classList.add('nickname');
		let usernameText = document.createTextNode(message.sender+ " : ");
		usernameElement.appendChild(usernameText);
		messageElement.appendChild(usernameElement);	
	}
	
	let textElement = document.createElement('span');
	let messageText = document.createTextNode(message.content);
	textElement.appendChild(messageText);
	messageElement.appendChild(textElement);
	
	document.querySelector('#msgArea').appendChild(messageElement);
	
	//자동 스크롤 기능 추가
	let messageArea = document.querySelector('#msgArea');
	messageArea.scrollTop.scrollHeight;
	
}

window.onload = () => connect();

window.onbeforeunload = () => leaveChat(); //브라우저가 닫히기 전 웹 소켓 연결을 종료
