import Grid from "@mui/material/Grid";
import BilboardTextField from "./BilboardTextField";
import BilboardButton from "./BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import React, { useState } from "react";
import { connect } from "react-redux";
import Colors from "../utils/Colors";
import Env from "../utils/Env";
import axios from "axios";
import VoteToQuestion from "./VoteToQuestion";
import { CircularProgress, Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";

/**
 * Vote To Question Dialog
 *
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const VoteToQuestionDialog = ( {program, survey, surveyParticipants, open, setOpen } ) => {

    const [ selectedChoices, setSelectedChoices ] = React.useState( [] )
    const [submitted, setSubmitted] = useState(false)
    const [error, setError] = useState("")
    const [success, setSuccess] = useState("")

    let headers = {
        "Content-Type": "application/json",
        Authorization: "Bearer " + Env.TOKEN,
      };

    const handleSubmitAnswers = () => {
        setSubmitted(true)
        if(survey.questions.length !== selectedChoices.length) {
            alert("Please answer all questions!")
        }
        else{
            axios.post(process.env.REACT_APP_URL + "survey/vote", {
                user: surveyParticipants.id,
                survey: survey.id,
                choices: selectedChoices
            }, { headers: headers }).then(function(response){
                if(response.data.operationResult === "SUCCESS"){
                    setOpen(false);
                    setSuccess("Your responses are saved!")
                }else{
                    setError("You can not vote anymore!")
                }
                setSubmitted(false)
            }).catch(function(error){
                console.log(error)
                setError("You can not vote anymore!")
                setSubmitted(false)

            })
        }
    }



    function addNewChoices( oldChoice, newChoiceId ) {
        let temp = []

        selectedChoices.forEach( choice => {
            if ( choice !== oldChoice ) {
                temp.push( choice )
            }
        } )

        temp.push( newChoiceId )

        setSelectedChoices( temp )
    }

    return (
        <Dialog open={ open } fullWidth
                maxWidth={ "sm" }
                onClose={ () => setOpen( false ) }>
            <DialogContent>
                <Grid container>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            Vote
                        </p>
                    </Grid>
                    { survey.questions.map( question => {
                        return <VoteToQuestion
                            addNewChoices={ ( oldChoice, newChoice ) => addNewChoices( oldChoice, newChoice ) }
                            question={ question }/>
                    } ) }

                    <Grid item xs={ 12 } style={ {
                        marginTop: "40px",
                        display: "flex",
                        justifyContent: "center"
                    } }>
                        {submitted ? <CircularProgress/> :  <BilboardButton width="100px" fontSize="14px" text="Submit" onClick={handleSubmitAnswers}/>}
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button
                    onClick={ () => setOpen( false ) }
                    style={ {
                        display: "flex",
                        justifyContent: "center"
                    } }
                >Cancel</Button>
            </DialogActions>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ error !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setError( '' ) }
            >
                <Alert onClose={ () => setError( '' ) }
                       severity={ "warning" }
                >
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ success !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setSuccess( '' ) }
            >
                <Alert onClose={ () => setSuccess( '' ) }
                       severity={ "success" }
                >
                    { success }
                </Alert>
            </Snackbar>
        </Dialog>
    )
}


export default VoteToQuestionDialog;