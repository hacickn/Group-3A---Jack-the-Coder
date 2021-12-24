import { Grid } from "@mui/material";
import BilboardNavbar from "../../components/BilboardNavbar";
import BilboardRoomRequest from "../../components/BilboardRoomRequest";
import Constants from "../../utils/Constants";

/**
 * Room Requests Screen
 *
 * Metehan Saçakçı
 * 16.11.2021
 */

const RoomRequestScreen = (props) => {
  const roomRequestList = [
    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "40",
      prefferedRoom: "BZ-02",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "50",
      prefferedRoom: "BZ-03",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "60",
      prefferedRoom: "BZ-04",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "70",
      prefferedRoom: "BZ-05",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "80",
      prefferedRoom: "BZ-06",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "90",
      prefferedRoom: "BZ-07",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },

    {
      photo:
        "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
      eventName: "kariyer.net example event",
      numberOfParticipants: "100",
      prefferedRoom: "BZ-08",
    },
  ];

  function addRoomRequest(roomRequestObject) {
    let temp = [...roomRequestList];

    temp.push({
      photo: roomRequestObject.photo,
      eventName: roomRequestObject.eventName,
      numberOfParticipants: roomRequestObject.numberOfParticipants,
      prefferedRoom: roomRequestObject.numberOfParticipants,
    });
  }

  return (
    <Grid container style={{height: "80vh",overflowY: "scroll", padding: "20px" }}>
      {roomRequestList.map((roomRequest) => (
        <Grid
          container
          xs={12}
        >
          <BilboardRoomRequest roomRequest={roomRequest} />
        </Grid>
      ))}
    </Grid>
  );
};
export default RoomRequestScreen;
