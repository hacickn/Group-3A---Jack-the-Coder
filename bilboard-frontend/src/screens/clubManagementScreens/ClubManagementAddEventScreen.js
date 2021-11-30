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
import { makeStyles } from "@mui/styles";
import FormGroup from "@mui/material/FormGroup";
import Constants from "../../utils/Constants";
import { ImageAspectRatio, ImageOutlined } from "@mui/icons-material";
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

const ClubManagementAddEventScreen = () => {
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
              <Grid item xs={5} className={classes.textGrid}>
                Title
              </Grid>
              <Grid item xs={7} className={classes.inputGrid}>
                <BilboardTextField width={"500px"} />
              </Grid>
            </Grid>
            <Grid container className={classes.rowGrid}>
              <Grid item xs={5} className={classes.textGrid}>
                Image
              </Grid>
              <Grid item xs={7} className={classes.inputGrid}>
                <IconButton>
                  <ImageOutlined style={{ color: Colors.BILBOARD_MAIN }} />
                </IconButton>
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
                  checked={isForMember}
                  onClick={() => setIsForMember(!isForMember)}
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
              <BilboardButton fontSize={"14px"} text={"Add"} width={"200px"} />
            </Grid>
          </Grid>
        </Grid>
      </Grid>

      <Grid item xs={3}></Grid>
    </Grid>
  );
};

export default ClubManagementAddEventScreen;
