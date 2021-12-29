import Grid from "@mui/material/Grid";
import Constants from "../../utils/Constants";
import { makeStyles } from "@mui/styles";
import RequestedMembership from "./clubManagementComponents/RequestedMembership";
import PendingMembership from "./clubManagementComponents/PendingMembership";

const useStyles = makeStyles( {
    container: {
        height: "80vh",
    },
} );

const ClubManagementMembershipRequestsScreen = ( { club,functionList } ) => {
    const classes = useStyles();
    return (
        <div>
            <div style={ { fontSize: "36px", marginBottom: "10px" } }>
                Membership Requests
            </div>
            <div style={ { fontSize: "18px", marginBottom: "10px" } }>
                (A: Accept, P: Pending, R: Reject)
            </div>
            <Grid container>
                <Grid item xs={ 6 }>
                    <div className={ classes.container }>
                        <div
                            style={ {
                                fontSize: "24px",
                                fontWeight: "bolder",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                marginBottom: "10px",
                            } }
                        >
                            Requests
                        </div>
                        <div>
                            <Grid container style={ { marginLeft: "2%" } }>
                                { club.enrollRequests.map( ( request ) => {
                                    if ( request.status === "created" ) {
                                        return <Grid item xs={ 12 }>
                                            <RequestedMembership
                                                functionList={functionList}
                                                requestId={ request.id }
                                                name={ request.user.name }
                                                surname={ request.user.surname }
                                                ID={ request.user.bilkentId }
                                            />
                                        </Grid>
                                    }
                                } ) }
                            </Grid>
                        </div>
                    </div>
                </Grid>
                <Grid item xs={ 6 }>
                    <div className={ classes.container }>
                        <div
                            style={ {
                                fontSize: "24px",
                                fontWeight: "bolder",
                                marginBottom: "10px",
                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                            } }
                        >
                            Pending
                        </div>
                        <div>
                            <Grid container style={ { marginLeft: "2%" } }>
                                <Grid item xs={ 12 }>
                                    { club.enrollRequests.map( ( request ) => {
                                        if ( request.status === "pending" ) {
                                            return <Grid item xs={ 12 }>
                                                <PendingMembership
                                                    functionList={functionList}
                                                    requestId={ request.id }
                                                    name={ request.user.name }
                                                    surname={ request.user.surname }
                                                    ID={ request.user.bilkentId }/>
                                            </Grid>
                                        }
                                    } ) }
                                </Grid>
                            </Grid>
                        </div>
                    </div>
                </Grid>
            </Grid>
        </div>
    );
};

export default ClubManagementMembershipRequestsScreen;
