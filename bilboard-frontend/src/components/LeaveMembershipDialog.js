import Grid  from "@mui/material/Grid";
import BilboardMultilineTextField from "./BilboardMultilineTextField";
import BilboardButton from "../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import React, {useState} from "react";

/**
 * Leave Membership Dialog
 * 
 * Metehan Saçakçı
 * 16.11.2021
 */

 const LeaveMembershipDialog  = () => {
    const [isDialogOpen, setIsDialogOpen] = useState(true);
    
    return (
        <Dialog open={isDialogOpen} fullWidth maxWidth={"sm"}
                onClose={() => setIsDialogOpen(false)}>
            <DialogContent>            
                <Grid container>
                    <Grid item xs={12}>
                        <p
                            style={{
                                color: Colors.BILBOARD_LIGHT_GREY,
                                fontSize: "44px",
                                marginTop: "10px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                display: "flex",
                                justifyContent: "center",
                            }}
                        >
                            Leave Membership
                        </p>                       
                    </Grid>
                
                    <Grid item xs={12}>                    
                        <p
                        style={{
                            color: Colors.BILBOARD_LIGHT_GREY,
                            fontSize: "16px",
                            marginBottom: "1px",
                            fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            align: "center",
                            display: "flex",
                            justifyContent: "center",
                        }}      
                    >Would you like to leave your membership?</p>                    
                    </Grid>

                    <Grid container style={{marginBottom: "15px"}}>
                        <Grid item xs={6} style={{marginTop: "50px",                  
                            display: "flex",
                            justifyContent: "center"}}>                         
                            <BilboardButton width="100px" fontSize="11px" text="Yes"/>
                         </Grid>
                        
                         <Grid item xs={6} style={{marginTop: "50px",                  
                            display: "flex",
                            justifyContent: "center"}}>                         
                            <BilboardButton 
                                width="100px" 
                                fontSize="11px" 
                                text="No" onClick={() => setIsDialogOpen(false)}
                                    style= {{
                                    display: "flex",
                                    justifyContent: "center"
                                    }}/>
                         </Grid>
                    </Grid>         
                </Grid>
            </DialogContent>
        </Dialog>
    )
}

export default LeaveMembershipDialog;