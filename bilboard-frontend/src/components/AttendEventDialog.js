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
import axios from "axios";
import Env from "../utils/Env";

/**
 * Attend Event Dialog
 *
 * Date: 13.11.2021
 * Metehan Saçakçı
 */

const AttendEventDialog = ( { isAttendDialogOpen, setIsAttendDialogOpen, setError, setSuccess } ) => {

    const [ code, setCode ] = React.useState( "" );


    function handleCodeCheck() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }


        axios.post( process.env.REACT_APP_URL + "event/attend?eventCode=" + code + "&userId=" + Env.PUBLIC_ID, {},
            { headers: headers } )
             .then( function ( response ) {
                 console.log( response.data )
                 if ( response.data.operationResult === "SUCCESS" ) {
                     setSuccess( "Your attendance is taken successfully!" )
                     setIsAttendDialogOpen( false )
                 } else {
                     setError( "You could not attend!" )

                 }
             } )
             .catch( function ( error ) {
                 setError( "You could not attend!" )
             } )
    }


    return (
        <Dialog open={ isAttendDialogOpen } fullWidth maxWidth={ "sm" }
                onClose={ () => setIsAttendDialogOpen( false ) }>
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
                            Attend An Event
                        </p>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "18px",
                                marginBottom: "1px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                letterSpacing: "1px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >Please enter 8-digit event code</p>
                    </Grid>
                    <Grid item xs={ 12 } style={ {
                        marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                    } }>
                        <BilboardTextField
                            label="Code"
                            type="attendanceCode"
                            width="300px"
                            style={ { marginTop: "30px" } }
                            value={ code }
                            onChange={ ( e ) => setCode( e.target.value ) }
                        />
                    </Grid>
                    <Grid item xs={ 12 } style={ {
                        marginTop: "40px",
                        display: "flex",
                        justifyContent: "center"
                    } }>
                        <BilboardButton onClick={ () => handleCodeCheck() } width="100px" fontSize="14px"
                                        text="Submit"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button
                    onClick={ () => setIsAttendDialogOpen( false ) }
                    style={ {
                        display: "flex",
                        justifyContent: "center"
                    } }
                >Cancel</Button>
            </DialogActions>

        </Dialog>
    )
}

const mapStateToProps = ( state ) => {
    return {
        isAttendDialogOpen: state.isAttendDialogOpen
    }
}

const mapDispatchToProps = ( dispatch ) => {
    return {
        setIsAttendDialogOpen: ( isAttendDialogOpen ) => dispatch(
            { type: "SET_IS_ATTEND_DIALOG_OPEN", isAttendDialogOpen: isAttendDialogOpen } )
    }
}

export default connect( mapStateToProps, mapDispatchToProps )( AttendEventDialog );