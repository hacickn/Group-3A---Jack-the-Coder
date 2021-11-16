const reducer = (state, action) => {
  if (action.type === "SET_IS_ATTEND_DIALOG_OPEN") {
    return {
      ...state,
      isAttendDialogOpen: action.isAttendDialogOpen,
    };
  }
  return state;
};

export default reducer;
