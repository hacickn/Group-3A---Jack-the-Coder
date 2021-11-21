import * as React from 'react';
import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "../components/BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import BilboardTextField from "./BilboardTextField";
import Colors from "../utils/Colors";
import { Alert, Card, Snackbar, TextField } from "@mui/material";
import IconButton from "@mui/material/IconButton";
import { AddAlert, AddBox, DeleteForever, RemoveOutlined } from "@mui/icons-material";

/**
 * Add Survey Dialog
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const AddSurveyDialog = ( props ) => {
    const [ warning, setWarning ] = React.useState( "" )
    const [ textValue, setTextValue ] = React.useState( "" )
    const [ choices, setChoices ] = React.useState( [ {
        title: "It was great!"
    },
        {
            title: "I dont like it"
        },
        {
            title: "It was fantastic!"
        },
        {
            title: "So far so good!So far so good!So far so good!So far so good!So far so ood!So far so good!So far so good!So far so good!So far so good!So far so gSo far so good!So far so good!So far so good!So far so good!So far so good!So far so gSo far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!So far so good!"
        },
        {
            title: "So far so good!"
        }
    ] )

    function handleDeletion( title ) {
        title = title.trim()
        let temp = []

        choices.forEach( choice => {
            if ( choice.title !== title ) {
                temp.push( choice )
            }
        } )

        setChoices( temp )
    }

    function handleAddition( title ) {
        let check = true
        title = title.trim()

        choices.forEach( choice => {
            if ( choice.title === title ) {
                check = false
            }
        } )

        if ( check ) {
            let temp = [ ...choices ]
            temp.push( { title: title } )
            setChoices( temp )
        } else {
            setWarning( "This choice was already added!" )
        }
    }

    return (
        <Dialog open={ props.open } fullWidth maxWidth={ "md" }
                onClose={ () => props.setOpen( false ) }>
            <DialogContent>
                <Grid container>
                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >
                            Add Survey
                        </p>
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
                        >Survey Question</p>
                    </Grid>
                    <Grid item xs={ 12 } style={ {
                        marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                    } }>
                        <BilboardMultilineTextField
                            label="Survey Question"
                            type="surveyQuestion"
                            width="500px"
                            rows="7"
                            style={ { marginTop: "30px" } }
                        />
                    </Grid>


                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "18px",
                                marginTop: "30px",
                                marginBottom: "10px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                letterSpacing: "1px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >Choices</p>
                    </Grid>
                    <Grid container style={ {
                        maxHeight: "200px",
                        overflowX: "hidden",
                        overflowY: "scroll",
                        marginLeft: "170px",
                        marginRight: "170px"
                    } }>
                        {
                            choices.map( choice => {
                                return ( <Grid item xs={ 12 } style={ { display: "flex", justifyContent: "center" } }>
                                    <Card elevation={ 0 } style={ {
                                        width: "440px",
                                        marginTop: 10,
                                        borderRadius: Constants.BORDER_RADIUS,
                                        background: Colors.BILBOARD_RED_ALTERNATIVE
                                    } }>
                                        <Grid container style={ { alignItems: "stretch" } }>
                                            <Grid item xs={ 11 }
                                                  style={ { fontSize: 12, alignItems: "center", padding: 8, } }>
                                                { choice.title }
                                            </Grid>
                                            <Grid item xs={ 1 }
                                                  style={ {
                                                      background: Colors.BILBOARD_RED,
                                                      alignItems: "center",
                                                      justifyItems: "center",
                                                      display: "flex"
                                                  } }>
                                                <IconButton
                                                    onClick={ () => handleDeletion( choice.title ) }
                                                    style={ {
                                                        borderRadius: 0,
                                                    } }>
                                                    <DeleteForever/>
                                                </IconButton>
                                            </Grid>
                                        </Grid>
                                    </Card>
                                </Grid> )
                            } )
                        }
                    </Grid>
                    <Grid container style={ { justifyContent: "center", display: "flex", marginTop: 8, } }>
                        <Card elevation={ 0 } style={ {
                            width: "460px",
                            marginTop: 10,
                            borderRadius: Constants.BORDER_RADIUS,
                            background: Colors.BILBOARD_BLUE_ALTERNATIVE
                        } }>
                            <Grid container style={ { alignItems: "stretch" } }>
                                <Grid item xs={ 10 }
                                      style={ { fontSize: 12, alignItems: "center", padding: 8, } }>
                                    <BilboardTextField onChange={ ( event ) => setTextValue( event.target.value ) }
                                                       value={ textValue } width={ "360px" }/>
                                </Grid>
                                <Grid item xs
                                      style={ {
                                          background: Colors.BILBOARD_BLUE,
                                          alignItems: "center",
                                          justifyItems: "center",
                                          display: "flex",
                                          cursor: "pointer",
                                      } }>
                                    <IconButton
                                        onClick={ () => {
                                            if ( textValue.trim().length > 0 ) {
                                                handleAddition( textValue )
                                                setTextValue( "" )
                                            } else {
                                                setWarning( "Choice can not be empty!" )
                                            }


                                        } }
                                        style={ {
                                            borderRadius: 0,
                                            width: "70px"
                                        } }>
                                        <AddBox/>
                                    </IconButton>
                                </Grid>
                            </Grid>
                        </Card>
                    </Grid>

                    <Grid item xs={ 12 }>
                        <p
                            style={ {
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "18px",
                                marginTop: "10px",
                                marginBottom: "1px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                letterSpacing: "1px",
                                display: "flex",
                                justifyContent: "center",
                            } }
                        >End Date</p>
                    </Grid>

                    <Grid item xs={ 12 } style={ {
                        marginTop: "10px",
                        marginBottom: "10px",
                        align: "center",
                        display: "flex",
                        justifyContent: "center",
                    } }>
                        <BilboardTextField width={ "300px" } type={ "datetime-local" }/>
                    </Grid>

                    <Grid item xs={ 12 } style={ {
                        marginTop: "40px",
                        display: "flex",
                        justifyContent: "center"
                    } }>
                        <BilboardButton width="200px" fontSize="14px" text="Add Survey"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button
                    onClick={ () => props.setOpen( false ) }
                    style={ {
                        display: "flex",
                        justifyContent: "center"
                    } }
                >Cancel</Button>
            </DialogActions>
            <Snackbar open={ warning.length > 0 }
                      anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                      autoHideDuration={ 3000 }

                      onClose={ () => setWarning( "" ) }
            >
                <Alert
                    style={ {
                        padding: 20,
                    } }
                    onClose={ () => setWarning( "" ) }
                    severity={ "warning" }
                >
                    { warning }
                </Alert>
            </Snackbar>
        </Dialog>

    )
}

export default AddSurveyDialog;