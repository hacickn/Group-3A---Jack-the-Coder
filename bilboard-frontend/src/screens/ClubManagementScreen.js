import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";
import BilboardButton from "../components/BilboardButton";
import React from "react";
import Constants from "../utils/Constants";
import ClubManagementGeneralScreen from "./clubManagementScreens/ClubManagementGeneralScreen";
import ClubManagementAddEventScreen from "./clubManagementScreens/ClubManagementAddEventScreen";
import ClubManagementSponsorScreen from "./clubManagementScreens/ClubManagementSponsorScreen";
import ClubManagementHierarchyScreen from "./clubManagementScreens/ClubManagementHierarchyScreen";
import ClubManagementSurveyScreen from "./clubManagementScreens/ClubManagementSurveyScreen";
import ClubManagementFeedbackScreen from "./clubManagementScreens/ClubManagementFeedbackScreen";

const ClubManagementScreen = () => {

    const pages = ["General", "Add Events", "Feedbacks", "Surveys", "Club Hierarchy", "Sponsors",];
    const [openedScreen, setOpenedScreen] = React.useState("General")


    return (<Grid container style={{padding: 20}}>
        <Grid style={{
            height: "88vh",
            borderRadius: Constants.BORDER_RADIUS
        }}
              item xs={3}>
            <Grid container style={{
                borderStyle: "solid",
                borderColor: Colors.BILBOARD_BLUE,
                borderRadius: Constants.BORDER_RADIUS,
            }}>
                {pages.map(page => <Grid item xs={12} style={{
                    paddingTop: 5,
                    paddingBottom: 5,
                }}>
                    {openedScreen === page ?
                        <BilboardButton text={page}
                                        fontSize={16}
                                        width="23vw"
                                        height={"4vh"}
                                        color={Colors.BILBOARD_BLUE}
                                        textColor={Colors.WHITE}
                        />
                        :
                        <BilboardButton text={page}
                                        fontSize={16}
                                        width="23vw"
                                        height={"4vh"}
                                        color={Colors.WHITE}
                                        textColor={Colors.BILBOARD_BLUE}
                                        onClick={() => setOpenedScreen(page)}
                        />}
                </Grid>)}
            </Grid>

        </Grid>
        <Grid item xs={9}>
            {openedScreen === "General" ? <ClubManagementGeneralScreen/> :
                openedScreen === "Add Events" ? <ClubManagementAddEventScreen/> :
                    openedScreen === "Feedbacks" ? <ClubManagementFeedbackScreen/> :
                        openedScreen === "Surveys" ? <ClubManagementSurveyScreen/> :
                            openedScreen === "Club Hierarchy" ? <ClubManagementHierarchyScreen/> :
                                openedScreen === "Sponsors" ? <ClubManagementSponsorScreen/> : <div/>}
        </Grid>
    </Grid>)
}

export default ClubManagementScreen;