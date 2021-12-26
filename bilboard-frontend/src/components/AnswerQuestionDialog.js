import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import React, { useState } from "react";
import Colors from "../utils/Colors"
import Env from "../utils/Env";
import axios from "axios";

/**
 * Ask Question Dialog
 *
 * Date: 21.12.2021
 * Metehan Saçakçı
 * İlke Doğan
 */

const AnswerQuestionDialog = ( { question, open, setOpen } ) => {
    const [questionResponse, setQuestionResponse] = React.useState("");
    const [error, setError] = useState("")

    function handleAnswerQuestion() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        axios.delete(process.env.REACT_APP_URL + "event/respondToQuestion?questionId=" + question.id + "&questionResponse=" + questionResponse, {}, {headers: headers})
            .then(function(response) {
                console.log(response)
            })
            .catch(function (error) { setError("Something went wrong!") })
    }

    return (
        <Dialog open={ true } fullWidth maxWidth={ "sm" }
                onClose={ () => setOpen( false ) }>
            <DialogContent>
                <Grid container>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginBottom: "20px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                display: "flex",
                                justifyContent: "center",
                                fontWeight: 'bold'

                            } }
                        >
                            Answer Question
                        </p>
                    </Grid>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "16px",
                                marginBottom: "1px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                display: "flex",
                                justifyContent: "center",
                                fontStyle: 'italic',
                                fontWeight: 'bold'
                            } }
                        >QUESTION CONTENT</p>
                    </Grid>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "16px",
                                marginBottom: "1px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                display: "flex",
                                justifyContent: "center",
                                fontStyle: 'italic',
                                fontWeight: 'bold'
                            } }
                        >Please Enter Your Answer Here</p>
                    </Grid>

                    <Grid item xs={ 12 } style={ {
                        marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                    } }>
                        <BilboardMultilineTextField
                            value={questionResponse}
                            onChange={(e) => setQuestionResponse(e)}
                            label="Your Answer"
                            type="answer"
                            width="300px"
                            rows="10"
                            style={ {
                                marginTop: "30px",
                                fontStyle: 'italic',
                            } }
                        />
                    </Grid>

                    <Grid item xs={ 12 } style={ {
                        marginTop: "50px",
                        display: "flex",
                        justifyContent: "center"
                    } }>
                        <BilboardButton 
                            onClick={() => handleAnswerQuestion()}
                            width="100px" fontSize="11px" text="Submit Answer"/>
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
        </Dialog>
    )
}

export default AnswerQuestionDialog