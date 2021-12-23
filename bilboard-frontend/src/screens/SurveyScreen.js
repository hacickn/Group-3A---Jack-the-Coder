import {Grid} from "@mui/material";
import Constants from "../utils/Constants";
import BilboardSurveyCard from "../components/BilboardSurveyCard";

/**
 * Survey Screen
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const SurveyScreen = (props) => {

    const surveyList = [
        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },

        {
            photo: "https://upload.wikimedia.org//wikipedia/commons/thumb/2/21/IEEE_logo.svg/1200px-IEEE_logo.svg.png",
            question: "What will our next event be?"
        },
    ]


    return (
        <Grid container
              style={{borderRadius: Constants.BORDER_RADIUS, height: '89vh'}}>

            <Grid style={{
                marginTop: 25,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            }} item xs={12}>
                Surveys
            </Grid>

            <Grid container xs={12} style={{height: '79vh', overflowX: "scroll"}}>
                {props.program.surveyParticipants.map(surveyParticipants => <BilboardSurveyCard survey={surveyParticipants.survey}/>)}
            </Grid>
        </Grid>
    )
}

export default SurveyScreen;