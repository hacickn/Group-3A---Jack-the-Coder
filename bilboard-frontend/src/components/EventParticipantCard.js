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
                  marginBottom: 5,
                  marginTop: 5,
                  marginLeft: 24,
                  marginRight: 24,
                  paddingTop: 20,
                  paddingBottom: 20,
                  borderRadius: Constants.BORDER_RADIUS,
                  background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                  alignItems: "center",
              } }>

            <Grid item xs={ 12 } style={ { fontSize: "25px", marginLeft: 20 } }>
                Event Participant: { participant.user.name + " " + participant.user.surname }
            </Grid>

        </Grid>
    )
}

export default EventParticipantCard;