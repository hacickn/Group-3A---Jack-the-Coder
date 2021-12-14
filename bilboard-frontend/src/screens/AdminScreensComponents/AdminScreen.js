import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import React from "react";
import Constants from "../../utils/Constants";
import { Card } from "@mui/material";
import AdminAddClubScreen from "./AdminAddClubScreen";
import AdminManageClubScreen from "./AdminManageClubScreen";

const AdminScreen = (props) => {
  const pages = [
    "Add Club",
    "Manage Clubs",
  ];
  const mockClubs = [
    {
      name: "Club 1",
      id: 1,
      advisor: "Advisor 1",
      president: "President 1",
    },
    {
      name: "Club 2",
      id: 2,
      advisor: "Advisor 2",
      president: "President 2",

    },
    {
      name: "Club 3",
      id: 3,
      advisor: "Advisor 3",
      president: "President 3",
    },
    {
      name: "Club 4",
      id: 4,
      advisor: "Advisor 4",
      president: "President 4",
    },
    {
      name: "Club 5",
      id: 5,
      advisor: "Advisor 5",
      president: "President 5",
    },
    {
      name: "Club 6",
      id: 6,
      advisor: "Advisor 6",
      president: "President 6",
    },
    {
      name: "Club 7",
      id: 7, 
      advisor: null,
      president: "President 7",
    },
  ]
  const [openedScreen, setOpenedScreen] = React.useState("Add Club");

  return (
    <Grid container style={{ padding: 20, height: "88vh" }}>
      <Grid
        style={{
          height: "85vh",
          borderRadius: Constants.BORDER_RADIUS,
          padding: 4,
        }}
        item
        xs={3}
      >
        <Card elevation={4} style={{ borderRadius: Constants.BORDER_RADIUS }}>
          {pages.map((page) => (
            <Grid
              item
              xs={12}
              style={{
                paddingTop: 5,
                paddingBottom: 5,
              }}
            >
              {openedScreen === page ? (
                <BilboardButton
                  text={page}
                  fontSize={16}
                  width="23vw"
                  height={"4vh"}
                  color={Colors.BILBOARD_MAIN}
                  textColor={Colors.WHITE}
                />
              ) : (
                <BilboardButton
                  text={page}
                  fontSize={16}
                  width="23vw"
                  height={"4vh"}
                  color={Colors.WHITE}
                  textColor={Colors.BILBOARD_MAIN}
                  onClick={() => setOpenedScreen(page)}
                />
              )}
            </Grid>
          ))}
        </Card>
      </Grid>
      <Grid item xs={9} style={{ padding: 4 }}>
        <Card
          elevation={4}
          style={{ borderRadius: Constants.BORDER_RADIUS, height: "85vh" }}
        >
          {openedScreen === "Add Club" ? (
            <AdminAddClubScreen />
          ) : openedScreen === "Manage Clubs" ? (
            <AdminManageClubScreen clubs={mockClubs} />
          ) : (
            <div />
          )}
        </Card>
      </Grid>
    </Grid>
  );
};

export default AdminScreen;
