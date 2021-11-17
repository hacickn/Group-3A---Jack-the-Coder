import {Grid} from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardSurveyCards from "../../components/BilboardSurveyCards";
import BilboardButton from "../../components/BilboardButton";

/**
 * Club Management Survey Screen
 * 
 * Metehan Saçakçı
 * 17.11.2021
 */

const ClubManagementSurveyScreen = () => {


    return (
        <Grid container>
            <Grid style={{
                marginTop: 15,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            }} item xs={12}>
                Active Surveys
            </Grid>

            <Grid item xs={12}>
                <BilboardSurveyCards/>
            </Grid>

            <Grid item xs= {12} style={{
                marginTop: 50,
            }}>
                <BilboardButton width="200px" fontSize="20px" text="Add Survey"/>
            </Grid>

        </Grid>

    )
}

export default ClubManagementSurveyScreen;