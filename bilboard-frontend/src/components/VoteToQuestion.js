import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Grid from "@mui/material/Grid";
import Colors from "../utils/Colors";
import Constants from "../utils/Constants";
import React from "react";

/**
 * Vote To Question
 *
 * Date: 23.12.2021
 * Metehan Saçakçı
 */

const VoteToQuestion = ( { question, addNewChoices } ) => {


    const [ currentOption, setCurrentOption ] = React.useState()


    return (
        <Grid container style={ {
            marginBottom: "20px",
            border: "5px solid",
            padding: "10px",
            borderColor: Colors.BILBOARD_MAIN_ALTERNATIVE,
            borderRadius: "10px"
        } }>
            <Grid item xs={ 12 }>
                <p
                    style={ {
                        color: Colors.BILBOARD_LIGHT_GREY,
                        fontSize: "18px",
                        marginBottom: "1px",
                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        align: "center",
                        letterSpacing: "1px",
                        display: "flex",
                        justifyContent: "center",
                    } }
                >Question: {question.question}</p>
            </Grid>
            <Grid item xs={ 12 } style={ {
                marginTop: "20px",
                display: "flex",
                justifyContent: "center",
            } }>
                <FormControl component="fieldset">
                    <FormLabel component="legend"/>
                    <RadioGroup
                        aria-label="choice"
                        defaultValue=""
                        name="radio-buttons-group"
                        onChange={ ( e ) => {
                            addNewChoices( currentOption, e.target.value )
                            setCurrentOption( e.target.value )
                        } }
                    >
                        { question.choices.map( choice => {
                            return <FormControlLabel value={ choice.id } control={ <Radio/> } label={ choice.content }/>
                        } ) }
                    </RadioGroup>
                </FormControl>
            </Grid>
        </Grid>
    )
}

export default VoteToQuestion;