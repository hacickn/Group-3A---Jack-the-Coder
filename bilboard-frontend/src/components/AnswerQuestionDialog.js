import Grid  from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import React, {useState} from "react";
import { connect } from "react-redux";

/**
 * Ask Question Dialog
 * 
 * Date: 21.12.2021
 * Metehan Saçakçı
 * İlke Doğan
 */

const AnswerQuestionDialog  = ({question, isAnswerQuestionDialogOpen ,setAnswerQuestionDialogOpen}) => {
    
    return (
        <Dialog open={isAnswerQuestionDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setAnswerQuestionDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    <Grid item xs={12}>
                        <p
                            style={{
                                color: "#616161",
                                fontSize: "44px",
                                marginBottom: "20px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                display: "flex",
                                justifyContent: "center",
                                fontWeight: 'bold'

                            }}
                        >
                            Answer Question
                        </p>                       
                    </Grid>
                    <Grid item xs={12}>                    
                        <p
                        style={{
                            color: "#616161",
                            fontSize: "16px",
                            marginBottom: "1px",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            align: "center",
                            display: "flex",
                            justifyContent: "center",
                            fontStyle: 'italic',
                            fontWeight: 'bold'
                        }}      
                    >{question.content}</p>                    
                    </Grid>
                    <Grid item xs={12}>                    
                        <p
                        style={{
                            color: "#616161",
                            fontSize: "16px",
                            marginBottom: "1px",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            align: "center",
                            display: "flex",
                            justifyContent: "center",
                            fontStyle: 'italic',
                            fontWeight: 'bold'
                        }}      
                    >Please Enter Your Answer Here</p>                    
                    </Grid>

                    <Grid item xs={12} style={{marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                        }}>
                        <BilboardMultilineTextField
                            label="Your Question"

                            type="feedback"
                            width="300px"
                            rows="10"
                            style={{marginTop: "30px",                            
                            fontStyle: 'italic',
                        }}
                        />
                    </Grid>
                   
                    <Grid item xs={12} style={{marginTop: "50px",                  
                        display: "flex",
                        justifyContent: "center"}}>                         
                        <BilboardButton width="100px" fontSize="11px" text="Submit Question"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button 
                    onClick={() => setAnswerQuestionDialogOpen(false)}
                    style= {{
                        display: "flex",
                        justifyContent: "center"
                    }}
                    >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}

export default AnswerQuestionDialog