import {Grid} from "@mui/material";
import BilboardNavbar from "../components/BilboardNavbar";

/**
 * Room Requests Screen
 * 
 * Metehan Saçakçı
 * 16.11.2021
 */

import BilboardRoomRequests from "../components/BilboardRoomRequests";
import Constants from "../utils/Constants";

const RoomRequestScreen = (props) => {

    return (
        <Grid container
            style= {{marginLeft: 10, borderRadius: Constants.BORDER_RADIUS}}>

            <Grid item xs={12}>
                <BilboardNavbar/>
            </Grid>

            <Grid style={{
                marginTop: 15,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            }} item xs={12}>
                Room Requests
            </Grid>
            <BilboardRoomRequests/>
        </Grid>
    )
}

export default RoomRequestScreen;