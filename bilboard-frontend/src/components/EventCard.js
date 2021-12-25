import { useState } from "react";
import Grid from "@mui/material/Grid";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import PersonIcon from "@mui/icons-material/Person";
import { makeStyles } from "@mui/styles";
import { connect } from "react-redux";

const useStyles = makeStyles( {
    root: {
        width: "260px",
        height: "260px",
        filter: "brightness(80%)",
        cursor: "pointer",
        borderRadius: "16px",
        backgroundSize: "260px 260px",
        backgroundRepeat: "no-repeat",
        transition: "transform .4s",
        "&:hover": {
            transform: "scale(1.2)",
            filter: "brightness(100%)",
        },
    },
} );

const EventCard = ( { event, setCurrentScreen, setCurrentEvent, fromBoardMember } ) => {
    const classes = useStyles();
    const [ visible, setVisible ] = useState( true );

    const handleEventCardClick = () => {
        if ( fromBoardMember ) {
            setCurrentEvent( event )
            setCurrentScreen( "eventDetailBoardMember" )
        } else {
            setCurrentEvent( event )
            setCurrentScreen( "eventDetail" )
        }
    }
    return (
        <div
            className={ classes.root }
            style={ {
                backgroundImage: `url(${
                    process.env.REACT_APP_IMAGE_URL + event.eventPhoto
                })`,
            } }
            onMouseOver={ () => setVisible( false ) }
            onMouseLeave={ () => setVisible( true ) }
            onClick={ () => handleEventCardClick() }
        >
            <Grid
                container
                style={ {
                    minHeight: "16%",
                    backgroundColor: "rgba(0,0,0,0.3)",
                    borderRadius: "16px 16px 4px 4px",
                } }
            >
                <Grid
                    item
                    xs={ 6 }
                    style={ {
                        color: "white",
                        display: "flex",
                        justifyContent: "start",
                        paddingLeft: "10px",
                        alignItems: "center",
                    } }
                >
                    <LocationOnIcon/>
                    <div style={ { fontSize: "120%" } }>
                        { event.online ? "Online" : "" }
                    </div>
                </Grid>
                <Grid item xs={ 2 }/>
                <Grid
                    item
                    xs={ 4 }
                    style={ {
                        color: "white",
                        display: "flex",
                        justifyContent: "center",
                        alignItems: "center",
                    } }
                >
                    <PersonIcon/>
                    <div style={ { fontSize: "120%" } }>
                        { event.maxParticipationCount }
                    </div>
                </Grid>
            </Grid>
            { visible && (
                <Grid
                    container
                    style={ {
                        minHeight: "24%",
                        position: "fixed",
                        bottom: "0%",
                        color: "white",
                        backgroundColor: "rgba(0,0,0,0.4)",
                        borderRadius: "4px 4px 16px 16px",
                    } }
                >
                    <Grid
                        item
                        xs={ 12 }
                        style={ {
                            display: "flex",
                            justifyContent: "start",
                            marginLeft: "4%",
                            fontSize: "120%",
                            fontWeight: "bolder",
                        } }
                    >
                        { event.title }
                    </Grid>
                    <Grid
                        item
                        xs={ 12 }
                        style={ {
                            display: "flex",
                            justifyContent: "start",
                            marginLeft: "4%",
                        } }
                    >
                        { event.club.name }
                    </Grid>
                </Grid>
            ) }
        </div>
    );
};

const mapDispatchToProps = ( dispatch ) => {
    return {
        setCurrentScreen: ( screen ) =>
            dispatch( { type: "SET_CURRENT_SCREEN", currentScreen: screen } ),
    };
};

export default connect( null, mapDispatchToProps )( EventCard );
