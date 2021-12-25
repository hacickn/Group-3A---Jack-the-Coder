import MainScreen from "./MainScreen";
import CalendarScreen from "./CalendarScreen";
import { connect } from "react-redux";
import UserScreen from "./UserScreen";
import ClubManagementScreen from "./ClubManagementScreen";
import SurveyScreen from "./SurveyScreen";
import BilboardNavbar from "../components/BilboardNavbar";
import AboutScreen from "./AboutScreen";
import InitialScreen from "./InitialScreen";
import AdminScreen from "./AdminScreensComponents/AdminScreen";
import AdministrativeAssistantScreen from "../screens/AdministrativeAssistantComponents/AdministrativeAssistantScreen";
import { CircularProgress } from "@mui/material";
import React from 'react';

const ScreensInNavbar = ( {
                              setScreenNoNavbar,
                              currentScreen,
                              screenNoNavbar,
                              program,
                              setProgram,
                              isFailed,
                              setFailed
                          } ) => {
    const [ currentClubId, setCurrentClubId ] = React.useState( 0 )


    function singOut() {
        localStorage.setItem( "token", '' )
        localStorage.setItem( "publicId", '' )
        setFailed( true )
        setProgram( null )
    }

    if ( !isFailed && screenNoNavbar === "login" ) {
        setScreenNoNavbar( "main" )
    }


    return (
        <div>
            { screenNoNavbar === "about" ? (
                <AboutScreen/>
            ) : screenNoNavbar === "login" ?
                <InitialScreen setProgram={ ( value ) => setProgram( value ) }
                               setFailed={ ( value ) => setFailed( value ) }/> :
                program === null ?
                    <CircularProgress/> : program.type === "student" || program.type === "academic" ?
                        <div>
                            <BilboardNavbar currentClubId={ currentClubId }
                                            setCurrentClubId={ ( value ) => setCurrentClubId( value ) } attendActive
                                            program={ program }/>
                            <div style={ { marginTop: "68px" } }>
                                { currentScreen === "main" ? (
                                    <MainScreen program={ program }/>
                                ) : currentScreen === "survey" ? (
                                    <SurveyScreen program={ program }/>
                                ) : currentScreen === "calendar" ? (
                                    <CalendarScreen program={ program }/>
                                ) : currentScreen === "user" ? (
                                    <UserScreen
                                        program={ program } signOut={ () => singOut() }
                                        image="https://picsum.photos/300"/>
                                ) : currentScreen === "clubManagement" ? (
                                    <ClubManagementScreen currentClubId={ currentClubId }
                                                          program={ program }/>
                                ) : (
                                    <MainScreen/>
                                ) }
                            </div>
                        </div> :
                        program.type === "admin" ?
                            <AdminScreen signOut={ () => singOut() }/> :
                            <AdministrativeAssistantScreen signOut={ () => singOut() }/> }
        </div>
    );
};

const mapStateToProps = ( state ) => {
    return {
        currentScreen: state.currentScreen,
        screenNoNavbar: state.screenNoNavbar,
    };
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setScreenNoNavbar: ( value ) => dispatch( { type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value } )
    }
}

export default connect( mapStateToProps, mapDispatchToProps )( ScreensInNavbar );
