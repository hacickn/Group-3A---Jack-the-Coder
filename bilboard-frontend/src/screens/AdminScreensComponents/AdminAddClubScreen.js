import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import React from "react";
import { TextField } from "@mui/material";
import Constants from "../../utils/Constants";

const AdminAddClubScreen = (props) => {
  const [clubName, setClubName] = React.useState("");
  const [clubShortName, setClubShortName] = React.useState("");
  return (
    <div>
      <Grid container >
      <Grid item xs={12} style={{marginTop: "60px"}}></Grid>
        <Grid item xs={12}>
          <Grid container>
            <Grid item xs={2} />
            <Grid item xs={4}>
              <div
                style={{
                  marginTop: "12px",
                  fontFamily: Constants.OXYGEN_FONT_FAMILY,
                  fontSize: "24px",
                  fontWeight: "bolder",
                }}
              >
                Club Name:
              </div>
            </Grid>
            <Grid item xs={3}>
              <TextField
                fullWidth
                onChange={(e) => setClubName(e.target.value)}
              />
            </Grid>
            <Grid item xs={3} />
          </Grid>
        </Grid>
        <Grid item xs={12} style={{marginTop: "60px"}}></Grid>
        <Grid item xs={12}>
          <Grid container>
            <Grid item xs={2} />
            <Grid item xs={4}>
              <div
                style={{
                  marginTop: "12px",
                  fontFamily: Constants.OXYGEN_FONT_FAMILY,
                  fontSize: "24px",
                  fontWeight: "bolder",
                }}
              >
                Club Short Name:
              </div>
            </Grid>
            <Grid item xs={3}>
              <TextField
                fullWidth
                onChange={(e) => setClubShortName(e.target.value)}
              />
            </Grid>
            <Grid item xs={3} />
          </Grid>
        </Grid>
        <Grid item xs={12} style={{marginTop: "60px"}}></Grid>
        <Grid item xs={12}>
          <BilboardButton text="Submit" width="100px" fontSize="16px" />
        </Grid>
      </Grid>
    </div>
  );
};

export default AdminAddClubScreen;
