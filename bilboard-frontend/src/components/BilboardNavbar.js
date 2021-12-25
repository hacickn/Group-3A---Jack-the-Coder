import { makeStyles } from "@mui/styles";
import Colors from "../utils/Colors";
import Grid from "@mui/material/Grid";
import IconButton from "@mui/material/IconButton";
import Badge from "@mui/material/Badge";
import MenuItem from "@mui/material/MenuItem";
import InputBase from '@mui/material/InputBase';
import { styled, alpha } from '@mui/material/styles';
import SearchIcon from '@mui/icons-material/Search';
import Select from "@mui/material/Select";
import Constants from "../utils/Constants";
import AssignmentIcon from "@mui/icons-material/Assignment";
import TodayIcon from "@mui/icons-material/Today";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import BilboardButton from "./BilboardButton";
import AttendEventDialog from "./AttendEventDialog";
import clsx from "clsx";
import { useState } from "react";
import { connect } from "react-redux";
import React from "react";
import { FormControl, InputLabel } from "@mui/material";

const useStyles = makeStyles({
  root: {
    width: "100vw",
    height: "68px",
    background: Colors.BILBOARD_MAIN,
    zIndex: "1000",
    position: "fixed",
    top: "0",
  },
  logo: {
    fontFamily: Constants.OXYGEN_FONT_FAMILY,
    fontSize: "32px",
    display: "flex",
    alignItems: "center",
    cursor: "pointer",
    width: "80px",
    color: "white",
    height: "68px",
    paddingLeft: "30px",
    justifyContent: "start",
  },
  searchBar: {
    display: "flex",
    alignItems: "center",
    justifyContent: "start",
    height: "68px",
    paddingLeft: "40px",
  },
  icons: {
    display: "flex",
    alignItems: "center",
    height: "68px",
    marginTop: "2px",
  },
  anIcon: {
    color: "white",
    minWidth: "40px",
    minHeight: "40px",
    borderRadius: "50px",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
  },
  iconBg: {
    backgroundColor: "rgba(0,0,0,0.05)",
  },
});

