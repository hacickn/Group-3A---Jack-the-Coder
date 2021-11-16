import "./App.css";
import InitialScreen from "./screens/InitialScreen";
import MainScreen from "./screens/MainScreen";
import CalendarScreen from "./screens/CalendarScreen";
import { Provider } from "react-redux";
import reducer from "./reducer";
import { createStore } from "redux";

function App() {

  const initialStore = {
    isAttendDialogOpen: false,
  };

  const store = createStore(reducer, initialStore);

  return (
    <Provider store={store}>
        {console.log(store.getState())}
      <div className="App" style={{ overflowX: "hidden" }}>
        <div>
          <CalendarScreen />
        </div>
      </div>
    </Provider>
  );
}

export default App;
