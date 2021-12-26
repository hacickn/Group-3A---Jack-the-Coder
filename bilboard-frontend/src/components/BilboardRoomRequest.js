import { Grid } from "@mui/material";
import axios from "axios";
import React from "react";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import BilboardButton from "./BilboardButton";
import Env from "../utils/Env";

/**
 * Bilboard Room Request
 *
 * Metehan Saçakçı
 * 16.11.2021
 */

const BilboardRoomRequest = (props) => {
  const [status, setStatus] = React.useState("");
  const [error, setError] = React.useState("")

  const handleApproveDeclineSlot = (status) => {
    let headers = {
      "Content-Type": "application/json",
      'Authorization': "Bearer " + Env.TOKEN,
    };

    axios.post(process.env.REACT_APP_URL + "reservation/respond?requestId=" + props.requestId + "&status= " + status, {}, {headers: headers})
      .then(function (response){
        console.log(response)
      })
      .catch( function (error){
        setError("Something went wrong!")
      })
  };

  return (
    <Grid
      container
      style={{
        marginBottom: 5,
        marginTop: 5,
        paddingTop: 20,
        paddingBottom: 20,
        borderRadius: Constants.BORDER_RADIUS,
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
        alignItems: "center",
      }}
    >
      <Grid item xs={3} style={{ display: "flex", justifyContent: "center" }}>
        <img
          src={props.roomRequest.photo}
          style={{ maxHeight: 100, maxWidth: 100 }}
        />
      </Grid>

      <Grid item xs={3}>
        {props.roomRequest.eventName}
      </Grid>

      <Grid item xs={2}>
        Participants: {props.roomRequest.numberOfParticipants}
      </Grid>

      <Grid item xs={3}>
        Preferred Slot: {props.roomRequest.prefferedSlot}
      </Grid>

      <Grid item xs={1}>
        <Grid container>
          <Grid
            iten
            xs={12}
            style={{ display: "flex", justifyContent: "center" }}
          >
            <BilboardButton
              onClick={() => handleApproveDeclineSlot("true")}
              fontSize="11px"
              text="Approve"
              color="#66BB6A"
            />
          </Grid>
        </Grid>
        <Grid
          item
          xs={12}
          style={{ display: "flex", justifyContent: "center" }}
        >
          <BilboardButton
            onClick={() => handleApproveDeclineSlot("false")}
            fontSize="11px"
            text="Reject"
            color={Colors.BILBOARD_RED}
          />
        </Grid>
      </Grid>
    </Grid>
  );
};

export default BilboardRoomRequest;
