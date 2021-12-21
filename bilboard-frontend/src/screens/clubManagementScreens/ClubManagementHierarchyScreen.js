//import * as React from 'react';
//import Grid from "@mui/material/Grid";
//import BilboardMultilineTextField from "../components/BilboardMultilineTextField";
//import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
//import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
//import BilboardTextField from "./BilboardTextField";
//import Colors from "../utils/Colors";
import { Alert, Card, Snackbar, TextField } from "@mui/material";
//import IconButton from "@mui/material/IconButton";
import { AddAlert, AddBox, DeleteForever, RemoveOutlined } from "@mui/icons-material";
import {
    FormControlLabel,
    Grid,
    IconButton,
    Radio,
    RadioGroup,
} from "@mui/material";
import BilboardTextField from "../../components/BilboardTextField";
import BilboardMultilineTextField from "../../components/BilboardMultilineTextField";
import BilboardButton from "../../components/BilboardButton";
import Colors from "../../utils/Colors";
import Checkbox from "@mui/material/Checkbox";
import Constants from "../../utils/Constants";
import { ImageOutlined } from "@mui/icons-material";
import { FormGroup } from "@mui/material";
import { makeStyles } from "@mui/styles";
import React from "react";

const useStyles = makeStyles({
    textGrid: {
        display: "flex",
        justifyContent: "end",
        paddingRight: "20px",
        fontFamily: Constants.OXYGEN_FONT_FAMILY,
    },
    inputGrid: {
        display: "flex",
        justifyContent: "start",
    },
    rowGrid: {
        paddingTop: "10px",
    },
});

const ClubManagementHierarchyScreen = () => {
    const classes = useStyles();
    const [isOnline, setIsOnline] = React.useState("online");
    const [isForMember, setIsForMember] = React.useState(false);
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
        <Grid
            container
            style={{
                paddingTop: 20,
            }}
        >
            <Grid item xs={3}></Grid>
            <Grid item xs={6}>
                <Grid container>
                    <Grid
                        item
                        xs={12}
                        style={{
                            padding: 20,
                            fontSize: 48,
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                        }}
                    >
                        Add Event
                    </Grid>

                    <Grid container>
                        <Grid container className={classes.rowGrid}>
                            <Grid item xs={5} className={classes.textGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                President
                            </Grid>
                            <Grid item xs={7} className={classes.inputGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,

                                }}>
                                Yaaaas
                            </Grid>
                        </Grid>
                        <Grid container>
                            <Grid container className={classes.rowGrid}>
                                <Grid item xs={5} className={classes.textGrid}  style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                    Board members
                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid}  style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                }}>
                                    Yaaaas
                                </Grid>
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
                            background: Colors.BILBOARD_MAIN_ALTERNATIVE
                        } }>
                            <Grid container style={ { alignItems: "stretch" } }>
                                <Grid item xs={ 10 }
                                      style={ { fontSize: 12, alignItems: "center", padding: 8, } }>
                                    <BilboardTextField onChange={ ( event ) => setTextValue( event.target.value ) }
                                                       value={ textValue } width={ "360px" }/>
                                </Grid>
                                <Grid item xs
                                      style={ {
                                          background: Colors.BILBOARD_MAIN,
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
                            <Grid container className={classes.rowGrid} style={{
                                    fontSize: "30px",
                                    fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    fontStyle: 'italic',
                                    fontWeight: 'bold'
                                }}>
                                <Grid item xs={5} className={classes.textGrid}>
                                    Add Board Member
                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid} style={ { marginTop: "10px" } }
                                    >
                                    <BilboardTextField label="Name" width={ '280px' }/>

                                </Grid>

                            </Grid>
                            <Grid container className={classes.rowGrid}>
                                <Grid item xs={5} className={classes.textGrid}>

                                </Grid>
                                <Grid item xs={7} className={classes.inputGrid} style={ { marginBottom: "10px" } }
                                    >
                                    <BilboardTextField label="Bilkent ID" width={ '280px' }/>

                                </Grid>
                            </Grid>
                            <Grid
                                container
                                style={{
                                    display: "flex",
                                    justifyContent: "center",
                                    paddingTop: "20px",
                                }}
                            >
                                <BilboardButton fontSize={"14px"} text={"Add"} width={"200px"} />
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
            <Grid item xs={3}></Grid>
        </Grid>
    );
};

export default ClubManagementHierarchyScreen;
