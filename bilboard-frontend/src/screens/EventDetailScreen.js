import Grid from "@mui/material/Grid";
import Rating from '@mui/material/Rating';
import Constants from "../utils/Constants";
import QuestionAnswerCard from "../components/QuestionAnswerCard";
import BilboardButton from "../components/BilboardButton";
import React from 'react'
import BilboardNavbar from "../components/BilboardNavbar";

const EventDetailScreen = () => {

    const questionAnswerList = [
        {
            question: "Question text",
            answer: "Answer text",
        },
        {
            question: "Question text",
            answer: "Answer text",
        },
        {
            question: "Question text",
            answer: "Answer text",
        },
        {
            question: "Question text",
            answer: "Answer text",
        },
    ]

    function addQuestionAnswer(questionAnswerObject) {
        let temp = [...questionAnswerList]

        temp.push({
            question: questionAnswerObject.question,
            answer: questionAnswerObject.answer,
        })
    }

    return (

        <div>
            <Grid container style={{ marginTop: 10}}>
                <Grid item xs={5} style={{ marginTop: 50}}>
                    <Grid container>
                        <Grid container>
                            <Grid item xs={12} style={
                                {
                                    paddingLeft: 12,
                                    marginTop: "5px",
                                    marginLeft: "100px",
                                    color: "black",
                                    display: "flex",
                                    justifyContent: "left",
                                    alignItems: "left",
                                    fontSize: "80%",

                                }}>
                                <div style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                }}>Event Name</div>
                                <Rating name="read-only" defaultValue={2} style={{ marginLeft: "20px" }} readOnly size="large" />
                            </Grid>



                        </Grid>
                        <Grid item xs={12} style={
                            {
                                paddingLeft: 12,
                                marginTop: "5px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "80%",
                            }}>
                            <div style={{
                                fontSize: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            }}>Club Name</div>
                        </Grid>
                        <Grid item xs={12} style={
                            {
                                paddingLeft: 12,
                                marginTop: "5px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "40%",

                            }}>
                            <div style={{
                                fontSize: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            }}>No.of</div>
                        </Grid>

                        <Grid item xs={12}
                            style={{
                                display: "flex",
                                justifyContent: "center",
                                alignItems: "center",
                            }}>
                            <img src="
                        https://relearnalanguage.com/wp-content/uploads/2021/01/language-club-activities.jpg"style={
                                    {

                                        marginLeft: "20px",
                                        backgroundSize: "cover",
                                        width: "600px",
                                        height: "600px",
                                        borderRadius: "10px",

                                    }}>
                            </img>
                        </Grid>
                    </Grid>

                </Grid>
                <Grid item xs={7}>
                    <Grid container>
                        <Grid item xs={12} style={
                            {
                                padding: 20,
                                fontSize: 48,
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                marginTop: "20px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "120%",

                            }}>
                            <Grid >
                                <div style={{ fontSize: 28, fontWeight:"bold", fontFamily: Constants.OXYGEN_FONT_FAMILY , textAlign : "justify"}}>
                                Event Details
                                </div>
                                <div style={{ fontSize: 18, fontFamily: Constants.OXYGEN_FONT_FAMILY , textAlign : "justify", marginRight: 70 }}>
                                     Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.
                                </div>

                            </Grid>

                        </Grid>
                        <Grid item xs={12} style={
                            {
                                padding: 20,
                                fontSize: 48,
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                marginTop: "20px",
                                marginLeft: "100px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "120%",

                            }}>
                             <div style={{ fontSize: 28, fontWeight:"bold", fontFamily: Constants.OXYGEN_FONT_FAMILY , textAlign : "justify", marginRight: 70}}>
                                Event Location: Online
                                </div>
                        </Grid>
                        <Grid item xs={12} >
                            <Grid container
                                style={{ borderRadius: Constants.BORDER_RADIUS }}>
                                <Grid item xs={12} style={{ padding: 20, fontSize: 38, fontFamily: Constants.OXYGEN_FONT_FAMILY, fontWeight:"bold" }}>
                                    Question and Answer
                                </Grid>
                                <Grid container style={{ maxHeight: "100vh", overflowY: "scroll", marginLeft: 80, marginRight: 70 }}>
                                    {questionAnswerList.map(questionAnswer => <QuestionAnswerCard questionAnswer={questionAnswer} />)}
                                </Grid>

                                <Grid item xs={12} style={{
                                    marginTop: "25px",
                                    display: "flex",
                                    justifyContent: "center",
                                    alignItems: "center",

                                }}>
                                    <BilboardButton width="160px" height="40px" fontSize="16px" text="Ask a question" />
                                </Grid>

                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </div>
    )
}

export default EventDetailScreen;