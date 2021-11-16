import MainScreen from "./MainScreen";
import CalendarScreen from "./CalendarScreen";
import {connect} from "react-redux";
import UserScreen from "./UserScreen";
import ClubManagementScreen from "./ClubManagementScreen";

const ScreensInNavbar = ({currentScreen}) => {
    return (
        <div>
            {currentScreen === "main" ? <MainScreen/> :
                currentScreen === "survey" ? <MainScreen/> :
                    currentScreen === "calendar" ? <CalendarScreen/> :
                        currentScreen === "user" ? <UserScreen/> :
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