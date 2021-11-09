import Button from "@mui/material/Button";
import Constants from "../utils/Constants";
import Colors from "../utils/Colors";

const BilboardButton = (props) => {
  return (
    <Button
      variant={props.variant}
      size={props.size}
      style={{
        width: props.width? props.width : "auto",
        height: props.height? props.height : "auto", 
        background: props.color? props.color : Colors.BILBOARD_RED,
        color: props.textColor? props.textColor : Colors.WHITE,
        borderRadius: Constants.BORDER_RADIUS,
        fontSize: props.fontSize? props.fontSize : "12px",
      }}
      onClick={props.onClick}
    >
      {props.text? props.text: "empty"}
    </Button>
  );
};

export default BilboardButton;
