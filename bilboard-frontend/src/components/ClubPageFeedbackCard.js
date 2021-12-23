import { makeStyles } from "@mui/styles";
import BilboardButton from "./BilboardButton";
import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";

const useStyles = makeStyles({
  root: {
    minHeight: "40px",
    borderRadius: "10px",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    width: "90%",
    padding: "16px",
    background: Colors.BILBOARD_MAIN_ALTERNATIVE,
  },
});

const FollowedClubs = (props) => {
  const classes = useStyles();
  return (
    <div
      className={classes.root}
      style={{ maxWidth: "100%", marginTop: "10px" }}
    >
        AAAAAAAAAAAAAAAAAAAALKKKKİKİKİK DOSTLAR MI HAKİKİ
        AAAAAAAAAAAAAAAAAAAALKKKKİKİKİK DOSTLAR MI HAKİKİ
        AAAAAAAAAAAAAAAAAAAALKKKKİKİKİK DOSTLAR MI HAKİKİ
        AAAAAAAAAAAAAAAAAAAALKKKKİKİKİK DOSTLAR MI HAKİKİ
        AAAAAAAAAAAAAAAAAAAALKKKKİKİKİK DOSTLAR MI HAKİKİ
    </div>
  );
};

export default FollowedClubs;
