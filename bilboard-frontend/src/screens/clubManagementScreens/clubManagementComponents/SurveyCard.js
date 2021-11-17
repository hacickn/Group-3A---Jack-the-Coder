import {Grid} from "@mui/material";
import Constants from "../../../utils/Constants";
import Colors from "../../../utils/Colors";
import BilboardButton from "../../../components/BilboardButton";

const SurveyCard = (props) => {

    return (<Grid container
                  style={{
                      minWidth: "300px",
                      minHeight: "300px",
                      cursor: "pointer",
                      borderRadius: Constants.BORDER_RADIUS,
                      background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                      marginBottom: 5,
                      marginTop: 5,
                      marginLeft: 5,
                      marginRight: 5,
                      paddingTop: 20,
                      paddingBottom: 20,

                  }}>
        <Grid item xs={12} style={{
            marginTop: 20,
            marginBottom: 45,
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            fontSize: 24,
        }}>
            {props.survey.surveyQuestion}
        </Grid>

        <Grid item xs={12} style={{
            marginBottom: 45,
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            fontSize: 15,

        }}>
            Planned End Date: {props.survey.endDate}
        </Grid>

        <Grid item xs={6}>
            <BilboardButton width="100px" fontSize="13px" text="End Survey"/>
        </Grid>

        <Grid item xs={6}>
            <BilboardButton width="100px" fontSize="13px" text="See Results"/>
        </Grid>

    </Grid>)
}

export default SurveyCard;