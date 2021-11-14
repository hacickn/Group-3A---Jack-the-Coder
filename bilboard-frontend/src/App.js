import "./App.css";
import InitialScreen from "./screens/InitialScreen";
import MainScreen from "./screens/MainScreen";

function App() {
    return (
        <div className="App" style={{overflowX: "hidden"}}>
            <div>
                <MainScreen/>
            </div>
        </div>
    );
}

export default App;
