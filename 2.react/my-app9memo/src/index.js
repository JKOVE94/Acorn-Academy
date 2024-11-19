import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode> {/* web의 Console에서 메세지가 2번 찍히는데 이유는 React.StrictMode 컴포넌트를 통해 Virtual DOM에서 적용된 내용, DOM에서 적용된 내용 둘다 확인할 수 있기 때문이다.  */}
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
