import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import FollowedClubs from "../components/FollowedClubs";
import BilboardTextField from "../components/BilboardTextField";
import Constants from "../utils/Constants";
import BilboardButton from "../components/BilboardButton";
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Colors from "../utils/Colors";
import Button from "@mui/material/Button";
import { Edit } from "@mui/icons-material";
import { Card, CircularProgress, Snackbar, Switch } from "@mui/material";
import { connect } from "react-redux";
import React from "react";
import Env from "../utils/Env";
import axios from "axios";
import Alert from "@mui/material/Alert";

const useStyles = makeStyles({
    root: {
        height: "calc(100vh-68px)",
    },
    userImage: {
        width: "300px",
        height: "300px",
        backgroundSize: "300px 300px",
        backgroundRepeat: "no-repeat",
        borderRadius: "100px",
    },
});

const UserScreen = ({
    setScreenNoNavbar,
    currentEvent,
    setCurrentEvent,
    signOut,
    program,
    currentClub,
    setCurrentClub
}) => {
    const [geStatus, setGeStatus] = React.useState(null);
    const [submitted, setSubmitted] = React.useState(false);
    const [name, setName] = React.useState(null);
    const [surname, setSurname] = React.useState(null);
    const [id, setId] = React.useState(null);
    const [error, setError] = React.useState("");
    const [success, setSuccess] = React.useState("");
    const [photo,setPhoto] = React.useState(null)

    if (geStatus == null && program.geTaken !== geStatus) {
        setGeStatus(program.geTaken);
    }

    if (name == null && program.name !== name) {
        setName(program.name);
    }

    if (surname == null && program.surname !== surname) {
        setSurname(program.surname);
    }

    if (id == null && program.bilkentId !== id) {
        setId(program.bilkentId);
    }

    if (photo == null || process.env.REACT_APP_IMAGE_URL + program.photo !== photo) {
        setPhoto(process.env.REACT_APP_IMAGE_URL + program.photo);
    }

    let totalGe = 0

    program.eventParticipants.forEach(participant=>{
        if(participant.attended){
            totalGe = totalGe + participant.event.gePoint
        }
    })

    function handleGeStatusChange(status) {
        let headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + Env.TOKEN,
        };

        setSubmitted(true);
        axios
            .post(
                process.env.REACT_APP_URL +
                "user/changeGeStatus?userId=" +
                program.id +
                "&geStatus=" +
                status,
                {},
                { headers: headers }
            )
            .then(function (response) {
                if (response.status === 200) {
                    setSubmitted(false);
                    setSuccess("GE250/1 is updated!");
                } else {
                    setSubmitted(false);
                    setGeStatus(!status);
                    setSuccess("GE250/1 is NOT updated!");
                }
            })
            .catch(function (error) {
                setSuccess("GE250/1 is NOT updated!");
                setSubmitted(false);
                setGeStatus(!status);
            });
    }

    function handleNameSurnameChange() {
        let headers = {
            "Content-Type": "application/json",
            Authorization: "Bearer " + Env.TOKEN,
        };

        axios
            .post(
                process.env.REACT_APP_URL +
                "user/changeNameSurname?userId=1&name=" +
                name +
                "&surname=" +
                surname,
                {},
                { headers: headers }
            )
            .then(function (response) {
                if (response.status === 200) {
                    setSubmitted(false);
                    setSuccess("Name and surname is updated!");
                } else {
                    setSubmitted(false);
                    setError("Name and surname is NOT updated!");
                }
            })
            .catch(function (error) {
                setError("Name and surname is NOT updated!");
                setSubmitted(false);
            });
    }

    function goToClubPage() {
        setScreenNoNavbar("clubScreen")
    }

    const classes = useStyles();
    return (
        <div className={classes.root}>
            <Grid container>
                <input
                    style={{ display: "none" }}
                    className={classes.input}
                    accept="image/*"
                    id="contained-button-file"
                    type="file"
                    onChange={(event) => {
                        const formData = new FormData();
                        let type
                        Array.from(event.target.files)
                            .forEach((file, index) => {
                                formData.append("photo", file, file.name);
                                 type = file.type.split("/")[1]
                            });

                        formData.append("userId", program.id);

                        const headers = {
                            Authorization: "Bearer " + Env.TOKEN,
                        };

                        fetch(process.env.REACT_APP_URL + "user/changePhoto", {
                            method: "POST",
                            headers: headers,
                            body: formData,
                        })
                            .then((response) => response.json())
                            .then((data) => {
                                //console.log(data.message)
                            })
                            .then(() => {
                                setPhoto(process.env.REACT_APP_IMAGE_URL + "users/default.png")
                                program.photo = "users/" + program.id + "." + type
                                setSuccess(
                                    "Image uploaded successfully! Please refresh the page!"
                                );
                            })
                            .catch(() => {
                                setError("Something went wrong!");
                            });
                    }}
                />
                <Grid item xs={4}>
                    <Card
                        elevation={3}
                        style={{
                            borderRadius: Constants.BORDER_RADIUS,
                            padding: "20px",
                            margin: "40px",
                            marginLeft: "100px",
                            marginRight: "80px",
                        }}
                    >
                        <Grid container direction="column">
                            <Grid
                                item
                                xs={4}
                                style={{
                                    paddingTop: "40px",
                                    paddingBottom: "30px",
                                    display: "flex",
                                    justifyContent: "center",
                                    alignItems: "center",
                                }}
                            >
                                <Grid container>
                                    <Grid item xs={12} style={{ display: "flex", justifyContent: "center" }}>
                                        <div
                                            className={classes.userImage}
                                            style={{
                                                backgroundImage: `url(${photo })`,
                                            }}
                                        />
                                    </Grid>
                                    <Grid item xs={12} style={{ display: "flex", justifyContent: "center" }}>
                                        <label htmlFor="contained-button-file">
                                            <Button component="span" style={{ marginLeft: -20 }}>
                                                <Edit />
                                            </Button>
                                        </label>
                                    </Grid>
                                </Grid>
                            </Grid>
                            <Grid item xs={8}>
                                <Grid container>
                                    <Grid
                                        item
                                        xs={12}
                                        style={{
                                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                            fontSize: "24px",
                                            fontStyle: "italic",
                                        }}
                                    >
                                        My Profile
                                    </Grid>
                                    <Grid
                                        item
                                        xs={12}
                                        style={{ marginBottom: "10px", marginTop: "10px" }}
                                    >
                                        <BilboardTextField
                                            label="Name"
                                            value={name}
                                            onChange={(e) => setName(e.target.value)}
                                            width={"280px"}
                                        />
                                    </Grid>
                                    <Grid item xs={12} style={{ marginBottom: "10px" }}>
                                        <BilboardTextField
                                            label="Surname"
                                            value={surname}
                                            onChange={(e) => setSurname(e.target.value)}
                                            width={"280px"}
                                        />
                                    </Grid>
                                    <Grid item xs={12} style={{ marginBottom: "10px" }}>
                                        <BilboardTextField
                                            label="Id"
                                            value={id}
                                            disabled
                                            width={"280px"}
                                        />
                                    </Grid>

                                    <Grid item xs={12} style={{ marginBottom: "10px" }}>
                                        <BilboardButton
                                            onClick={() => {
                                                if (
                                                    name.trim().length > 0 &&
                                                    surname.trim().length > 0
                                                ) {
                                                    handleNameSurnameChange();
                                                } else {
                                                    setError("Name or surname can NOT be empty!");
                                                }
                                            }}
                                            text="Update"
                                            width={"160px"}
                                            fontSize={"12px"}
                                        />
                                    </Grid>
                                    <Grid
                                        item
                                        xs={12}
                                        style={{
                                            marginBottom: "10px",
                                            display: "flex",
                                            justifyContent: "center",
                                        }}
                                    >
                                        {program.type === "student" && <FormGroup>
                                            <FormControlLabel
                                                control={
                                                    <Switch
                                                        checked={geStatus}
                                                        onChange={() => {
                                                            const newStatus = !geStatus;
                                                            setGeStatus(newStatus);
                                                            handleGeStatusChange(newStatus);
                                                        }}
                                                    />
                                                }
                                                label="GE250/1"
                                            />
                                        </FormGroup>}
                                    </Grid>
                                    <Grid
                                        item
                                        xs={12}
                                        style={{
                                            marginBottom: "10px",
                                            display: "flex",
                                            justifyContent: "center",
                                        }}
                                    >
                                        {program.type === "student" && geStatus && <div>
                                            Total Ge Point :  { totalGe }
                                        </div> }
                                    </Grid>
                                    <Grid
                                        item
                                        xs={12}
                                        style={{
                                            marginBottom: "10px",
                                            display: "flex",
                                            minHeight: 60,
                                            justifyContent: "center",
                                        }}
                                    >
                                        {submitted ? <CircularProgress /> : <div />}
                                    </Grid>
                                    <Grid item xs={12} style={{ marginTop: "10px" }}>
                                        <BilboardButton
                                            color={Colors.BILBOARD_RED}
                                            text="Sign Out"
                                            width="160px"
                                            fontSize="12px"
                                            onClick={() => {
                                                signOut();
                                                setScreenNoNavbar("login");
                                            }}
                                        />
                                    </Grid>
                                </Grid>
                            </Grid>
                        </Grid>
                    </Card>
                </Grid>
                <Grid item xs={8}>
                    <Card
                        elevation={3}
                        style={{
                            borderRadius: Constants.BORDER_RADIUS,
                            padding: "20px",
                            marginRight: "20px",
                            marginTop: "40px",
                        }}
                    >
                        <Grid container style={{ maxHeight: "75vh", overflowX: "scroll" }}>
                            <Grid item xs={12}>
                                <p
                                    style={{
                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                        fontSize: "32px",
                                        float: "left",
                                        fontStyle: "italic",
                                    }}
                                >
                                    Club Memberships
                                    {program.clubMemberShips.length === 0 &&
                                        " (You do not have any" + " membership)"}
                                </p>
                            </Grid>
                            <Grid item xs={12}>
                                {program.clubMemberShips.map((membership) => {
                                    return <FollowedClubs
                                        goToClubPage={() => {
                                            setCurrentClub(membership.club)

                                        }}
                                        club={membership.club}
                                        membership={membership}
                                    />;
                                })}
                            </Grid>
                        </Grid>
                    </Card>
                </Grid>
            </Grid>
            <Snackbar
                anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
                open={error !== ""}
                autoHideDuration={2000}
                onClose={() => setError("")}
            >
                <Alert onClose={() => setError("")} severity={"warning"}>
                    {error}
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
                open={success !== ""}
                autoHideDuration={2000}
                onClose={() => setSuccess("")}
            >
                <Alert onClose={() => setSuccess("")} severity={"success"}>
                    {success}
                </Alert>
            </Snackbar>
        </div>
    );
};

const mapDispatchToProps = (dispatch) => {
    return {
        setScreenNoNavbar: (value) =>
            dispatch({ type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value }),
    };
};

export default connect(null, mapDispatchToProps)(UserScreen);