const BilboardNavbar = ({
  currentScreen,
  attendActive,
  surveyCount,
  calendarCount,
  isAttendDialogOpen,
  setIsAttendDialogOpen,
  setCurrentScreen,
  program,
  currentClubId,
  setCurrentClubId,
}) => {
  const classes = useStyles();

  let clubs = [];

  program.clubBoardMemberships.forEach((boardMemberShip) => {
    clubs.push(boardMemberShip.club);
  });

  if (program.advisorOf !== null) {
    let check = true;

    for (let a = 0; a < clubs.length; a++) {
      if (clubs[a].id === program.advisorOf.id) {
        check = false;
      }
    }

    if (check) {
      clubs.push(program.advisorOf);
    }
  }

  if (program.presidentOf !== null) {
    let check = true;

    for (let a = 0; a < clubs.length; a++) {
      if (clubs[a].id === program.presidentOf.id) {
        check = false;
      }
    }

    if (check) {
      clubs.push(program.presidentOf);
    }
  }

  const Search = styled('div')(({ theme }) => ({
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: alpha(theme.palette.common.white, 0.15),
    '&:hover': {
      backgroundColor: alpha(theme.palette.common.white, 0.25),
    },
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing(1),
      width: 'auto',
    },
  }));
  
  const SearchIconWrapper = styled('div')(({ theme }) => ({
    padding: theme.spacing(0, 2),
    height: '100%',
    position: 'absolute',
    pointerEvents: 'none',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  }));

  const StyledInputBase = styled(InputBase)(({ theme }) => ({
    color: 'inherit',
    '& .MuiInputBase-input': {
      padding: theme.spacing(1, 1, 1, 0),
      // vertical padding + font size from searchIcon
      paddingLeft: `calc(1em + ${theme.spacing(4)})`,
      transition: theme.transitions.create('width'),
      width: '100%',
      [theme.breakpoints.up('sm')]: {
        width: '36ch',
        '&:focus': {
          width: '48ch',
        },
      },
    },
  }));

  const handleSearchBarChange = (e) => {
    console.log(e.target.value)
  }

  return (
    <div className={classes.root}>
      {isAttendDialogOpen && <AttendEventDialog />}
      <Grid container>
        <Grid item xs={3}>
          <div
            className={classes.logo}
            onClick={() => {
              setCurrentClubId(0);
              setCurrentScreen("main");
            }}
          >
            BilBoard
          </div>
        </Grid>
        <Grid item xs={4} className={classes.searchBar}>
          <Search>
            <SearchIconWrapper>
              <SearchIcon />
            </SearchIconWrapper>
            <StyledInputBase
              placeholder="Search…"
              inputProps={{ "aria-label": "search" }}
              onChange={handleSearchBarChange}
            />
          </Search>
        </Grid>
        <Grid
          item
          xs={2}
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          {attendActive && (
            <BilboardButton
              onClick={() => setIsAttendDialogOpen(true)}
              width="160px"
              fontSize="13px"
              text="Attend an Event"
              color="#00e676"
            />
          )}
        </Grid>
        <Grid item xs={3}>
          <Grid
            container
            className={classes.icons}
            style={{ display: "flex", alignItems: "start" }}
          >
            <Grid item xs={2} />
            <Grid item xs={2}>
              <IconButton
                size="large"
                onClick={() => {
                  setCurrentClubId(0);
                  setCurrentScreen("survey");
                }}
              >
                <Badge badgeContent={surveyCount} color="error">
                  {currentScreen === "survey" ? (
                    <div className={clsx(classes.anIcon, classes.iconBg)}>
                      <AssignmentIcon />
                    </div>
                  ) : (
                    <div className={classes.anIcon}>
                      <AssignmentIcon />
                    </div>
                  )}
                </Badge>
              </IconButton>
            </Grid>
            <Grid item xs={2}>
              <IconButton
                size="large"
                onClick={() => {
                  setCurrentClubId(0);
                  setCurrentScreen("calendar");
                }}
              >
                <Badge badgeContent={calendarCount} color="error">
                  {currentScreen === "calendar" ? (
                    <div className={clsx(classes.anIcon, classes.iconBg)}>
                      <TodayIcon />
                    </div>
                  ) : (
                    <div className={classes.anIcon}>
                      <TodayIcon />
                    </div>
                  )}
                </Badge>
              </IconButton>
            </Grid>
            <Grid item xs={2}>
              <IconButton
                size="large"
                onClick={() => {
                  setCurrentClubId(0);
                  setCurrentScreen("user");
                }}
              >
                {currentScreen === "user" ? (
                  <div className={clsx(classes.anIcon, classes.iconBg)}>
                    <AccountCircleIcon />
                  </div>
                ) : (
                  <div className={classes.anIcon}>
                    <AccountCircleIcon />
                  </div>
                )}
              </IconButton>
            </Grid>

            {clubs.length > 0 ? (
              <Grid item xs={3}>
                {" "}
                <FormControl sx={{ m: 1, minWidth: 120 }}>
                  <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={currentClubId}
                    displayEmpty
                    label="CLub"
                    onChange={(e) => {
                      setCurrentClubId(e.target.value);
                      if (e.target.value !== 0) {
                        setCurrentScreen("clubManagement");
                      } else {
                        setCurrentScreen("main");
                      }
                    }}
                  >
                    <MenuItem value={0}>
                      <em>None</em>
                    </MenuItem>
                    {clubs.map((club) => {
                      return (
                        <MenuItem value={club.id}>
                          {club.shortName.toUpperCase()}{" "}
                        </MenuItem>
                      );
                    })}
                  </Select>
                </FormControl>
              </Grid>
            ) : (
              <div></div>
            )}
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    isAttendDialogOpen: state.isAttendDialogOpen,
    currentScreen: state.currentScreen,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    setIsAttendDialogOpen: (value) =>
      dispatch({
        type: "SET_IS_ATTEND_DIALOG_OPEN",
        isAttendDialogOpen: value,
      }),
    setCurrentScreen: (screen) =>
      dispatch({ type: "SET_CURRENT_SCREEN", currentScreen: screen }),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(BilboardNavbar);
