import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import EventCard from "../../../components/EventCard";

const useStyles = makeStyles({
  container: {
    maxWidth: "260px",
    maxHeight: "340px",
    marginBottom: "10px",
  },
});

const EventForGeneralPage = () => {
  const classes = useStyles();
  return (
    <div className={classes.container}>
      <Grid container>

        <Grid item xs={12} style={{paddingTop:"50px"}}>
          <EventCard
          />
          <Grid item xs={12} style={{paddingTop:"10px"}}>
            <BilboardButton
              text="Edit"
              width="75px"
              fontWeight="bold"
              fontSize={10}
              color="#2f1da3"
              textColor="white"
            />
            <BilboardButton
              text="Delete"
              width="75px"
              font-weight="bold"
              fontSize={10}
              color="#cc0a0a"
              textColor="white"
            />
            <BilboardButton
              text="Participants"
              width="75px"
              fontSize={10}
              color="#20d62c"
              textColor="white"
            />
          </Grid>
        </Grid>

      </Grid>
    </div>
  );
};

export default EventForGeneralPage;
