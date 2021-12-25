import Grid  from "@mui/material/Grid";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";

/**
 * Answer And Result
 *
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const AnswerAndResult = () => {
    
    return (
        <Grid container style={{
            marginBottom: "20px", 
            maxHeight: "50px", 
            border: "5px solid", 
            padding: "10px", 
            borderColor: Colors.BILBOARD_MAIN_ALTERNATIVE, 
            borderRadius: "10px",
            fontSize: "18px",
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            align: "center",
            letterSpacing: "1px",
            display: "flex",
            justifyContent: "center",
            }}>     
                CHOICE_TEXT - RESULTS_AND_COUNTS
            
        </Grid>
    )
}

 export default AnswerAndResult;