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

const ClubManagementFeedbackScreen = () => {

    const feedbackList = [
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },
        {
            feedbackDate: "20 October 2021",
            feedbackText: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum!",
        },

    ]

    function addFeedback( feedbackObject ) {
        let temp = [ ...feedbackList ]

        temp.push( {
            feedbackDate: feedbackObject.feedbackDate,
            feedbackText: feedbackObject.feedbackText,
        } )
    }

    return (
        <Grid container
              style={ { borderRadius: Constants.BORDER_RADIUS } }>
            <Grid item xs={ 12 } style={ { padding: 20, fontSize: 48, fontFamily: Constants.OXYGEN_FONT_FAMILY } }>
                Feedbacks
            </Grid>
            <Grid container style={ { maxHeight: "100vh", overflowY: "scroll", marginLeft: 15, marginRight: 10 } }>
                { feedbackList.map( feedback => <BilboardFeedbackCard feedback={ feedback }/> ) }
            </Grid>
        </Grid>
    )
}

export default ClubManagementFeedbackScreen;