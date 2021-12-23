import Grid  from "@mui/material/Grid";
import BilboardTextField from "./BilboardTextField";
import BilboardButton from "./BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import React, {useState} from "react";
import {connect} from "react-redux";
import Colors from "../utils/Colors";

import VoteToQuestion from "./VoteToQuestion";

/**
 * Vote To Question Dialog
 * 
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const VoteToQuestionDialog  = ({open, setOpen}) => {
    const [isDialogOpen, setIsDialogOpen] = useState(true);
    
    return (
        <Dialog open={open} fullWidth maxWidth={"sm"}
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
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            }}
                        >
                            Attend An Event
                        </p>                       
                    </Grid>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <VoteToQuestion/>
                    <Grid item xs={12} style={{marginTop: "40px",                  
                        display: "flex",
                        justifyContent: "center"}}>                         
                        <BilboardButton width="100px" fontSize="14px" text="Submit"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button 
                    onClick={() => setOpen(false)}
                    style= {{
                        display: "flex",
                        justifyContent: "center"
                    }}
                    >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}


export default VoteToQuestionDialog;