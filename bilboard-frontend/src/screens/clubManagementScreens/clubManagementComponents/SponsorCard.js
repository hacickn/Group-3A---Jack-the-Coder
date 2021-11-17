import Constants from "../../../utils/Constants";
import Colors from "../../../utils/Colors";
import {Grid} from "@mui/material";
import React from "react";
import {DeleteOutline} from "@mui/icons-material";
import IconButton from "@mui/material/IconButton";

const SponsorCard = (props)=>{

    return (<Grid container
                  style={{
                      width:"70vw",
                      marginBottom: 5,
                      marginTop: 5,
                      paddingTop: 20,
                      paddingBottom: 20,
                      borderRadius: Constants.BORDER_RADIUS,
                      background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                      alignItems: "center",
                  }}>
        <Grid item xs>
            <img
                src={props.sponsor.photo}
                style={{maxHeight: 50, maxWidth: 60}}
            />
        </Grid>
        <Grid item xs>
            {props.sponsor.name}
        </Grid>
        <Grid item xs>
            {props.sponsor.amount}
        </Grid>
        <Grid item xs>
            <img
                src={props.sponsor.type}
                style={{maxHeight: 50, maxWidth: 60}}
            />
        </Grid>
        <Grid item xs>
            <IconButton>
                <DeleteOutline style={{color:Colors.BILBOARD_RED}}/>
            </IconButton>
        </Grid>
    </Grid>)
}

export default SponsorCard