import {Grid} from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';

/**
 * Feedback Card
 * 
 * Metehan Saçakçı
 * 18.11.2021
 */

const BilboardFeedbackCard = (props) => {

    return(
        <Grid container
              style={{
                  marginBottom: 5,
                  marginTop: 5,
                  marginLeft: 24,
                  marginRight: 24,
                  paddingTop: 20,
                  paddingBottom: 20,
                  borderRadius: Constants.BORDER_RADIUS,
                  background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                  alignItems: "center",
              }}>

              <Grid container xs={8}>

                <Grid item xs={4} style={{
                    fontSize: 24,
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                }}>
                    A feedback was given
                </Grid>

                <Grid item xs={8} style={{
                    fontSize: 15,
                    marginTop: 5,
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                    display: "flex",
                    justifyContent: "start",
                }}>
                    at {props.feedback.feedbackDate}
                </Grid>

                <Grid item style={{
                    fontSize: 15,
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                    marginTop: 25,
                    marginLeft: 30,
                    minHeight: "100px",
                    maxHeight: "100px",
                    maxWidth: "100vw",
                    display: "flex",
                    justifyContent: "start",
                }}>
                    {props.feedback.feedbackText}
                </Grid>
            </Grid>

            <Grid container xs={4}>

                <Grid item style={{
                    display: "flex",
                    marginLeft: 175,
                    justifyContent: "end",
                }}>
                    <Button variant="outlined" startIcon={<DeleteIcon />}>
                        Delete Feedback
                    </Button>
                </Grid>
            </Grid>
        </Grid>
    )
}

export default BilboardFeedbackCard