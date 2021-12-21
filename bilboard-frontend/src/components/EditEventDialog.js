import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import React, { useState } from "react";
import { connect } from "react-redux";
import BilboardTextField from "./BilboardTextField";
import { Checkbox } from "@mui/material";
import { Radio } from "@mui/material";
import { FormControlLabel } from "@mui/material";
import Colors from "../utils/Colors";
import { ImageOutlined } from "@mui/icons-material";
import { IconButton } from "@mui/material";
import { RadioGroup } from "@mui/material";
import { FormGroup } from "@mui/material";

/**
 * Ask Question Dialog
 *
 * Date: 21.12.2021
 * Metehan Saçakçı
 * İlke Doğan
 */
import { makeStyles } from "@mui/styles";

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

const EditEventDialog = () => {
    const classes = useStyles();
    const [isOnline, setIsOnline] = React.useState("online");
    const [isForMember, setIsForMember] = React.useState(false);
    const [isDialogOpen, setIsDialogOpen] = useState(true);

    return (
        <Dialog open={isDialogOpen} fullWidth maxWidth={"lg"}
            onClose={() => setIsDialogOpen(false)}>
            <DialogContent>
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
                                    fontSize: 48,
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    display: "flex",
                                    justifyContent: "center",
                                    marginBottom: "20px"
                                }}
                            >
                                Edit Event
                            </Grid>
                            <Grid container>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Title
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <BilboardTextField width={"500px"} />
                                    </Grid>
                                </Grid>
                                
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Description
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <BilboardMultilineTextField width={"500px"} rows={5} />
                                    </Grid>
                                </Grid>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Date
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <BilboardTextField type={"datetime-local"} width={"500px"} />
                                    </Grid>
                                </Grid>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Location
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <Grid container>
                                            <RadioGroup
                                                row
                                                aria-label="type"
                                                value={isOnline}
                                                onChange={(event) => setIsOnline(event.target.value)}
                                                name="radio-buttons-group"
                                            >
                                                <FormControlLabel
                                                    value="faceToFace"
                                                    control={<Radio />}
                                                    label="Face to Face"
                                                />
                                                <FormControlLabel
                                                    value="online"
                                                    control={<Radio />}
                                                    label="Online"
                                                />
                                            </RadioGroup>
                                        </Grid>
                                    </Grid>
                                    <Grid item xs={5} className={classes.textGrid}></Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        {isOnline === "online" ? (
                                            <div>
                                                <BilboardTextField
                                                    width={"500px"}
                                                    label={"Enter Zoom Link"}
                                                />
                                                <FormGroup>
                                                    <FormControlLabel
                                                        control={<Checkbox />}
                                                        label="List Now"
                                                    />
                                                </FormGroup>
                                            </div>
                                        ) : (
                                            <BilboardButton text={"Choose timeslots"} width={"200px"} />
                                        )}
                                    </Grid>
                                </Grid>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Number of Participant
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <BilboardTextField type={"number"} width={"100px"} />
                                    </Grid>
                                </Grid>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Ge 250/1 Point
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <BilboardTextField type={"number"} width={"100px"} />
                                    </Grid>
                                </Grid>
                                <Grid container className={classes.rowGrid}>
                                    <Grid item xs={5} className={classes.textGrid}>
                                        Private for Members
                                    </Grid>
                                    <Grid item xs={7} className={classes.inputGrid}>
                                        <Radio
                                        //checked={isForMember}
                                        //onClick={() => setIsForMember(!isForMember)}
                                        />
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
                                    <BilboardButton fontSize={"14px"} text={"Edit"} width={"200px"} />
                                </Grid>
                            </Grid>
                        </Grid>
                    </Grid>

                    <Grid item xs={3}></Grid>
                </Grid>

            </DialogContent>
            <DialogActions>
                <Button

                    style={{
                        display: "flex",
                        justifyContent: "center"
                    }}
                >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}

export default EditEventDialog