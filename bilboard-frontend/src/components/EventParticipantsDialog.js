import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import React, { useState } from "react";
import { connect } from "react-redux"
import Colors from "../utils/Colors"
import EventParticipantCard from "./EventParticipantCard";

/**
 * Event Participants Dialog
 *
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const EventParticipantsDialog = ( { open, setOpen, event } ) => {
    const [ isDialogOpen, setIsDialogOpen ] = useState( true );

    const participantList = [
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
        {
            name: "Metehan Saçakçı"
        },
    ]

    function addParticipant( participantObject ) {
        let temp = [ ...participantList ]

        temp.push( {
            name: participantObject.name
        } )
    }

    return (
        <Dialog open={ open } fullWidth maxWidth={ "sm" }
                onClose={ () => setIsDialogOpen( false ) }>
            <DialogContent style={ { overflow: 'hidden' } }>
                <Grid container>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "35px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            Participants of the Event
                        </p>
                    </Grid>
                    <Grid item xs={ 12 } style={ {
                        marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                    } }>
                        <Grid container xs={ 12 }
                              style={ { maxHeight: "40vh", overflowY: "scroll", marginLeft: 15, marginRight: 10 } }>
                            { event.eventParticipants.map(
                                participant => <EventParticipantCard participant={ participant }/> ) }
                        </Grid>
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

export default EventParticipantsDialog;