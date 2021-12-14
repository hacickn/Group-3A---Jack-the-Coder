import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";
import React from "react";
import { TextField } from "@mui/material";
import Constants from "../../utils/Constants";

const AdminManageClubScreen = ({ clubs }) => {
  const [currentClub, setCurrentClub] = React.useState(null);
  return (
    <div>
      <Grid container>
        <Grid item xs={4}>
          <div style={{ maxHeight: "800px", overflowY: "scroll" }}>
            {clubs.map((club, index) => (
              <div
                key={index}
                style={{
                  fontFamily: Constants.OXYGEN_FONT_FAMILY,
                  fontSize: "20px",
                  marginTop: "10px",
                  marginBottom: "10px",
                }}
              >
                <BilboardButton
                  fontSize="20px"
                  width="80%"
                  text={club.name}
                  onClick={() => setCurrentClub(club)}
                />
              </div>
            ))}
          </div>
        </Grid>
        <Grid item xs={8} style={{ display: "flex", justifyContent: "center" }}>
          <div>
            {!currentClub && (
              <div
                style={{
                  fontSize: "40px",
                  fontFamily: Constants.OXYGEN_FONT_FAMILY,
                }}
              >
                Please select a club to manage.
              </div>
            )}
            {currentClub && (
              <Grid container>
                <Grid item xs={12} style={{ marginTop: "40px" }}>
                  <Grid container>
                    <Grid item xs={6}>
                      <div
                        style={{
                          marginTop: "12px",
                          fontFamily: Constants.OXYGEN_FONT_FAMILY,
                          fontSize: "24px",
                          fontWeight: "bolder",
                        }}
                      >
                        Club Advisor:
                      </div>
                    </Grid>
                    <Grid item xs={4}>
                      <TextField fullWidth placeholder={currentClub.advisor} />
                    </Grid>
                  </Grid>
                </Grid>

                <Grid item xs={12} style={{ marginTop: "40px" }}>
                  <Grid container>
                    <Grid item xs={6}>
                      <div
                        style={{
                          marginTop: "12px",
                          fontFamily: Constants.OXYGEN_FONT_FAMILY,
                          fontSize: "24px",
                          fontWeight: "bolder",
                        }}
                      >
                        Club President:
                      </div>
                    </Grid>
                    <Grid item xs={4}>
                      <TextField
                        fullWidth
                        placeholder={currentClub.president}
                      />
                    </Grid>
                  </Grid>
                </Grid>

                <Grid item xs={12} style={{marginTop: "60px"}}>
                  <BilboardButton text="Save" width="100px" fontSize="16px" />
                </Grid>
              </Grid>
            )}
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default AdminManageClubScreen;
