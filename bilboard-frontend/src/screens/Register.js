import React from "react";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";

const Register = () => {
    return (
        <div>
            <Grid container>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Name"
                        type="name"
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Surname"
                        type="surname"
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Bilkent Mail"
                        type="email"
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Password"
                        type="password"
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="ID"
                        type="number"
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
            </Grid>

            <Grid item xs={12} style={{marginTop: "40px"}}>
                <BilboardButton width="100px" fontSize="14px" text="Register"/>
            </Grid>
        </div>
    )
}

export default Register;