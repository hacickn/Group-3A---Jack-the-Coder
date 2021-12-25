import * as React from "react";
import Grid from "@mui/material/Grid";
import BilboardMultilineTextField from "../../../components/BilboardMultilineTextField";
import BilboardButton from "../../../components/BilboardButton";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import Dialog from "@mui/material/Dialog";
import Constants from "../../../utils/Constants";
import Button from "@mui/material/Button";
import BilboardTextField from "../../../components/BilboardTextField";
import Colors from "../../../utils/Colors";
import { Alert, Card, Snackbar, TextField } from "@mui/material";
import IconButton from "@mui/material/IconButton";
import {
  AddAlert,
  AddBox,
  DeleteForever,
  RemoveOutlined,
} from "@mui/icons-material";

/**
 * Add Survey Dialog
 *
 * Metehan Saçakçı
 * 17.11.2021
 */

const AddSurveyCard = (props) => {
  const [warning, setWarning] = React.useState("");
  const [textValue, setTextValue] = React.useState("");
  const [choices, setChoices] = React.useState([]);
  const [question, setQuestion] = React.useState("");

  React.useEffect(() => {
    var qa = {question, choices}
    props.setQA(qa);
  }, [question, choices]);

  function handleDeletion(content) {
    content = content.trim();
    let temp = [];

    choices.forEach((choice) => {
      if (choice.content !== content) {
        temp.push(choice);
      }
    });

    setChoices(temp);
  }


  function handleAddition(content) {
    let check = true;
    content = content.trim();

    choices.forEach((choice) => {
      if (choice.content === content) {
        check = false;
      }
    });

    if (check) {
      let temp = [...choices];
      temp.push({ content: content, voteCount: 0 });
      setChoices(temp);
    } else {
      setWarning("This choice was already added!");
    }
  }

  return (
    <div
      fullWidth
      style={{
        border: "10px solid",
        borderImageSlice: "1",
        borderWidth: "2px",
        borderColor: Colors.BILBOARD_MAIN,
        borderRadius: "10px",
        margin: "20px",
      }}
    >
      <Grid container>
        <Grid item xs={12}>
          <p
            style={{
              color: Colors.BILBOARD_LIGHT_GREY,
              fontSize: "18px",
              marginBottom: "1px",
              fontFamily: Constants.OXYGEN_FONT_FAMILY,
              align: "center",
              letterSpacing: "1px",
              display: "flex",
              justifyContent: "center",
            }}
          >
            Survey Question
          </p>
        </Grid>
        <Grid
          item
          xs={12}
          style={{
            marginTop: "20px",
            display: "flex",
            justifyContent: "center",
          }}
        >
          <BilboardMultilineTextField
            label="Survey Question"
            type="surveyQuestion"
            value={question}
            onChange= {(e) => setQuestion(e)}
            width="500px"
            rows="7"
            style={{ marginTop: "30px" }}
          />
        </Grid>

        <Grid item xs={12}>
          <p
            style={{
              color: Colors.BILBOARD_LIGHT_GREY,
              fontSize: "18px",
              marginTop: "30px",
              marginBottom: "10px",
              fontFamily: Constants.OXYGEN_FONT_FAMILY,
              align: "center",
              letterSpacing: "1px",
              display: "flex",
              justifyContent: "center",
            }}
          >
            Choices
          </p>
        </Grid>
        <Grid
          container
          style={{
            maxHeight: "200px",
            overflowX: "hidden",
            overflowY: "scroll",
            marginLeft: "170px",
            marginRight: "170px",
          }}
        >
          {choices.map((choice, index) => {
            return (
              <Grid
                key={index}
                item
                xs={12}
                style={{ display: "flex", justifyContent: "center" }}
              >
                <Card
                  elevation={0}
                  style={{
                    width: "440px",
                    marginTop: 10,
                    borderRadius: Constants.BORDER_RADIUS,
                    background: Colors.BILBOARD_RED_ALTERNATIVE,
                  }}
                >
                  <Grid container style={{ alignItems: "stretch" }}>
                    <Grid
                      item
                      xs={11}
                      style={{
                        fontSize: 12,
                        alignItems: "center",
                        padding: 8,
                      }}
                    >
                      {choice.content}
                    </Grid>
                    <Grid
                      item
                      xs={1}
                      style={{
                        background: Colors.BILBOARD_RED,
                        alignItems: "center",
                        justifyItems: "center",
                        display: "flex",
                      }}
                    >
                      <IconButton
                        onClick={() => handleDeletion(choice.content)}
                        style={{
                          borderRadius: 0,
                        }}
                      >
                        <DeleteForever />
                      </IconButton>
                    </Grid>
                  </Grid>
                </Card>
              </Grid>
            );
          })}
        </Grid>
        <Grid
          container
          style={{ justifyContent: "center", display: "flex", marginTop: 8 }}
        >
          <Card
            elevation={0}
            style={{
              width: "460px",
              marginTop: 10,
              borderRadius: Constants.BORDER_RADIUS,
              background: Colors.BILBOARD_MAIN_ALTERNATIVE,
              marginBottom: "20px",
            }}
          >
            <Grid container style={{ alignItems: "stretch" }}>
              <Grid
                item
                xs={10}
                style={{ fontSize: 12, alignItems: "center", padding: 8 }}
              >
                <BilboardTextField
                  onChange={(event) => setTextValue(event.target.value)}
                  value={textValue}
                  width={"360px"}
                />
              </Grid>
              <Grid
                item
                xs
                style={{
                  background: Colors.BILBOARD_MAIN,
                  alignItems: "center",
                  justifyItems: "center",
                  display: "flex",
                  cursor: "pointer",
                }}
              >
                <IconButton
                  onClick={() => {
                    if (textValue.trim().length > 0) {
                      handleAddition(textValue);
                      setTextValue("");
                    } else {
                      setWarning("Choice can not be empty!");
                    }
                  }}
                  style={{
                    borderRadius: 0,
                    width: "70px",
                  }}
                >
                  <AddBox />
                </IconButton>
              </Grid>
            </Grid>
          </Card>
        </Grid>
      </Grid>
      <Snackbar
        open={warning.length > 0}
        anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
        autoHideDuration={3000}
        onClose={() => setWarning("")}
      >
        <Alert
          style={{
            padding: 20,
          }}
          onClose={() => setWarning("")}
          severity={"warning"}
        >
          {warning}
        </Alert>
      </Snackbar>
    </div>
  );
};

export default AddSurveyCard;
