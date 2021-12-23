import React from "react";
import Grid from "@mui/material/Grid";
import Constants from "../utils/Constants";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";

export default function ResetPasswordScreen() {
  const [newPassword, setNewPassword] = React.useState("");
  const [confirmPassword, setConfirmPassword] = React.useState("");
  const [arePasswordsEqual, setArePasswordsEqual] = React.useState(false);

  React.useEffect(() => {
    if (newPassword === confirmPassword) {
      setArePasswordsEqual(true);
    } else {
      setArePasswordsEqual(false);
    }
  }, [newPassword, confirmPassword]);

  const handleResetPassword = () => {
    console.log(newPassword)
  }

  return (
    <div
      style={{
        height: "80vh",
        width: "100%",
        display: "flex",
        alignItems: "center",
      }}
    >
      <Grid container>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginTop: "60px",
          }}
        >
          <div
            style={{
              fontSize: "32px",
              fontWeight: "bold",
              fontFamily: Constants.OXYGEN_FONT_FAMILY,
            }}
          >
            Reset Password
          </div>
        </Grid>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginTop: "40px",
          }}
        >
          <BilboardTextField
            label="New Password"
            onChange={(e) => setNewPassword(e.target.value)}
            type="password"
            value={newPassword}
            width="300px"
            style={{ marginTop: "30px" }}
          />
        </Grid>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginTop: "20px",
          }}
        >
          <BilboardTextField
            label="Confirm Password"
            type="password"
            onChange={(e) => setConfirmPassword(e.target.value)}
            value={confirmPassword}
            width="300px"
            style={{ marginTop: "30px" }}
          />
        </Grid>
        {(!arePasswordsEqual && confirmPassword.length !== 0) ? (
          <Grid
            item
            xs={12}
            style={{
              display: "flex",
              justifyContent: "center",
              marginTop: "20px",
            }}
          >
            <div
              style={{
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: "16px",
                color: "red",
              }}
            >
              Passwords do not match.
            </div>
          </Grid>
        ) : 
        (<Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginTop: "40px",
          }}
        ></Grid>)}
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginTop: "40px",
          }}
        >
          <BilboardButton text="Reset" fontSize="16px" width="200px" onClick={()=> handleResetPassword()}/>
        </Grid>
      </Grid>
    </div>
  );
}
