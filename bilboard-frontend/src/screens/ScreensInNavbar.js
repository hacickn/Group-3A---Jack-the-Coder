import MainScreen from "./MainScreen";
import CalendarScreen from "./CalendarScreen";
import { connect } from "react-redux";
import UserScreen from "./UserScreen";

const ScreensInNavbar = ({currentScreen}) => {
    return (
        <div>
        {currentScreen === "main" ? <MainScreen /> : currentScreen === "survey" ? <MainScreen/>: currentScreen === "calendar" ? <CalendarScreen/>: currentScreen === "user" ? <UserScreen image="https://picsum.photos/300"/>: <MainScreen/>}

        </div>
    );
}




const mapStateToProps = (state) => {
    return {
        currentScreen: state.currentScreen,
    };
}


export default connect(mapStateToProps)(ScreensInNavbar);