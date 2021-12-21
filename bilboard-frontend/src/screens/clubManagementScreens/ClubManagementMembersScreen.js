import Constants from "../../utils/Constants";
import MemberComponent from "./clubManagementComponents/MemberComponent";
import Grid from "@mui/material/Grid";

const ClubManagementMembersScreen = () => {
  const members = [
    {
      name: "Hacı Çakın",
      surname: "Çakın",
      id: "21802641",
    },
    {
      name: "İlke Doğan",
        surname: "Doğan",
      id: "21702215",
    },
    {
      name: "Aslı Dinç",
        surname: "Dinç",
      id: "21802527",
    },
    {
      name: "Metehan Saçakçı",
        surname: "Saçakçı",
      id: "21802788",
    },
    {
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },{
        name: "Metehan Saçakçı",
          surname: "Saçakçı",
        id: "21802788",
      },
  ];
  return (
    <div>
      <div style={{ fontSize: "40px" }}>Members</div>
      <Grid container style={{marginLeft: "20px"}}>
        <Grid item xs={4} style={{ marginTop: "30px", marginBottom: "20px" }}>
          <div style={{ fontSize: "24px", fontFamily: "Oxygen, sans-serif" }}>
            Student Name
          </div>
        </Grid>
        <Grid item xs={4} style={{ marginTop: "30px", marginBottom: "20px" }}>
          <div style={{ fontSize: "24px", fontFamily: "Oxygen, sans-serif" }}>
            Student ID
          </div>
        </Grid>
        <Grid item xs={4} style={{ marginTop: "30px", marginBottom: "20px" }}>
          <div style={{ fontSize: "24px", fontFamily: "Oxygen, sans-serif" }}>
            Operations
          </div>
        </Grid>
      </Grid>
      {members.sort((a, b) => (a.name > b.name) ? 1 : -1).map((member, index) => (
        <div key={index} style={{ marginLeft: "24px" }}>
          <MemberComponent name={member.name} surname={member.surname} ID={member.id} />
        </div>
      ))}
    </div>
  );
};

export default ClubManagementMembersScreen;
