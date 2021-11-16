import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import FollowedClubs from "../components/FollowedClubs";
import BilboardTextField from "../components/BilboardTextField";
import Constants from "../utils/Constants";
import BilboardButton from "../components/BilboardButton";
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";

const useStyles = makeStyles({
  root: {
    height: "calc(100vh-68px)",
  },
  userImage: {
    width: "200px",
    height: "200px",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
    borderRadius: "100px"
  },
});

const UserScreen = (props) => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <Grid container>
        <Grid item xs={4}>
          <Grid container direction="column">
            <Grid item xs={4} style={{paddingTop: "40px",paddingBottom:"30px", display: "flex", justifyContent: "center", alignItems: "center"}}>
              <div
                className={classes.userImage}
                style={{ backgroundImage: `url(${props.image})`}}
              ></div>
            </Grid>
            <Grid item xs={8}>
              <Grid container>
                <Grid
                  item
                  xs={12}
                  style={{
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                    fontSize: "24px",
                  }}
                >
                  Change Password
                </Grid>
                <Grid
                  item
                  xs={12}
                  style={{ marginBottom: "10px", marginTop: "10px" }}
                >
                  <BilboardTextField label="Current Password"/>
                </Grid>
                <Grid item xs={12} style={{ marginBottom: "10px" }}>
                  <BilboardTextField label="New Password" />
                </Grid>
                <Grid item xs={12} style={{ marginBottom: "10px" }}>
                  <BilboardTextField label="Retype New Password"/>
                </Grid>
                <Grid item xs={12} style={{ marginBottom: "30px" }}>
                  <BilboardButton text="change" />
                </Grid>
                <Grid item xs={12}>
                  <Grid container>
                    <Grid
                      item
                      xs={6}
                      style={{ display: "flex", justifyContent: "end" }}
                    >
                      <FormGroup>
                        <FormControlLabel
                          control={<Checkbox />}
                          label="GE250/1"
                        />
                      </FormGroup>
                    </Grid>
                    <Grid item xs={1}></Grid>
                    <Grid
                      item
                      xs={5}
                      style={{ display: "flex", justifyContent: "start" }}
                    >
                      <BilboardButton text="update" />
                    </Grid>
                  </Grid>
                </Grid>
                <Grid item xs={12} style={{ marginTop: "30px" }}>
                  <BilboardButton text="Sign Out" width="80px"  fontSize="14px"/>
                </Grid>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={8}>
          <Grid container>
            <Grid item xs={12}>
              <p
                style={{
                  fontFamily: Constants.OXYGEN_FONT_FAMILY,
                  fontSize: "32px",
                  float: "left",
                }}
              >
                Followed Clubs
              </p>
            </Grid>
            <Grid item xs={12}>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
              <FollowedClubs  image="https://picsum.photos/200"/>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

export default UserScreen;
