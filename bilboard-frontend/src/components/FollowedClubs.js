import { makeStyles } from "@mui/styles";
import BilboardButton from "./BilboardButton";
import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";
import React from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import { connect } from "react-redux";
import axios from "axios";
import Env from "../utils/Env";


const useStyles = makeStyles( {
    root: {
        minHeight: "100px",
        borderRadius: "10px",
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
    },
    clubLogo: {
        marginTop: "10px",
        marginLeft: "20px",
        height: "80px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
    },
} );

const FollowedClubs = ( props ) => {
    const [ isLeaveAlertOpen, setIsLeaveAlertOpen ] = React.useState( false );
    const [isDialogOpen, setIsDialogOpen] = React.useState(true);
    const [error, setError] = React.useState("")
    function handleLeaveMembershipDialog() {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }
        axios.delete(process.env.REACT_APP_URL + "club/member?memberId=" + props.membership.id, { headers: headers })
            .then(function (response) {
                if (response.data.operationResult === "SUCCESS") {
                    console.log(response.data)
                    setIsDialogOpen(false);
                }
                else {
                    setError("Leaving Club is failed!");
                }
            })
            .catch(function (error) { setError("Something went wrong!") })
    }
    const handleLeaveMembership = () => {
        setIsLeaveAlertOpen( true );
    };

    const handleCloseAlert = () => {
        setIsLeaveAlertOpen( false );
    };

    const classes = useStyles();
    return (
        <div
            className={ classes.root }
            style={ { maxWidth: "100%", marginTop: "20px" } }
        >
            <Grid container>
                <Grid item xs={ 4 }>
                    <div
                        className={ classes.clubLogo }
                        style={ { 
                          backgroundImage: `url(${ process.env.REACT_APP_IMAGE_URL + props.club.photo })`,
                          width:"100px",
                          height:"100px"
                        } }
                    />
                </Grid>
                <Grid
                    item
                    xs={ 2 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginTop: "10px",
                        fontWeight: "bold",
                    } }
                >
                    { "Club Name:  " + props.club.name.toUpperCase() + "(" + props.club.shortName.toUpperCase() + ")"}
                </Grid>
                <Grid
                    item
                    xs={ 3 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginTop: "10px",
                    } }
                >
                    <BilboardButton onClick={ () => {
                        props.setCurrentScreen( "clubScreen" )
                        props.goToClubPage()
                    } } text="Go To Club Page" width={ "10vw" }/>
                </Grid>
                <Grid
                    item
                    xs={ 3 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginTop: "10px",
                    } }
                >
                    <BilboardButton
                        text="Leave Membership"
                        width={ "10vw" }
                        color={ Colors.BILBOARD_RED }
                        onClick={ () => handleLeaveMembership() }
                    />
                </Grid>
            </Grid>
            <Dialog open={ isLeaveAlertOpen } onClose={ handleCloseAlert }>
                <DialogTitle>{ "Leave Membership" }</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        Are you sure to leave membership of the club { props.club.name }?
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <BilboardButton  onClick={ handleCloseAlert } text="Cancel"/>
                    <BilboardButton onClick={()=>{
                      handleLeaveMembershipDialog()
                      handleCloseAlert()}}  text="Leave" autoFocus/>
                </DialogActions>
            </Dialog>
        </div>
    );
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setCurrentScreen: ( value ) =>
            dispatch( { type: "SET_CURRENT_SCREEN", currentScreen: value } ),
    };
};

export default connect( null, mapDispatchToProps )( FollowedClubs );
