import Grid from "@mui/material/Grid";
import Rating from '@mui/material/Rating';
import Constants from "../utils/Constants";
import EditEventDialog from "../components/EditEventDialog";
import BilboardQuestionCard from "../components/BilboardQuestionCard";
import BilboardButton from "../components/BilboardButton";
import React from 'react'

const EventDetailedScreenBoardMember = () => {
    const [ editEventDialog, setEditEventDialog ] = React.useState( false )

    const questionList = [
        {
            content: "Which would you rather do: wash dishes, mow the lawn, clean the bathroom, or vacuum the house?",
        },
        {
            content: "If you could hire someone to help you, would it be with cleaning, cooking, or yard work?2",
        },
        {
            content: "If you could hire someone to help you, would it be with cleaning, cooking, or yard work?3",
        },
        {
            content: "What is your proudest accomplishment?",
        },
    ]

    const editedEventList = [

        {
            title: "Yas yas yaas",
            description: "Yaas, yas yyas!!",
            numberOfParticipants: 125,
            Ge2501: 15,
        }

    ]

    function addQuestion(questionObject) {
        let temp = [...questionList]

        temp.push({
            content: questionObject.content,
        })
    }

    function addEditedEvent(editedEventObject) {
        let temp = [...editedEventList]

        temp.push({
            title: editedEventObject.title,
            description: editedEventObject.description,
        })
    }

    return (

        <div>
            { <EditEventDialog open={ editEventDialog } setOpen={ ( status ) => {
                setEditEventDialog( status )
            } }/> }
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
                                <Rating name="read-only" defaultValue={2} style={{ paddingLeft: "290px" }} readOnly size="large" />
                            </Grid>



                        </Grid>
                        <Grid item xs={12} style={
                            {
                                paddingLeft: 12,
                                marginTop: "10px",
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
                        <Grid item xs={7} style={
                            {
                                paddingLeft: "115px",
                                marginTop: "10px",
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
                        <Grid xs = {5}>
                            
                            <BilboardButton
                                width="160px"
                                fontSize="13px"
                                text="Generate Code"
                                color="#00e676"
                                />
                        </Grid>
                        

                        <Grid item xs={12}
                            style={{
                                marginTop: "40px",
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

                            }}>
                            <Grid xs={9}>
                                <div style={{ fontSize: 28, fontWeight:"bold", fontFamily: Constants.OXYGEN_FONT_FAMILY , textAlign : "justify"
                            }}>
                                Event Details
                                </div>
                                <div style={{ fontSize: 18, fontFamily: Constants.OXYGEN_FONT_FAMILY , textAlign : "justify", marginRight: 70, marginTop:10}}>
                                     Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.
                                </div>

                            </Grid>
                            <Grid xs = {3}
                            style={{
                                marginTop:"60px",
                            }}>
                            
                            <BilboardButton
                                onClick={ () => setEditEventDialog( true ) }
                                width="180px"
                                fontSize="20px"
                                text= "Edit Event"
                                color="#FF4B4B"
                                height="100px"
                                />
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
                                <Grid container style={{ maxHeight: "40vh", overflowY: "scroll", marginLeft: 80, marginRight: 70 }}>
                                    {questionList.map(question => <BilboardQuestionCard question={question} />)}
                                </Grid>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </div>
    )
}

export default EventDetailedScreenBoardMember;