import AnswerAndResult from "./AnswerAndResult";
import { Grid } from "@mui/material";
import Constants from "../utils/Constants";

const QuestionAndAnswersAndResult = ({question}) => {

    const answerAndResultList = [
        {
          choice: "Choice1",
          voteCount: 25,
        },
        {
          choice: "Choice2",
          voteCount: 30,
        },
        {
          choice: "Choice3",
          voteCount: 40,
        },
    ]    


    return (
        <div>
            <Grid item xs={ 12 } style={ {
                                fontSize: 24,
                                textAlign: "start",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }>
                                Q: {question.question}
                            </Grid>
            <Grid container style={{height: "40vh",overflowY: "scroll", padding: "10px" }}>
                {question.choices.map((choice) => (
                
                    <AnswerAndResult choice={choice} />
                
                ))}
            </Grid>
        </div>
    )
};

export default QuestionAndAnswersAndResult