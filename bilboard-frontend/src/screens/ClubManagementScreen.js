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
import ClubManagementMembersScreen from "./clubManagementScreens/ClubManagementMembersScreen";
import ClubManagementMembershipRequestsScreen from "./clubManagementScreens/ClubManagementMembershipRequestsScreen";
import {Card} from "@mui/material";

const ClubManagementScreen = () => {

    const pages = ["General", "Add Events", "Members", "Membership Requests", "Feedbacks", "Surveys", "Club Hierarchy", "Sponsors"];
    const [openedScreen, setOpenedScreen] = React.useState("General")


    return (<Grid container style={{padding: 20, height: "88vh"}}>
        <Grid style={{
            height: "85vh",
            borderRadius: Constants.BORDER_RADIUS,
            padding: 4,
        }}
              item xs={3}>
            <Card elevation={4} style={{borderRadius: Constants.BORDER_RADIUS}}>
                {pages.map(page => <Grid item xs={12} style={{
                    paddingTop: 5,
                    paddingBottom: 5,
                }}>
                    {openedScreen === page ?
                        <BilboardButton text={page}
                                        fontSize={16}
                                        width="23vw"
                                        height={"4vh"}
                                        color={Colors.BILBOARD_MAIN}
                                        textColor={Colors.WHITE}
                        />
                        :
                        <BilboardButton text={page}
                                        fontSize={16}
                                        width="23vw"
                                        height={"4vh"}
                                        color={Colors.WHITE}
                                        textColor={Colors.BILBOARD_MAIN}
                                        onClick={() => setOpenedScreen(page)}
                        />}
                </Grid>)}
            </Card>

        </Grid>
        <Grid item xs={9} style={{padding: 4}}>
            <Card elevation={4} style={{borderRadius: Constants.BORDER_RADIUS, height: "85vh", overflowY: "scroll"}}>
                {openedScreen === "General" ? <ClubManagementGeneralScreen/> :
                    openedScreen === "Add Events" ? <ClubManagementAddEventScreen/> :
                        openedScreen === "Members" ? <ClubManagementMembersScreen/> :
                            openedScreen === "Membership Requests" ? <ClubManagementMembershipRequestsScreen/> :
                                openedScreen === "Feedbacks" ? <ClubManagementFeedbackScreen/> :
                                    openedScreen === "Surveys" ? <ClubManagementSurveyScreen/> :
                                        openedScreen === "Club Hierarchy" ? <ClubManagementHierarchyScreen/> :
                                            openedScreen === "Sponsors" ? <ClubManagementSponsorScreen/> : <div/>}
            </Card>
        </Grid>
    </Grid>)
}

export default ClubManagementScreen;