import { Grid } from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardFeedbackCard from "../../components/BilboardFeedbackCard";
import React from "react";

/**
 * Club Management Feedback Screen
 *
 * Metehan Saçakçı
 * 18.11.2021
 */

const ClubManagementFeedbackScreen = ( { club } ) => {

    return (
        <Grid container
              style={ { borderRadius: Constants.BORDER_RADIUS } }>
            <Grid item xs={ 12 } style={ { padding: 20, fontSize: 48, fontFamily: Constants.OXYGEN_FONT_FAMILY } }>
                Feedbacks
            </Grid>
            <Grid container style={ { maxHeight: "100vh", overflowY: "scroll", marginLeft: 15, marginRight: 10 } }>
                { club.clubFeedbacks.map( feedback => <BilboardFeedbackCard feedback={ feedback }/> ) }
            </Grid>
        </Grid>
    )
}

export default ClubManagementFeedbackScreen;