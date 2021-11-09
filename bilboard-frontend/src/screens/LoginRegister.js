import BilboardButton from "../components/BilboardButton";
import Colors from "../utils/Colors";
import { makeStyles } from "@mui/styles";
import ButtonGroup from "@mui/material/ButtonGroup";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";

const useStyles = makeStyles({
  root: {
    backgroundColor: Colors.BILBOARD_BLACK,
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
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <div className={classes.container}>
        <Grid container>
          <Grid item xs={12}>
            <p
              style={{
                color: Colors.BILBOARD_RED,
                fontSize: "44px",
                fontWeight: "lighter",
                marginBottom: "30px",
              }}
            >
              Welcome To Bilboard!
            </p>
            <ButtonGroup
              variant="contained"
              color="error"
              style={{ height: "48px" }}
            >
              <Button
                style={{ background: Colors.BILBOARD_RED, width: "200px" }}
              >
                Login
              </Button>
              <Button
                style={{ background: Colors.BILBOARD_RED, width: "200px" }}
              >
                Register
              </Button>
            </ButtonGroup>
          </Grid>
        </Grid>

        <BilboardButton text="Login" />
      </div>
    </div>
  );
};

export default LoginRegister;
