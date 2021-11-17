import {Grid} from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import BilboardButton from "./BilboardButton";

/**
 * Bilboard Survey Cards
 * 
 * Metehan Saçakçı
 * 17.11.2021
 */

const BiloardSurveyCards = (props) => {

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

    function addSurveyCard( surveyCardObject)
    {
        let temp = [...surveyCardObject]

        temp.push({
            surveyQuestion: surveyCardObject.surveyQuestion,
            endDate: surveyCardObject.endDate,
        })
    }

    return(
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
        {surveyCardsList.map( surveyCard => {
            return(<Grid container
                style={{
                    minWidth: "300px",
                    minHeight: "300px",
                    cursor: "pointer",
                    borderRadius: Constants.BORDER_RADIUS,
                    background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                    marginBottom: 5,
                    marginTop: 5,
                    marginLeft: 5,
                    marginRight: 5,
                    paddingTop: 20,
                    paddingBottom: 20,
                    
                }}>
                    <Grid item xs={12} style={{
                        marginTop: 20,
                        marginBottom: 45,
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        fontSize: 24,
                    }}>
                        {surveyCard.surveyQuestion}
                    </Grid>

                    <Grid item xs={12} style={{
                        marginBottom: 45,
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        fontSize: 15,

                    }}>
                        Planned End Date: {surveyCard.endDate}
                    </Grid>

                    <Grid item xs={6}>
                            <BilboardButton width="100px" fontSize="13px" text="End Survey"/>
                    </Grid>

                    <Grid item xs={6}>
                            <BilboardButton width="100px" fontSize="13px" text="See Results"/>
                    </Grid>
                   
                </Grid>        
            )
        })}
        </Grid>
    )
}

export default BiloardSurveyCards;