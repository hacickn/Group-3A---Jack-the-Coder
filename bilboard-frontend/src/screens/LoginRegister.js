import BilboardButton from "../components/BilboardButton";
import Colors from "../utils/Colors";
import { makeStyles } from "@mui/styles";
import ButtonGroup from "@mui/material/ButtonGroup";
import { useState, useEffect } from "react";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import TextField from "@mui/material/TextField";
import Alert from "@mui/material/Alert";

const useStyles = makeStyles({
  root: {
    backgroundColor: Colors.WHITE,
    height: "100vh",
    width: "100vw",
    display: "flex",
    alignItems: "center",
  },
  container: {
    width: "34%",
    height: "80%",
    margin: "auto",
    border: "1px solid white",
  },
});

const LoginRegister = () => {
  const [loginOrRegister, setLoginOrRegister] = useState(true);
  const [isDialogOpen, setIsDialogOpen] = useState(false);
  const [isAlertOpen, setIsAlertOpen] = useState(false);

  useEffect(()=>{
    if(isAlertOpen){
      setTimeout(()=>{
        setIsAlertOpen(false);
      }, 3000);
    }
  }, [isAlertOpen]);

  const classes = useStyles();
  return (
    <div className={classes.root}>
      <div className={classes.container}>
        <Grid container>
          <Grid item xs={12}>
            <p
              style={{
                color: Colors.BILBOARD_BLUE,
                fontSize: "44px",
                fontWeight: "lighter",
                marginBottom: "30px",
              }}
            >
              Welcome to Bilboard!
            </p>
            <ButtonGroup
              variant="contained"
              color="primary"
              style={{ height: "40px", borderRadius: "10px" }}
            >
              <Button
                style={{
                  background: Colors.BILBOARD_BLUE,
                  width: "200px",
                  borderRadius: "10px 0px 0px 10px",
                }}
                onClick={() => setLoginOrRegister(true)}
              >
                Login
              </Button>
              <Button
                style={{
                  background: Colors.BILBOARD_BLUE,
                  width: "200px",
                  borderRadius: "0px 10px 10px 0px",
                }}
                onClick={() => setLoginOrRegister(false)}
              >
                Register
              </Button>
            </ButtonGroup>
          </Grid>
        </Grid>
        {loginOrRegister ? (
          <div>
            <Grid container>
              <Grid item xs={12} style={{ marginTop: "60px" }}>
                <BilboardTextField
                  label="Bilkent Mail"
                  type="email"
                  width="300px"
                  style={{ marginTop: "30px" }}
                ></BilboardTextField>
              </Grid>
              <Grid item xs={12} style={{ marginTop: "20px" }}>
                <BilboardTextField
                  label="Password"
                  type="password"
                  width="300px"
                  style={{ marginTop: "30px" }}
                />
              </Grid>
            </Grid>

            <Grid item xs={12} style={{ marginTop: "40px" }}>
              <BilboardButton width="100px" fontSize="14px" text="Login" />
            </Grid>

            <Grid item xs={12} style={{ marginTop: "30px" }}>
              <BilboardButton
                text="Forgot Password?"
                variant="text"
                color="white"
                textColor={Colors.BILBOARD_BLUE}
                onClick={() => setIsDialogOpen(true)}
              />
            </Grid>
            <Dialog open={isDialogOpen} onClose={() => setIsDialogOpen(false)}>
              <DialogTitle>Forgot Password</DialogTitle>
              <DialogContent>
                <DialogContentText style={{ textAlign: "justify" }}>
                  To reset your password, please enter your Bilkent mail and
                  click "Reset Password" button.
                </DialogContentText>
                <TextField
                  autoFocus
                  margin="dense"
                  id="name"
                  label="Email Address"
                  type="email"
                  fullWidth
                  variant="standard"
                />
              </DialogContent>
              <DialogActions>
                <Button onClick={() => setIsDialogOpen(false)}>Cancel</Button>
                <Button
                  onClick={() => {
                    setIsDialogOpen(false);
                    setIsAlertOpen(true);
                  }}
                >
                  Reset Password
                </Button>
              </DialogActions>
            </Dialog>
            {isAlertOpen && <Alert severity="info">If you provided a valid info, a mail was sent to your email.</Alert>}
          </div>
        ) : (
          <div>
            <Grid container>
              <Grid item xs={12} style={{ marginTop: "40px" }}>
                <BilboardTextField
                  label="Name"
                  type="name"
                  width="300px"
                  style={{ marginTop: "30px" }}
                ></BilboardTextField>
              </Grid>
              <Grid item xs={12} style={{ marginTop: "20px" }}>
                <BilboardTextField
                  label="Surname"
                  type="surname"
                  width="300px"
                  style={{ marginTop: "30px" }}
                />
              </Grid>
              <Grid item xs={12} style={{ marginTop: "20px" }}>
                <BilboardTextField
                  label="Bilkent Mail"
                  type="email"
                  width="300px"
                  style={{ marginTop: "30px" }}
                />
              </Grid>
              <Grid item xs={12} style={{ marginTop: "20px" }}>
                <BilboardTextField
                  label="Password"
                  type="password"
                  width="300px"
                  style={{ marginTop: "30px" }}
                />
              </Grid>
              <Grid item xs={12} style={{ marginTop: "20px" }}>
                <BilboardTextField
                  label="ID"
                  type="number"
                  width="300px"
                  style={{ marginTop: "30px" }}
                />
              </Grid>
            </Grid>

            <Grid item xs={12} style={{ marginTop: "40px" }}>
              <BilboardButton width="100px" fontSize="14px" text="Register" />
            </Grid>
          </div>
        )}
      </div>
    </div>
  );
};

export default LoginRegister;
