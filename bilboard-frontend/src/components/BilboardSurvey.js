import {Grid} from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import BilboardButton from "./BilboardButton";

/**
 * Bilboard Survey
 * 
 * Metehan Saçakçı
 * 17.11.2021
 */

const BilboardSurvey = (props) => {
    return(
        <Grid container 
        style={{
            marginBottom: 5,
            marginTop: 5,
            paddingTop: 20,
            paddingBottom: 20,
            borderRadius: Constants.BORDER_RADIUS,
            background: Colors.BILBOARD_BLUE_ALTERNATIVE,
            alignItems: "center",
        }}>
        
            <Grid item xs>
                <img src={props.survey.photo}
                    style={{maxHeight: 100, maxWidth: 100}} />                      
            </Grid>

            <Grid item xs style={{
                fontSize: "26px"
            }}>
                Question: {props.survey.question}                     
            </Grid>

            <Grid item xs>
                <BilboardButton width="120px" height="50px" fontSize="18px" text="Vote"/>
            </Grid>
        </Grid>
    )
}

export default BilboardSurvey;