import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardButton from "../../components/BilboardButton";
import Constants from "../../utils/Constants";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import InputLabel from "@mui/material/InputLabel";
import FormControl from "@mui/material/FormControl";
import React from "react";

const CreateClassroomDayScreen = () => {
  const [building, setBuilding] = React.useState("");
  const [classroom, setClassroom] = React.useState("");
  const [classroomDay, setClassroomDay] = React.useState(0);
  const [date, setDate] = React.useState("");
  const [time, setTime] = React.useState("");

  const handleBuildingSelect = (e) => {
    setBuilding(e.target.value);
  };

  const handleClassroomSelect = (e) => {
    setClassroom(e.target.value);
  };

  const handleDateTimeSelect = (e) => {
    setDate(e.target.value.substring(0, e.target.value.indexOf("T")));
    setTime(e.target.value.substring(e.target.value.indexOf("T") + 1));
  };

  const handleDaySelect = (e) => {
    setClassroomDay(e.target.value);
  };

  const handleAddButton = () => {
      console.log(building, classroom, classroomDay, date, time);
  }

  return (
    <div style={{ height: "70vh", display: "flex", alignItems: "center" }}>
      <Grid container>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginBottom: "20px",
          }}
        >
          <div
            style={{
              fontFamily: Constants.OXYGEN_FONT_FAMILY,
              fontSize: "28px",
            }}
          >
            Classroom Slot Addition:
          </div>
        </Grid>
        <Grid
          item
          xs={12}
          style={{
            display: "flex",
            justifyContent: "center",
            marginBottom: "20px",
          }}
        >
          <FormControl sx={{ width: 300 }}>
            <InputLabel id="building-select-label">
              Please Select Building
            </InputLabel>
            <Select
              value={building}
              labelId="building-select-label"
              id="building-select"
              label="Please Select Building"
              onChange={handleBuildingSelect}
            >
              <MenuItem value={"1"}>Building1</MenuItem>
              <MenuItem value={"2"}>Building2</MenuItem>
              <MenuItem value={"3"}>Building3</MenuItem>
            </Select>
          </FormControl>
        </Grid>
        {building != "" && (
          <Grid container>
            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              <FormControl sx={{ width: 300 }}>
                <InputLabel id="classroom-select-label">
                  Please Select Classroom
                </InputLabel>
                <Select
                  value={classroom}
                  labelId="classroom-select-label"
                  id="classroom-select"
                  label="Please Select Classroom"
                  onChange={handleClassroomSelect}
                >
                  <MenuItem value={"1"}>Classroom1</MenuItem>
                  <MenuItem value={"2"}>Classroom2</MenuItem>
                  <MenuItem value={"3"}>Classroom3</MenuItem>
                </Select>
              </FormControl>
            </Grid>
          </Grid>
        )}

        {classroom != "" && (
          <Grid container>
            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              Please select a date and time firstly
            </Grid>

            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              <BilboardTextField
                onChange={handleDateTimeSelect}
                type={"datetime-local"}
                width={"300px"}
              />
            </Grid>
          </Grid>
        )}
        {date.length !== 0 && time.length !== 0 && (
          <Grid container>
            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              Please select number of days from the date you select
            </Grid>
            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              <FormControl sx={{ width: 300 }}>
                <Select
                  value={classroomDay}
                  labelId="classroom-day-select-label"
                  id="classroom-day-select"
                  onChange={handleDaySelect}
                >
                  <MenuItem value={1}>1</MenuItem>
                  <MenuItem value={2}>2</MenuItem>
                  <MenuItem value={3}>3</MenuItem>
                  <MenuItem value={4}>4</MenuItem>
                  <MenuItem value={5}>5</MenuItem>
                </Select>
              </FormControl>
            </Grid>
            <Grid
              item
              xs={12}
              style={{
                display: "flex",
                justifyContent: "center",
                marginBottom: "20px",
              }}
            >
              <BilboardButton onClick={handleAddButton} text="Add" fontSize="16px" width="100px" />
            </Grid>
          </Grid>
        )}
      </Grid>
    </div>
  );
};

export default CreateClassroomDayScreen;
