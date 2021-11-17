import {Grid} from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import { Radio } from "@mui/material";
import { FormControlLabel } from "@mui/material";

/**
 * Survey Choices
 * 
 * Metehan Saçakçı
 * 17.11.2021
 */

const SurveyChoices = () => {

    const surveyChoicesList = [
        {
            choiceName: "Choice 1"
        },

        {
            choiceName: "Choice 2"
        },

        {
            choiceName: "Choice 3"
        },
    ]

    function addSurveyChoice( surveyChoiceObject)
    {
        let temp = [...surveyChoicesList]

        temp.push({
            choiceName: surveyChoiceObject.choiceName
        })
    }

    return (
        <Grid item style={{maxHeight: "20vh", maxWidth: "140px", overflowY: "scroll", marginLeft: 15, marginRight: 10}}>
            {surveyChoicesList.map( surveyChoice => {

                return (<Grid container 
                    style={{
                        marginBottom: 5,
                        marginTop: 5,
                        paddingTop: 20,
                        paddingBottom: 20,
                        alignItems: "center",
                    }}>
                    
                        <Grid item xs>
                            <FormControlLabel value={surveyChoice.choiceName} control={<Radio />} label={surveyChoice.choiceName} />
                        </Grid>
                    
                    </Grid>
                )
            })}
        </Grid>    
    )
}

export default SurveyChoices;