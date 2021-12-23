import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import FollowedClubs from "../components/FollowedClubs";
import BilboardTextField from "../components/BilboardTextField";
import Constants from "../utils/Constants";
import BilboardButton from "../components/BilboardButton";
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Colors from "../utils/Colors";
import { Card, CircularProgress, Snackbar, Switch } from "@mui/material";
import { connect } from "react-redux";
import React from "react";
import Env from "../utils/Env";
import axios from "axios";
import Alert from "@mui/material/Alert";

const useStyles = makeStyles( {
    root: {
        height: "calc(100vh-68px)",
    },
    userImage: {
        width: "200px",
        height: "200px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        borderRadius: "100px"
    },
} );

const UserScreen = ( { image, setScreenNoNavbar, signOut, program } ) => {
    console.log( program )
    const [ geStatus, setGeStatus ] = React.useState( null )
    const [ submitted, setSubmitted ] = React.useState( false )
    const [ name, setName ] = React.useState( null )
    const [ surname, setSurname ] = React.useState( null )
    const [ id, setId ] = React.useState( null )
    const [ error, setError ] = React.useState( "" )
    const [ success, setSuccess ] = React.useState( "" )

    if ( geStatus == null && program.geTaken !== geStatus ) {
        setGeStatus( program.geTaken )
    }

    if ( name == null && program.name !== name ) {
        setName( program.name )
    }

    if ( surname == null && program.surname !== surname ) {
        setSurname( program.surname )
    }

    if ( id == null && program.bilkentId !== id ) {
        setId( program.bilkentId )
    }

    function handleGeStatusChange( status ) {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }


        setSubmitted( true )
        axios.post( process.env.REACT_APP_URL + "user/changeGeStatus?userId=" + program.id + "&geStatus=" + status,
            {}, { headers: headers } )
             .then( function ( response ) {
                 if ( response.status === 200 ) {
                     setSubmitted( false )
                     setSuccess( "GE250/1 is updated!" )
                 } else {
                     setSubmitted( false )
                     setGeStatus( !status )
                     setSuccess( "GE250/1 is NOT updated!" )
                 }
             } )
             .catch( function ( error ) {
                 setSuccess( "GE250/1 is NOT updated!" )
                 setSubmitted( false )
                 setGeStatus( !status )
             } )
    }

    function handleNameSurnameChange() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        axios.post( process.env.REACT_APP_URL + "user/changeNameSurname?userId=1&name=" + name + "&surname=" + surname,
            {}, { headers: headers } )
             .then( function ( response ) {
                 if ( response.status === 200 ) {
                     setSubmitted( false )
                     setSuccess( "Name and surname is updated!" )
                 } else {
                     setSubmitted( false )
                     setError( "Name and surname is NOT updated!" )
                 }
             } )
             .catch( function ( error ) {
                 setError( "Name and surname is NOT updated!" )
                 setSubmitted( false )
             } )
    }

    const classes = useStyles();
    return (
        <div className={ classes.root }>
            <Grid container>
                <Grid item xs={ 4 }>
                    <Card elevation={ 3 }
                          style={ {
                              borderRadius: Constants.BORDER_RADIUS,
                              padding: "20px",
                              margin: "40px",
                              marginLeft: "100px",
                              marginRight: "80px",

                          } }>
                        <Grid container direction="column">
                            <Grid item xs={ 4 } style={ {
                                paddingTop: "40px",
                                paddingBottom: "30px",
                                display: "flex",
                                justifyContent: "center",
                                alignItems: "center"
                            } }>
                                <div
                                    className={ classes.userImage }
                                    style={ {
                                        backgroundImage: `url(${ process.env.REACT_APP_IMAGE_URL + program.photo })`
                                    } }
                                />
                            </Grid>
                            <Grid item xs={ 8 }>
                                <Grid container>
                                    <Grid
                                        item
                                        xs={ 12 }
                                        style={ {
                                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                            fontSize: "24px",
                                        } }
                                    >
                                        Change Password
                                    </Grid>
                                    <Grid
                                        item
                                        xs={ 12 }
                                        style={ { marginBottom: "10px", marginTop: "10px" } }
                                    >
                                        <BilboardTextField label="Name" value={ name }
                                                           onChange={ ( e ) => setName( e.target.value ) }
                                                           width={ '280px' }/>
                                    </Grid>
                                    <Grid item xs={ 12 } style={ { marginBottom: "10px" } }>
                                        <BilboardTextField label="Surname" value={ surname }
                                                           onChange={ ( e ) => setSurname( e.target.value ) }
                                                           width={ '280px' }/>
                                    </Grid>
                                    <Grid item xs={ 12 } style={ { marginBottom: "10px" } }>
                                        <BilboardTextField label="Id" value={ id } width={ '280px' }
                                                           onChange={ ( e ) => {
                                                           } }/>
                                    </Grid>

                                    <Grid item xs={ 12 } style={ { marginBottom: "10px" } }>
                                        <BilboardButton onClick={ () => {
                                            if ( name.trim().length > 0 && surname.trim().length > 0 ) {
                                                handleNameSurnameChange()
                                            } else {
                                                setError( "Name or surname can NOT be empty!" )
                                            }
                                        } } text="Update" width={ '160px' } fontSize={ "12px" }/>
                                    </Grid>
                                    <Grid item xs={ 12 }
                                          style={ { marginBottom: "10px", display: "flex", justifyContent: "center" } }>
                                        <FormGroup>
                                            <FormControlLabel
                                                control={
                                                    <Switch
                                                        checked={ geStatus }
                                                        onChange={ () => {
                                                            const newStatus = !geStatus
                                                            setGeStatus( newStatus )
                                                            handleGeStatusChange( newStatus )
                                                        } }/> }
                                                label="GE250/1"
                                            />
                                        </FormGroup>
                                    </Grid>
                                    <Grid item xs={ 12 }
                                          style={ {
                                              marginBottom: "10px",
                                              display: "flex",
                                              minHeight: 60,
                                              justifyContent: "center"
                                          } }>
                                        { submitted ? <CircularProgress/> : <div/> }
                                    </Grid>
                                    <Grid item xs={ 12 } style={ { marginTop: "10px" } }>
                                        <BilboardButton color={ Colors.BILBOARD_RED } text="Sign Out" width="160px"
                                                        fontSize="12px" onClick={ () => {
                                            signOut()
                                            setScreenNoNavbar( "login" )
                                        } }/>
                                    </Grid>
                                </Grid>
                            </Grid>
                        </Grid>
                    </Card>
                </Grid>
                <Grid item xs={ 8 }>
                    <Card elevation={ 3 } style={ {
                        borderRadius: Constants.BORDER_RADIUS,
                        padding: "20px",
                        marginRight: "20px",
                        marginTop: "40px"
                    } }>
                        <Grid container style={ { maxHeight: "75vh", overflowX: "scroll" } }>
                            <Grid item xs={ 12 }>
                                <p
                                    style={ {
                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                        fontSize: "32px",
                                        float: "left",
                                    } }
                                >
                                    Followed Clubs
                                </p>
                            </Grid>
                            <Grid item xs={ 12 }>
                                { program.clubMemberShips.map( ( membership ) => {
                                    return <FollowedClubs club={ membership.club }/>
                                } ) }
                            </Grid>
                        </Grid>
                    </Card>
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
        </div>
    );
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setScreenNoNavbar: ( value ) => dispatch( { type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value } )
    }
}

export default connect( null, mapDispatchToProps )( UserScreen );
