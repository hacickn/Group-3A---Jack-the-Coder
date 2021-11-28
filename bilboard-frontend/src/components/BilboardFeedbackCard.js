import { Grid } from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import BilboardButton from "./BilboardButton";

/**
 * Feedback Card
 *
 * Metehan Saçakçı
 * 18.11.2021
 */

const BilboardFeedbackCard = ( props ) => {

    return (
        <Grid container
              style={ {
                  marginBottom: 5,
                  marginTop: 5,
                  marginLeft: 24,
                  marginRight: 24,
                  paddingTop: 20,
                  paddingBottom: 20,
                  borderRadius: Constants.BORDER_RADIUS,
                  background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                  alignItems: "center",
              } }>
            <Grid item xs={ 9 }>
                <Grid container style={ { marginLeft: "30px" } }>

                    <Grid container style={ { alignItems: "end", display: "flex", justifyContent: "space-between" } }>
                        <Grid item xs={ 4 } style={ {
                            fontSize: 24,
                            textAlign: "start",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        } }>
                            A feedback was given
                        </Grid>

                        <Grid item xs={ 2 } style={ {
                            fontSize: 16,

                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            display: "flex",
                            justifyContent: "start",
                        } }>
                            at { props.feedback.feedbackDate }
                        </Grid>
                    </Grid>

                    <Grid item xs={ 12 } style={ {
                        fontSize: 15,
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        marginTop: 25,

                        minHeight: "100px",
                        textAlign: "start",
                    } }>
                        { props.feedback.feedbackText }
                    </Grid>
                </Grid>
            </Grid>
            <Grid item xs={ 3 }>
                <Grid container style={ {
                    display: "flex",
                    justifyContent: "center",
                    margin: "20px"
                } }>
                    <Grid item xs={ 12 } style={ { paddingBottom: 14 } }>
                        <BilboardButton text={ "Accept" } width={ "200px" } fontSize={ "14px" }
                                        color={ Colors.BILBOARD_MAIN }/>
                    </Grid>
                    <Grid item xs={ 12 }>
                        <BilboardButton text={ "Delete" } width={ "200px" } fontSize={ "14px" }
                                        color={ Colors.BILBOARD_RED }/>

                    </Grid>
                </Grid>
            </Grid>

        </Grid>
    )
}

export default BilboardFeedbackCard