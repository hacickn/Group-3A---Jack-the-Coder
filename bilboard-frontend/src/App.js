import "./App.css"; 
import { Provider } from "react-redux";
import reducer from "./reducer";
import { createStore } from "redux";
import ScreensInNavbar from "./screens/ScreensInNavbar";

function App() {
  const initialStore = {
    isAttendDialogOpen: false,
    currentScreen: "main",
    screenNoNavbar: "login",
  };

  const store = createStore(reducer, initialStore);

  return (
    <Provider store={store}>
      <div className="App">
        <div>
          <ScreensInNavbar />
        </div>
      </div>
    </Provider>
  );
}

export default App;
