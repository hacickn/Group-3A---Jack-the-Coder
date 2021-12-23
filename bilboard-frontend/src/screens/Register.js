import React from "react";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import { useState } from "react";
import axios from "axios";
import { CircularProgress, Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";

const Register = () => {
    const [ name, setName ] = useState( "" );
    const [ surname, setSurname ] = useState( "" );
    const [ email, setEmail ] = useState( "" );
    const [ password, setPassword ] = useState( "" );
    const [ ID, setID ] = useState( "" );
    const [ submitted, setSubmitted ] = useState( false )
    const [ error, setError ] = useState( "" )
    const [ success, setSuccess ] = useState( "" )

    async function handleRegisterRequest() {
        setSubmitted( true )
        axios.post( process.env.REACT_APP_URL + 'auth/signUp', {
            "name": name,
            "surname": surname,
            "email": email,
            "bilkentId": ID,
            "password": password,
            "type": email.includes( "ug" ) ? "student" : "academic",
            "university": "2"
        } )
             .then( function ( response ) {
                 console.log( response.status )
                 setName( "" )
                 setSurname( "" )
                 setEmail( "" )
                 setID( "" )
                 setPassword( "" )
                 setSubmitted( false )
                 setSuccess( "Confirmation code is sent! Check your email box!" )
             } )
             .catch( function ( error ) {
                 setError( "Email or id in usage! Please contact with system admin!" )
                 setSubmitted( false )
             } )
    }

    return (
        <div>
            <Grid container>
                <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                    <BilboardTextField
                        label="Name"
                        type="name"
                        value={ name }
                        onChange={ ( e ) => setName( e.target.value ) }
                        width="300px"
                        style={ { marginTop: "30px" } }
                    />
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                    <BilboardTextField
                        label="Surname"
                        type="surname"
                        value={ surname }
                        onChange={ ( e ) => setSurname( e.target.value ) }
                        width="300px"
                        style={ { marginTop: "30px" } }
                    />
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                    <BilboardTextField
                        label="Bilkent Mail"
                        type="email"
                        value={ email }
                        onChange={ ( e ) => setEmail( e.target.value ) }
                        width="300px"
                        style={ { marginTop: "30px" } }
                    />
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                    <BilboardTextField
                        label="Password"
                        type="password"
                        value={ password }
                        onChange={ ( e ) => setPassword( e.target.value ) }
                        width="300px"
                        style={ { marginTop: "30px" } }
                    />
                </Grid>
                <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                    <BilboardTextField
                        label="ID"
                        type="number"
                        value={ ID }
                        onChange={ ( e ) => setID( e.target.value ) }
                        width="300px"
                        style={ { marginTop: "30px" } }
                    />
                </Grid>
            </Grid>

            <Grid item xs={ 12 } style={ { marginTop: "40px" } }>
                { submitted ? <CircularProgress/> : <BilboardButton width="100px" fontSize="14px" text="Register"
                                                                    onClick={ () => {
                                                                        if ( name.trim().length === 0 ) {
                                                                            setError( "Name can not be empty!" )
                                                                        } else if ( surname.trim().length === 0 ) {
                                                                            setError( "Surname can not be empty!" )

                                                                        } else if ( !email.includes( "bilkent" ) ) {
                                                                            setError( "Enter valid bilkent mail" +
                                                                                " adress!" )

                                                                        } else if ( ID.trim().length === 0 ) {
                                                                            setError( "Id can not be empty!" )
                                                                        } else if ( password.trim().length <= 6 ) {
                                                                            setError( "Password should be longer thab" +
                                                                                " 6 characters!" )
                                                                        } else {
                                                                            handleRegisterRequest()
                                                                        }
                                                                    } }/> }
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
                onClose={ () => setError( '' ) }
            >
                <Alert onClose={ () => setError( '' ) }
                       severity={ "success" }
                >
                    { success }
                </Alert>
            </Snackbar>
        </div>
    )
}

export default Register;