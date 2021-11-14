import React from "react";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import {useState} from "react";

const Register = () => {
    const [name, setName] = useState("");
    const [surname, setSurname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [ID, setID] = useState("");
    return (
        <div>
            <Grid container>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Name"
                        type="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Surname"
                        type="surname"
                        value={surname}
                        onChange={(e) => setSurname(e.target.value)}
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Bilkent Mail"
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="Password"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
                <Grid item xs={12} style={{marginTop: "20px"}}>
                    <BilboardTextField
                        label="ID"
                        type="number"
                        value={ID}
                        onChange={(e) => setID(e.target.value)}
                        width="300px"
                        style={{marginTop: "30px"}}
                    />
                </Grid>
            </Grid>

            <Grid item xs={12} style={{marginTop: "40px"}}>
                <BilboardButton width="100px" fontSize="14px" text="Register" />
            </Grid>
        </div>
    )
}

export default Register;