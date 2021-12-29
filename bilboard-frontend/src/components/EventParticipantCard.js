import { Grid } from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";

/**
 * Event Participant Card
 * Metehan Saçakçı
 *
 * 23.12.2021
 */

const EventParticipantCard = ( { participant } ) => {
    return (
        <Grid container
              style={ {
                  maxHeight:"8vh",
                  padding:10,
                  margin:5,
                  borderRadius: Constants.BORDER_RADIUS,
                  background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                  alignItems: "center",
              } }>

            <Grid item xs={ 10 } style={ { fontSize: "25px"} }>
                { participant.user.name + " " + participant.user.surname  }
            </Grid>
            <Grid item xs={1}  style={ { fontSize: "25px" } }>
                {  participant.user.bilkentId }
            </Grid>
        </Grid>
    )
}

export default EventParticipantCard;