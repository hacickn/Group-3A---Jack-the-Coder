import Grid  from "@mui/material/Grid";
import BilboardTextField from "../components/BilboardTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../utils/Constants";
import Button from "@mui/material/Button";
import React, {useState} from "react";
import {connect} from "react-redux"
import Colors from "../utils/Colors"

/**
 * Edit Instagram Link Dialog
 * 
 * Metehan Saçakçı
 * 25.12.2021
 */

const EditInstagramLinkDialog  = ({open, setOpen}) => {
    const [ isDialogOpen, setIsDialogOpen ] = useState( true );
    
    return (
        <Dialog open={open} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    <Grid item xs={12}>
                        <p
                            style={{
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "30px",
                                marginBottom: "30px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                letterSpacing: "4px",
                                display: "flex",
                                justifyContent: "center",
                            }}
                        >
                            Edit The Instagram Link
                        </p>                       
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
                    >Please enter the new instagram link</p>
                    </Grid>
                    <Grid item xs={12} style={{marginTop: "20px",
                        display: "flex",
                        justifyContent: "center",
                        }}>
                        <BilboardTextField
                            label=""
                            type="instagramLink"
                            width="300px"
                            style={{marginTop: "30px"}}
                        />
                    </Grid>
                    <Grid item xs={12} style={{marginTop: "40px",                  
                        display: "flex",
                        justifyContent: "center"}}>                         
                        <BilboardButton width="100px" fontSize="14px" text="Submit"/>
                    </Grid>
                </Grid>
            </DialogContent>
            <DialogActions>
                <Button 
                    onClick={ () => setOpen( false ) }
                    style= {{
                        display: "flex",
                        justifyContent: "center"
                    }}
                    >Cancel</Button>
            </DialogActions>
        </Dialog>
    )
}

export default EditInstagramLinkDialog