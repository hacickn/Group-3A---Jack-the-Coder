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
import AnswerAndResult from "./AnswerAndResult";
import QuestionAndAnswersAndResult from "./QuestionAndAnswersAndResults";

/**
 * Vote To Question Dialog
 * 
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const AnswerAndResultDialog  = ({open, setOpen}) => {
    const [isDialogOpen, setIsDialogOpen] = useState(true);
    
    return (
        <Dialog open={open} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    
                    <QuestionAndAnswersAndResult/>
                    <QuestionAndAnswersAndResult/>
                    <QuestionAndAnswersAndResult/>
                    <QuestionAndAnswersAndResult/>
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


export default AnswerAndResultDialog;