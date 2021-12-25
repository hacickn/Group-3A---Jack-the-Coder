import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import Env from "../../../utils/Env";
import axios from "axios";
import React from "react";

const useStyles = makeStyles( {
    container: {
        width: "96%",
        height: "80px",
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
        marginBottom: "10px",
        borderRadius: "10px",
    },
} );

const RequestedMembership = ( { requestId, name, surname, ID } ) => {
    const classes = useStyles();
    const [error, setError] = React.useState("")

    function handleEnrollRequest(status) {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': "Bearer " + Env.TOKEN,
        };

        axios.post(process.env.REACT_APP_URL + "club/enrollment/respond?enrollmentId=" + requestId + "&status=" + status, {}, {headers:headers})
            .then(function (response) {
                console.log(response)
            })
            .catch( function (error) {setError("Something went wrong!")})
    }

    return (
        <div className={ classes.container }>
            <Grid container>
                <Grid item xs={ 5 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "18px", fontFamily: "Oxygen, sans-serif" } }>
                        { name } { surname }
                    </div>
                </Grid>
                <Grid item xs={ 2 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "18px", fontFamily: "Oxygen, sans-serif" } }>
                        { ID }
                    </div>
                </Grid>
                <Grid item xs={ 5 } style={ { marginTop: "20px" } }>
                    <BilboardButton
                        onClick={() => handleEnrollRequest("accepted")}
                        text="A"
                        width="60px"
                        fontSize={ 20 }
                        color="#9CCC65"
                        textColor="white"
                    />
                    <BilboardButton
                        onClick={() => handleEnrollRequest("pending")}
                        text="P"
                        width="60px"
                        fontSize={ 20 }
                        color="#4FC3F7"
                        textColor="white"
                    />
                    <BilboardButton
                        onClick={() => handleEnrollRequest("denied")}
                        text="R"
                        width="60px"
                        fontSize={ 20 }
                        color="#EF5350"
                        textColor="white"
                    />
                </Grid>
            </Grid>
        </div>
    );
};

export default RequestedMembership;
