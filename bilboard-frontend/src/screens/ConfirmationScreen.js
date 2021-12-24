import React from "react";
import BilboardButton from "../components/BilboardButton";
import Grid from "@mui/material/Grid";
import Constants from "../utils/Constants";
import Colors from "../utils/Colors";

export default function ConfirmationScreen() {
  const handleOnClick = () => {
      
  };
  return (
    <div style={{ height: "88vh", display: "flex", alignItems: "center" }}>
      <Grid
        container
        style={{
          margin: "20%",
          padding: "80px 60px 80px 60px",
          border: "5px solid",
          borderRadius: "20px",
          borderColor: Colors.BILBOARD_LIGHT_GREY,
        }}
      >
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginBottom: "40px",
          }}
        >
          <div
            style={{
              fontSize: "32px",
              fontWeight: "bolder",
              fontFamily: Constants.OXYGEN_FONT_FAMILY,
            }}
          >
            Your account is successfully confirmed. Enjoy BilBoard!
          </div>
        </Grid>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <BilboardButton
            text="Login"
            color="#F44336"
            fontSize="20px"
            width="200px"
            onClick={() => handleOnClick()}
          />
        </Grid>
      </Grid>
    </div>
  );
}
