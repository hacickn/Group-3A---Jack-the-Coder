import MainScreen from "./MainScreen";
import CalendarScreen from "./CalendarScreen";
import { connect } from "react-redux";
import UserScreen from "./UserScreen";
import ClubManagementScreen from "./ClubManagementScreen";
import SurveyScreen from "./SurveyScreen";
import BilboardNavbar from "../components/BilboardNavbar";
import AboutScreen from "./AboutScreen";

const ScreensInNavbar = ({ currentScreen, isAboutScreen }) => {
  return (
    <div>
      {isAboutScreen ? (
        <AboutScreen />
      ) : (
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
    isAboutScreen: state.isAboutScreen,
  };
};

export default connect(mapStateToProps)(ScreensInNavbar);
