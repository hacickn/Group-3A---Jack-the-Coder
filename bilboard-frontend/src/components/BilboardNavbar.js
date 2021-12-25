import { makeStyles } from "@mui/styles";
import Colors from "../utils/Colors";
import Grid from "@mui/material/Grid";
import IconButton from "@mui/material/IconButton";
import Badge from "@mui/material/Badge";
import MenuItem from "@mui/material/MenuItem";
import InputBase from "@mui/material/InputBase";
import Constants from "../utils/Constants";
import AssignmentIcon from "@mui/icons-material/Assignment";
import { Autocomplete } from "@mui/lab";
import TodayIcon from "@mui/icons-material/Today";
import Env from "../utils/Env";
import Select from "@mui/material/Select";
import axios from "axios";
import { CircularProgress, Snackbar, TextField } from "@mui/material";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import BilboardButton from "./BilboardButton";
import AttendEventDialog from "./AttendEventDialog";
import clsx from "clsx";
import { useState } from "react";
import { connect } from "react-redux";
import React from "react";
import { FormControl, InputLabel } from "@mui/material";
import Logo from "../utils/Logo12.png";


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
        color: "white !important",
        borderBlockColor: "white !important",
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
                             program,
                             currentClubId,
                             setCurrentClubId,
                             currentClub,
                             setCurrentClub,
                             currentEvent,
                             setCurrentEvent
                         } ) => {
    const classes = useStyles();

    const [ options, setOptions ] = React.useState( [] );
    const [ searchOpen, setSearchOpen ] = React.useState( false )
    const loading = searchOpen && options.length === 0;
    const [ searchText, setSearchText ] = React.useState( "" )

    let clubs = [];


    program.clubBoardMemberships.forEach( ( boardMemberShip ) => {
        clubs.push( boardMemberShip.club );
    } );

    if ( program.advisorOf !== null ) {
        let check = true;

        for ( let a = 0; a < clubs.length; a++ ) {
            if ( clubs[ a ].id === program.advisorOf.id ) {
                check = false;
            }
        }

        if ( check ) {
            clubs.push( program.advisorOf );
        }
    }

    if ( program.presidentOf !== null ) {
        let check = true;

        for ( let a = 0; a < clubs.length; a++ ) {
            if ( clubs[ a ].id === program.presidentOf.id ) {
                check = false;
            }
        }

        if ( check ) {
            clubs.push( program.presidentOf );
        }
    }

    React.useEffect( () => {
        let active = true;

        if ( !loading ) {
            return undefined;
        }

        ( async () => {
            const response = await fetch(
                process.env.REACT_APP_URL + "club/search?name=" + searchText,
                {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: "Bearer " + Env.TOKEN,
                    },
                }
            );

            const temp = await response.json();

            if ( active ) {
                setOptions(
                    [ ...temp ].map( ( club ) => {
                        return club;
                    } )
                );
            }
        } )();

        return () => {
            active = false;
        };
    }, [ loading ] );

    React.useEffect( () => {
        if ( !searchOpen ) {
            setOptions( [] );
        }
    }, [ searchOpen ] );

    return (
        <div className={ classes.root }>
            { isAttendDialogOpen && <AttendEventDialog/> }
            <Grid container>
                <Grid item xs={ 3 }>
                    <div
                        className={ classes.logo }
                        onClick={ () => {
                            setCurrentClubId( 0 );
                            setCurrentScreen( "main" );
                        } }
                    >
                        <img src={ Logo } style={
                            {
                                marginLeft: "20px",
                                paddingTop: "20px",
                                width: "200px",

                            } }>
                        </img>
                    </div>
                </Grid>
                <Grid item xs={ 4 } className={ classes.searchBar }>
                    <Autocomplete
                        id="club-search"
                        fullWidth
                        open={ searchOpen }
                        onOpen={ () => {
                            setSearchOpen( true );
                        } }
                        onClose={ () => {
                            setSearchOpen( false );
                        } }
                        onChange={ ( event, value, reason, details ) => {
                            setSearchText( value )
                            if ( clubs.length > 0 ) {
                                setCurrentClub( clubs[ 0 ] )
                            } else {
                                setCurrentClub( null )

                            }
                            setCurrentScreen( "clubScreen" )
                        } }
                        getOptionSelected={ ( option, value ) => {
                            return option.name === searchText.name;
                        } }
                        getOptionLabel={ ( option ) =>
                            option.name
                        }
                        options={ options }
                        loading={ loading }
                        renderInput={ ( params ) => (
                            <TextField
                                { ...params }
                                label="Search Clubs"
                                fullWidth
                                InputProps={ {
                                    ...params.InputProps,
                                    endAdornment: (
                                        <React.Fragment>
                                            { loading ? (
                                                <CircularProgress color="inherit" size={ 20 }/>
                                            ) : null }
                                            { params.InputProps.endAdornment }
                                        </React.Fragment>
                                    ),
                                } }
                            />
                        ) }
                    />
                </Grid>
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
                    <Grid
                        container
                        className={ classes.icons }
                        style={ { display: "flex", alignItems: "start" } }
                    >
                        <Grid item xs={ 2 }/>
                        <Grid item xs={ 2 }>
                            <IconButton
                                size="large"
                                onClick={ () => {
                                    setCurrentClubId( 0 );
                                    setCurrentScreen( "survey" );
                                } }
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
                                onClick={ () => {
                                    setCurrentClubId( 0 );
                                    setCurrentScreen( "calendar" );
                                } }
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
                            <IconButton
                                size="large"
                                onClick={ () => {
                                    setCurrentClubId( 0 );
                                    setCurrentScreen( "user" );
                                } }
                            >
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

                        { clubs.length > 0 ? (
                            <Grid item xs={ 3 }>
                                { " " }
                                <FormControl sx={ { m: 1, minWidth: 120 } }>
                                    <Select
                                        labelId="demo-simple-select-label"
                                        id="demo-simple-select"
                                        value={ currentClubId }
                                        displayEmpty
                                        label="CLub"
                                        onChange={ ( e ) => {
                                            setCurrentClubId( e.target.value );
                                            if ( e.target.value !== 0 ) {
                                                setCurrentScreen( "clubManagement" );
                                            } else {
                                                setCurrentScreen( "main" );
                                            }
                                        } }
                                    >
                                        <MenuItem value={ 0 }>
                                            <em>None</em>
                                        </MenuItem>
                                        { clubs.map( ( club ) => {
                                            return (
                                                <MenuItem value={ club.id }>
                                                    { club.shortName.toUpperCase() }{ " " }
                                                </MenuItem>
                                            );
                                        } ) }
                                    </Select>
                                </FormControl>
                            </Grid>
                        ) : (
                            <div></div>
                        ) }
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
