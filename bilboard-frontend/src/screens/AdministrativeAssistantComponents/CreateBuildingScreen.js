import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardButton from "../../components/BilboardButton";
import Constants from "../../utils/Constants";
import React from "react";
import axios from "axios";
import Env from "../../utils/Env";
import { Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";

const CreateBuildingScreen = () => {
    const [ building, setBuilding ] = React.useState( "" );
    const [ error, setError ] = React.useState( "" );
    const [ success, setSuccess ] = React.useState( "" );

    const handleBuilding = ( e ) => {
        setBuilding( e.target.value );
    }

    const handleAddButton = () => {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': "Bearer " + Env.TOKEN,
        };

        axios.post( process.env.REACT_APP_URL + 'reservation/building', {
            "name": building,
            "university": 1
        }, { headers: headers } )
             .then( function ( response ) {
                 if ( response.status === 200 ) {
                     setSuccess( "Added!" )
                     setBuilding( "" )
                 } else {
                     setError( "Failed!" )
                 }

             } )
             .catch( function ( error ) {
                 setError( "Failed!" )

             } )
    }
    return <div style={ { height: "70vh", display: "flex", alignItems: "center" } }>
        <Grid container>
            <Grid item xs={ 12 } style={ { display: "flex", justifyContent: "center", marginBottom: "20px" } }>
                <div style={ { fontFamily: Constants.OXYGEN_FONT_FAMILY, fontSize: "28px" } }>Please Enter Building
                    Name:
                </div>
            </Grid>
            <Grid item xs={ 12 } style={ { display: "flex", justifyContent: "center", marginBottom: "20px" } }>
                <BilboardTextField value={ building } onChange={ ( e ) => setBuilding( e.target.value ) }
                                   label="Building Name" width="300px"/>
            </Grid>
            <Grid item xs={ 12 } style={ { display: "flex", justifyContent: "center", marginBottom: "20px" } }>
                <BilboardButton onClick={ handleAddButton } text="Add" fontSize="16px" width="100px"/>
            </Grid>
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
    </div>

}

export default CreateBuildingScreen;