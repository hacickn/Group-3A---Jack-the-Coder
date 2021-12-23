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
import Env from "./utils/Env";
import React from "react";
import axios from "axios";


function App() {
    const [ program, setProgram ] = React.useState( null )
    const [ isFailed, setFailed ] = React.useState( false )

    async function getProgram() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        axios.get( process.env.REACT_APP_URL + "user/detail?userId=" + Env.PUBLIC_ID, { headers: headers } )
             .then( function ( response ) {

                 if ( response.status === 200 ) {
                     setProgram( response.data )
                     console.log( response.data )
                     setFailed( false )
                 } else {
                     setProgram( null )
                     setFailed( true )
                 }
             } )
             .catch( function ( error ) {
                 setProgram( null )
                 setFailed( true )
             } )
    }

    const initialStore = {
        isAttendDialogOpen: false,
        currentScreen: "main",
        screenNoNavbar: "login",
    };

    const store = createStore( reducer, initialStore );

    if ( program === null && !isFailed ) {
        Env.TOKEN = localStorage.getItem( "token" ) !== null ? localStorage.getItem( "token" ) : ''
        Env.PUBLIC_ID = localStorage.getItem( "publicId" ) !== null ? localStorage.getItem( "publicId" ) : ''
        getProgram()
    }

    return ( <Router>
            <Switch>
                <Route children={ <ConfirmationScreen/> } path={ "/confirmation/:confirmationCode" }/>
                <Route children={ <ResetPasswordScreen/> } path={ "/resetPassword/:resetCode" }/>
                <Route children={
                    <Provider store={ store }>
                        <div className="App">
                            <div>
                                <ScreensInNavbar program={ program }
                                                 setProgram={ ( value ) => setProgram( value ) }
                                                 isFailed={ isFailed }
                                                 setFailed={ ( value ) => setFailed( value ) }/>
                            </div>
                        </div>
                    </Provider>
                } path={ "/" }/>
            </Switch>
        </Router>
    );
}

export default App;
