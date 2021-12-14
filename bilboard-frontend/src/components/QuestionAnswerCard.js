import {Grid} from "@mui/material";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";

/**
 * Bilboard Question Answer Card
 *
 * 
 * 14.12.2021
 */

const QuestionAnswerCard = (props) => {
    return (
        <Grid container
              style={{
                  marginBottom: 5,
                  marginTop: 5,
                  marginLeft: 24,
                  marginRight: 24,
                  paddingTop: 20,
                  paddingBottom: 20,
                  borderRadius: Constants.BORDER_RADIUS,
                  background: Colors.BILBOARD_MAIN_ALTERNATIVE,
                  alignItems: "center",
              }}>

            <Grid item xs = {12} style= {{fontSize: "25px"}}>
                Question: {props.questionAnswer.question}
            </Grid>

            <Grid item xs= {12} style={{
                fontSize: "25px",
            }}>
                Answer: {props.questionAnswer.answer}
            </Grid>

        </Grid>
    )
}

export default QuestionAnswerCard;