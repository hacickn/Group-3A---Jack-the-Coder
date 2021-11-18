import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import EventCard from "../components/EventCard";
import { MockData } from "../MockData";

const useStyles = makeStyles({
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
});

const CalendarScreen = () => {
  const {eventsFuture, eventsPast} = MockData();
  const classes = useStyles();
  return (
    <>
      <div>
        <Grid container direction="column">
          <Grid item xs={6}>
            <Grid container>
              <Grid item xs={12} style={{ marginBottom: "-40px" }}>
                <p
                  style={{
                    float: "left",
                    marginLeft: "20px",
                    fontSize: "28px",
                  }}
                >
                  Future Events
                </p>
              </Grid>
              <Grid item xs={12}>
                <div className={classes.eventsContainer}>
                  {eventsFuture.map((event) => {
                    return (
                      <div className={classes.eventCard}>
                        <EventCard key={event.id} title={event.title} image={event.image} location={event.location} club={event.club} participantCount={event.participantCount} />
                      </div>
                    );
                  })}
                </div>
              </Grid>
            </Grid>
          </Grid>
          <Grid item xs={6}>
            <Grid container>
              <Grid item xs={12} style={{ marginBottom: "-40px" }}>
                <p
                  style={{
                    float: "left",
                    marginLeft: "20px",
                    fontSize: "28px",
                  }}
                >
                  Past Events
                </p>
              </Grid>
              <Grid item xs={12}>
                <div className={classes.eventsContainer}>
                {eventsPast.map((event) => {
                    return (
                      <div className={classes.eventCard}>
                        <EventCard key={event.id} title={event.title} image={event.image} location={event.location} club={event.club} participantCount={event.participantCount} />
                      </div>
                    );
                  })}
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
