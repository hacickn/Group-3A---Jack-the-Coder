import Grid from "@mui/material/Grid";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";
import React from "react";
import { CircularProgress, TextField } from "@mui/material";
import Constants from "../../utils/Constants";
import Env from "../../utils/Env";
import { Autocomplete } from "@mui/lab";

const AdminManageClubScreen = ( { clubs, allClubs, getClubs, clubLoading } ) => {
    const [ currentClub, setCurrentClub ] = React.useState( null )
    const [ searchOpen, setSearchOpen ] = React.useState( false )
    const [ searchOpenForAdvisor, setSearchOpenForAdvisor ] = React.useState( false )

    const [ options, setOptions ] = React.useState( [] );
    const [ optionsForAdvisor, setOptionsForAdvisor ] = React.useState( [] );
    const loading = searchOpen && options.length === 0;
    const loadingForAdvisor = searchOpenForAdvisor && optionsForAdvisor.length === 0;


    const [ newAdvisor, setNewAdvisor ] = React.useState( "" )
    const [ newPresident, setNewPresident ] = React.useState( "" )


    if ( allClubs === null ) {
        getClubs()
    }


    React.useEffect( () => {
        let active = true;
        if ( !loading ) {
            return undefined;
        }

        ( async () => {

            const response = await fetch( process.env.REACT_APP_URL + 'user/search?name=' + newPresident + '&type=student', {
                method: 'GET', headers: {
                    "Content-Type": "application/json",
                    'Authorization': 'Bearer ' + Env.TOKEN
                }
            }, )

            const temp = await response.json();

            if ( active ) {
                setOptions( [...temp].map( ( user ) => {
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

            const response = await fetch( process.env.REACT_APP_URL + 'user/search?name=' + newAdvisor + '&type=academic', {
                method: 'GET', headers: {
                    "Content-Type": "application/json",
                    'Authorization': 'Bearer ' + Env.TOKEN
                }
            }, )

            const temp = await response.json();

            if ( active ) {
                setOptionsForAdvisor( [...temp].map( ( user ) => {
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
                                                    Club Advisor:
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
                                                                        { loadingForAdvisor ? <CircularProgress color="inherit"
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
                                                    Club President:
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
                                                    getOptionSelected={ ( option, value ) => {
                                                        return option.name === newPresident.name;
                                                    } }
                                                    getOptionLabel={ ( option ) => option.name + " " + option.surname +
                                                        " " + option.bilkentId }
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
                                        <BilboardButton text="Save" width="100px" fontSize="16px"/>
                                    </Grid>
                                </Grid>
                            ) }
                        </div>
                    </Grid>
                </Grid> }
        </div>
    );
};

export default AdminManageClubScreen;
