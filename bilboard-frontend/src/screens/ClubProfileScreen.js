import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";
import EventCard from "../components/EventCard";
import Rating from "@mui/material/Rating";
import React from "react";
import Button from "@mui/material/Button";
import WhatsAppIcon from "@mui/icons-material/WhatsApp";
import InstagramIcon from "@mui/icons-material/Instagram";
import AboutImage from "../utils/AboutImage.png";
import LeaveFeedbackDialog from "../components/LeaveFeedbackDialog";
import ClubPageFeedbackCard from "../components/ClubPageFeedbackCard";
import LoyaltyIcon from "@mui/icons-material/Loyalty";
import ExitToAppIcon from "@mui/icons-material/ExitToApp";
import Env from "../utils/Env";
import axios from "axios";
import { CircularProgress, Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import BilboardButton from "../components/BilboardButton";
import Program from "../utils/Program";

const ClubProfileScreen = ( { image, currentClub, program } ) => {
    const [ isLeaveFeedbackDialogOpen, setIsLeaveFeedbackDialogOpen ] =
        React.useState( false );
    const [ clubFullData, setClubFullData ] = React.useState( null );
    const [ loading, setLoading ] = React.useState( true );
    const [ isMemberOfClub, setIsMemberOfClub ] = React.useState( false );
    const [ error, setError ] = React.useState( "" );
    const [ success, setSuccess ] = React.useState( "" );
    const [ isLeaveAlertOpen, setIsLeaveAlertOpen ] = React.useState( false );

    const handleSendMembershipRequest = () => {
        setIsLeaveAlertOpen( true );
    };

    const handleCloseAlert = () => {
        setIsLeaveAlertOpen( false );
    };

    function handleEnrollClub() {
        let headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + Env.TOKEN,
        };

        axios.post(
            process.env.REACT_APP_URL + "club/enrollment/request?userId=" + program.id + "&clubId=" + currentClub.id,
            {}, { headers: headers } )
             .then( function ( response ) {
                 setIsLeaveAlertOpen( true );
             } )
             .catch( function ( error ) {
                 setError( "Something went wrong!" )
             } )
    }

    function handleFeedbackSend( content ) {
        let headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + Env.TOKEN,
        };

        axios
            .post(
                process.env.REACT_APP_URL + "club/feedback",
                {
                    content: content,
                    club: currentClub.id,
                    user: Env.PUBLIC_ID,
                },
                { headers: headers }
            )
            .then( function ( response ) {
                setSuccess( "Feedback was sent successfully!" );
            } )
            .catch( function ( error ) {
                setError( "Something went wrong!" );
            } );
    }

    async function handleClubResponse( clubId ) {
        let headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + Env.TOKEN,
        };

        await axios
            .get( process.env.REACT_APP_URL + "club?clubId=" + currentClub.id, {
                headers,
            } )
            .then( function ( response ) {
                Program.addClub( response.data, clubId );
                console.log( response.data );
                setClubFullData( response.data );
                setLoading( false );
            } )
            .catch( function ( error ) {
                setLoading( false );
            } );
    }

    if ( Program.getClub( currentClub.id ) === undefined ) {
        handleClubResponse( currentClub.id );
    } else if ( Program.getClub( currentClub.id ) !== null && loading ) {
        setLoading( false );
        setClubFullData( Program.getClub( currentClub.id ) );
    } else {
    }

    let point = 0;
    let totalParticipant = 1;
    if ( clubFullData !== null ) {
        clubFullData.events.forEach( ( eventOfList ) => {
            point = point + eventOfList.averageRate * eventOfList.rateCount;
            totalParticipant = totalParticipant + eventOfList.rateCount;
        } );
    }

    return loading ? (
        <div style={ { margin: "20px" } }>
            <CircularProgress/>
        </div>
    ) : (
        <div style={ { margin: "20px" } }>
            <LeaveFeedbackDialog
                handleSetError={ ( value ) => setError( value ) }
                handleSendFeedback={ ( content ) => handleFeedbackSend( content ) }
                open={ isLeaveFeedbackDialogOpen }
                onClose={ () => setIsLeaveFeedbackDialogOpen( false ) }
            />
            <Grid
                container
                style={ {
                    marginTop: "20px",
                    background: "#F5F5F5",
                    border: "5px solid #F5F5F5",
                    padding: "20px",
                    borderRadius: "20px",
                    maxHeight: "400px",
                    display: "flex",
                    alignItems: "center",
                } }
            >
                <Grid item xs={ 3 }>
                    <img src={ AboutImage } alt="clubImage" style={ { width: "320px" } }/>
                </Grid>
                <Grid item xs={ 3 }>
                    <div
                        style={ {
                            fontSize: "40px",
                            marginTop: "20px",
                            fontWeight: "bold",
                            fontFamily: "Oxygen, sans-serif",
                            color: Colors.BILBOARD_LIGHT_GREY,
                        } }
                    >
                        { clubFullData.name }
                    </div>
                    <div></div>
                    <Rating
                        name="read-only"
                        defaultValue={ point / totalParticipant }
                        style={ { marginTop: "20px" } }
                        readOnly
                        size="large"
                    />
                    <div></div>
                    { !isMemberOfClub ? (
                        <Button
                            onClick={ () => handleSendMembershipRequest() }
                            variant="contained"
                            startIcon={ <LoyaltyIcon/> }
                            style={ {
                                marginTop: "20px",
                                minWidth: "300px",
                                minHeight: "60px",
                            } }
                        >
                            Send Membership Request
                        </Button>
                    ) : (
                        <Button
                            variant="contained"
                            startIcon={ <ExitToAppIcon/> }
                            style={ {
                                marginTop: "20px",
                                minWidth: "300px",
                                minHeight: "60px",
                            } }
                            color="error"
                        >
                            Leave Membership
                        </Button>
                    ) }
                    <div></div>
                    <Button
                        variant="contained"
                        startIcon={ <WhatsAppIcon/> }
                        style={ {
                            marginTop: "20px",
                            minWidth: "300px",
                            minHeight: "40px",
                            backgroundColor: "#25d366",
                        } }
                    >
                        Go to Whatsapp Group
                    </Button>
                    <div></div>
                    <Button
                        variant="contained"
                        startIcon={ <InstagramIcon/> }
                        style={ {
                            marginTop: "20px",
                            minWidth: "300px",
                            minHeight: "40px",
                            background:
                                "linear-gradient(90deg, rgba(138,58,185,1) 0%, rgba(233,89,80,1) 60%, rgba(252,204,99,1) 100%)",
                        } }
                    >
                        Go to Instagram Link
                    </Button>
                </Grid>
                <Grid
                    item
                    xs={ 6 }
                    style={ { marginTop: "20px", maxHeight: "300px", overflowY: "scroll" } }
                >
                    <Grid container>
                        <Grid item xs={ 12 }>
                            <Grid container>
                                <Grid item xs={ 3 }></Grid>
                                <Grid item xs={ 3 }>
                                    <div style={ { fontSize: "28px", fontWeight: "bold" } }>
                                        Feedbacks
                                    </div>
                                </Grid>
                                <Grid item xs={ 3 }>
                                    <Button
                                        style={ { fontSize: "16px" } }
                                        variant="outlined"
                                        onClick={ () => setIsLeaveFeedbackDialogOpen( true ) }
                                    >
                                        Add Feedback
                                    </Button>
                                </Grid>
                                <Grid item xs={ 3 }></Grid>
                            </Grid>
                        </Grid>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                marginTop: "20px",
                                background: "#F5F5F5",
                                border: "5px solid #F5F5F5",
                            } }
                        >
                            <Grid container>
                                { clubFullData.clubFeedbacks.map( ( feedback ) => {
                                    if ( feedback.status ) {
                                        return (
                                            <Grid item xs={ 12 }>
                                                <ClubPageFeedbackCard feedback={ feedback }/>
                                            </Grid>
                                        );
                                    }
                                } ) }
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
            <div
                style={ {
                    fontSize: "30px",
                    marginTop: "50px",
                    fontWeight: "bold",
                    marginBottom: "40px",
                    fontFamily: "Oxygen, sans-serif",
                    color: Colors.BILBOARD_LIGHT_GREY,
                } }
            >
                Posts
            </div>
            <Grid
                container
                style={ {
                    paddingTop: "60px",
                    border: "5px solid #F5F5F5",
                    borderRadius: "20px",
                } }
            >
                { clubFullData.events.map( ( event ) => {
                    return (
                        <Grid
                            item
                            xs={ 3 }
                            style={ {
                                marginBottom: "60px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <EventCard event={ event }/>
                        </Grid>
                    );
                } ) }
            </Grid>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center" } }
                open={ error !== "" }
                autoHideDuration={ 2000 }
                onClose={ () => setError( "" ) }
            >
                <Alert onClose={ () => setError( "" ) } severity={ "warning" }>
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center" } }
                open={ success !== "" }
                autoHideDuration={ 2000 }
                onClose={ () => setSuccess( "" ) }
            >
                <Alert onClose={ () => setSuccess( "" ) } severity={ "success" }>
                    { success }
                </Alert>
            </Snackbar>
            <Dialog open={ isLeaveAlertOpen } onClose={ handleCloseAlert }>
                <DialogTitle>{ "Send Membership Request" }</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Are you sure to send a membership to the club?
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <BilboardButton onClick={ handleCloseAlert } text="Cancel"/>
                    <BilboardButton
                        onClick={ () => handleEnrollClub() }
                        text="Send Request"
                        autoFocus
                    />
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default ClubProfileScreen;
