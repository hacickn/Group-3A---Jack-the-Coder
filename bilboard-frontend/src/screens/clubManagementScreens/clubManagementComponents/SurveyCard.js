import { Grid } from "@mui/material";
import Constants from "../../../utils/Constants";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import AnswerAndResultDialog from "../../../components/AnswerAndResultDialog";
import React from 'react';
import axios from "axios";

const SurveyCard = ( { survey } ) => {
    const [ answerAndResultDialog, setAnswerAndResultDialog ] = React.useState( false )
    let voteCount = 0

    survey.questions[ 0 ].choices.forEach( choice => {
        voteCount = voteCount + choice.voteCount;
    } )

    return (
        <div> { <AnswerAndResultDialog open={ answerAndResultDialog } survey={survey} setOpen={ ( status ) => {
            setAnswerAndResultDialog( status )
        } }/> }
            <Grid container
                  style={ {
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

                  } }>
                <Grid item xs={ 12 } style={ {
                    marginTop: 20,
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                    fontSize: 20,
                } }>
                    { survey.title }
                </Grid>
                <Grid container style={ { alignItems: "end" } }>
                    <Grid item xs={ 6 } style={ {
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        fontSize: 15,
                    } }>
                        Due: { new Date( survey.endDate ).toLocaleString() }
                    </Grid>
                    <Grid item xs={ 6 } style={ {
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        fontSize: 15,
                    } }>
                        Vote: { voteCount }
                    </Grid>

                    <Grid item xs={ 6 }>
                        <BilboardButton width="140px" color={ Colors.BILBOARD_RED } fontSize="12px" text="Cancel"/>
                    </Grid>

                    <Grid item xs={ 6 }>
                        <BilboardButton
                            onClick={ () => setAnswerAndResultDialog( true ) }
                            width="140px"
                            fontSize="12px"
                            text="Results"/>
                    </Grid>
                </Grid>
            </Grid>
        </div> )
}

export default SurveyCard;