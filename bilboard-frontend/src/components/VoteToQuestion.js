import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Grid  from "@mui/material/Grid";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";

/**
 * Vote To Question
 * 
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

 const VoteToQuestion = () => {
    
    return (
        <Grid container style={{marginBottom: "20px", border: "5px solid", padding: "10px", borderColor: Colors.BILBOARD_MAIN_ALTERNATIVE, borderRadius: "10px"}}>
            <Grid item xs={12}>                     
                <p
                style={{
                    color: Colors.BILBOARD_LIGHT_GREY,
                    fontSize: "18px",
                    marginBottom: "1px",
                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                    align: "center",
                    letterSpacing: "1px",
                    display: "flex",
                    justifyContent: "center",
                }}      
            >Question: QUESTION-TEXT</p>
            </Grid>
            <Grid item xs={12} style={{marginTop: "20px",
                display: "flex",
                justifyContent: "center",
                }}>
                <FormControl component="fieldset">
                    <FormLabel component="legend"></FormLabel>
                    <RadioGroup
                        aria-label="choice"
                        defaultValue="choice1"
                        name="radio-buttons-group"
                    >
                        <FormControlLabel value="choice1" control={<Radio />} label="Choice 1" />
                        <FormControlLabel value="choice2" control={<Radio />} label="Choice 2" />
                        <FormControlLabel value="choice3" control={<Radio />} label="Choice 3" />
                    </RadioGroup>
                </FormControl>
            </Grid>
        </Grid>
    )
}

 export default VoteToQuestion;