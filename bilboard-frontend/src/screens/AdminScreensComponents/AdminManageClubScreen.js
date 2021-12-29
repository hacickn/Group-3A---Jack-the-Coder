import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";
import React from "react";
import { CircularProgress, Snackbar, TextField } from "@mui/material";
import Constants from "../../utils/Constants";
import Env from "../../utils/Env";
import { Autocomplete } from "@mui/lab";
import axios from "axios";
import Alert from "@mui/material/Alert";

const AdminManageClubScreen = ( { allClubs, getClubs, clubLoading, setClub } ) => {
    const [ currentClub, setCurrentClub ] = React.useState( null )
    const [ searchOpen, setSearchOpen ] = React.useState( false )
    const [ searchOpenForAdvisor, setSearchOpenForAdvisor ] = React.useState( false )
    const [ options, setOptions ] = React.useState( [] );
    const [ optionsForAdvisor, setOptionsForAdvisor ] = React.useState( [] );
    const loading = searchOpen && options.length === 0;
    const loadingForAdvisor = searchOpenForAdvisor && optionsForAdvisor.length === 0;
    const [ newAdvisor, setNewAdvisor ] = React.useState( "" )
    const [ newPresident, setNewPresident ] = React.useState( "" )
    const [ error, setError ] = React.useState( '' )
    const [ success, setSuccess ] = React.useState( '' )
    const [ submitted, setSubmitted ] = React.useState( false )

    if ( allClubs === null ) {
        getClubs()
    }

    function handlePresidentAndAdvisorChange() {
        setSubmitted( true )
        let headers = {
            "Content-Type": "application/json",
            'Authorization': 'Bearer ' + Env.TOKEN
        }

        axios.post(
            process.env.REACT_APP_URL + "admin/president?clubId=" + currentClub.id + "&userId=" + newPresident.id,
            {}, { headers: headers } )
             .then( function ( presidentResponse ) {
                 if ( presidentResponse.status === 200 ) {
                     axios.post( process.env.REACT_APP_URL + "admin/advisor?clubId=" + currentClub.id + "&userId=" +
                         newAdvisor.id, {}, { headers: headers } )
                          .then( function ( advisorResponse ) {
                              if ( advisorResponse.status === 200 ) {
                                  setSuccess( "Advisor and President is updated!" )
                                  let tempClub = { ...currentClub }
                                  tempClub.advisor = newAdvisor
                                  tempClub.president = newPresident
                                  setCurrentClub( tempClub )
                                  setClub( newAdvisor, newPresident, currentClub.id )
                                  setSubmitted( false )
                              } else {
                                  setSubmitted( false )
                                  setError( "Something went wrong!" )
                              }

                          } )
                          .catch( function ( error ) {
                              setSubmitted( false )
                              setError( "Something went wrong!" )
                          } )
                 } else {
                     setSubmitted( false )
                     setError( "Something went wrong!" )
                 }
             } )
             .catch( function ( error ) {
                 setError( "Something went wrong!" )
                 setSubmitted( false )
             } )


    }


    React.useEffect( () => {
        let active = true;


        if ( !loading ) {
            return undefined;
        }

        ( async () => {


            const response = await fetch(
                process.env.REACT_APP_URL + 'user/search?name=' + '&type=student', {
                    method: 'GET', headers: {
                        "Content-Type": "application/json",
                        'Authorization': 'Bearer ' + Env.TOKEN
                    }
                }, )

            const temp = await response.json();

            if ( active ) {
                setOptions( [ ...temp ].map( ( user ) => {
                    return user
                } ) );
            }
        } )();

        return () => {
            active = false;
        };
    }, [ loading ] );

    React.useEffect( () => {
        if ( !searchOpen ) {
            setOptions( [] );
        }
    }, [ searchOpen ] );


    React.useEffect( () => {
        let active = true;
        if ( !loadingForAdvisor ) {
            return undefined;
        }

        ( async () => {

            const response = await fetch(
                process.env.REACT_APP_URL + 'user/search?name=' + '&type=academic', {
                    method: 'GET', headers: {
                        "Content-Type": "application/json",
                        'Authorization': 'Bearer ' + Env.TOKEN
                    }
                }, )

            const temp = await response.json();

            if ( active ) {
                setOptionsForAdvisor( [ ...temp ].map( ( user ) => {
                    return user
                } ) );
            }
        } )();

        return () => {
            active = false;
        };
    }, [ loadingForAdvisor ] );

    React.useEffect( () => {
        if ( !searchOpenForAdvisor ) {
            setOptionsForAdvisor( [] );
        }
    }, [ searchOpenForAdvisor ] );

    return (
        <div>
            { clubLoading ? <CircularProgress/> :
                <Grid container>
                    <Grid item xs={ 4 }>
                        <div style={ { maxHeight: "800px", overflowY: "scroll" } }>
                            { allClubs.map( ( club, index ) => (
                                <div
                                    key={ index }
                                    style={ {
                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                        fontSize: "20px",
                                        marginTop: "10px",
                                        marginBottom: "10px",
                                    } }
                                >
                                    <BilboardButton
                                        fontSize="20px"
                                        width="80%"
                                        text={ club.shortName }
                                        onClick={ () => setCurrentClub( club ) }
                                    />
                                </div>
                            ) ) }
                        </div>
                    </Grid>
                    <Grid item xs={ 8 } style={ { display: "flex", justifyContent: "center" } }>
                        <div>
                            { !currentClub && (
                                <div
                                    style={ {
                                        fontSize: "34px",
                                        paddingTop: 40,
                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                    } }
                                >
                                    Please select a club to manage.
                                </div>
                            ) }
                            { currentClub && (
                                <Grid container>
                                    <Grid item xs={ 12 } style={ { fontSize: "34px", marginTop: "40px" } }>
                                        { currentClub.name }
                                    </Grid>
                                    <Grid item xs={ 12 } style={ { marginTop: "20px" } }>
                                        <Grid container>
                                            <Grid item xs={ 6 }>
                                                <div
                                                    style={ {
                                                        marginTop: "12px",
                                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                        fontSize: "14px",
                                                        fontWeight: "bolder",
                                                    } }
                                                >
                                                    Club Advisor:
                                                </div>
                                            </Grid>
                                            <Grid item xs={ 4 }
                                                  style={ {
                                                      marginTop: "12px",
                                                      fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                      fontSize: "14px",
                                                      fontWeight: "bolder",
                                                  } }>
                                                { currentClub.advisor !== null ?
                                                    currentClub.advisor.name + " " + currentClub.advisor.surname +
                                                    " " + currentClub.advisor.bilkentId : "Empty" }
                                            </Grid>
                                        </Grid>
                                    </Grid>

                                    <Grid item xs={ 12 } style={ { marginTop: "10px" } }>
                                        <Grid container>
                                            <Grid item xs={ 6 }>
                                                <div
                                                    style={ {
                                                        marginTop: "12px",
                                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                        fontSize: "14px",
                                                        fontWeight: "bolder",
                                                    } }
                                                >
                                                    Club President:
                                                </div>
                                            </Grid>
                                            <Grid item xs={ 4 } style={ {
                                                marginTop: "12px",
                                                fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                fontSize: "14px",
                                                fontWeight: "bolder",
                                            } }>
                                                { currentClub.president !== null ?
                                                    currentClub.president.name + " " + currentClub.president.surname +
                                                    " " + currentClub.president.bilkentId : "Empty" }

                                            </Grid>
                                        </Grid>
                                    </Grid>
                                    <Grid item xs={ 12 } style={ { marginTop: "40px" } }>
                                        <Grid container>
                                            <Grid item xs={ 6 }>
                                                <div
                                                    style={ {
                                                        marginTop: "12px",
                                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                        fontSize: "24px",
                                                        fontWeight: "bolder",
                                                    } }
                                                >
                                                    New Club Advisor:
                                                </div>
                                            </Grid>
                                            <Grid item xs={ 4 }>
                                                <Autocomplete
                                                    id="Advisor"
                                                    fullWidth
                                                    open={ searchOpenForAdvisor }
                                                    onOpen={ () => {
                                                        setSearchOpenForAdvisor( true );
                                                    } }
                                                    onClose={ () => {
                                                        setSearchOpenForAdvisor( false );
                                                    } }
                                                    onChange={ ( event, value, reason, details ) => {
                                                        setNewAdvisor( value )
                                                    }
                                                    }
                                                    getOptionSelected={ ( option, value ) => {
                                                        return option.name === newAdvisor.name;
                                                    } }
                                                    getOptionLabel={ ( option ) => option.name + " " + option.surname +
                                                        " " + option.bilkentId }
                                                    options={ optionsForAdvisor }
                                                    loading={ loadingForAdvisor }
                                                    renderInput={ ( params ) => (

                                                        <TextField
                                                            { ...params }
                                                            label="Advisor"
                                                            fullWidth
                                                            InputProps={ {
                                                                ...params.InputProps,
                                                                endAdornment: (
                                                                    <React.Fragment>
                                                                        { loadingForAdvisor ?
                                                                            <CircularProgress color="inherit"
                                                                                              size={ 20 }/> :
                                                                            null }
                                                                        { params.InputProps.endAdornment }
                                                                    </React.Fragment>
                                                                ),
                                                            } }
                                                        />
                                                    ) }
                                                />
                                            </Grid>
                                        </Grid>
                                    </Grid>

                                    <Grid item xs={ 12 } style={ { marginTop: "40px" } }>
                                        <Grid container>
                                            <Grid item xs={ 6 }>
                                                <div
                                                    style={ {
                                                        marginTop: "12px",
                                                        fontFamily: Constants.OXYGEN_FONT_FAMILY,
                                                        fontSize: "24px",
                                                        fontWeight: "bolder",
                                                    } }
                                                >
                                                    New Club President:
                                                </div>
                                            </Grid>
                                            <Grid item xs={ 4 }>
                                                <Autocomplete
                                                    id="President"
                                                    fullWidth
                                                    open={ searchOpen }
                                                    onOpen={ () => {
                                                        setSearchOpen( true );
                                                    } }
                                                    onClose={ () => {
                                                        setSearchOpen( false );
                                                    } }
                                                    onChange={ ( event, value, reason, details ) => {
                                                        setNewPresident( value )
                                                    }
                                                    }
                                                    getOptionSelected={ ( option, newPresident ) => {
                                                        return option.id === newPresident.id;
                                                    } }
                                                    getOptionLabel={ ( option ) => option.name.trim() + " " +
                                                        option.surname.trim() + " " + option.bilkentId }
                                                    options={ options }
                                                    loading={ loading }
                                                    renderInput={ ( params ) => (

                                                        <TextField
                                                            { ...params }
                                                            label="User"
                                                            fullWidth
                                                            InputProps={ {
                                                                ...params.InputProps,
                                                                endAdornment: (
                                                                    <React.Fragment>
                                                                        { loading ? <CircularProgress color="inherit"
                                                                                                      size={ 20 }/> :
                                                                            null }
                                                                        { params.InputProps.endAdornment }
                                                                    </React.Fragment>
                                                                ),
                                                            } }
                                                        />
                                                    ) }
                                                />
                                            </Grid>
                                        </Grid>
                                    </Grid>

                                    <Grid item xs={ 12 } style={ { marginTop: "60px" } }>
                                        { submitted ? <CircularProgress/> :
                                            <BilboardButton onClick={ () => handlePresidentAndAdvisorChange() }
                                                            text="Save" width="100px" fontSize="16px"/> }
                                    </Grid>
                                </Grid>
                            ) }
                        </div>
                    </Grid>
                </Grid> }
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ error !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setError( '' ) }
            >
                <Alert onClose={ () => setError( '' ) }
                       severity={ "warning" }
                >
                    { error }
                </Alert>
            </Snackbar>
            <Snackbar
                anchorOrigin={ { vertical: "bottom", horizontal: "center", } }
                open={ success !== '' }
                autoHideDuration={ 2000 }
                onClose={ () => setSuccess( '' ) }
            >
                <Alert onClose={ () => setSuccess( '' ) }
                       severity={ "success" }
                >
                    { success }
                </Alert>
            </Snackbar>
        </div>
    );
};

export default AdminManageClubScreen;
