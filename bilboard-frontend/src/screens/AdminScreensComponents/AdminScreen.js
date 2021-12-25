import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import React from "react";
import Constants from "../../utils/Constants";
import { Card, Snackbar } from "@mui/material";
import AdminAddClubScreen from "./AdminAddClubScreen";
import AdminManageClubScreen from "./AdminManageClubScreen";
import Env from "../../utils/Env";
import axios from "axios";
import Alert from "@mui/material/Alert";
import IconButton from "@mui/material/IconButton";
import LogoutIcon from "@mui/icons-material/Logout";
import { makeStyles } from "@mui/styles";
import { connect } from "react-redux";


const useStyles = makeStyles( {
    root: {
        width: "100%",
    },
    navbar: {
        height: "68px",
        background: Colors.BILBOARD_MAIN,
    },
    navbarText: {
        fontSize: "40px",
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
        color: "white",
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
} );

const AdminScreen = ( props ) => {
    const pages = [
        "Add Club",
        "Manage Clubs",
    ];
    const classes = useStyles();

    const [ openedScreen, setOpenedScreen ] = React.useState( "Add Club" );
    const [ loading, setLoading ] = React.useState( true )
    const [ success, setSuccess ] = React.useState( "" )
    const [ error, setError ] = React.useState( "" )
    const [ clubs, setClubs ] = React.useState( null )
    const handleLogOut = () => {
        props.signOut()
        props.setScreenNoNavbar( "login" )
    };

    async function getClubs() {
        setLoading( true )
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        axios.get( process.env.REACT_APP_URL + 'admin/clubs', { headers: headers } )
             .then( function ( response ) {
                 if ( response.status === 200 ) {
                     console.log( response.data )
                     setClubs( response.data )
                     setLoading( false )
                 } else {
                     setError( "Clubs could not fetched!" )
                     setLoading( false )
                     setClubs( [] )
                 }
             } )
             .catch( function ( error ) {
                 setError( "Clubs could not fetched!" )
                 setLoading( false )
                 setClubs( [] )
             } )
    }

    function setClub( advisor, president, clubId ) {
        let temp = []
        clubs.forEach( club => {
            if ( clubId !== club.id ) {
                temp.push( club )
            } else {
                let tempClub = { ...club }
                tempClub.president = president
                tempClub.advisor = advisor
                temp.push( tempClub )
            }
        } )

        setClub( temp )
    }

    function addNewClub( clubResponse ) {
        let temp = [ ...clubs ]

        temp.push( clubResponse )
        setClubs( temp )
    }

    return (
        <div>
            <div className={ classes.navbar }>
                <Grid container>
                    <Grid item xs={ 4 }/>
                    <Grid
                        item
                        xs={ 4 }
                        style={ {
                            display: "flex",
                            justifyContent: "center",
                            alignItems: "center",
                        } }
                    >
                        <div className={ classes.navbarText }>Admin</div>
                    </Grid>
                    <Grid item xs={ 2 }/>
                    <Grid
                        item
                        xs={ 2 }
                        style={ {
                            display: "flex",
                            justifyContent: "center",
                            alignItems: "center",
                        } }
                    >
                        <IconButton size="large" onClick={ () => handleLogOut() }>
                            <LogoutIcon className={ classes.anIcon }/>
                        </IconButton>
                    </Grid>
                </Grid>
            </div>

            <Grid container style={ { padding: 20, height: "88vh" } }>
                <Grid
                    style={ {
                        height: "85vh",
                        borderRadius: Constants.BORDER_RADIUS,
                        padding: 4,
                    } }
                    item
                    xs={ 3 }
                >
                    <Card elevation={ 4 } style={ { borderRadius: Constants.BORDER_RADIUS } }>
                        { pages.map( ( page ) => (
                            <Grid
                                item
                                xs={ 12 }
                                style={ {
                                    paddingTop: 5,
                                    paddingBottom: 5,
                                } }
                            >
                                { openedScreen === page ? (
                                    <BilboardButton
                                        text={ page }
                                        fontSize={ 16 }
                                        width="23vw"
                                        height={ "4vh" }
                                        color={ Colors.BILBOARD_MAIN }
                                        textColor={ Colors.WHITE }
                                    />
                                ) : (
                                    <BilboardButton
                                        text={ page }
                                        fontSize={ 16 }
                                        width="23vw"
                                        height={ "4vh" }
                                        color={ Colors.WHITE }
                                        textColor={ Colors.BILBOARD_MAIN }
                                        onClick={ () => setOpenedScreen( page ) }
                                    />
                                ) }
                            </Grid>
                        ) ) }
                    </Card>
                </Grid>
                <Grid item xs={ 9 } style={ { padding: 4 } }>
                    <Card
                        elevation={ 4 }
                        style={ { borderRadius: Constants.BORDER_RADIUS, height: "85vh" } }
                    >
                        { openedScreen === "Add Club" ? (
                            <AdminAddClubScreen addClub={ ( clubResponse ) => addNewClub( clubResponse ) }/>
                        ) : openedScreen === "Manage Clubs" ? (
                            <AdminManageClubScreen
                                setClub={ ( advisor, president, clubId ) => setClub( advisor, president, clubId ) }
                                allClubs={ clubs }
                                getClubs={ () => getClubs() }
                                clubLoading={ loading }
                            />
                        ) : (
                            <div/>
                        ) }
                    </Card>
                </Grid>
            </Grid>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ error !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setError( '' ) }
            >
                <Alert onClose={ () => setError( '' ) }
                       severity={ "warning" }
                >
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ success !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setSuccess( '' ) }
            >
                <Alert onClose={ () => setSuccess( '' ) }
                       severity={ "success" }
                >
                    { success }
                </Alert>
            </Snackbar>
        </div>
    );
};


const mapDispatchToProps = ( dispatch ) => {
    return {
        setScreenNoNavbar: ( value ) => dispatch( { type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value } )
    }
}

export default connect( null, mapDispatchToProps )( AdminScreen );

