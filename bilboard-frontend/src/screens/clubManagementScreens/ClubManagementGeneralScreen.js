import { Edit } from "@mui/icons-material";
import InstagramIcon from "@mui/icons-material/Instagram";
import WhatsAppIcon from "@mui/icons-material/WhatsApp";
import { Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";

import DialogContent from "@mui/material/DialogContent";
import Grid from "@mui/material/Grid";
import Rating from "@mui/material/Rating";
import { makeStyles } from "@mui/styles";
import React from "react";
import Colors from "../../utils/Colors";
import Env from "../../utils/Env";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";
import Constants from "../../utils/Constants";
import EventForGeneralPage from "./clubManagementComponents/EventForGeneralPage";
import axios from "axios";
import Program from "../../utils/Program";

const useStyles = makeStyles( {
    input: {
        display: "none",
    },
} );

const ClubManagementGeneralScreen = ( {
                                          club,
                                          currentEvent,
                                          setCurrentEvent,
                                          functionList
                                      } ) => {
    const [ whatsappLink, setWhatsappLink ] = React.useState( null );
    const [ instagramLink, setInstagramLink ] = React.useState( null );
    const [photo,setPhoto] = React.useState(null)

    const [ isInstagramDialogOpen, setIsInstagramDialogOpen ] =
        React.useState( false );
    const [ isWhatsappDialogOpen, setIsWhatsappDialogOpen ] = React.useState( false );

    const classes = useStyles();
    const [ success, setSuccess ] = React.useState( "" );
    const [ error, setError ] = React.useState( "" );

    let totalPoint = 0;

    let point = 0;
    let totalParticipant = 0;
    if ( club !== null ) {
        club.events.forEach( ( eventOfList ) => {
            point = point + eventOfList.averageRate * eventOfList.rateCount;
            totalParticipant = totalParticipant + eventOfList.rateCount;
        } );
    }


    if ((photo == null && club !== null) || (club !== null && process.env.REACT_APP_IMAGE_URL + club.photo !== photo)) {
        setPhoto(process.env.REACT_APP_IMAGE_URL + club.photo);
    }


    let headers = {
        "Content-Type": "application/json",
        Authorization: "Bearer " + Env.TOKEN,
    };

    function handleWhatsappLinkChange() {
        axios
            .post(
                process.env.REACT_APP_URL + "club/update",
                {
                    id: club.id,
                    name: club.name,
                    shortName: club.shortName,
                    wpLink: whatsappLink,
                    instaLink: club.instaLink,
                },
                { headers: headers }
            )
            .then( function ( response ) {
                if ( response.data.operationResult === "SUCCESS" ) {
                    functionList.handleWpLinkUpdate( whatsappLink )
                    setSuccess( "Successfully updated! Please refresh the page." );
                    setWhatsappLink( null );
                    setIsWhatsappDialogOpen( false );
                } else {
                    setError( "Could not updated!" );
                }
            } );
    }

    function handleInstagramLinkChange() {
        axios
            .post(
                process.env.REACT_APP_URL + "club/update",
                {
                    id: club.id,
                    name: club.name,
                    shortName: club.shortName,
                    wpLink: club.wpLink,
                    instaLink: instagramLink,
                },
                { headers: headers }
            )
            .then( function ( response ) {
                if ( response.data.operationResult === "SUCCESS" ) {
                    functionList.handleInstaLinkUpdate( instagramLink )
                    setSuccess( "Successfully updated! Please refresh the page." );
                    setInstagramLink( null );
                    setIsInstagramDialogOpen( false );
                } else {
                    setError( "Could not updated!" );
                }
            } );
    }

    return (
        <div>
            <Grid container style={ { maxHeight: "300px" } }>
                <input
                    className={ classes.input }
                    accept="image/*"
                    id="contained-button-file"
                    type="file"
                    onChange={ ( event ) => {
                        const formData = new FormData();
                        let type

                        Array.from( event.target.files )
                             .forEach( ( file, index ) => {
                                 formData.append( "photo", file, file.name );
                                 type = file.type.split("/")[1]
                             } );

                        formData.append( "clubId", club.id );

                        const headers = {
                            Authorization: "Bearer " + Env.TOKEN,
                        };

                        fetch( process.env.REACT_APP_URL + "club/updatePhoto", {
                            method: "POST",
                            headers: headers,
                            body: formData,
                        } )
                            .then( ( response ) => response.json() )
                            .then( ( data ) => {
                            } )
                            .then( () => {
                                setPhoto(process.env.REACT_APP_IMAGE_URL + "clubs/default.png")
                                club.photo = "clubs/" + club.id + "." + type
                                Program.addClub(club,club.id)
                                setSuccess(
                                    "Image uploaded successfully! Please refresh the page!"
                                );
                            } )
                            .catch( () => {
                                setError( "Something went wrong!" );
                            } );
                    } }
                />
                <Grid item xs={ 5 }>
                    <img
                        src={ process.env.REACT_APP_IMAGE_URL + club.photo }
                        alt="clubImage"
                        style={ {
                            maxWidth: "300px",
                            maxHeight: "250px",
                            marginBottom: "-10%",
                            marginTop: "5%",
                        } }
                    />
                    <label htmlFor="contained-button-file">
                        <Button component="span" style={ { marginLeft: -20 } }>
                            <Edit/>
                        </Button>
                    </label>
                    <div/>
                </Grid>
                <Grid item xs={ 7 }>
                    <div
                        style={ {
                            fontSize: "40px",
                            marginTop: "20px",
                            fontWeight: "bold",
                            fontFamily: "Oxygen, sans-serif",
                            color: Colors.BILBOARD_LIGHT_GREY,
                        } }
                    >
                        { club.name }
                    </div>
                    <div/>
                    <Rating
                        name="read-only"
                        defaultValue={ totalParticipant !== 0 ? point / totalParticipant : 0 }
                        style={ { marginTop: "20px" } }
                        readOnly
                        size="large"
                    />
                    <div/>
                    <Button
                        variant="contained"
                        startIcon={ <WhatsAppIcon/> }
                        onClick={ () => window.open( club.wpLink, "_blank" ) }
                        style={ {
                            marginTop: "20px",
                            minWidth: "300px",
                            minHeight: "40px",
                            backgroundColor: "#25d366",
                        } }
                    >
                        Go to Whatsapp Group
                    </Button>

                    <Button
                        onClick={ () => setIsWhatsappDialogOpen( true ) }
                        variant="outlined"
                        color="warning"
                        style={ { marginTop: "20px", marginLeft: "10px" } }
                    >
                        Edit
                    </Button>
                    <div></div>
                    <Button
                        variant="contained"
                        onClick={ () => {
                            window.open( club.instaLink, "_blank" )
                        } }
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
                    <Button
                        onClick={ () => setIsInstagramDialogOpen( true ) }
                        variant="outlined"
                        color="warning"
                        style={ { marginTop: "20px", marginLeft: "10px" } }
                    >
                        Edit
                    </Button>
                </Grid>
            </Grid>
            <div
                style={ {
                    fontSize: "50px",
                    marginTop: "50px",
                    fontWeight: "bold",
                    fontStyle: "italic",
                    marginBottom: "40px",
                    fontFamily: "Oxygen, sans-serif",
                    color: Colors.BILBOARD_LIGHT_GREY,
                } }
            >
                Posts
            </div>

            <Grid container>
                { club.events.map( ( event ) => {
                    return (
                        <Grid
                            item
                            xs={ 3 }
                            style={ {
                                marginBottom: "20px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <EventForGeneralPage
                                functionList={ functionList }
                                currentEvent={ event }
                                setCurrentEvent={ setCurrentEvent }
                                event={ event }
                            />
                        </Grid>
                    );
                } ) }
            </Grid>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center" } }
                open={ error !== "" }
                autoHideDuration={ 5000 }
                onClose={ () => setError( "" ) }
            >
                <Alert onClose={ () => setError( "" ) } severity={ "warning" }>
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center" } }
                open={ success !== "" }
                autoHideDuration={ 5000 }
                onClose={ () => setSuccess( "" ) }
            >
                <Alert onClose={ () => setSuccess( "" ) } severity={ "success" }>
                    { success }
                </Alert>
            </Snackbar>

            <Dialog
                open={ isWhatsappDialogOpen }
                fullWidth
                maxWidth={ "sm" }
                onClose={ () => setIsWhatsappDialogOpen( false ) }
            >
                <DialogContent>
                    <Grid container>
                        <Grid item xs={ 12 }>
                            <p
                                style={ {
                                    color: Colors.BILBOARD_LIGHT_GREY,
                                    fontSize: "30px",
                                    marginBottom: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    letterSpacing: "4px",
                                    display: "flex",
                                    justifyContent: "center",
                                } }
                            >
                                Edit The Whatsapp Link
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
                            >
                                Please enter the new Whatsapp link
                            </p>
                        </Grid>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                marginTop: "20px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <BilboardTextField
                                onChange={ ( e ) => setWhatsappLink( e.target.value ) }
                                value={ whatsappLink }
                                type="whatsappLink"
                                width="300px"
                                style={ { marginTop: "30px" } }
                            />
                        </Grid>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                marginTop: "40px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <BilboardButton
                                width="100px"
                                fontSize="14px"
                                text="Submit"
                                onClick={ () => handleWhatsappLinkChange() }
                            />
                        </Grid>
                    </Grid>
                </DialogContent>
                <DialogActions>
                    <Button
                        onClick={ () => setIsWhatsappDialogOpen( false ) }
                        style={ {
                            display: "flex",
                            justifyContent: "center",
                        } }
                    >
                        Cancel
                    </Button>
                </DialogActions>
            </Dialog>

            <Dialog
                open={ isInstagramDialogOpen }
                fullWidth
                maxWidth={ "sm" }
                onClose={ () => setIsInstagramDialogOpen( false ) }
            >
                <DialogContent>
                    <Grid container>
                        <Grid item xs={ 12 }>
                            <p
                                style={ {
                                    color: Colors.BILBOARD_LIGHT_GREY,
                                    fontSize: "30px",
                                    marginBottom: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    letterSpacing: "4px",
                                    display: "flex",
                                    justifyContent: "center",
                                } }
                            >
                                Edit The Instagram Link
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
                            >
                                Please enter the new instagram link
                            </p>
                        </Grid>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                marginTop: "20px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <BilboardTextField
                                onChange={ ( e ) => setInstagramLink( e.target.value ) }
                                value={ instagramLink }
                                type="instagramLink"
                                width="300px"
                                style={ { marginTop: "30px" } }
                            />
                        </Grid>
                        <Grid
                            item
                            xs={ 12 }
                            style={ {
                                marginTop: "40px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            <BilboardButton
                                width="100px"
                                fontSize="14px"
                                text="Submit"
                                onClick={ () => handleInstagramLinkChange() }
                            />
                        </Grid>
                    </Grid>
                </DialogContent>
                <DialogActions>
                    <Button
                        onClick={ () => setIsInstagramDialogOpen( false ) }
                        style={ {
                            display: "flex",
                            justifyContent: "center",
                        } }
                    >
                        Cancel
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
};

export default ClubManagementGeneralScreen;
