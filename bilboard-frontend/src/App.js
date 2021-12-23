import "./App.css";
import { Provider } from "react-redux";
import reducer from "./reducer";
import { createStore } from "redux";
import ScreensInNavbar from "./screens/ScreensInNavbar";
import ConfirmationScreen from "./screens/ConfirmationScreen";
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";
import ResetPasswordScreen from "./screens/ResetPasswordScreen";


function App() {
    const initialStore = {
        isAttendDialogOpen: false,
        currentScreen: "main",
        screenNoNavbar: "login",
    };

    const store = createStore( reducer, initialStore );

    return ( <Router>
            <Switch>
                <Route children={ <ConfirmationScreen/> } path={ "/confirmation/:confirmationCode" }/>
                <Route children={ <ResetPasswordScreen/> } path={ "/resetPassword/:resetCode" }/>
                <Route children={
                    <Provider store={ store }>
                        <div className="App">
                            <div>
                                <ScreensInNavbar/>
                            </div>
                        </div>
                    </Provider>
                } path={ "/" }/>
            </Switch>
        </Router>
    );
}

export default App;
