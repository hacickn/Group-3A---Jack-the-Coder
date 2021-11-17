import { TenMp } from "@mui/icons-material";
import {Grid} from "@mui/material";
import BilboardNavbar from "../components/BilboardNavbar";
import BilboardRoomRequest from "../components/BilboardRoomRequest";
import Constants from "../utils/Constants";
import BilboardSurvey from "../components/BilboardSurvey";

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

    function addSurvey( surveyObject)
    {
        let temp = [...surveyList]

        temp.push({
            photo: surveyObject.photo,
            question: surveyObject.question,
        })
    }

    return(
        <Grid container
            style= {{borderRadius: Constants.BORDER_RADIUS}}>

            <Grid item xs={12} style={{
                marginBottom: 25,
                paddingBottom: 20,
            }}>
                <BilboardNavbar/>
            </Grid>

            <Grid style={{
                marginTop: 35,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            }} item xs={12}>
                Surveys
            </Grid>

            <Grid container xs={12} style={{maxHeight: "100vh", overflowY: "scroll", marginLeft: 15, marginRight: 10}}>
                {surveyList.map( survey => <BilboardSurvey survey={survey}/> )}
            </Grid>
        </Grid>
    )
}

export default SurveyScreen;