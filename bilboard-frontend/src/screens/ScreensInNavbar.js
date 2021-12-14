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

const ScreensInNavbar = ({ currentScreen, screenNoNavbar }) => {
  return (
    <div>
      {screenNoNavbar === "about" ? (
        <AboutScreen />
      ) : screenNoNavbar === "login" ? <InitialScreen/> : (
        <div>
          <BilboardNavbar attendActive />
          <div style={{ marginTop: "68px" }}>
            {currentScreen === "main" ? (
              <MainScreen />
            ) : currentScreen === "survey" ? (
              <SurveyScreen />
            ) : currentScreen === "calendar" ? (
              <CalendarScreen />
            ) : currentScreen === "user" ? (
              <UserScreen image="https://picsum.photos/300" />
            ) : currentScreen === "clubManagement" ? (
              <ClubManagementScreen />
            ) : (
              <MainScreen />
            )}
          </div>
        </div>
      )}
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    currentScreen: state.currentScreen,
    screenNoNavbar: state.screenNoNavbar,
  };
};

export default connect(mapStateToProps)(ScreensInNavbar);
