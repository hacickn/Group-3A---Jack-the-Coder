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
  else if (action.type === "SET_IS_ABOUT_SCREEN"){
    return{
      ...state,
      isAboutScreen: action.isAboutScreen
    }
  }
  return state;

};

export default reducer;
