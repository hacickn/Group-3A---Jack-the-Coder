import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import React from "react";
import { CircularProgress, Snackbar, TextField } from "@mui/material";
import Constants from "../../utils/Constants";
import axios from "axios";
import Env from "../../utils/Env";
import Alert from "@mui/material/Alert";

const AdminAddClubScreen = ( props ) => {
    const [ clubName, setClubName ] = React.useState( "" );
    const [ clubShortName, setClubShortName ] = React.useState( "" );
    const [ submitted, setSubmitted ] = React.useState( false )
    const [ success, setSuccess ] = React.useState( "" )
    const [ error, setError ] = React.useState( "" )

    async function handleClubAddition() {
        setSubmitted( true )
        let checkExist = false
      /*
        props.clubs.forEach(club=>{
            if(club.name.toLowerCase() === clubName.toLowerCase() || club.shortName.toLowerCase() === clubShortName.toLowerCase()){
                checkExist = true
            }
        })
       */

        if(checkExist){
            setError("This name or shortname is taken already!")
            setSubmitted(false)
        }else{
            let headers = {
                "Content-Type": "application/json",
                'Authorization': 'Bearer ' + Env.TOKEN
            }

            axios.post( process.env.REACT_APP_URL + 'admin/createClub', {
                "name": clubName,
                "shortName": clubShortName,
                "university": "1"
            }, { headers: headers } )
                 .then( function ( response ) {
                     if ( response.status === 200 ) {
                         setClubName( "" )
                         setClubShortName( "" )
                         setSuccess( "Successfully added!" )
                         response.data.president = null
                         response.data.advisor = null
                         props.addClub( response.data )
                         setSubmitted( false )
                     } else {
                         setSubmitted( false )
                         setError( "Could not added!" )
                     }
                 } )
                 .catch( function ( error ) {
                     setSubmitted( false )
                     setError( "Could not added!" )
                 } )
        }
    }

    return (
        <div>
            <Grid container>
                <Grid item xs={ 12 } style={ { marginTop: "60px" } }/>
                <Grid item xs={ 12 }>
                    <Grid container>
                        <Grid item xs={ 2 }/>
                        <Grid item xs={ 4 }>
                            <div
                                style={ {
                                    marginTop: "12px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontSize: "24px",
                                    fontWeight: "bolder",
                                } }
                            >
                                Club Name:
                            </div>
                        </Grid>
                        <Grid item xs={ 3 }>
                            <TextField
                                fullWidth
                                value={ clubName }
                                onChange={ ( e ) => setClubName( e.target.value ) }
                            />
                        </Grid>
                        <Grid item xs={ 3 }/>
                    </Grid>
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "60px" } }/>
                <Grid item xs={ 12 }>
                    <Grid container>
                        <Grid item xs={ 2 }/>
                        <Grid item xs={ 4 }>
                            <div
                                style={ {
                                    marginTop: "12px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontSize: "24px",
                                    fontWeight: "bolder",
                                } }
                            >
                                Club Short Name:
                            </div>
                        </Grid>
                        <Grid item xs={ 3 }>
                            <TextField
                                fullWidth
                                value={ clubShortName }
                                onChange={ ( e ) => setClubShortName( e.target.value ) }
                            />
                        </Grid>
                        <Grid item xs={ 3 }/>
                    </Grid>
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "60px" } }/>
                <Grid item xs={ 12 }>
                    { submitted ? <CircularProgress/> :
                        <BilboardButton text="Submit" width="100px" fontSize="16px" onClick={ () => {
                            if ( clubShortName.trim().length === 0 || clubName.trim().length === 0 ) {
                                setError( "Name and shortname can not be empty!" )
                            } else {
                                handleClubAddition()
                            }
                        } }/> }
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

export default AdminAddClubScreen;
