import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../utils/Colors";
import Rating from "@mui/material/Rating";
import Button from "@mui/material/Button";
import WhatsAppIcon from "@mui/icons-material/WhatsApp";
import InstagramIcon from "@mui/icons-material/Instagram";
import EventForGeneralPage from "./clubManagementComponents/EventForGeneralPage";
import { Edit } from "@mui/icons-material";
import Env from "../../utils/Env";
import { Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";
import React from "react";

const useStyles = makeStyles( {
    input: {
        display: "none",
    },
} );

const ClubManagementGeneralScreen = ( { club } ) => {

    const classes = useStyles();
    const [ success, setSuccess ] = React.useState( "" )
    const [ error, setError ] = React.useState( "" )

    let totalPoint = 0;
    club.events.forEach( event => {
        totalPoint = totalPoint + event.averageRate
    } )

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

                        Array.from( event.target.files )
                             .forEach( ( file, index ) => {
                                 formData.append( "photo", file, file.name )
                             } )

                        formData.append( "clubId", club.id )


                        const headers = {
                            'Authorization': 'Bearer ' + Env.TOKEN
                        }

                        fetch( process.env.REACT_APP_URL + 'club/updatePhoto', {
                            method: 'POST', headers: headers, body: formData
                        }, )
                            .then( response => response.json(

                            ) )
                            .then( ( data ) => {
                                //console.log(data.message)
                            } )
                            .then( () => {
                                setSuccess( "Image uploaded successfully! Please refresh the page!" )
                            } )
                            .catch( () => {
                                setError( "Something went wrong!" )
                            } )

                    } }
                />
                <Grid item xs={ 5 }>
                    <img
                        src={ process.env.REACT_APP_IMAGE_URL + club.photo }
                        alt="clubImage"
                        style={ { maxWidth: "300px", maxHeight: "250px", marginBottom: "-10%", marginTop: "5%" } }
                    />
                    <label htmlFor="contained-button-file">
                        <Button component="span" style={ { marginLeft: -20 } }><Edit/></Button>
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
                        defaultValue={ totalPoint / club.events.length }
                        style={ { marginTop: "20px" } }
                        readOnly
                        size="large"
                    />
                    <div/>
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
                    <Button
                        variant="outlined"
                        color="warning"
                        style={ { marginTop: "20px", marginLeft: "10px" } }
                    >
                        Edit
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
                    <Button
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
                { club.events.map( event => {
                    return <Grid item xs={ 3 }
                                 style={ { marginBottom: "20px", display: "flex", justifyContent: "center" } }>
                        <EventForGeneralPage event={ event }/>
                    </Grid>
                } ) }
            </Grid>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ error !== '' }
                autoHideDuration={ 5000 }
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
                autoHideDuration={ 5000 }
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

export default ClubManagementGeneralScreen;
