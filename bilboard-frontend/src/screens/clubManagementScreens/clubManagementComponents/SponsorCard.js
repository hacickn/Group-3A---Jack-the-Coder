import Constants from "../../../utils/Constants";
import Colors from "../../../utils/Colors";
import { Grid } from "@mui/material";
import { DeleteOutline } from "@mui/icons-material";
import IconButton from "@mui/material/IconButton";
import axios from "axios";
import React from "react";
import Env from "../../../utils/Env";

const SponsorCard = ( { sponsor } ) => {
    const [isDialogOpen, setIsDialogOpen] = React.useState(true);
    const [error, setError] = React.useState("")
    function sponsorDelete() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }
        axios.delete(process.env.REACT_APP_URL + "club/sponsorship?sponsorshipId=" + sponsor.id, { headers: headers })
            .then(function (response) {
                if (response.data.operationResult === "SUCCESS") {
                    console.log(response.data)
                    setIsDialogOpen(false);
                }
                else {
                    setError("Deleting Sponsor is failed!");
                }
            })
            .catch(function (error) { setError("Something went wrong!") })
    }
    function returnTypePhoto( type ) {
        switch ( type ) {
            case "GOLD":

                return "https://www.pngall.com/wp-content/uploads/8/Gold-Sponsor-Transparent.png"
            case "SILVER":

                return "https://www.pngall.com/wp-content/uploads/8/Silver-Sponsor-PNG-Image.png"

            default:

                return "https://www.pngall.com/wp-content/uploads/8/Gold-Sponsor-PNG-Clipart.png"

        }
    }

    return ( <Grid container
                   style={ {
                       width: "70vw",
                       marginBottom: 5,
                       marginTop: 5,
                       paddingTop: 20,
                       paddingBottom: 20,
                       borderRadius: Constants.BORDER_RADIUS,
                       background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                       alignItems: "center",
                   } }>
        <Grid item xs>
            <img
                src={ process.env.REACT_APP_IMAGE_URL + sponsor.photo }
                style={ { maxHeight: 50, maxWidth: 60 } }
            />
        </Grid>
        <Grid item xs>
            { sponsor.name }
        </Grid>
        <Grid item xs>
            { sponsor.amount }
        </Grid>
        <Grid item xs>
            <img
                src={ returnTypePhoto( sponsor.type ) }
                style={ { maxHeight: 50, maxWidth: 60 } }
            />
        </Grid>
        <Grid item xs>
            <IconButton onClick={ () => sponsorDelete() }>
                <DeleteOutline style={ { color: Colors.BILBOARD_RED } }/>
            </IconButton>
        </Grid>
    </Grid> )
}

export default SponsorCard