import Grid from "@mui/material/Grid";
import Rating from '@mui/material/Rating';
import Constants from "../utils/Constants";
import QuestionAnswerCard from "../components/QuestionAnswerCard";
import BilboardButton from "../components/BilboardButton";
import React, { useState } from 'react'
import BilboardNavbar from "../components/BilboardNavbar";
import { connect } from "react-redux";
import AskQuestionDialog from "../components/AskQuestionDialog";
import axios from "axios";
import Env from "../utils/Env";
import Program from "../utils/Program";
import { CircularProgress, Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";
import Colors from "../utils/Colors";


const EventDetailScreen = ( { isAskQuestionDialogOpen, setAskQuestionDialogOpen, currentEvent, setCurrentClub }
) => {
    const [ eventData, setEventData ] = React.useState( null );

    const [ loading, setLoading ] = React.useState( true );
    const [ success, setSuccess ] = useState( "" )
    const [ error, setError ] = useState( "" )
    const [ isEnrolled, setEnrolled ] = useState( null )

    function enrollEvent() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }
        axios.post( process.env.REACT_APP_URL + "event/enroll?eventId=" + currentEvent.id + "&userId=" + Env.PUBLIC_ID,
            {},
            { headers: headers } )
             .then( function ( response ) {
                 if ( response.data.operationResult === "SUCCESS" ) {
                     setEnrolled( true )
                     currentEvent.eventParticipans.push( {
                         user: {
                             id: Env.PUBLIC_ID
                         }
                     } )
                     setEventData( currentEvent )
                     setSuccess( "Attend event is successful!" )
                 } else {
                     setError( "Attending event is failed!" );
                 }
             } )
             .catch( function ( error ) {
                 setError( "Something went wrong!" )
             } )
    }


    if ( Program.getEvent( currentEvent.id ) === undefined ) {
        setEventData( currentEvent )
        Program.addEvent( currentEvent, currentEvent.id )
        setLoading( false );
    } else if ( Program.getClub( currentEvent.id ) !== null && loading ) {
        setLoading( false );
        setEventData( Program.getClub( currentEvent.id ) );
    } else {
    }

    if ( isEnrolled === null ) {
        setEnrolled( checkIsEnrolled() )
    }

    function checkIsEnrolled() {
        let status = false
        currentEvent.eventParticipants.forEach( participant => {
            if ( participant.user.id.toString() === Env.PUBLIC_ID.toString() ) {
                status = true
            }
        } )

        return status
    }
    console.log(currentEvent)

    return (

        <div>
            { isAskQuestionDialogOpen &&
            <AskQuestionDialog setError={ ( val ) => setError( val ) } setSuccess={ ( val ) => setSuccess( val ) }
                               event={ currentEvent }/> }
            { loading ? <CircularProgress/> : <Grid container style={ { marginTop: 10 } }>
                <Grid item xs={ 5 } style={ { marginTop: 50 } }>
                    <Grid container>
                        <Grid container>
                            <Grid item xs={ 12 } style={
                                {
                                    paddingLeft: 12,
                                    marginTop: "5px",
                                    marginLeft: "100px",
                                    color: "black",
                                    display: "flex",
                                    justifyContent: "left",
                                    alignItems: "left",
                                    fontSize: "80%",

                                } }>
                                <div style={ {
                                    fontSize: "24px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                } }>{ currentEvent.title }
                                </div>
                                <Rating name="read-only" defaultValue={ currentEvent.averageRate }
                                        style={ { marginLeft: "260px" } } readOnly
                                        size="large"/>
                            </Grid>


                        </Grid>
                        <Grid item xs={ 12 } style={
                            {
                                paddingLeft: 12,
                                marginTop: "10px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "80%",
                            } }>
                            <div style={ {
                                fontSize: "40px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }>{ currentEvent.club.name }
                            </div>
                        </Grid>
                        <Grid item xs={ 7 } style={
                            {
                                paddingLeft: "115px",
                                marginTop: "10px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "24px",

                            } }>
                            <div style={ {
                                fontSize: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }>Participant Limit { currentEvent.eventParticipants.length }/ {currentEvent.maxParticipationCount}
                            </div>


                        </Grid>
                        <Grid xs={ 5 }>

                            { !isEnrolled ? <BilboardButton
                                onClick={ () => enrollEvent() }
                                width="200px"
                                fontSize="13px"
                                text="Enroll an Event"
                                color="#00e676"
                            /> : <BilboardButton
                                onClick={ () => {
                                } }
                                width="200px"
                                disabled={ true }
                                fontSize="13px"
                                text="Already Enrolled"
                                color={ Colors.BILBOARD_GREY }
                            /> }
                        </Grid>

                        <Grid item xs={ 12 }
                              style={ {
                                  marginTop: "40px",
                                  display: "flex",
                                  justifyContent: "center",
                                  alignItems: "center",
                              } }>
                            <img src={ process.env.REACT_APP_IMAGE_URL + currentEvent.eventPhoto } style={
                                {

                                    marginLeft: "20px",
                                    backgroundSize: "cover",
                                    width: "600px",
                                    height: "600px",
                                    borderRadius: "10px",

                                } }>
                            </img>
                        </Grid>
                    </Grid>

                </Grid>
                <Grid item xs={ 7 }>
                    <Grid container>
                        <Grid item xs={ 12 } style={
                            {
                                padding: 20,
                                fontSize: 48,
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                marginTop: "20px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",

                            } }>
                            <Grid>
                                <div style={ {
                                    fontSize: 28,
                                    fontWeight: "bold",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    textAlign: "justify"
                                } }>
                                    Event Details
                                </div>
                                <div style={ {
                                    fontSize: 18,
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    textAlign: "justify",
                                    marginRight: 70
                                } }>
                                    { currentEvent.description }
                                </div>

                            </Grid>

                        </Grid>
                        <Grid item xs={ 12 } style={
                            {
                                padding: 20,
                                fontSize: 48,
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                marginTop: "20px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",

                            } }>
                            <div style={ {
                                fontSize: 28,
                                fontWeight: "bold",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                textAlign: "justify",
                                marginRight: 70
                            } }>
                                Event Location: { currentEvent.online ? "Online" : "B206" }
                            </div>
                        </Grid>
                        <Grid item xs={ 12 }>
                            <Grid container
                                  style={ { borderRadius: Constants.BORDER_RADIUS } }>
                                <Grid item xs={ 12 } style={ {
                                    padding: 20,
                                    fontSize: 38,
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontWeight: "bold"
                                } }>
                                    Question and Answer
                                </Grid>
                                <Grid container style={ {
                                    maxHeight: "100vh",
                                    overflowY: "scroll",
                                    marginLeft: 80,
                                    marginRight: 70
                                } }>
                                    { currentEvent.eventQuestions.map(
                                        question => {
                                            if ( question.answer !== null ) {
                                                return <QuestionAnswerCard questionAnswer={ question }/>
                                            }
                                        } ) }
                                </Grid>

                                <Grid item xs={ 12 } style={ {
                                    marginTop: "25px",
                                    display: "flex",
                                    justifyContent: "center",
                                    alignItems: "center",

                                } }>
                                    <BilboardButton
                                        onClick={ () => setAskQuestionDialogOpen( true ) }
                                        width="160px" height="40px" fontSize="16px" text="Ask a question"/>
                                </Grid>

                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
                <Snackbar
                    anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                    open={ error !== '' }
                    autoHideDuration={ 2000 }
                    onClose={ () => setError( '' ) }
                >
                    <Alert onClose={ () => setError( '' ) }
                           severity={ "warning" }
                    >
                        { error }
                    </Alert>
                </Snackbar>
                <Snackbar
                    anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                    open={ success !== '' }
                    autoHideDuration={ 2000 }
                    onClose={ () => setSuccess( '' ) }
                >
                    <Alert onClose={ () => setSuccess( '' ) }
                           severity={ "success" }
                    >
                        { success }
                    </Alert>
                </Snackbar>
            </Grid> }

        </div>
    )
}

const mapStateToProps = ( state ) => {
    return { isAskQuestionDialogOpen: state.isAskQuestionDialogOpen };
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setAskQuestionDialogOpen: ( value ) =>
            dispatch( {
                type: "SET_IS_ASK_QUESTION_DIALOG_OPEN",
                isAskQuestionDialogOpen: value,
            } ),
    };
};


export default connect( mapStateToProps, mapDispatchToProps )( EventDetailScreen );