import { Grid } from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import BilboardButton from "./BilboardButton";
import VoteToQuestionDialog from "./VoteToQuestionDialog";
import React from 'react';

/**
 * Bilboard Survey Card
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const BilboardSurveyCard = ( props ) => {
    const [ voteToQuestionDialog, setVoteToQuestionDialog ] = React.useState( false )


    return (
        <div>{ <VoteToQuestionDialog survey={ props.survey } open={ voteToQuestionDialog } setOpen={ ( status ) => {
            setVoteToQuestionDialog( status )
        } }/> }
            <Grid container
                  style={ {
                      marginBottom: 5,
                      marginTop: 5,
                      maxHeight: 120,
                      paddingTop: 20,
                      paddingBottom: 20,
                      borderRadius: Constants.BORDER_RADIUS,
                      background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                      alignItems: "center",
                  } }>

                <Grid item xs>
                    <img src={ process.env.REACT_APP_IMAGE_URL + props.survey.club.photo }
                         style={ { maxHeight: 100, maxWidth: 100 } }/>
                </Grid>

                <Grid item xs style={ {
                    fontSize: "24px",
                } }>
                    { props.survey.club.shortName.toUpperCase() }
                </Grid>

                <Grid item xs style={ {
                    fontSize: "24px",
                } }>
                    Title: { props.survey.title }
                </Grid>
                <Grid item xs>
                    { props.survey.questions.length } Question
                </Grid>
                <Grid item xs>
                    <BilboardButton
                        disabled={props.voted}
                        onClick={ () => setVoteToQuestionDialog( true ) }
                        width="160px" height="40px" fontSize="16px" text={props.voted ? "Completed" : "Vote" }
                    />
                </Grid>
            </Grid>
        </div>
    )
}

export default BilboardSurveyCard;