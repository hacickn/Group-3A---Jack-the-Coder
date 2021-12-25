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

const CalendarScreen = ( props ) => {
    const classes = useStyles();
    let pastEvents = []
    let futureEvents = []

    props.program.eventParticipants.forEach( eventParticipant => {
        if ( new Date( eventParticipant.event.date ) > new Date( Date.now() ) ) {
            futureEvents.push( eventParticipant.event )
        } else {
            pastEvents.push( eventParticipant.event )
        }
    } )

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
                                    Future Events { futureEvents.length === 0 && "(There is no future event for you!)" }
                                </p>
                            </Grid>
                            <Grid item xs={ 12 }>
                                <div className={ classes.eventsContainer }>
                                    { futureEvents.map( ( event ) => {
                                        return (
                                            <div className={ classes.eventCard }>
                                                <EventCard event={ event }/>
                                            </div>
                                        );
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
                                    Past Events { pastEvents.length === 0 && "(There is no past event for you!)" }
                                </p>
                            </Grid>
                            <Grid item xs={ 12 }>
                                <div className={ classes.eventsContainer }>
                                    { pastEvents.map( ( event ) => {
                                        return (
                                            <div className={ classes.eventCard }>
                                                <EventCard event={ event }/>
                                            </div>
                                        );
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

export default CalendarScreen;
