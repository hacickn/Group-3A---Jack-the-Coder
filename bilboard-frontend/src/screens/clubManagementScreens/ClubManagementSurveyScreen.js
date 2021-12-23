import { Grid } from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardButton from "../../components/BilboardButton";
import SurveyCard from "./clubManagementComponents/SurveyCard";
import AddSurveyDialog from "./clubManagementComponents/AddSurveyDialog";
import React from 'react'

/**
 * Club Management Survey Screen
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const ClubManagementSurveyScreen = () => {
    const [ addSurveyDialog, setAddSurveyDialog ] = React.useState( false )

    const surveyCardsList = [

        {
            surveyQuestion: "What will o will our next event be What will our next event be? ",
            endDate: "28 Oct 2021",
            voteCount: 25,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 1125,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 125,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 225,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 425,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 125,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 325,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 2,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 5,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 125,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 215,
        },

        {
            surveyQuestion: "What will our next event be?",
            endDate: "28 Oct 2021",
            voteCount: 225,
        },
    ]

    return (
        <Grid container style={ {
            padding: 20,
        } }>
            <Grid style={ {
                marginTop: 15,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            } } item xs={ 12 }>
                Active Surveys
            </Grid>

            <Grid container style={ {
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
            } }>
                { surveyCardsList.map( survey => <SurveyCard survey={ survey }/> ) }
            </Grid>

            <Grid item xs={ 12 } style={ {
                marginTop: 50,
            } }>
                <BilboardButton onClick={ () => {
                    setAddSurveyDialog( true )
                } } width="220px" fontSize="14px"
                                text="Add Survey"/>
            </Grid>
            <AddSurveyDialog open={ addSurveyDialog } setOpen={ ( val ) => setAddSurveyDialog( val ) }/>
        </Grid>

    )
}

export default ClubManagementSurveyScreen;