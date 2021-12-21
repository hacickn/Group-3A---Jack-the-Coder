import Grid from "@mui/material/Grid";
import Constants from "../../utils/Constants";
import { makeStyles } from "@mui/styles";
import RequestedMembership from "./clubManagementComponents/RequestedMembership";
import PendingMembership from "./clubManagementComponents/PendingMembership";

const useStyles = makeStyles({
  container: {
    height: "80vh",
  },
});

const ClubManagementMembershipRequestsScreen = () => {
  const classes = useStyles();
  return (
    <div>
      <div style={{ fontSize: "36px", marginBottom: "10px" }}>
        Membership Requests
      </div>
      <div style={{ fontSize: "18px", marginBottom: "10px" }}>
        (A: Accept, P: Pending, R: Reject)
      </div>
      <Grid container>
        <Grid item xs={6}>
          <div className={classes.container}>
            <div
              style={{
                fontSize: "24px",
                fontWeight: "bolder",
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                marginBottom: "10px",
              }}
            >
              Requests
            </div>
            <div>
              <Grid container style={{ marginLeft: "2%" }}>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
                <Grid item xs={12}>
                  <RequestedMembership
                    name="Aslı"
                    surname="Dinç"
                    ID="21802527"
                  />
                </Grid>
              </Grid>
            </div>
          </div>
        </Grid>
        <Grid item xs={6}>
          <div className={classes.container}>
            <div
              style={{
                fontSize: "24px",
                fontWeight: "bolder",
                marginBottom: "10px",
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
              }}
            >
              Pending
            </div>
            <div>
              <Grid container style={{ marginLeft: "2%" }}>
                <Grid item xs={12}>
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                  <PendingMembership name="Aslı" surname="Dinç" ID="21802527" />
                </Grid>
              </Grid>
            </div>
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default ClubManagementMembershipRequestsScreen;
