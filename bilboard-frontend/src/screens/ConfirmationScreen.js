import React from "react";
import BilboardButton from "../components/BilboardButton";
import Grid from "@mui/material/Grid";
import Constants from "../utils/Constants";
import Colors from "../utils/Colors";
import axios from "axios";
import { useParams } from "react-router-dom";
import { CircularProgress } from "@mui/material";

export default function ConfirmationScreen() {
    const [ loading, setLoading ] = React.useState( true )
    const [ success, setSuccess ] = React.useState( false )
    const [ check, setCheck ] = React.useState( true )
    let { confirmationCode } = useParams();

    const handleOnClick = () => {
        axios.post( process.env.REACT_APP_URL + "auth/emailVerification?token=" + confirmationCode, {} )
             .then( function ( response ) {
                 console.log( response )
                 if ( response.data.operationResult === "SUCCESS" ) {
                     setSuccess( true )
                     setLoading( false )
                 } else {
                     setSuccess( false )
                     setLoading( false )

                 }
             } )
             .catch( function ( error ) {
                 setSuccess( false )
                 setLoading( false )
             } )
    };

    if ( check ) {
        setCheck( false )
        handleOnClick()
    }
    return (
        <div style={ { height: "88vh", display: "flex", alignItems: "center" } }>
            { loading ? <CircularProgress/> : <Grid
                container
                style={ {
                    margin: "20%",
                    padding: "80px 60px 80px 60px",
                    border: "5px solid",
                    borderRadius: "20px",
                    borderColor: Colors.BILBOARD_LIGHT_GREY,
                } }
            >
                <Grid
                    item
                    xs={ 12 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginBottom: "40px",
                    } }
                >
                    <div
                        style={ {
                            fontSize: "32px",
                            fontWeight: "bolder",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        } }
                    >
                        { success ? "Your account is successfully confirmed. Enjoy BilBoard!" : "Link is not" +
                            " correct. Try it later!" }
                    </div>
                </Grid>
                <Grid
                    item
                    xs={ 12 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                    } }
                >
                    <a href="/" style={ { textDecoration: "none" } }>
                        <BilboardButton
                            text="Login"
                            color="#F44336"
                            fontSize="20px"
                            width="200px"
                        />
                    </a>

                </Grid>
            </Grid> }
        </div>
    );
}
