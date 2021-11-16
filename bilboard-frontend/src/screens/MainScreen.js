import React from 'react';
import BilboardNavbar from "../components/BilboardNavbar";
import CalendarScreen from "./CalendarScreen";
import HomeScreen from "./HomeScreen";


const MainScreen = () => {
    const [currentScreen, setCurrentScreen] = React.useState("home")

    function handleCurrentScreenChange(pageName) {
        setCurrentScreen(pageName)
    }

    return (
        <>
            <BilboardNavbar currentScreen={currentScreen}
                            handleCurrentScreenChange={(pageName) => handleCurrentScreenChange(pageName)}/>
            {currentScreen === "home" ? <HomeScreen/> :
                currentScreen === "survey" ? <div> Survey Screen </div> :
                    currentScreen === "calendar" ? <CalendarScreen/> :
                        currentScreen === "account" ? <div> Account Screen </div>
                    : <HomeScreen/>}
        </>
    );
};

export default MainScreen;
