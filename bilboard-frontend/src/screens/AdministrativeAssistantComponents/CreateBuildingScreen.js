import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardButton from "../../components/BilboardButton";
import Constants from "../../utils/Constants";
import React from "react";
import axios from "axios";
import Env from "../../utils/Env";

const CreateBuildingScreen = () => {
    const [building, setBuilding] = React.useState("");

    const handleBuilding = (e) => {
        setBuilding(e.target.value);
    }

    const handleAddButton = () => {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': "Bearer " + Env.TOKEN,
          };

        axios.post(process.env.REACT_APP_URL + 'reservation/building', {
            "name": building,
            "university": 1
        }, {headers: headers})
        .then(function(response) {
            console.log(response);
        })
        .catch( function(error) {
            console.log(error);
        })
    }
    return <div style={{height: "70vh",display: "flex", alignItems: "center"}}>
        <Grid container>
            <Grid item xs={12} style={{display: "flex", justifyContent: "center", marginBottom: "20px"}}>
                <div style={{fontFamily: Constants.OXYGEN_FONT_FAMILY, fontSize: "28px"}}>Please Enter Building Name:</div>
            </Grid>
            <Grid item xs={12} style={{display: "flex", justifyContent: "center", marginBottom: "20px"}}>
                <BilboardTextField value={building} onChange={(e) => setBuilding(e.target.value)} label="Building Name" width="300px"/>
            </Grid>
            <Grid item xs={12} style={{display: "flex", justifyContent: "center", marginBottom: "20px"}}>
                <BilboardButton onClick={handleAddButton} text="Add" fontSize="16px" width="100px"/>
            </Grid>
        </Grid>
    </div>

}

export default CreateBuildingScreen;