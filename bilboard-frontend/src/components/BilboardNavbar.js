import {makeStyles} from "@mui/styles";
import Colors from "../utils/Colors";
import Grid from "@mui/material/Grid";
import InputAdornment from "@mui/material/InputAdornment";
import TextField from "@mui/material/TextField";
import IconButton from "@mui/material/IconButton";
import SearchIcon from "@mui/icons-material/Search";
import Badge from "@mui/material/Badge";
import Constants from "../utils/Constants";
import AssignmentIcon from "@mui/icons-material/Assignment";
import TodayIcon from "@mui/icons-material/Today";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import clsx from "clsx";
import React from "react";
import BilboardButton from "./BilboardButton";
import AttendEventDialog from "./AttendEventDialog";

const useStyles = makeStyles({
    root: {
        width: "100vw",
        height: "68px",
        background: Colors.BILBOARD_BLUE,
    },
    logo: {
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
        fontSize: "32px",
        display: "flex",
        alignItems: "center",
        color: "white",
        height: "68px",
        paddingLeft: "30px",
        justifyContent: "start",
        cursor: "pointer"
    },
    searchBar: {
        display: "flex",
        alignItems: "center",
        justifyContent: "start",
        height: "68px",
        paddingLeft: "40px",
    },
    icons: {
        display: "flex",
        alignItems: "center",
        height: "68px",
        marginTop: "2px",
    },
    anIcon: {
        color: "white",
        minWidth: "40px",
        minHeight: "40px",
        borderRadius: "50px",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
    },
    iconBg: {
        backgroundColor: "rgba(0,0,0,0.05)"
    },
});

const BilboardNavbar = (props) => {
    const classes = useStyles();
    const [isAttendDialogOpen, setIsAttendDialogOpen] = React.useState(false)
    return (
        <div className={classes.root}>
            <Grid container>
                <Grid item xs={3}>
                    <div className={classes.logo}
                         onClick={() => props.handleCurrentScreenChange("home")}>BilBoard
                    </div>
                </Grid>
                <Grid item xs={3} className={classes.searchBar}>
                    <div style={{backgroundColor: "white", borderRadius: "5px"}}>
                        <TextField
                            color="info"
                            InputProps={{
                                startAdornment: (
                                    <InputAdornment position="start">
                                        <SearchIcon/>
                                    </InputAdornment>
                                ),
                            }}
                            size="small"
                            style={{width: "420px"}}
                        />
                    </div>
                </Grid>
                <Grid item xs={2} className={classes.anIcon}>
                    <BilboardButton
                        onClick={() => setIsAttendDialogOpen(true)}
                        width="160px"
                        fontSize="13px"
                        text="Attend an Event"
                        color="#00C853"
                    />
                </Grid>
                <Grid item xs={1}/>
                <Grid item xs={3}>
                    <Grid container className={classes.icons}>
                        <Grid item xs={4}/>
                        <Grid item xs={2}>
                            <IconButton size="large" onClick={() => props.handleCurrentScreenChange("survey")}>
                                <Badge badgeContent={props.surveyCount} color="error">
                                    {props.currentScreen === "survey" ? (
                                        <div className={clsx(classes.anIcon, classes.iconBg)}>
                                            <AssignmentIcon/>
                                        </div>
                                    ) : (
                                        <div className={classes.anIcon}>
                                            <AssignmentIcon/>
                                        </div>
                                    )}
                                </Badge>
                            </IconButton>
                        </Grid>
                        <Grid item xs={2}>
                            <IconButton size="large" onClick={() => props.handleCurrentScreenChange("calendar")}>
                                <Badge badgeContent={props.calendarCount} color="error">
                                    {props.currentScreen === "calendar" ? (
                                        <div className={clsx(classes.anIcon, classes.iconBg)}>
                                            <TodayIcon/>
                                        </div>
                                    ) : (
                                        <div className={classes.anIcon}>
                                            <TodayIcon/>
                                        </div>
                                    )}
                                </Badge>
                            </IconButton>
                        </Grid>
                        <Grid item xs={2}>
                            <IconButton size="large" onClick={() => props.handleCurrentScreenChange("account")}>
                                {props.currentScreen === "account" ? (
                                    <div className={clsx(classes.anIcon, classes.iconBg)}>
                                        <AccountCircleIcon/>
                                    </div>
                                ) : (
                                    <div className={classes.anIcon}>
                                        <AccountCircleIcon/>
                                    </div>
                                )}
                            </IconButton>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
            <AttendEventDialog isOpen={isAttendDialogOpen} setOpen={(value) => setIsAttendDialogOpen(value)}/>
        </div>
    );
};

export default BilboardNavbar;
