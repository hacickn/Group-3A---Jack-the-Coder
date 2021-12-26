import Grid from "@mui/material/Grid";
import Rating from '@mui/material/Rating';
import Constants from "../utils/Constants";
import EditEventDialog from "../components/EditEventDialog";
import BilboardQuestionCard from "../components/BilboardQuestionCard";
import BilboardButton from "../components/BilboardButton";
import React, { useState } from 'react'
import axios from "axios";
import Env from "../utils/Env";
import Program from "../utils/Program";
import { CircularProgress } from "@mui/material";
import QuestionAnswerCard from "../components/QuestionAnswerCard";

const EventDetailedScreenBoardMember = ( { setCurrentEvent, currentEvent, currentClub, setCurrentClub, program } ) => {
    const [ eventData, setEventData ] = React.useState( null );
    const [ editEventDialog, setEditEventDialog ] = React.useState( false )
    const [ loading, setLoading ] = React.useState( true );
    const [ success, setSuccess ] = useState( "" )
    const [ error, setError ] = useState( "" )
    const [ eventCode, setEventCode ] = React.useState( "" )


    if ( Program.getEvent( currentEvent.id ) === undefined ) {
        setEventData( currentEvent )
        Program.addEvent( currentEvent, currentEvent.id )
        setLoading( false );
    } else if ( Program.getClub( currentEvent.id ) !== null && loading ) {
        setLoading( false );
        setEventData( Program.getClub( currentEvent.id ) );
    } else {
    }

    const generateCode = () => {

        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }
        axios.post( process.env.REACT_APP_URL + "event/eventCode?eventId=" + currentEvent.id, {}, { headers: headers } )
             .then( function ( response ) {
                 setEventCode( response.data )
             } )
             .catch( function ( error ) {
                 setError( "Something went wrong!" )
                 console.log( error );
             } )
    }

    return (

        <div>
            { <EditEventDialog open={ editEventDialog } setOpen={ ( status ) => {
                setEditEventDialog( status )
            } }/> }
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
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                } }>{ currentEvent.title }
                                </div>
                                <Rating name="read-only" defaultValue={ currentEvent.averageRate }
                                        style={ { paddingLeft: "290px" } } readOnly
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
                                fontSize: "30px",
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
                                fontSize: "40%",

                            } }>
                            <div style={ {
                                fontSize: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }>Participant
                                Limit { currentEvent.eventParticipants.length }/ { currentEvent.maxParticipationCount }
                            </div>


                        </Grid>
                        <Grid xs={ 5 }>

                            { eventCode === "" ? <BilboardButton
                                onClick={ () => generateCode() }
                                width="160px"
                                fontSize="13px"
                                text="Generate Code"
                                color="#00e676"
                            /> : <div style={ {
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                fontSize: "24px"
                            } }>Code: { eventCode }</div> }

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
                            <Grid xs={ 9 }>
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
                                    marginRight: 70,
                                    marginTop: 10
                                } }>
                                    { currentEvent.description }
                                </div>

                            </Grid>
                            <Grid xs={ 3 }
                                  style={ {
                                      marginTop: "60px",
                                  } }>

                                <BilboardButton
                                    onClick={ () => setEditEventDialog( true ) }
                                    width="180px"
                                    fontSize="20px"
                                    text="Edit Event"
                                    color="#FF4B4B"
                                    height="100px"
                                />
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
                                    maxHeight: "40vh",
                                    overflowY: "scroll",
                                    padding: 20,
                                    paddingLeft: 60,
                                    paddingRight: 60,
                                } }>
                                    { currentEvent.eventQuestions.map(
                                        question => {

                                            return <Grid item xs={ 12 }>
                                                <BilboardQuestionCard question={ question }/>
                                            </Grid>

                                        } ) }
                                </Grid>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid> }
        </div>
    )
}

export default EventDetailedScreenBoardMember;