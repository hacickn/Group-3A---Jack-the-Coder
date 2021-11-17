import { makeStyles } from "@mui/styles";
import BilboardButton from "./BilboardButton";
import Grid from "@mui/material/Grid";

const useStyles = makeStyles({
  root: {
    minHeight: "100px",
    borderRadius: "10px",
    background: "#E0F2F1",
  },
  clubLogo: {
    width: "300px",
    marginTop: "10px",
    marginLeft: "20px",
    height: "80px",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
  },
});

const FollowedClubs = (props) => {
  const classes = useStyles();
  return (
    <div
      className={classes.root}
      style={{ maxWidth:"95%", marginTop: "30px" }}
    >
      <Grid container>
        <Grid item xs={6}>
          <div
            className={classes.clubLogo}
            style={{ backgroundImage: `url(${props.image})` }}
          ></div>
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "10px"
          }}
        >
          <BilboardButton text="Go To Club Page" />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: "10px"
          }}
        >
          <BilboardButton text="Leave Membership"/>
        </Grid>
      </Grid>
    </div>
  );
};

export default FollowedClubs;
