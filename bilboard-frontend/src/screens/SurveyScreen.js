import { Grid } from "@mui/material";
import Constants from "../utils/Constants";
import BilboardSurveyCard from "../components/BilboardSurveyCard";

/**
 * Survey Screen
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const SurveyScreen = ( props ) => {

    console.log( props.program.surveyParticipants )

    return (
        <Grid container
              style={ { borderRadius: Constants.BORDER_RADIUS, height: '89vh' } }>

            <Grid style={ {
                marginTop: 25,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            } } item xs={ 12 }>
                Surveys
            </Grid>

            <Grid container xs={ 12 } style={ { height: '79vh', overflowY: "scroll", alignContent: "start" } }>
                { props.program.surveyParticipants.map( surveyParticipants =>
                    <Grid item xs={ 12 }><BilboardSurveyCard
                        voted={ surveyParticipants.voted }
                        survey={ surveyParticipants.survey }/>
                    </Grid> ) }
                { props.program.surveyParticipants.length === 0 &&
                <Grid item xs={ 12 }  style={ {
                    float: "left",
                    marginLeft: "20px",
                    fontSize: "28px",
                    fontStyle: "italic",
                } }> There is no survey for you! </Grid> }
            </Grid>
        </Grid>
    )
}

export default SurveyScreen;