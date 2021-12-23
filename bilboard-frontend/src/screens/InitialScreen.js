import Colors from "../utils/Colors";
import { makeStyles } from "@mui/styles";
import ButtonGroup from "@mui/material/ButtonGroup";
import { useState, useEffect } from "react";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import Grid from "@mui/material/Grid";
import Login from "./Login";
import Register from "./Register";
import { connect } from "react-redux";

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
    height: "600px",
    margin: "auto",
    border: "5px solid #EEEEEE",
    borderRadius: "10px",
    backgroundColor: "#F5F5F5",
  },
});

const LoginRegister = ({setScreenNoNavbar}) => {
  const [loginOrRegister, setLoginOrRegister] = useState(true);
  const [isAlertOpen, setIsAlertOpen] = useState(false);

  useEffect(() => {
    if (isAlertOpen) {
      setTimeout(() => {
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
                color: Colors.BILBOARD_LIGHT_GREY,
                fontSize: "44px",
                marginBottom: "30px",
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                letterSpacing: "4px",
              }}
            >
              BilBoard
            </p>
            <ButtonGroup
              variant="contained"
              color="primary"
              style={{ height: "40px", borderRadius: "10px" }}
            >
              <Button
                style={{
                  background: Colors.BILBOARD_MAIN,
                  width: "160px",
                  borderRadius: "10px 0px 0px 10px",
                }}
                onClick={() => setLoginOrRegister(true)}
              >
                Login
              </Button>
              <Button
                style={{
                  background: Colors.BILBOARD_MAIN,
                  width: "160px",
                  borderRadius: "0px 10px 10px 0px",
                }}
                onClick={() => setLoginOrRegister(false)}
              >
                Register
              </Button>
            </ButtonGroup>
          </Grid>
        </Grid>
        {loginOrRegister ? <Login /> : <Register />}
        <div style={{ marginTop: "20px" }}>
          <Button variant="text" color="inherit" onClick={()=> setScreenNoNavbar("about")}>About Bilboard</Button>
        </div>
      </div>
    </div>
  );
};

const mapDispatchToProps = (dispatch) => {
    return{
        setScreenNoNavbar: (value) => dispatch({type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value})
    }
}

export default connect(null, mapDispatchToProps)(LoginRegister);
