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
            >CHOICE_TEXT - RESULTS_AND_COUNTS</p>
            </Grid>
            <Grid item xs={12} style={{marginTop: "20px",
                display: "flex",
                justifyContent: "center",
                }}>
                
            </Grid>
        </Grid>
    )
}

 export default AnswerAndResult;