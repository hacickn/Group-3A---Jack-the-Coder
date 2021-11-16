import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import React, {useState} from "react";
import Colors from "../utils/Colors";

/**
 * Leave Feedback Dialog
 *
 * Date: 14.11.2021
 * Metehan Saçakçı
 */

const LeaveFeedbackDialog = () => {
    const [isDialogOpen, setIsDialogOpen] = useState(true);

    return (
        <Dialog open={isDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
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
                            }}
                        >
                            Leave Feedback
                        </p>
                    </Grid>
                    <Grid item xs={12} style={{
                        marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                    }}>
                        <BilboardMultilineTextField
                            label="Your Feedback"
                            type="feedback"
                            width="300px"
                            rows="10"
                            style={{marginTop: "30px"}}
                        />
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
                            }}
                        >Your feedback will be anonymous and only board members can see your feedback.</p>
                    </Grid>
                    <Grid item xs={12} style={{
                        marginTop: "50px",
                        display: "flex",
                        justifyContent: "center"
                    }}>
                        <BilboardButton width="100px" fontSize="11px" text="Send Feedback"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button
                    onClick={() => setIsDialogOpen(false)}
                    style={{
                        display: "flex",
                        justifyContent: "center"
                    }}
                >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}

export default LeaveFeedbackDialog;