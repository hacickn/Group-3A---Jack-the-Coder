import {Grid} from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardFeedbackCard from "../../components/BilboardFeedbackCard";

/**
 * Club Management Feedback Screen
 * 
 * Metehan Saçakçı
 * 18.11.2021
 */

const ClubManagementFeedbackScreen = () => {

    const feedbackList =[

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

        {
            feedbackDate: "20 October 2021",
            feedbackText: "This is a feedback message!",
        },

    ]

    function addFeedback( feedbackObject)
    {
        let temp = [...feedbackList]

        temp.push({
            feedbackDate: feedbackObject.feedbackDate,
            feedbackText: feedbackObject.feedbackText,
        })
    }

    return (
        <Grid container
            style= {{borderRadius: Constants.BORDER_RADIUS}}>

            <Grid container xs={12} style={{maxHeight: "100vh", overflowY: "scroll", marginLeft: 15, marginRight: 10}}>
                {feedbackList.map( feedback => <BilboardFeedbackCard feedback={feedback}/> )}
            </Grid>
        </Grid>
    )
}

export default ClubManagementFeedbackScreen;