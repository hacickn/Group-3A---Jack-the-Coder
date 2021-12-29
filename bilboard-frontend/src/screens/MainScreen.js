import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import EventCard from "../components/EventCard";
import { MockData } from "../MockData";

const useStyles = makeStyles( {
    root: {
        height: "100vh",
    },
    eventsContainer: {
        display: "flex",
        alignItems: "center",
        minHeight: "340px",
        maxHeight: "340px",
        maxWidth: "100vw",
        overflowY: "hidden",
        flexWrap: "nowrap",
        justifyContent: "start",
        marginRight: "20px",
        paddingBottom: "10px",
        marginTop: "10px",
    },
    eventCard: {
        width: "20%",
        margin: "20px",
    },
} );

const MainScreen = ( { program, currentEvent, setCurrentEvent, currentClub, setCurrentClub } ) => {
    const { eventsFollowing, eventsDiscover } = MockData();
    const classes = useStyles();


    return (
        <>
            <div>
                <Grid container direction="column">
                    <Grid item xs={ 6 }>
                        <Grid container>
                            <Grid item xs={ 12 } style={ { marginBottom: "-40px" } }>
                                <p
                                    style={ {
                                        float: "left",
                                        marginLeft: "20px",
                                        fontSize: "28px",
                                        fontStyle: "italic",
                                    } }
                                >
                                    Events of Following Clubs { program.followingClubsEvents.length === 0 &&
                                "(Please follow some" +
                                " clubs first!)" }
                                </p>
                            </Grid>
                            <Grid item xs={ 12 }>
                                <div className={ classes.eventsContainer }>
                                    { program.followingClubsEvents.map( ( event ) => {
                                        if(event.visible){
                                            return (
                                                <div className={ classes.eventCard }>
                                                    <EventCard
                                                        currentEvent={ currentEvent }
                                                        setCurrentEvent={ setCurrentEvent }
                                                        event={ event }
                                                    />
                                                </div>
                                            );
                                        }
                                    } ) }
                                </div>
                            </Grid>
                        </Grid>
                    </Grid>
                    <Grid item xs={ 6 }>
                        <Grid container>
                            <Grid item xs={ 12 } style={ { marginBottom: "-40px" } }>
                                <p
                                    style={ {
                                        float: "left",
                                        marginLeft: "20px",
                                        fontSize: "28px",
                                        fontStyle: "italic",
                                    } }
                                >
                                    Discover
                                </p>
                            </Grid>
                            <Grid item xs={ 12 }>
                                <div className={ classes.eventsContainer }>
                                    { program.discover.map( ( event ) => {
                                        if(event.visible){
                                            return (
                                                <div className={ classes.eventCard }>
                                                    <EventCard
                                                        currentEvent={ currentEvent }
                                                        setCurrentEvent={ setCurrentEvent }
                                                        event={ event }
                                                    />
                                                </div>
                                            );
                                        }
                                    } ) }
                                </div>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </div>
        </>
    );
};

export default MainScreen;
