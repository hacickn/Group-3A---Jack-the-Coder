import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import BilboardNavbar from "../components/BilboardNavbar";
import EventCard from "../components/EventCard";

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
    marginTop: "10px"
  },
  eventCard: {
    width: "20%",
    margin: "20px",
  },
});

const CalendarScreen = () => {
  const classes = useStyles();
  return (
    <>
      <BilboardNavbar currentScreen="calendar" attendActive/>
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
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
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
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  <div className={classes.eventCard}>
                    <EventCard />
                  </div>
                  
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
