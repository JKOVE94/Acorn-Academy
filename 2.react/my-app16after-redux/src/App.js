import './App.css';
import ShowNumberSuper from "./mydir/ShowNumberSuper";
import AddNumberSuper from "./mydir/AddNumberSuper";

const App = () => {
  return (
    <div>
      <h1>메인 (Redux 사용)</h1>
        <AddNumberSuper/>
        <br/>
        <ShowNumberSuper/>
    </div>
  );
}

export default App;
