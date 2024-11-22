// action을 정의하는 파일을 별도 작성
// action 객체를 생성하는 액션 생성자 함수를 정의

// Jikwon data를 처리하는 action객체 생성
// dispatch(setEmployees([{jikwonno:"1", jikwonname:"홍길동"},... ])) 이런식으로 사용
export const setEmployees = (employees) => ({
    type : "SET_EMPLOYEES",
    payload : employees
})

// Gogek data를 처리하는 action객체 생성
export const setCustomers = (costumers) => ({
    type : "SET_CUSTOMERS",
    payload : costumers
})