import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";
import BilboardButton from "../components/BilboardButton";
import React from "react";
import Constants from "../utils/Constants";
import ClubManagementGeneralScreen from "./clubManagementScreens/ClubManagementGeneralScreen";
import ClubManagementAddEventScreen from "./clubManagementScreens/ClubManagementAddEventScreen";
import ClubManagementSponsorScreen from "./clubManagementScreens/ClubManagementSponsorScreen";
import ClubManagementHierarchyScreen from "./clubManagementScreens/ClubManagementHierarchyScreen";
import ClubManagementSurveyScreen from "./clubManagementScreens/ClubManagementSurveyScreen";
import ClubManagementFeedbackScreen from "./clubManagementScreens/ClubManagementFeedbackScreen";
import ClubManagementMembersScreen from "./clubManagementScreens/ClubManagementMembersScreen";
import ClubManagementMembershipRequestsScreen from "./clubManagementScreens/ClubManagementMembershipRequestsScreen";
import { Card, CircularProgress } from "@mui/material";
import Env from "../utils/Env";
import axios from "axios";
import Program from "../utils/Program";

const ClubManagementScreen = ( { currentClubId, program } ) => {
    const pages = [
        "General",
        "Add Events",
        "Members",
        "Membership Requests",
        "Feedbacks",
        "Surveys",
        "Club Hierarchy",
        "Sponsors",
    ];
    const [ openedScreen, setOpenedScreen ] = React.useState( "General" );
    const [ loading, setLoading ] = React.useState( true )
    const [ pageError, setPageError ] = React.useState( false )

    async function handleClubResponse( clubId ) {
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        await axios.get( process.env.REACT_APP_URL + "club?clubId=" + clubId, { headers } )
                   .then( function ( response ) {

                       Program.addClub( response.data, clubId )
                       setLoading( false )
                       setPageError( false )
                   } )
                   .catch( function ( error ) {
                       setLoading( false )
                       setPageError( true )
                   } )
    }

    if ( Program.getClub( currentClubId ) === undefined ) {
        handleClubResponse( currentClubId )
    } else if ( Program.getClub( currentClubId ) !== null && loading ) {
        console.log( Program.getClub( currentClubId ) )
        setLoading( false )
    } else {
        console.log( Program.getClub( currentClubId ) )
    }

    return (
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
                                    width="21vw"
                                    height={ "9.36vh" }
                                    color={ Colors.BILBOARD_MAIN }
                                    textColor={ Colors.WHITE }
                                />
                            ) : (
                                <BilboardButton
                                    text={ page }
                                    fontSize={ 16 }
                                    width="21vw"
                                    height={ "9.36vh" }
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
                { loading ?
                    <CircularProgress/> :
                    pageError ?
                        <div> Error </div> :
                        <Card
                            elevation={ 4 }
                            style={ {
                                borderRadius: Constants.BORDER_RADIUS,
                                height: "85vh",
                                overflowY: "scroll",
                            } }
                        >
                            { openedScreen === "General" ? (
                                <ClubManagementGeneralScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Add Events" ? (
                                <ClubManagementAddEventScreen/>
                            ) : openedScreen === "Members" ? (
                                <ClubManagementMembersScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Membership Requests" ? (
                                <ClubManagementMembershipRequestsScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Feedbacks" ? (
                                <ClubManagementFeedbackScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Surveys" ? (
                                <ClubManagementSurveyScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Club Hierarchy" ? (
                                <ClubManagementHierarchyScreen club={ Program.getClub( currentClubId ) }/>
                            ) : openedScreen === "Sponsors" ? (
                                <ClubManagementSponsorScreen club={ Program.getClub( currentClubId ) }/>
                            ) : (
                                <div/>
                            ) }
                        </Card>
                }
            </Grid>
        </Grid>
    );
};

export default ClubManagementScreen;
