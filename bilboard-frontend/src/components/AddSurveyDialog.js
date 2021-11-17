import * as React from 'react';
import Grid  from "@mui/material/Grid";
import BilboardMultilineTextField from "../components/BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import SurveyChoices from "./SurveyChoices";
import AdapterDateFns from '@mui/lab/AdapterDateFns';
import LocalizationProvider from '@mui/lab/LocalizationProvider';
import { TextField } from '@mui/material';
import { useState } from 'react';
import DatePicker from '@mui/lab/DatePicker';

/**
 * Add Survey Dialog
 * 
 * Metehan Saçakçı
 * 17.11.2021
 */

 function App() {
    return (
      <LocalizationProvider dateAdapter={AdapterDateFns}>...</LocalizationProvider>
    );
  }

const AddSurveyDialog = () =>{
    const [isDialogOpen, setIsDialogOpen] = useState(true);
    const [value, setValue] = React.useState(null);

    return(
        <Dialog open={isDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    <Grid item xs={12}>
                        <p
                            style={{
                                color: "#616161",
                                fontSize: "44px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            }}
                        >
                            Add Survey
                        </p>                       
                        <p
                        style={{
                            color: "#616161",
                            fontSize: "18px",
                            marginBottom: "1px",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            align: "center",
                            letterSpacing: "1px",
                            display: "flex",
                            justifyContent: "center",
                        }}      
                    >Survey Question</p>
                    </Grid>
                    <Grid item xs={12} style={{marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                        }}>
                        <BilboardMultilineTextField
                            label="Survey Question"
                            type="surveyQuestion"
                            width="300px"
                            rows="7"
                            style={{marginTop: "30px"}}
                        />
                    </Grid>


                    <Grid item xs={12}>
                        <p
                            style={{
                                color: "#616161",
                                fontSize: "18px",
                                marginTop: "30px",
                                marginBottom: "10px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                letterSpacing: "1px",
                                display: "flex",
                                justifyContent: "center",
                            }}      
                        >Choices</p>
                    </Grid>

                    <Grid item xs={7} style={{
                        display: "flex",
                        justifyContent: "center",
                        marginTop: "10px",
                        marginBottom: "10px",
                    }}>
                        <SurveyChoices/>
                    </Grid>

                    <Grid item xs={5}>
                        <Grid item xs={12} style={{
                            marginTop: "50px",
                            marginBottom: "10px",
                            marginLeft: "15px",
                            marginRight: "5px",
                            justifyContent: "center",
                        }}>
                            <BilboardButton width="100px" fontSize="14px" text="Choice Name" />
                        </Grid>

                        <Grid item xs={12} style={{
                            marginTop: "10px",
                            marginBottom: "10px",
                            marginLeft: "22px",
                            marginRight: "5px",
                            justifyContent: "center",
                        }}>
                            <BilboardButton width="100px" fontSize="14px" text="Add Choice" />
                        </Grid>
                    </Grid>

                    <Grid item xs={12}>
                        <p
                            style={{
                                color: "#616161",
                                fontSize: "18px",
                                marginTop: "10px",
                                marginBottom: "1px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                align: "center",
                                letterSpacing: "1px",
                                display: "flex",
                                justifyContent: "center",
                            }}      
                        >End Date</p>
                    </Grid>

                    <Grid item xs={12} style={{
                        marginTop: "10px",
                        marginBottom: "10px",
                        align: "center",
                        display: "flex",
                        justifyContent: "center",
                    }}>
                        <LocalizationProvider dateAdapter={AdapterDateFns}>
                            <DatePicker
                                label="End Date"
                                value={value}
                                onChange={(newValue) => {
                                setValue(newValue);
                                }}
                                renderInput={(params) => <TextField {...params} />}
                            />
                        </LocalizationProvider>
                    </Grid>

                    <Grid item xs={12} style={{marginTop: "40px",                  
                        display: "flex",
                        justifyContent: "center"}}>                         
                        <BilboardButton width="100px" fontSize="14px" text="Add Survey"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button 
                    onClick={() => setIsDialogOpen(false)}
                    style= {{
                        display: "flex",
                        justifyContent: "center"
                    }}
                    >Cancel</Button>
            </DialogActions>
        </Dialog>

    )
}

export default AddSurveyDialog;