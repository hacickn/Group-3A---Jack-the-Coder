import Grid from "@mui/material/Grid";
import { makeStyles } from "@mui/styles";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";
import {
    CheckCircle,
    ConfirmationNumber,
    EventAvailable,
    RadioButtonChecked,
    Remove,
    RemoveCircle
} from "@mui/icons-material";

const useStyles = makeStyles( {
    container: {
        width: "70vw",
        height: "100px",
        background: Colors.BILBOARD_MAIN_ALTERNATIVE,
        marginBottom: "10px",
        borderRadius: "10px",
    },
} );

const MemberComponent = ( { name, surname, ID, gePoint, geTaken, eventCount } ) => {
    const classes = useStyles();

    return (
        <div className={ classes.container }>
            <Grid container>
                <Grid item xs={ 3 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "24px", fontFamily: "Oxygen, sans-serif" } }>
                        { name } { surname }
                    </div>
                </Grid>
                <Grid item xs={ 2 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "24px", fontFamily: "Oxygen, sans-serif" } }>
                        { eventCount }
                    </div>
                </Grid>
                <Grid item xs={ 1 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "24px", fontFamily: "Oxygen, sans-serif" } }>
                        { geTaken ? <CheckCircle style={ { color: Colors.BILBOARD_MAIN } }/> :
                            <RemoveCircle style={ { color: Colors.BILBOARD_RED } }/> }
                    </div>
                </Grid>
                <Grid item xs={ 1 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "24px", fontFamily: "Oxygen, sans-serif" } }>
                        { gePoint }
                    </div>
                </Grid>
                <Grid item xs={ 2 } style={ { marginTop: "30px" } }>
                    <div style={ { fontSize: "24px", fontFamily: "Oxygen, sans-serif" } }>
                        { ID }
                    </div>
                </Grid>
                <Grid item xs={ 3 } style={ { marginTop: "26px" } }>
                    <BilboardButton
                        text="Remove"
                        fontSize={ 20 }
                        width="140px"
                        color={ Colors.WHITE }
                        textColor={ Colors.BILBOARD_MAIN }
                    />
                </Grid>
            </Grid>
        </div>
    );
};

export default MemberComponent;
