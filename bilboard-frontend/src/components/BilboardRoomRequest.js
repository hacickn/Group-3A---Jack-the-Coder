import {Grid} from "@mui/material";
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

    return (<Grid container 
        style={{
            marginBottom: 5,
            marginTop: 5,
            paddingTop: 20,
            paddingBottom: 20,
            borderRadius: Constants.BORDER_RADIUS,
            background: Colors.BILBOARD_MAIN_ALTERNATIVE,
            alignItems: "center",
        }}>
        
            <Grid item xs>
                <img src={props.roomRequest.photo}
                    style={{maxHeight: 100, maxWidth: 100}} />                      
            </Grid>

            <Grid item xs>
                {props.roomRequest.eventName}                     
            </Grid>

            <Grid item xs>
                No of participants: {props.roomRequest.numberOfParticipants}                     
            </Grid>

            <Grid item xs>
                Preferred Room: {props.roomRequest.prefferedRoom}                     
            </Grid>

            <Grid item xs>
                <BilboardButton width="100px" fontSize="11px" text="Assign Room"/>
            </Grid>
        </Grid>
    )
}

export default BilboardRoomRequest;