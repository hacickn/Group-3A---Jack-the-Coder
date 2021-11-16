import BilboardNavbar from "../components/BilboardNavbar";
import HomeScreen from "./HomeScreen";


const MainScreen = () => {

    return (
        <>
            <BilboardNavbar  currentScreen="calendar" attendActive/>
            <HomeScreen/>
        </>
    );
};

export default MainScreen;
