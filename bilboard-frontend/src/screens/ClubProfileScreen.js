import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../utils/Colors";
import EventCard from "../components/EventCard";
import Rating from "@mui/material/Rating";
import React from "react";
import Button from "@mui/material/Button";
import WhatsAppIcon from "@mui/icons-material/WhatsApp";
import InstagramIcon from "@mui/icons-material/Instagram";
import AboutImage from "../utils/AboutImage.png";
import LeaveFeedbackDialog from "../components/LeaveFeedbackDialog";
import ClubPageFeedbackCard from "../components/ClubPageFeedbackCard";
import LoyaltyIcon from '@mui/icons-material/Loyalty';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';

const ClubManagementGeneralScreen = ({ image }) => {
  const [isLeaveFeedbackDialogOpen, setIsLeaveFeedbackDialogOpen] = React.useState(false);
  const [isMemberOfClub, setIsMemberOfClub] = React.useState(false);
  return (
    <div style={{ margin: "20px" }}>
      <LeaveFeedbackDialog
        open={isLeaveFeedbackDialogOpen}
        onClose={() => setIsLeaveFeedbackDialogOpen(false)}
      />
      <Grid
        container
        style={{
          marginTop: "20px",
          background: "#F5F5F5",
          border: "5px solid #F5F5F5",
          padding: "20px",
          borderRadius: "20px",
          maxHeight: "400px",
          display: "flex",
          alignItems: "center",
        }}
      >
        <Grid item xs={3}>
          <img src={AboutImage} alt="clubImage" style={{ width: "320px" }} />
        </Grid>
        <Grid item xs={3}>
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
          {!isMemberOfClub ? (
              <Button
              variant="contained"
              startIcon={<LoyaltyIcon />}
              style={{
                marginTop: "20px",
                minWidth: "300px",
                minHeight: "60px",
              }}
            >
              Send Membership Request
            </Button>
          ):
          (
            <Button
            variant="contained"
            startIcon={<ExitToAppIcon />}
            style={{
              marginTop: "20px",
              minWidth: "300px",
              minHeight: "60px",
            }}
            color="error"
          >
            Leave Membership
          </Button>
          )}
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
        </Grid>
        <Grid
          item
          xs={6}
          style={{ marginTop: "20px", maxHeight: "300px", overflowY: "scroll" }}
        >
          <Grid container>
            <Grid item xs={12}>
              <Grid container>
                <Grid item xs={3}></Grid>
                <Grid item xs={3}>
                  <div style={{ fontSize: "28px", fontWeight: "bold" }}>
                    Feedbacks
                  </div>
                </Grid>
                <Grid item xs={3}>
                  <Button
                    style={{ fontSize: "16px" }}
                    variant="outlined"
                    onClick={() => setIsLeaveFeedbackDialogOpen(true)}
                  >
                    Add Feedback
                  </Button>
                </Grid>
                <Grid item xs={3}></Grid>
              </Grid>
            </Grid>
            <Grid
              item
              xs={12}
              style={{
                marginTop: "20px",
                background: "#F5F5F5",
                border: "5px solid #F5F5F5",
              }}
            >
              <Grid container>
                <Grid item xs={12}>
                  <ClubPageFeedbackCard />
                </Grid>
                <Grid item xs={12}>
                  <ClubPageFeedbackCard />
                </Grid>
              </Grid>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
      <div
        style={{
          fontSize: "30px",
          marginTop: "50px",
          fontWeight: "bold",
          marginBottom: "40px",
          fontFamily: "Oxygen, sans-serif",
          color: Colors.BILBOARD_LIGHT_GREY,
        }}
      >
        Posts
      </div>
      <Grid container style={{paddingTop:"60px" ,border: "5px solid #F5F5F5", borderRadius: "20px"}}>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
        <Grid
          item
          xs={3}
          style={{
            marginBottom: "60px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <EventCard />
        </Grid>
      </Grid>
    </div>
  );
};

export default ClubManagementGeneralScreen;
