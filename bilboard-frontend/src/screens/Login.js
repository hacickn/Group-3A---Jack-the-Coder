import React, { useState } from "react";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import Colors from "../utils/Colors";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import TextField from "@mui/material/TextField";
import DialogActions from "@mui/material/DialogActions";
import Button from "@mui/material/Button";
import Alert from "@mui/material/Alert";
import { connect } from "react-redux";
import axios from "axios";
import Env from "../utils/Env";
import { Snackbar } from "@mui/material";


const Login = ({ setScreenNoNavbar, setProgram, setFailed }) => {
    const [isDialogOpen, setIsDialogOpen] = useState(false);
    const [isAlertOpen, setIsAlertOpen] = useState(false);
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [submitted, setSubmitted] = useState(false)
    const [error, setError] = useState("")
    const [emailForget, setEmailForget] = useState("");

    function handleResetPasswordRequest() {
        axios.post(process.env.REACT_APP_URL + "auth/resetPasswordRequest?email=" + emailForget, {})
            .then(function (response) {
                if (response.data.operationResult === "SUCCESS") {
                    setIsDialogOpen(false);
                    setIsAlertOpen(true);
                }
                else
                {
                    setError("This email not exists!");
                }
            })
            .catch(function (error) { setError("Something went wrong!") })
    }

    async function handleLoginRequest() {
        setSubmitted(true)
        axios.post(process.env.REACT_APP_URL + 'auth/signIn', {
            "email": email,
            "password": password
        })
            .then(function (response) {
                if (response.status === 200) {
                    Env.PUBLIC_ID = response.data.id
                    Env.TOKEN = response.data.token
                    localStorage.setItem("token", response.data.token)
                    localStorage.setItem("publicId", response.data.id)

                    setSubmitted(false)
                    setFailed(false)
                    setScreenNoNavbar("main")
                } else {
                    setError("Email or password is wrong!")
                }
            })
            .catch(function (error) {
                setError("Email or password is wrong!")
                setSubmitted(false)
            })
    }

    const handleKeyDown = (event) => {
        if (event.key === 'Enter') {
            if (password.trim().length < 6) {
                setError("Password can not shorter than 6 characters!")
            } else if (!email.includes("bilkent")) {
                setError("Please enter a valid bilkent email adress!")
            } else {
                handleLoginRequest()
            }
        }
      }

    return (
        <div onKeyDown={handleKeyDown}>
            <Grid container>
                <Grid item xs={12} style={{ marginTop: "60px" }}>
                    <BilboardTextField
                        label="Bilkent Mail"
                        onChange={(e) => setEmail(e.target.value)}
                        type="email"
                        value={email}
                        width="300px"
                        style={{ marginTop: "30px" }}
                    />
                </Grid>
                <Grid item xs={12} style={{ marginTop: "20px" }}>
                    <BilboardTextField
                        label="Password"
                        type="password"
                        onChange={(e) => setPassword(e.target.value)}
                        value={password}
                        width="300px"
                        style={{ marginTop: "30px" }}
                    />
                </Grid>
            </Grid>

            <Grid item xs={12} style={{ marginTop: "40px" }}>
                <BilboardButton width="100px" fontSize="14px" text="Login" onClick={() => {
                    if (password.trim().length < 6) {
                        setError("Password can not shorter than 6 characters!")
                    } else if (!email.includes("bilkent")) {
                        setError("Please enter a valid bilkent email adress!")
                    } else {
                        handleLoginRequest()
                    }
                }} />
            </Grid>

            <Grid item xs={12} style={{ marginTop: "30px" }}>
                <BilboardButton
                    text="Forgot Password?"
                    variant="text"
                    color="#F5F5F5"
                    textColor={Colors.BILBOARD_MAIN}
                    onClick={() => setIsDialogOpen(true)}
                />
            </Grid>
            <Dialog open={isDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
                <DialogTitle style={{ display: "flex", justifyContent: "center" }}>Forgot Password</DialogTitle>
                <DialogContent>
                    <DialogContentText style={{ textAlign: "justify" }}>
                        To reset your password, please enter your Bilkent mail and
                        click "Reset Password" button.
                    </DialogContentText>
                    <TextField
                        autoFocus
                        value={emailForget} onChange={(e) => setEmailForget(e.target.value)}
                        margin="dense"
                        id="name"
                        label="Email Address"
                        type="email"
                        fullWidth
                        variant="standard"
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={() => setIsDialogOpen(false)}>Cancel</Button>
                    <Button
                        onClick={() => {
                            if (emailForget.trim().length === 0) {
                                setError("Email cannot be empty")
                            }
                            else {
                                handleResetPasswordRequest()
                            }
                        }}
                    >
                        Reset Password
                    </Button>
                </DialogActions>
            </Dialog>
            {
                isAlertOpen &&
                <Alert severity="info">If you provided a valid info, a mail was sent to your email.</Alert>
            }
            <Snackbar
                anchorOrigin={{ vertical: "bottom", horizontal: "center", }}
                open={error !== ''}
                autoHideDuration={5000}
                onClose={() => setError('')}
            >
                <Alert onClose={() => setError('')}
                    severity={"warning"}
                >
                    {error}
                </Alert>
            </Snackbar>
        </div>
    )

}

const mapDispatchToProps = (dispatch) => {
    return {
        setScreenNoNavbar: (value) => dispatch({ type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value })
    }
}

export default connect(null, mapDispatchToProps)(Login);