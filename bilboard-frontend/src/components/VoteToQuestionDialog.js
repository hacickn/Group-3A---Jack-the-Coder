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

import VoteToQuestion from "./VoteToQuestion";

/**
 * Vote To Question Dialog
 *
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const VoteToQuestionDialog = ( { survey, open, setOpen } ) => {
    const [ isDialogOpen, setIsDialogOpen ] = useState( true );

    const [ selectedChoices, setSelectedChoices ] = React.useState( [] )


    function addNewChoices( oldChoice, newChoiceId ) {
        let temp = []

        selectedChoices.forEach( choice => {
            if ( choice !== oldChoice ) {
                temp.push( choice )
            }
        } )

        temp.push( newChoiceId )

        setSelectedChoices( temp )
        console.log( selectedChoices )
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
                        <BilboardButton width="100px" fontSize="14px" text="Submit"/>
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


export default VoteToQuestionDialog;