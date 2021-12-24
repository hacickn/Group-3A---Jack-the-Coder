import { Grid } from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import BilboardButton from "./BilboardButton";

/**
 * Bilboard Room Request
 *
 * Metehan Saçakçı
 * 16.11.2021
 */

const BilboardRoomRequest = (props) => {
  const handleApproveSlot = () => {};

  const handleRejectSlot = () => {};

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
              fontSize="11px"
              text="Approve"
              color="#66BB6A"
              onClick={handleApproveSlot}
            />
          </Grid>
        </Grid>
        <Grid
          item
          xs={12}
          style={{ display: "flex", justifyContent: "center" }}
        >
          <BilboardButton
            fontSize="11px"
            text="Reject"
            color={Colors.BILBOARD_RED}
            onClick={handleRejectSlot}
          />
        </Grid>
      </Grid>
    </Grid>
  );
};

export default BilboardRoomRequest;
