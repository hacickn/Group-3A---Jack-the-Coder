import { makeStyles } from "@mui/styles";
import Grid from "@mui/material/Grid";
import BilboardNavbar from "../components/BilboardNavbar";

const useStyles = makeStyles({
  root: {
    height: "100vh",
  },
});


const UserScreen = () => {
  const classes = useStyles();
  return(
    <div className={classes.root}>
      a
    </div>
  )
    
}

export default UserScreen;
