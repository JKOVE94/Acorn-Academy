import React from 'react';
import { Provider } from 'react-redux';
import store from './Store';
import EmployeeSearch from './EmployeeSearch';
import CustomerSearch from './CustomerSearch';

function App() {
  return (
    <Provider store={store}>
    <div className="App">
      <EmployeeSearch />
      <CustomerSearch />
    </div>
    </Provider>
  );
}

export default App;
