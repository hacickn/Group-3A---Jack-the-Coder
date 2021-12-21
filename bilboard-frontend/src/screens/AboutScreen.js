import { Grid } from "@mui/material";
import React from "react";
import AboutImage from "../utils/AboutImage.png";
import { makeStyles } from "@mui/styles";
import { connect } from "react-redux";
import BilboardButton from "../components/BilboardButton";

const useStyles = makeStyles({
  root: {
    height: "100%",
    background: "#c4d5f4",
    overflow: "hidden",
  },
  bilboardText: {
    float: "left",
    marginLeft: "80px",
    marginTop: "10%",
    color: "#f0f4fd",
    fontFamily: "Oxygen, sans-serif",
    fontSize: "80px",
  },
  bilboardAltText: {
    float: "left",
    marginLeft: "80px",
    color: "#f0f4fd",
    fontFamily: "Oxygen, sans-serif",
    fontSize: "40px",
  },
  bilboardInfoText: {
    float: "left",
    marginTop: "20%",
    marginLeft: "80px",
    textAlign: "left",
    color: "#f0f4fd",
    fontFamily: "Oxygen, sans-serif",
    fontSize: "28px",
  },
  button: {
    float: "left",
    marginTop: "40px",
    marginLeft: "80px",
  },
  credits:{
    float: "left",
    marginTop: "40px",
    marginLeft: "80px",
    fontSize: "110%",
    color: "#f0f4fd",
  }
});

const AboutScreen = ({setScreenNoNavbar}) => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <Grid container>
        <Grid item xs={6}>
          <div>
            <Grid container>
              <Grid item xs={12}>
                <div className={classes.bilboardText}>BilBoard</div>
              </Grid>
              <Grid item xs={12}>
                <div className={classes.bilboardAltText}>
                  Your assistant for student clubs.
                </div>
              </Grid>
              <Grid item xs={12}>
                <div className={classes.bilboardInfoText}>
                  BilBoard helps you discovering, finding and attending all
                  events in Bilkent University.
                </div>
              </Grid>
              <Grid item xs={12}>
                <div className={classes.button}>
                  <BilboardButton
                    color="#f55c5b"
                    text="Go to BilBoard"
                    fontSize="20px"
                    width="300px"
                    fontFamily="Oxygen, sans-serif"
                    onClick={() => setScreenNoNavbar("login")}
                  />
                </div>
              </Grid>
            </Grid>
            <p className={classes.credits}>Credits: Aslı Dinç, Hacı Çakın, İlke Doğan, Metehan Saçakçı, Muhammet Abdullah Koç</p>
          </div>
        </Grid>
        <Grid item xs={6}>
          <img
            src={AboutImage}
            alt="About"
            style={{ width: "100vh", height: "100vh" }}
          />
        </Grid>
      </Grid>
    </div>
  );
};

const mapDispatchToProps = (dispatch) => {
    return{
        setScreenNoNavbar: (value) => dispatch({type: "SET_SCREEN_NO_NAVBAR", screenNoNavbar: value})
    }
}

export default connect(null, mapDispatchToProps)(AboutScreen);
