import {
    CircularProgress,
    FormControlLabel,
    Grid,
    IconButton,
    Radio,
    RadioGroup, Snackbar,
} from "@mui/material";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardMultilineTextField from "../../components/BilboardMultilineTextField";
import BilboardButton from "../../components/BilboardButton";
import Colors from "../../utils/Colors";
import Checkbox from "@mui/material/Checkbox";
import { makeStyles } from "@mui/styles";
import FormGroup from "@mui/material/FormGroup";
import Constants from "../../utils/Constants";
import { Edit, ImageAspectRatio, ImageOutlined } from "@mui/icons-material";
import React from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import Env from "../../utils/Env";
import Button from "@mui/material/Button";
import axios from "axios";
import Alert from "@mui/material/Alert";

const useStyles = makeStyles( {
    textGrid: {
        display: "flex",
        justifyContent: "end",
        paddingRight: "20px",
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
    },
    inputGrid: {
        display: "flex",
        justifyContent: "start",
    },
    rowGrid: {
        paddingTop: "10px",
    },
    input: {
        display: "none",
    },
} );

const ClubManagementAddEventScreen = ( { club } ) => {
    const classes = useStyles();
    const [ isLeaveAlertOpen, setIsLeaveAlertOpen ] = React.useState( false );
    const [ submitted, setSubmitted ] = React.useState( false )
    const [ error, setError ] = React.useState( "" )
    const [ success, setSuccess ] = React.useState( "" )
    const [ title, setTitle ] = React.useState( "" )
    const [ description, setDescription ] = React.useState( "" )
    const [ photo, setPhoto ] = React.useState( null )
    const [ date, setDate ] = React.useState( new Date() )
    const [ zoomLink, setZoomLink ] = React.useState( "" )
    const [ listNow, setListNow ] = React.useState( false )
    const [ numberOfParticipants, setNumberOfParticipants ] = React.useState( 0 )
    const [ gePoint, setGePoint ] = React.useState( 0 )
    const [ isForMember, setIsForMember ] = React.useState( false );
    const [ isOnline, setIsOnline ] = React.useState( "online" );
    const [ duration, setDuration ] = React.useState( "" )

    const handleAddEvent = () => {
        setIsLeaveAlertOpen( true );
    };

    const handleCloseAlert = () => {
        setIsLeaveAlertOpen( false );
    };

    function handleEventAddition() {
        const formData = new FormData()

        if ( photo === null || title.trim().length === 0 || description.trim().length === 0 ) {
            setError( "Please fill all the fields!" )
        } else {
            setSubmitted( true )
            Array.from( photo )
                 .forEach( ( file ) => {
                     formData.append( "eventPhoto", file, file.name )
                 } )
            formData.append( "title", title )
            formData.append( "clubId", club.id )
            formData.append( "description", description )
            formData.append( "date", date.toLocaleString()
                                         .split( "T" )
                                         .join( " " ) )
            formData.append( "isOnline", ( isOnline === "online" ).toString() )
            formData.append( "isVisible", listNow.toString() )
            formData.append( "location", zoomLink )
            formData.append( "maxParticipationCount", numberOfParticipants.toString() )
            formData.append( "gePoint", gePoint.toString() )
            formData.append( "restrictionForMember", isForMember.toString() )
            formData.append( "timeSlotIdList", "" )
            formData.append( "duration", duration )

            const headers = {
                'Authorization': 'Bearer ' + Env.TOKEN
            }


            axios.post( process.env.REACT_APP_URL + "event", formData, { headers: headers } )
                 .then( function ( response ) {

                     setSuccess( "Event is successfully created!" )
                     setSubmitted( false )

                     setTitle("")
                     setDate(new Date())
                     setDescription("")
                     setDuration("")
                     setNumberOfParticipants(0)
                     setGePoint(0)
                     setZoomLink("")
                 } )
                 .catch( function ( error ) {
                     setError( "Event could NOT be created!" )
                     setSubmitted( false )

                     console.log( error )
                 } )
        }


    }

    return (
        <div>
            <Grid
                container
                style={ {
                    paddingTop: 20,
                } }
            >
                <Grid item xs={ 3 }/>
                <Grid item xs={ 6 }>
                    <Grid container>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                padding: 20,
                                fontSize: 48,
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }
                        >
                            Add Event
                        </Grid>
                        <Grid container>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Title
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardTextField value={ title } onChange={ ( e ) => setTitle( e.target.value ) }
                                                       width={ "500px" }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <input
                                    className={ classes.input }
                                    accept="image/*"
                                    id="contained-button-file"
                                    type="file"
                                    onChange={ ( event ) => {
                                        setPhoto( event.target.files )
                                    } }
                                />
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Image
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <label htmlFor="contained-button-file">
                                        <Button component="span" style={ { marginLeft: -20 } }> <ImageOutlined
                                            style={ { color: Colors.BILBOARD_MAIN } }/></Button>
                                    </label>
                                    <label htmlFor="contained-button-file">
                                        <Button disabled={ true } component="span"
                                                style={ { marginLeft: -20 } }>           { photo !== null &&
                                        "Selected!" }</Button>
                                    </label>

                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Description
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardMultilineTextField value={ description }
                                                                onChange={ ( e ) => setDescription( e ) }
                                                                width={ "500px" } rows={ 5 }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Date
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardTextField value={ date } onChange={ ( e ) => setDate( e.target.value ) }
                                                       type={ "datetime-local" } width={ "500px" }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Location
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <Grid container>
                                        <RadioGroup
                                            row
                                            aria-label="type"
                                            value={ isOnline }
                                            onChange={ ( event ) => setIsOnline( event.target.value ) }
                                            name="radio-buttons-group"
                                        >
                                            <FormControlLabel
                                                value="faceToFace"
                                                control={ <Radio/> }
                                                label="Face to Face"
                                            />
                                            <FormControlLabel
                                                value="online"
                                                control={ <Radio/> }
                                                label="Online"
                                            />
                                        </RadioGroup>
                                    </Grid>
                                </Grid>
                                <Grid item xs={ 5 } className={ classes.textGrid }/>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    { isOnline === "online" ? (
                                        <div>
                                            <BilboardTextField
                                                value={ zoomLink } onChange={ ( e ) => setZoomLink( e.target.value ) }
                                                width={ "500px" }
                                                label={ "Enter Zoom Link" }
                                            />
                                            <FormGroup>
                                                <FormControlLabel
                                                    checked={ listNow }
                                                    onChange={ () => setListNow( !listNow ) }
                                                    control={ <Checkbox/> }
                                                    label="List Now"
                                                />
                                            </FormGroup>
                                        </div>
                                    ) : (
                                        <BilboardButton text={ "Choose timeslots" } width={ "200px" }/>
                                    ) }
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Duration
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardTextField value={ duration }
                                                       onChange={ ( e ) => setDuration( e.target.value ) }
                                                       width={ "500px" }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Number of Participant
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardTextField value={ numberOfParticipants }
                                                       onChange={ ( e ) => setNumberOfParticipants( e.target.value ) }
                                                       type={ "number" } width={ "100px" }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Ge 250/1 Point
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <BilboardTextField value={ gePoint }
                                                       onChange={ ( e ) => setGePoint( e.target.value ) }
                                                       type={ "number" } width={ "100px" }/>
                                </Grid>
                            </Grid>
                            <Grid container className={ classes.rowGrid }>
                                <Grid item xs={ 5 } className={ classes.textGrid }>
                                    Private for Members
                                </Grid>
                                <Grid item xs={ 7 } className={ classes.inputGrid }>
                                    <Radio
                                        checked={ isForMember }
                                        onClick={ () => setIsForMember( !isForMember ) }
                                    />
                                </Grid>
                            </Grid>
                            <Grid
                                container
                                style={ {
                                    display: "flex",
                                    justifyContent: "center",
                                    paddingTop: "20px",
                                } }
                            >
                                <BilboardButton
                                    onClick={ () => handleAddEvent() }
                                    fontSize={ "14px" } text={ "Add" } width={ "200px" }/>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>

                <Grid item xs={ 3 }/>
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
            <Dialog open={ isLeaveAlertOpen } onClose={ handleCloseAlert }>
                <DialogTitle>{ "Add Event" }</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Are you sure to add the new event?
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <BilboardButton disabled={ submitted } onClick={ handleCloseAlert } text="Cancel"/>
                    { submitted ? <CircularProgress/> :
                        <BilboardButton onClick={ () => handleEventAddition() } text="Add" autoFocus/> }
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default ClubManagementAddEventScreen;
