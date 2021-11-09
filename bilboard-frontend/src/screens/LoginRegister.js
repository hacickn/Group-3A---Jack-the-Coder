import BilboardButton from "../components/BilboardButton";
import Colors from "../utils/Colors";
import { makeStyles } from "@mui/styles";
import ButtonGroup from "@mui/material/ButtonGroup";
import { useState } from "react";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";

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
              />
            </Grid>
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
