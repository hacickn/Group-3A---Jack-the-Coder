import MainScreen from "./MainScreen";
import CalendarScreen from "./CalendarScreen";
import {connect} from "react-redux";
import UserScreen from "./UserScreen";
import ClubManagementScreen from "./ClubManagementScreen";
import SurveyScreen from "./SurveyScreen";

const ScreensInNavbar = ({currentScreen}) => {
    return (
        <div style={{marginTop: "68px"}}>
            {currentScreen === "main" ? <MainScreen/> :
                currentScreen === "survey" ? <SurveyScreen/> :
                    currentScreen === "calendar" ? <CalendarScreen/> :
                        currentScreen === "user" ? <UserScreen image="https://picsum.photos/300"/> :
                            currentScreen === "clubManagement" ? <ClubManagementScreen/>
                                : <MainScreen/>}

        </div>
    );
}


const mapStateToProps = (state) => {
    return {
        currentScreen: state.currentScreen,
    };
}


export default connect(mapStateToProps)(ScreensInNavbar);