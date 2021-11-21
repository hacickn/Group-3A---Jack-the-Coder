import { Dialog, Grid } from "@mui/material";

const AddSurveyDialog = ( props ) => {
    return <Dialog fullWidth maxWidth={ "sm" } open={ props.open } onClose={ () => props.onClose() }>
        <Grid container>
            <Grid item xs={ 12 }>
                Add Event
            </Grid>
            <Grid container>

            </Grid>
        </Grid>
    </Dialog>
}

export default AddSurveyDialog