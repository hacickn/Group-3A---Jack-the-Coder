import Colors from "../utils/Colors";
import {makeStyles} from "@mui/styles";
import ButtonGroup from "@mui/material/ButtonGroup";
import {useState, useEffect} from "react";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import Grid from "@mui/material/Grid";
import Login from "./Login";
import Register from "./Register";

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
        backgroundColor: "#F5F5F5"
    },
});

const LoginRegister = () => {
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
                                color: "#616161",
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px"
                            }}
                        >
                            BilBoard
                        </p>
                        <ButtonGroup
                            variant="contained"
                            color="primary"
                            style={{height: "40px", borderRadius: "10px"}}
                        >
                            <Button
                                style={{
                                    background: Colors.BILBOARD_BLUE,
                                    width: "160px",
                                    borderRadius: "10px 0px 0px 10px",
                                }}
                                onClick={() => setLoginOrRegister(true)}
                            >
                                Login
                            </Button>
                            <Button
                                style={{
                                    background: Colors.BILBOARD_BLUE,
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
                {
                    loginOrRegister
                        ?
                        <Login/>
                        :
                        <Register/>
                }
            </div>
        </div>
    );
};

export default LoginRegister;
