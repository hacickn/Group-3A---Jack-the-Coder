import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import EventCard from "../../../components/EventCard";
import EventParticipantsDialog from "../../../components/EventParticipantsDialog";
import React from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import EditEventDialog from "../../../components/EditEventDialog";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import axios from "axios";
import Env from "../../../utils/Env";

const useStyles = makeStyles( {
    container: {
        maxWidth: "260px",
        maxHeight: "340px",
        marginBottom: "10px",
    },
} );

const EventForGeneralPage = ( { event, currentEvent, setCurrentEvent, functionList } ) => {
    const [ editEventDialog, setEditEventDialog ] = React.useState( false );

    const [ eventParticipantsDialog, setEventParticipantsDialog ] =
        React.useState( false );
    const classes = useStyles();
    const [ isLeaveAlertOpen, setIsLeaveAlertOpen ] = React.useState( false );
    const [ error, setError ] = React.useState( "" )

    const handleCloseAlert = () => {
        setIsLeaveAlertOpen( false );
    };

    function handleDeleteEvent() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': "Bearer " + Env.TOKEN,
        };

        axios.delete( process.env.REACT_APP_URL + "event?eventId=" + event.id, { headers: headers } )
             .then( function ( response ) {
                 if ( response.data.operationResult === "SUCCESS" ) {
                     functionList.handleEventRemoval( event.id )
                     setIsLeaveAlertOpen( false )
                 }

             } )
             .catch( function ( error ) {
                 setError( "Something went wrong!" )
             } )
    }

    return (
        <div className={ classes.container }>
            <EditEventDialog
                open={ editEventDialog }
                setOpen={ ( status ) => {
                    setEditEventDialog( status );
                } }
            />
            {
                <EventParticipantsDialog
                    event={ event }
                    open={ eventParticipantsDialog }
                    setOpen={ ( status ) => {
                        setEventParticipantsDialog( status );
                    } }
                />
            }
            <Grid container>
                <Grid item xs={ 12 } style={ { paddingTop: "50px" } }>
                    <EventCard setCurrentEvent={ setCurrentEvent } currentEvent={ currentEvent } event={ event }
                               fromBoardMember={ true }/>
                    <Grid item xs={ 12 } style={ { paddingTop: "10px" } }>
                        <BilboardButton
                            text="Edit"
                            width="75px"
                            fontWeight="bold"
                            fontSize={ 10 }
                            color="#2f1da3"
                            textColor="white"
                            onClick={ () => setEditEventDialog( true ) }
                        />
                        <BilboardButton
                            onClick={ () => setIsLeaveAlertOpen( true ) }
                            text="Delete"
                            width="75px"
                            font-weight="bold"
                            fontSize={ 10 }
                            color="#cc0a0a"
                            textColor="white"
                        />
                        <BilboardButton
                            onClick={ () => setEventParticipantsDialog( true ) }
                            text="Participants"
                            width="75px"
                            fontSize={ 10 }
                            color="#20d62c"
                            textColor="white"
                        />
                    </Grid>
                </Grid>
            </Grid>

            <Dialog open={ isLeaveAlertOpen } onClose={ handleCloseAlert }>
                <DialogTitle>{ "Delete Event" }</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Are you sure to delete the event of the club?
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <BilboardButton onClick={ handleCloseAlert } text="Cancel"/>
                    <BilboardButton onClick={ () => handleDeleteEvent() } text="Delete" autoFocus/>
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default EventForGeneralPage;
