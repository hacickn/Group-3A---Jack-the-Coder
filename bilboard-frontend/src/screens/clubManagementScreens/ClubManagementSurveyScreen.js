import {Grid} from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardButton from "../../components/BilboardButton";
import SurveyCard from "./clubManagementComponents/SurveyCard";

/**
 * Club Management Survey Screen
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const ClubManagementSurveyScreen = () => {

    const surveyCardsList = [

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021"
        },
    ]

    return (
        <Grid container style={{
            padding: 20,
        }}>
            <Grid style={{
                marginTop: 15,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            }} item xs={12}>
                Active Surveys
            </Grid>

            <Grid container style={{
                display: "flex",
                alignItems: "center",
                minHeight: "340px",
                maxHeight: "340px",
                maxWidth: "100vw",
                overflowY: "hidden",
                overflowX: "scroll",
                flexWrap: "nowrap",
                justifyContent: "start",
                marginRight: "20px",
                paddingBottom: "10px",
                marginTop: "10px",
            }}>
                {surveyCardsList.map(survey => <SurveyCard survey={survey}/>)}
            </Grid>

            <Grid item xs={12} style={{
                marginTop: 50,
            }}>
                <BilboardButton width="200px" fontSize="20px" text="Add Survey"/>
            </Grid>

        </Grid>

    )
}

export default ClubManagementSurveyScreen;