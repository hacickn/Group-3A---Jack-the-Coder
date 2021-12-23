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

const useStyles = makeStyles({});

const ClubManagementGeneralScreen = ({ image }) => {
  const classes = useStyles();
  return (
    <div>
      <Grid container style={{ maxHeight: "300px" }}>
        <Grid item xs={5}>
          <img
            src={AboutImage}
            alt="clubImage"
            style={{ width: "320px", marginBottom: "-10%", marginTop: "-5%" }}
          />
          <div></div>
          <Button variant="outlined">Edit Photo</Button>
        </Grid>
        <Grid item xs={7}>
          <div
            style={{
              fontSize: "40px",
              marginTop: "20px",
              fontWeight: "bold",
              fontFamily: "Oxygen, sans-serif",
              color: Colors.BILBOARD_LIGHT_GREY,
            }}
          >
            IEEE Bilkent
          </div>
          <div></div>
          <Rating
            name="read-only"
            defaultValue={2}
            style={{ marginTop: "20px" }}
            readOnly
            size="large"
          />
          <div></div>
          <Button
            variant="contained"
            startIcon={<WhatsAppIcon />}
            style={{
              marginTop: "20px",
              minWidth: "300px",
              minHeight: "40px",
              backgroundColor: "#25d366",
            }}
          >
            Go to Whatsapp Group
          </Button>
          <Button
            variant="outlined"
            color="warning"
            style={{ marginTop: "20px", marginLeft: "10px" }}
          >
            Edit
          </Button>
          <div></div>
          <Button
            variant="contained"
            startIcon={<InstagramIcon />}
            style={{
              marginTop: "20px",
              minWidth: "300px",
              minHeight: "40px",
              background:
                "linear-gradient(90deg, rgba(138,58,185,1) 0%, rgba(233,89,80,1) 60%, rgba(252,204,99,1) 100%)",
            }}
          >
            Go to Instagram Link
          </Button>
          <Button
            variant="outlined"
            color="warning"
            style={{ marginTop: "20px", marginLeft: "10px" }}
          >
            Edit
          </Button>
        </Grid>
      </Grid>
      <div
        style={{
          fontSize: "30px",
          marginTop: "50px",
          fontWeight: "bold",
          fontStyle: "italic",
          marginBottom: "40px",
          fontFamily: "Oxygen, sans-serif",
          color: Colors.BILBOARD_LIGHT_GREY,
        }}
      >
        Posts
      </div>
      <Grid container>
        <Grid item xs={3} style={{ marginBottom: "20px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard
              />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >

            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white" />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px"}}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} style={{ justifyContent: "left" }}>
              <EventCard />
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} >
              <EventCard/>
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} >
              <EventCard/>
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} >
              <EventCard/>
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
        <Grid item xs={3} style={{ marginBottom: "20px", paddingTop: "80px" }}>
          <Grid container style={{ marginLeft: "10px" }}>
            <Grid item xs={12} >
              <EventCard/>
              <Grid item xs={12} style={{ marginTop: "10px",  marginRight: "85px" }}>
                <BilboardButton
                  text="Edit"
                  width="85px"
                  fontWeight="bold"
                  fontSize={10}
                  color="#2f1da3"
                  textColor="white"
                />
                <BilboardButton
                  text="Delete"
                  width="85px"
                  font-weight="bold"
                  fontSize={10}
                  color="#cc0a0a"
                  textColor="white"
                />
                <BilboardButton
                  text="Participants"
                  width="85px"
                  fontSize={10}
                  color="#20d62c"
                  textColor="white"
                />
              </Grid>
            </Grid>
            <Grid
              item
              xs={4}
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
              }}
            >
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

export default ClubManagementGeneralScreen;
