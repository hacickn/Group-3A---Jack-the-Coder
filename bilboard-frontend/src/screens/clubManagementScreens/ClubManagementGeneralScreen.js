import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import EventCard from "../../components/EventCard";
import Rating from "@mui/material/Rating";
import Button from "@mui/material/Button";
import WhatsAppIcon from "@mui/icons-material/WhatsApp";
import InstagramIcon from "@mui/icons-material/Instagram";
import AboutImage from "../../utils/AboutImage.png";
import EventForGeneralPage from "./clubManagementComponents/EventForGeneralPage";

const useStyles = makeStyles( {} );

const ClubManagementGeneralScreen = ( { club } ) => {

    const classes = useStyles();

    let totalPoint = 0;
    club.events.forEach( event => {
        totalPoint = totalPoint + event.averageRate
    } )

    return (
        <div>
            <Grid container style={ { maxHeight: "300px" } }>
                <Grid item xs={ 5 }>
                    <img
                        src={ AboutImage }
                        alt="clubImage"
                        style={ { width: "320px", marginBottom: "-10%", marginTop: "-5%" } }
                    />
                    <Button variant="outlined">Edit Photo</Button>
                    <div/>
                </Grid>
                <Grid item xs={ 7 }>
                    <div
                        style={ {
                            fontSize: "40px",
                            marginTop: "20px",
                            fontWeight: "bold",
                            fontFamily: "Oxygen, sans-serif",
                            color: Colors.BILBOARD_LIGHT_GREY,
                        } }
                    >
                        { club.name }
                    </div>
                    <div/>
                    <Rating
                        name="read-only"
                        defaultValue={ totalPoint / club.events.length }
                        style={ { marginTop: "20px" } }
                        readOnly
                        size="large"
                    />
                    <div/>
                    <Button
                        variant="contained"
                        startIcon={ <WhatsAppIcon/> }
                        style={ {
                            marginTop: "20px",
                            minWidth: "300px",
                            minHeight: "40px",
                            backgroundColor: "#25d366",
                        } }
                    >
                        Go to Whatsapp Group
                    </Button>
                    <Button
                        variant="outlined"
                        color="warning"
                        style={ { marginTop: "20px", marginLeft: "10px" } }
                    >
                        Edit
                    </Button>
                    <div></div>
                    <Button
                        variant="contained"
                        startIcon={ <InstagramIcon/> }
                        style={ {
                            marginTop: "20px",
                            minWidth: "300px",
                            minHeight: "40px",
                            background:
                                "linear-gradient(90deg, rgba(138,58,185,1) 0%, rgba(233,89,80,1) 60%, rgba(252,204,99,1) 100%)",
                        } }
                    >
                        Go to Instagram Link
                    </Button>
                    <Button
                        variant="outlined"
                        color="warning"
                        style={ { marginTop: "20px", marginLeft: "10px" } }
                    >
                        Edit
                    </Button>
                </Grid>
            </Grid>
            <div
                style={ {
                    fontSize: "50px",
                    marginTop: "50px",
                    fontWeight: "bold",
                    fontStyle: "italic",
                    marginBottom: "40px",
                    fontFamily: "Oxygen, sans-serif",
                    color: Colors.BILBOARD_LIGHT_GREY,
                } }
            >
                Posts
            </div>

            <Grid container>
                { club.events.map( event => {
                    return <Grid item xs={ 3 }
                                 style={ { marginBottom: "20px", display: "flex", justifyContent: "center" } }>
                        <EventForGeneralPage event={ event }/>
                    </Grid>
                } ) }
            </Grid>
        </div>
    );
};

export default ClubManagementGeneralScreen;
