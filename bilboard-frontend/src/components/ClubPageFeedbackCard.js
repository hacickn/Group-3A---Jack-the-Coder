import { makeStyles } from "@mui/styles";
import BilboardButton from "./BilboardButton";
import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";

const useStyles = makeStyles( {
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
} );

const FollowedClubs = ( { feedback } ) => {
    const classes = useStyles();
    return (
        <div
            className={ classes.root }
            style={ { maxWidth: "100%", marginTop: "10px" } }
        >
            { feedback.content }
        </div>
    );
};

export default FollowedClubs;
