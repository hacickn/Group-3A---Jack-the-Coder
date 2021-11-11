import { makeStyles } from "@mui/styles";
import Colors from "../utils/Colors";
import Grid from "@mui/material/Grid";
import InputAdornment from "@mui/material/InputAdornment";
import TextField from "@mui/material/TextField";
import IconButton from "@mui/material/IconButton";
import SearchIcon from "@mui/icons-material/Search";
import Badge from "@mui/material/Badge";
import AssignmentIcon from "@mui/icons-material/Assignment";
import TodayIcon from "@mui/icons-material/Today";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";

const useStyles = makeStyles({
  root: {
    width: "100vw",
    height: "68px",
    background: Colors.BILBOARD_BLUE,
  },
  logo: {
    fontFamily: "Oxygen",
    fontSize: "32px",
    display: "flex",
    alignItems: "center",
    color: "white",
    height: "68px",
    paddingLeft: "30px",
    justifyContent: "start",
  },
  searchBar: {
    display: "flex",
    alignItems: "center",
    justifyContent: "start",
    height: "68px",
    paddingLeft: "40px",
  },
  icons: {
    display: "flex",
    alignItems: "center",
    height: "68px",
    marginTop: "2px",
  },
});

const BilboardNavbar = (props) => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <Grid container>
        <Grid item xs={3}>
          <div className={classes.logo}>BilBoard</div>
        </Grid>
        <Grid item xs={5} className={classes.searchBar}>
          <div style={{ backgroundColor: "white", borderRadius: "5px" }}>
            <TextField
              color="info"
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <SearchIcon />
                  </InputAdornment>
                ),
              }}
              size="small"
              style={{ width: "420px" }}
            />
          </div>
        </Grid>
        <Grid item xs={1}></Grid>
        <Grid item xs={3}>
          <Grid container className={classes.icons}>
            <Grid item xs={4} />
            <Grid item xs={2}>
              <IconButton size="large">
                <Badge badgeContent={props.surveyCount} color="error">
                  <div style={{ color: "white" }}>
                    <AssignmentIcon />
                  </div>
                </Badge>
              </IconButton>
            </Grid>
            <Grid item xs={2}>
              <IconButton size="large">
                <Badge badgeContent={props.calendarCount} color="error">
                  <div style={{ color: "white" }}>
                    <TodayIcon />
                  </div>
                </Badge>
              </IconButton>
            </Grid>
            <Grid item xs={2}>
              <IconButton size="large">
                <div style={{ color: "white" }}>
                  <AccountCircleIcon />
                </div>
              </IconButton>
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

export default BilboardNavbar;
