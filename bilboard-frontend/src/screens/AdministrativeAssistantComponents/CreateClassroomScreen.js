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
import Env from "../../utils/Env";
import axios from "axios";

const CreateClassroomScreen = () => {
  const [building, setBuilding] = React.useState("");
  const [classroom, setClassroom] = React.useState("");
  const [capacity, setCapacity] = React.useState(0);

  const handleBuildingSelect = (e) => {
    setBuilding(e.target.value);
  };

  const handleClassroomName = (e) => {
    setClassroom(e.target.value);
  }

  const handleAddButton = () => {
    console.log(building, classroom)

    let headers = {
      "Content-Type": "application/json",
      'Authorization': "Bearer " + Env.TOKEN,
    };

    axios.post(process.env.REACT_APP_URL + 'reservation/classroom', {
      "name": classroom,
      "capacity": capacity,
      "building": 50
    }, {headers: headers})
    .then(function(response) {
      // todo
    }) 
    .catch( function(error) {
      // todo
    })
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
            Please Enter Classroom:
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
              Please Select Building First
            </InputLabel>
            <Select
              value={building}
              labelId="building-select-label"
              id="building-select"
              label="Please Select Building First"
              onChange={handleBuildingSelect}
            >
              <MenuItem value={"Building1"}>Building1</MenuItem>
              <MenuItem value={"Building2"}>Building2</MenuItem>
              <MenuItem value={"Building3"}>Building3</MenuItem>
            </Select>
          </FormControl>
        </Grid>

        {building !== "" && (
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
              <BilboardTextField onChange={handleClassroomName} label="Classroom Name" width="300px" />
            </Grid>

            <Grid item xs={12} style={{marginTop: "20px",
              display: "flex",
              justifyContent: "center",
              }}>
              <BilboardTextField
                  label="Capacity"
                  type="capacity"
                  value={capacity}
                  onChange={(e) => setCapacity(e.target.value)}
                  width="300px"
                  style={{marginTop: "30px"}}
              />
            </Grid>

            <Grid
              item
              xs={12}
              style={{
                marginTop: "30px",
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

export default CreateClassroomScreen;
