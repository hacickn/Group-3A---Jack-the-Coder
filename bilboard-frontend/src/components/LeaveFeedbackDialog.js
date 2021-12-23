import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import Colors from "../utils/Colors";
import React, { useState } from "react";

/**
 * Leave Feedback Dialog
 *
 * Date: 14.11.2021
 * Metehan Saçakçı
 */

const LeaveFeedbackDialog = ( props ) => {
    const [ content, setContent ] = React.useState( "" )

    return (
        <Dialog
            open={ props.open }
            fullWidth
            maxWidth={ "md" }
            onClose={ () => props.onClose() }
        >
            <DialogContent>
                <Grid container>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            Leave Feedback
                        </p>
                    </Grid>
                    <Grid
                        item
                        xs={ 12 }
                        style={ {
                            marginTop: "20px",
                            display: "flex",
                            justifyContent: "center",
                        } }
                    >
                        <BilboardMultilineTextField
                            label="Your Feedback"
                            value={ content }
                            onChange={ ( value ) => setContent( value ) }
                            type="feedback"
                            width="300px"
                            rows="10"
                            style={ { marginTop: "30px" } }
                        />
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
                                textAlign: "center",
                            } }
                        >
                            Your feedback will be anonymous.
                        </p>
                    </Grid>
                    <Grid
                        item
                        xs={ 12 }
                        style={ {
                            marginTop: "50px",
                            display: "flex",
                            justifyContent: "center",
                        } }
                    >
                        <BilboardButton
                            onClick={ () => {
                                if ( content.trim().length > 0 ) {
                                    props.handleSendFeedback( content )
                                    setContent( "" )
                                    props.onClose()
                                } else {
                                    props.handleSetError( "Feedback can not be empty!" )
                                }
                            } }
                            width="100px"
                            fontSize="14px"
                            text="Send Feedback"
                        />
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button
                    onClick={ () => props.onClose() }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                    } }
                >
                    Cancel
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default LeaveFeedbackDialog;
