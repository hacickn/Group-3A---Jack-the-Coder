import React from "react";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import { useState } from "react";
import axios from "axios";
import { CircularProgress } from "@mui/material";

const Register = () => {
    const [ name, setName ] = useState( "" );
    const [ surname, setSurname ] = useState( "" );
    const [ email, setEmail ] = useState( "" );
    const [ password, setPassword ] = useState( "" );
    const [ ID, setID ] = useState( "" );
    const [ submitted, setSubmitted ] = useState( false )

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
                 console.log( response.data )
                 setSubmitted( false )
             } )
             .catch( function ( error ) {
                 console.log( error )
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
                                                                    onClick={ () => handleRegisterRequest() }/> }
            </Grid>
        </div>
    )
}

export default Register;