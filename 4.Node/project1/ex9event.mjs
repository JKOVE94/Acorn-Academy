//이벤트 처리
// events 모듈의 EventEmitter 클래스를 사용하면 이벤트와 이벤트 핸들러를 연결할 수 있다.

import {EventEmitter} from 'events';

const myEvent = new EventEmitter();

//이벤트 등록 addListener(이벤트명, 이벤트 핸들러)
//removeListener(이벤트명, 이벤트 핸들러) => 이벤트 제거
myEvent.addListener('event1', () => {
    console.log('이벤트 1');

})

//이벤트 등록 on(이벤트명, 이벤트 핸들러) => addListener와 같은 기능을 가진 method
//myEvent.off => 이벤트 제거
myEvent.on('event2', () => {
    console.log('이벤트 2');
})

//이벤트 등록 on(이벤트명, 이벤트 핸들러) => addListener와 같은 기능을 가진 method
myEvent.on('event2', () => {
    console.log('이벤트 2 한번 더');
})

//이벤트 등록 once(이벤트명, 이벤트 핸들러) => 여러번 실행해도 1회만 수행
myEvent.once('event3', () => {
    console.log('이벤트 3');
})

myEvent.emit('event1');
myEvent.emit('event2');
myEvent.emit('event3');
myEvent.emit('event3');
myEvent.emit('event3');

console.log(myEvent.listenerCount('event1')) //이벤트 핸들러 개수 확인 1
console.log(myEvent.listenerCount('event2')) //이벤트 핸들러 개수 확인 2
console.log(myEvent.listenerCount('event3')) /*이벤트 핸들러 개수 확인 0 
=> 한개가 등록 되어있는데 왜 0이 나오는가?
once는 한번 실행되고 바로 EventEmitter에서 제거되기 때문에 0이 나온다.
*/
console.log("\n")

myEvent.on('event4', () => {
    console.log('이벤트 4');
})

myEvent.emit('event4');
//myEvent.off('event4');  <= 이렇게 하면 이벤트 핸들러가 제거되지 않는다.
myEvent.removeAllListeners('event4'); //이벤트 핸들러 제거
myEvent.emit('event4'); 

const listener = () => {
    console.log('이벤트 5');
}

myEvent.on('event5', listener);

myEvent.off('event5', listener); //이벤트 핸들러 제거
myEvent.emit('event5');

console.log("----------------------")
class MyEmitter extends EventEmitter {}; //이벤트 클래스를 상속받아 사용
const myEmitter = new MyEmitter();

myEmitter.on('event6', (a,b) => {
    console.log(a,b);
})
myEmitter.emit('event6', 'Hello', ' World');