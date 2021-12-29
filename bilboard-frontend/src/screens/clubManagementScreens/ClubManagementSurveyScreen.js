import { Grid } from "@mui/material";
import Constants from "../../utils/Constants";
import BilboardButton from "../../components/BilboardButton";
import SurveyCard from "./clubManagementComponents/SurveyCard";
import AddSurveyDialog from "./clubManagementComponents/AddSurveyDialog";
import React from 'react'

/**
 * Club Management Survey Screen
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const ClubManagementSurveyScreen = ({club,functionList}) => {
    const [ addSurveyDialog, setAddSurveyDialog ] = React.useState( false )

    return (
        <Grid container style={ {
            padding: 20,
        } }>
            <Grid style={ {
                marginTop: 15,
                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                fontSize: 48,
                paddingBottom: 20,
            } } item xs={ 12 }>
                Surveys
            </Grid>

            <Grid container style={ {
                display: "flex",
                alignItems: "center",
                minHeight: "340px",
                maxHeight: "340px",
                maxWidth: "100vw",
                overflowY: "hidden",
                overflowX: "scroll",
                flexWrap: "nowrap",
                justifyContent: "start",
                marginRight: "20px",
                paddingBottom: "10px",
                marginTop: "10px",
            } }>
                { club.surveys.map( survey => <div style={{padding:4}}><SurveyCard survey={ survey }/></div> ) }
            </Grid>

            <Grid item xs={ 12 } style={ {
                marginTop: 50,
            } }>
                <BilboardButton onClick={ () => {
                    setAddSurveyDialog( true )
                } } width="220px" fontSize="14px"
                                text="Add Survey"/>
            </Grid>
            <AddSurveyDialog functionList={functionList} club={club} open={ addSurveyDialog } setOpen={ ( val ) => setAddSurveyDialog( val ) }/>
        </Grid>

    )
}

export default ClubManagementSurveyScreen;