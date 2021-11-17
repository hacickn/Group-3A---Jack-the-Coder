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

const BilboardRoomRequests = (props) => {

    const roomRequestList = [
        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "40",
            prefferedRoom: "BZ-02",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "50",
            prefferedRoom: "BZ-03",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "60",
            prefferedRoom: "BZ-04",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "70",
            prefferedRoom: "BZ-05",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "80",
            prefferedRoom: "BZ-06",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "90",
            prefferedRoom: "BZ-07",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            eventName: "kariyer.net example event",
            numberOfParticipants: "100",
            prefferedRoom: "BZ-08",
        },
    ]

    function addRoomRequest( roomRequestObject)
    {
        let temp = [...roomRequestList]

        temp.push({
            photo: roomRequestObject.photo,
            eventName: roomRequestObject.eventName,
            numberOfParticipants: roomRequestObject.numberOfParticipants,
            prefferedRoom: roomRequestObject.numberOfParticipants,
        })
    }

    return (
        <Grid container style={{maxHeight: "100vh", overflowY: "scroll", marginLeft: 15, marginRight: 10}}>
            {roomRequestList.map( roomRequest => {

                return (<Grid container 
                    style={{
                        marginBottom: 5,
                        marginTop: 5,
                        paddingTop: 20,
                        paddingBottom: 20,
                        borderRadius: Constants.BORDER_RADIUS,
                        background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                        alignItems: "center",
                    }}>
                    
                        <Grid item xs>
                            <img src={roomRequest.photo}
                                style={{maxHeight: 100, maxWidth: 100}} />                      
                        </Grid>

                        <Grid item xs>
                            {roomRequest.eventName}                     
                        </Grid>

                        <Grid item xs>
                            No of participants: {roomRequest.numberOfParticipants}                     
                        </Grid>

                        <Grid item xs>
                            Preferred Room: {roomRequest.prefferedRoom}                     
                        </Grid>

                        <Grid item xs>
                            <BilboardButton width="100px" fontSize="11px" text="Assign Room"/>
                        </Grid>

                    </Grid>
                )
            })}
        </Grid>    
    )
}

export default BilboardRoomRequests;