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
import Colors from "../utils/Colors"

/**
 * Ask Question Dialog
 * 
 * Date: 21.12.2021
 * Metehan Saçakçı
 * İlke Doğan
 */

const AskQuestionDialog  = ({isAskQuestionDialogOpen ,setAskQuestionDialogOpen}) => {
    
    return (
        <Dialog open={isAskQuestionDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setAskQuestionDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    <Grid item xs={12}>
                        <p
                            style={{
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                display: "flex",
                                justifyContent: "center",
                                fontWeight: 'bold'

                            }}
                        >
                            Ask Question
                        </p>                       
                    </Grid>
                    <Grid item xs={12}>                    
                        <p
                        style={{
                            color: Colors.BILBOARD_LIGHT_GREY,
                            fontSize: "16px",
                            marginBottom: "1px",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            align: "center",
                            display: "flex",
                            justifyContent: "center",
                            fontStyle: 'italic',
                            fontWeight: 'bold'
                        }}      
                    >Please Enter Your Question Here</p>                    
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
                            style={{marginTop: "30px",                            fontStyle: 'italic',
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
                    onClick={() => setAskQuestionDialogOpen(false)}
                    style= {{
                        display: "flex",
                        justifyContent: "center"
                    }}
                    >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}

const mapStateToProps = (state) => {
    return { isAskQuestionDialogOpen: state.isAskQuestionDialogOpen};
};

const mapDispatchToProps = (dispatch) => {
    return {
        setAskQuestionDialogOpen: (value) =>
            dispatch({
                type: "SET_IS_ASK_QUESTION_DIALOG_OPEN",
                isAskQuestionDialogOpen: value,
            }),
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(AskQuestionDialog);