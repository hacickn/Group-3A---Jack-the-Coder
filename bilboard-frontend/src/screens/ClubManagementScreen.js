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

const ClubManagementScreen = ( { currentClubId, program, currentEvent, setCurrentEvent } ) => {
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
    const [ latestId, setLatestId ] = React.useState( -1 )
    const [ loading, setLoading ] = React.useState( true )
    const [ latestClub, setLatestClub ] = React.useState( null )
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
                       setLatestClub( response.data )
                       setLatestId( currentClubId )
                   } )
                   .catch( function ( error ) {
                       setLoading( false )
                       setPageError( true )
                   } )
    }


    if ( Program.getClub( currentClubId ) === undefined || latestClub === null ) {
        handleClubResponse( currentClubId )
    } else if ( Program.getClub( currentClubId ) !== undefined && loading ) {
        setLatestClub( Program.getClub( currentClubId ) )
        setLoading( false )
        setLatestId( currentClubId )
    } else {
    }
    const functionList = {
        handleNewSponsorAddition: function handleNewSponsorAddition( newResponse ) {
            let temp = { ...latestClub }
            temp.clubSponsorships.push( newResponse )
            setLatestClub( temp )
        },
        handleWpLinkUpdate: function handleWpLinkUpdate( newWpLink ) {
            let temp = { ...latestClub }
            temp.wpLink = newWpLink
            setLatestClub( temp )
        },
        handleInstaLinkUpdate: function handleInstaLinkUpdate( newInstaLink ) {
            let temp = { ...latestClub }
            temp.instaLink = newInstaLink
            setLatestClub( temp )
        },
        handleSponsorDeletion: function handleSponsorDeletion( sponsorId ) {
            let temp = { ...latestClub }
            let tempList = []

            latestClub.clubSponsorships.forEach( sponsor => {
                if ( sponsor.id !== sponsorId ) {
                    tempList.push( sponsor )
                }
            } )

            temp.clubSponsorships = tempList

            setLatestClub( temp )
        },
        handleBoardMemberAddition: function handleBoardMemberAddition( response ) {
            let temp = { ...latestClub }
            temp.clubBoardMembers.push( response )
            setLatestClub( temp )
        },
        handleBoardMemberDeletion: function handleBoardMemberDeletion( boardMemberId ) {
            let temp = { ...latestClub }
            let tempList = []

            latestClub.clubBoardMembers.forEach( member => {
                if ( member.id !== boardMemberId ) {
                    tempList.push( member )
                }
            } )

            temp.clubBoardMembers = tempList
            setLatestClub( temp )
        },
        handleFeedbackChange: function handleFeedbackChange( feedbackId, newStatus ) {
            let temp = { ...latestClub }
            let tempList = []

            latestClub.clubFeedbacks.forEach( feedback => {
                if ( feedback.id !== feedbackId ) {
                    tempList.push( feedback )
                } else {
                    let tempFeedback = { ...feedback }
                    tempFeedback.status = newStatus
                    tempList.push( tempFeedback )
                }
            } )

            temp.clubFeedbacks = tempList
            setLatestClub( temp )

        },
        handleMemberRemoval: function handleMemberRemoval( memberID ) {
            let temp = { ...latestClub }
            let tempList = []

            latestClub.clubMembers.forEach( member => {
                if ( member.id !== memberID ) {
                    tempList.push( member )
                }
            } )

            temp.clubMembers = tempList

            setLatestClub( temp )
        },
        handleEventAddition: function handleEventAddition( eventResponse ) {
            let temp = { ...latestClub }
            eventResponse.eventQuestions = []
            eventResponse.eventParticipants = []
            eventResponse.locationRequests = []

            temp.events.push( eventResponse )

            setLatestClub( temp )
        },
        handleEventRemoval: function handleEventRemoval( eventId ) {
            let temp = { ...latestClub }
            let tempList = []

            latestClub.events.forEach( event => {
                if ( event.id !== eventId ) {
                    tempList.push( event )
                }
            } )

            temp.events = tempList

            setLatestClub( temp )
        }
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
                { loading || ( latestClub === null ) ?
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
                                <ClubManagementGeneralScreen currentEvent={ currentEvent }
                                                             setCurrentEvent={ setCurrentEvent }
                                                             functionList={ functionList }
                                                             club={ latestClub }/>
                            ) : openedScreen === "Add Events" ? (
                                <ClubManagementAddEventScreen club={ latestClub } functionList={ functionList }/>
                            ) : openedScreen === "Members" ? (
                                <ClubManagementMembersScreen club={ latestClub } functionList={ functionList }/>
                            ) : openedScreen === "Membership Requests" ? (
                                <ClubManagementMembershipRequestsScreen club={ latestClub }
                                                                        functionList={ functionList }/>
                            ) : openedScreen === "Feedbacks" ? (
                                <ClubManagementFeedbackScreen club={ latestClub } functionList={ functionList }/>
                            ) : openedScreen === "Surveys" ? (
                                <ClubManagementSurveyScreen club={ latestClub } functionList={ functionList }/>
                            ) : openedScreen === "Club Hierarchy" ? (
                                <ClubManagementHierarchyScreen club={ latestClub } functionList={ functionList }/>
                            ) : openedScreen === "Sponsors" ? (
                                <ClubManagementSponsorScreen club={ latestClub } functionList={ functionList }/>
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
