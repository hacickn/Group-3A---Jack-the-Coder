import { makeStyles } from "@mui/styles";
import BilboardButton from "./BilboardButton";
import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";

const useStyles = makeStyles( {
    root: {
        minHeight: "100px",
        borderRadius: "10px",
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
    },
    clubLogo: {
        width: "300px",
        marginTop: "10px",
        marginLeft: "20px",
        height: "80px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
    },
} );

const FollowedClubs = ( props ) => {
    const classes = useStyles();
    return (
        <div
            className={ classes.root }
            style={ { maxWidth: "100%", marginTop: "20px" } }
        >
            <Grid container>
                <Grid item xs={ 6 }>
                    <div
                        className={ classes.clubLogo }
                        style={ { backgroundImage: `url(${ props.image })` } }
                    />
                </Grid>
                <Grid
                    item
                    xs={ 3 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginTop: "10px"
                    } }
                >
                    <BilboardButton text="Go To Club Page" width={ "10vw" }/>
                </Grid>
                <Grid
                    item
                    xs={ 2 }
                    style={ {
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                        marginTop: "10px"
                    } }
                >
                    <BilboardButton text="Leave Membership" width={ "10vw" } color={ Colors.BILBOARD_RED }/>
                </Grid>
            </Grid>
        </div>
    );
};

export default FollowedClubs;
