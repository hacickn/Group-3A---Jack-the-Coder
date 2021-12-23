import {Grid} from "@mui/material";
import Constants from "../../../utils/Constants";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import AnswerAndResultDialog from "../../../components/AnswerAndResultDialog";
import React from 'react';

const SurveyCard = (props) => {
    const [ answerAndResultDialog, setanswerAndResultDialog ] = React.useState( false )

    return (
        <div> { <AnswerAndResultDialog open={ answerAndResultDialog } setOpen={ ( status ) => {
            setanswerAndResultDialog( status )
            } }/> }
        <Grid container
                  style={{
                      minWidth: "300px",
                      minHeight: "300px",
                      borderRadius: Constants.BORDER_RADIUS,
                      background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                      marginBottom: 5,
                      marginTop: 5,
                      marginLeft: 5,
                      marginRight: 5,
                      paddingTop: 20,
                      paddingBottom: 20,

                  }}>
        <Grid item xs={12} style={{
            marginTop: 20,
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            fontSize: 20,
        }}>
            {props.survey.surveyQuestion}
        </Grid>
        <Grid container style={{alignItems: "end"}}>
            <Grid item xs={6} style={{
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 15,
            }}>
                Due: {props.survey.endDate}
            </Grid>
            <Grid item xs={6} style={{
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 15,
            }}>
                Vote: {props.survey.voteCount}
            </Grid>

            <Grid item xs={6}>
                <BilboardButton width="140px" color={Colors.BILBOARD_RED} fontSize="12px" text="Cancel"/>
            </Grid>

            <Grid item xs={6}>
                <BilboardButton 
                    onClick = {() => setanswerAndResultDialog(true) } 
                    width="140px" 
                    fontSize="12px" 
                    text="Results"/>
            </Grid>
        </Grid>
    </Grid>
    </div>)
}

export default SurveyCard;