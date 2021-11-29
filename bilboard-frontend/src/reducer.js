const reducer = (state, action) => {
  if (action.type === "SET_IS_ATTEND_DIALOG_OPEN") {
    return {
      ...state,
      isAttendDialogOpen: action.isAttendDialogOpen,
    };
  }
  else if (action.type=== "SET_CURRENT_SCREEN"){
    return {
      ...state,
      currentScreen: action.currentScreen
    }
  }
  else if (action.type === "SET_SCREEN_NO_NAVBAR"){
    return{
      ...state,
      screenNoNavbar: action.screenNoNavbar
    }
  }
  return state;

};

export default reducer;
