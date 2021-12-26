import React from "react";
import Grid from "@mui/material/Grid";
import Constants from "../utils/Constants";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import axios from "axios";
import { useParams } from "react-router-dom";
import { CircularProgress } from "@mui/material";
import { Snackbar } from "@mui/material";
import Alert from "@mui/material/Alert";

export default function ResetPasswordScreen() {
  const [newPassword, setNewPassword] = React.useState("");
  const [confirmPassword, setConfirmPassword] = React.useState("");
  const [arePasswordsEqual, setArePasswordsEqual] = React.useState(false);
  const [ submitted, setSubmitted ] = React.useState( false )
  const [confirmed, setConfirmed] = React.useState(false);
  const [error, setError] = React.useState("");
  const [success, setSuccess] = React.useState("");

  let {resetCode} = useParams();

  React.useEffect(() => {
    if (newPassword === confirmPassword) {
      setArePasswordsEqual(true);
    } else {
      setArePasswordsEqual(false);
    }
  }, [newPassword, confirmPassword]);

  const handleResetPassword = () => {
    setSubmitted(true)
    axios.post(process.env.REACT_APP_URL + 'auth/resetPassword', {
      "newPassword": newPassword,
      "token": resetCode
      }
    )
      .then(function(response) {
        if(response.data.operationResult === "SUCCESS")
        {
          setSubmitted(false);
          setConfirmed(true);
          setSuccess("Password is changed successfully");
        }
        else
        {
          setError("Password could not be changed");
        }
        
      })
      .catch(function(error) {
        setSubmitted(false);
        setError("Password could not be changed");
      })
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
          {submitted? <CircularProgress/> : confirmed? <a href="/" style={{textDecoration: "none"}}><BilboardButton text="Go to login" fontSize="16px" width="200px"/></a> : <BilboardButton text="Reset" fontSize="16px" width="200px" onClick={()=> handleResetPassword()}/>}
        </Grid>
      </Grid>
      <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ error !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setError( '' ) }
            >
                <Alert onClose={ () => setError( '' ) }
                       severity={ "warning" }
                >
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ success !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setSuccess( '' ) }
            >
                <Alert onClose={ () => setSuccess( '' ) }
                       severity={ "success" }
                >
                    { success }
                </Alert>
            </Snackbar>
    </div>
  );
}
