import { makeStyles } from "@mui/styles";
import Colors from "../utils/Colors";
import Grid from "@mui/material/Grid";
import InputAdornment from "@mui/material/InputAdornment";
import TextField from "@mui/material/TextField";
import IconButton from "@mui/material/IconButton";
import SearchIcon from "@mui/icons-material/Search";
import Badge from "@mui/material/Badge";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import Constants from "../utils/Constants";
import AssignmentIcon from "@mui/icons-material/Assignment";
import TodayIcon from "@mui/icons-material/Today";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import BilboardButton from "./BilboardButton";
import AttendEventDialog from "./AttendEventDialog";
import clsx from "clsx";
import SettingsApplicationsIcon from "@mui/icons-material/SettingsApplications";
import { useState } from "react";
import { connect } from "react-redux";

const useStyles = makeStyles( {
    root: {
        width: "100vw",
        height: "68px",
        background: Colors.BILBOARD_MAIN,
        zIndex: "1000",
        position: "fixed",
        top: "0",
    },
    logo: {
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
        fontSize: "32px",
        display: "flex",
        alignItems: "center",
        cursor: "pointer",
        width: "80px",
        color: "white",
        height: "68px",
        paddingLeft: "30px",
        justifyContent: "start",
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
        backgroundColor: "rgba(0,0,0,0.05)",
    },
} );

const BilboardNavbar = ( {
                             currentScreen,
                             attendActive,
                             surveyCount,
                             calendarCount,
                             isAttendDialogOpen,
                             setIsAttendDialogOpen,
                             setCurrentScreen,
                             program
                         } ) => {
    const classes = useStyles();

    let clubs = new Map()

    program.clubBoardMemberships.forEach( boardMemberShip => {
        if ( clubs.get( boardMemberShip.club.id ) === null ) {
            clubs.set( boardMemberShip.club.id, boardMemberShip.club );
        }
    } )
    // todo

    const [ isCMClicked, setIsCMClicked ] = useState( false );
    return (
        <div className={ classes.root }>
            { isAttendDialogOpen && <AttendEventDialog/> }
            <Grid container>
                <Grid item xs={ 3 }>
                    <div
                        className={ classes.logo }
                        onClick={ () => setCurrentScreen( "main" ) }
                    >
                        BilBoard
                    </div>
                </Grid>
                <Grid item xs={ 4 } className={ classes.searchBar }></Grid>
                <Grid
                    item
                    xs={ 2 }
                    style={ {
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "center",
                    } }
                >
                    { attendActive && (
                        <BilboardButton
                            onClick={ () => setIsAttendDialogOpen( true ) }
                            width="160px"
                            fontSize="13px"
                            text="Attend an Event"
                            color="#00e676"
                        />
                    ) }
                </Grid>
                <Grid item xs={ 3 }>
                    <Grid container className={ classes.icons } style={ { display: "flex", alignItems: "start" } }>
                        <Grid item xs={ 3 }/>
                        <Grid item xs={ 2 }>
                            <IconButton
                                size="large"
                                onClick={ () => setCurrentScreen( "survey" ) }
                            >
                                <Badge badgeContent={ surveyCount } color="error">
                                    { currentScreen === "survey" ? (
                                        <div className={ clsx( classes.anIcon, classes.iconBg ) }>
                                            <AssignmentIcon/>
                                        </div>
                                    ) : (
                                        <div className={ classes.anIcon }>
                                            <AssignmentIcon/>
                                        </div>
                                    ) }
                                </Badge>
                            </IconButton>
                        </Grid>
                        <Grid item xs={ 2 }>
                            <IconButton
                                size="large"
                                onClick={ () => setCurrentScreen( "calendar" ) }
                            >
                                <Badge badgeContent={ calendarCount } color="error">
                                    { currentScreen === "calendar" ? (
                                        <div className={ clsx( classes.anIcon, classes.iconBg ) }>
                                            <TodayIcon/>
                                        </div>
                                    ) : (
                                        <div className={ classes.anIcon }>
                                            <TodayIcon/>
                                        </div>
                                    ) }
                                </Badge>
                            </IconButton>
                        </Grid>
                        <Grid item xs={ 2 }>
                            <IconButton size="large" onClick={ () => setCurrentScreen( "user" ) }>
                                { currentScreen === "user" ? (
                                    <div className={ clsx( classes.anIcon, classes.iconBg ) }>
                                        <AccountCircleIcon/>
                                    </div>
                                ) : (
                                    <div className={ classes.anIcon }>
                                        <AccountCircleIcon/>
                                    </div>
                                ) }
                            </IconButton>
                        </Grid>

                        <Grid item xs={ 2 }>
                            <IconButton
                                size="large"
                                onClick={ () => setIsCMClicked( !isCMClicked ) }
                            >
                                { currentScreen === "clubManagement" ? (
                                    <div className={ clsx( classes.anIcon, classes.iconBg ) }>
                                        <SettingsApplicationsIcon/>
                                    </div>
                                ) : (
                                    <div className={ classes.anIcon }>
                                        <SettingsApplicationsIcon/>
                                    </div>
                                ) }
                            </IconButton>
                            { isCMClicked && (
                                <div style={ { zIndex: "-1" } }>
                                    <Select
                                        labelId="demo-simple-select-label"
                                        id="demo-simple-select"
                                        value={ 10 }
                                        label="Clubs"
                                        onChange={ () => console.log( "aa" ) }
                                    >
                                        <MenuItem onClick={ () => {
                                            setCurrentScreen( "clubManagement" )
                                            setIsCMClicked( false )
                                        } }>Club 1</MenuItem>
                                        <MenuItem onClick={ () => {
                                            setCurrentScreen( "clubManagement" )
                                            setIsCMClicked( false )
                                        } }>Club 2</MenuItem>
                                        <MenuItem onClick={ () => {
                                            setCurrentScreen( "clubManagement" )
                                            setIsCMClicked( false )
                                        } }>Club 3</MenuItem>
                                    </Select>
                                </div>
                            ) }
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </div>
    );
};

const mapStateToProps = ( state ) => {
    return {
        isAttendDialogOpen: state.isAttendDialogOpen,
        currentScreen: state.currentScreen,
    };
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setIsAttendDialogOpen: ( value ) =>
            dispatch( {
                type: "SET_IS_ATTEND_DIALOG_OPEN",
                isAttendDialogOpen: value,
            } ),
        setCurrentScreen: ( screen ) =>
            dispatch( { type: "SET_CURRENT_SCREEN", currentScreen: screen } ),
    };
};

export default connect( mapStateToProps, mapDispatchToProps )( BilboardNavbar );
