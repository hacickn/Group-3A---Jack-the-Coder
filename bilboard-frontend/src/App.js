import "./App.css";
import InitialScreen from "./screens/InitialScreen";
import MainScreen from "./screens/MainScreen";
import CalendarScreen from "./screens/CalendarScreen";
import { connect, Provider } from "react-redux";
import reducer from "./reducer";
import { createStore } from "redux";
import BilboardNavbar from "./components/BilboardNavbar";
import ScreensInNavbar from "./screens/ScreensInNavbar";

function App() {

  const initialStore = {
    isAttendDialogOpen: false,
    currentScreen: "main",
  };

  const store = createStore(reducer, initialStore);

  return (
    <Provider store={store}>
      <div className="App">
        <div>
          <BilboardNavbar attendActive/>
          <ScreensInNavbar/>
        </div>
      </div>
    </Provider>
  );
}



export default App;
