import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";

const useStyles = makeStyles( {
    container: {
        width: "96%",
        height: "80px",
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
        marginBottom: "10px",
        borderRadius: "10px",
    },
} );

const PendingMembership = ( { requestId, name, surname, ID } ) => {
    const classes = useStyles();
    return (
        <div className={ classes.container }>
            <Grid container>
                <Grid item xs={ 5 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "18px", fontFamily: "Oxygen, sans-serif" } }>
                        { name } { surname }
                    </div>
                </Grid>
                <Grid item xs={ 2 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "18px", fontFamily: "Oxygen, sans-serif" } }>
                        { ID }
                    </div>
                </Grid>
                <Grid item xs={ 5 } style={ { marginTop: "20px" } }>
                    <BilboardButton
                        text="A"
                        width="60px"
                        fontSize={ 20 }
                        color="#9CCC65"
                        textColor="white"
                    />
                    <BilboardButton
                        text="R"
                        width="60px"
                        fontSize={ 20 }
                        color="#EF5350"
                        textColor="white"
                    />
                </Grid>
            </Grid>
        </div>
    );
};

export default PendingMembership;
