import {
    FormControlLabel,
    Grid,
    IconButton,
    Radio,
    RadioGroup,
} from "@mui/material";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardMultilineTextField from "../../components/BilboardMultilineTextField";
import BilboardButton from "../../components/BilboardButton";
import Colors from "../../utils/Colors";
import Checkbox from "@mui/material/Checkbox";
import Constants from "../../utils/Constants";
import { ImageOutlined } from "@mui/icons-material";
import { FormGroup } from "@mui/material";
import { makeStyles } from "@mui/styles";
import React from "react";

const useStyles = makeStyles({
    textGrid: {
        display: "flex",
        justifyContent: "end",
        paddingRight: "20px",
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
    },
    inputGrid: {
        display: "flex",
        justifyContent: "start",
    },
    rowGrid: {
        paddingTop: "10px",
    },
});

const ClubManagementHierarchyScreen = () => {
    const classes = useStyles();
    const [isOnline, setIsOnline] = React.useState("online");
    const [isForMember, setIsForMember] = React.useState(false);
    return (
        <Grid
            container
            style={{
                paddingTop: 20,
            }}
        >
            <Grid item xs={3}></Grid>
            <Grid item xs={6}>
                <Grid container>
                    <Grid
                        item
                        xs={12}
                        style={{
                            padding: 20,
                            fontSize: 48,
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        }}
                    >
                        Add Event
                    </Grid>

                    <Grid container>
                        <Grid container className={classes.rowGrid}>
                            <Grid item xs={5} className={classes.textGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                President
                            </Grid>
                            <Grid item xs={7} className={classes.inputGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,

                                }}>
                                Yaaaas
                            </Grid>
                        </Grid>
                        <Grid container>
                            <Grid container className={classes.rowGrid}>
                                <Grid item xs={5} className={classes.textGrid}  style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                    Board members
                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid}  style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                }}>
                                    Yaaaas
                                </Grid>
                            </Grid>
                            <Grid container className={classes.rowGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                <Grid item xs={5} className={classes.textGrid}>
                                    Add Board Member
                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid}>
                                    <BilboardTextField type={"number"} width={"200px"} />
                                </Grid>
                            </Grid>
                            <Grid container className={classes.rowGrid}>
                                <Grid item xs={5} className={classes.textGrid}>

                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid}>
                                    <BilboardTextField type={"number"} width={"200px"} />
                                </Grid>
                            </Grid>
                            <Grid
                                container
                                style={{
                                    display: "flex",
                                    justifyContent: "center",
                                    paddingTop: "20px",
                                }}
                            >
                                <BilboardButton fontSize={"14px"} text={"Add"} width={"200px"} />
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
            <Grid item xs={3}></Grid>
        </Grid>
    );
};

export default ClubManagementHierarchyScreen;
