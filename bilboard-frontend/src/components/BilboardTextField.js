import TextField from '@mui/material/TextField';
import React from 'react';

const BilboardTextField = (props) => {
    const [value, setValue] = React.useState("")

    return (
        <div>
            <TextField id="outlined-basic"
                value={value}
                size="small"
                onChange={(event) => { setValue(event.target.value) }}
                type={props.type}
                label={props.label}
                variant={props.variant ? props.variant : "outlined"}
                style={{
                    color: props.color,
                    fontSize: props.fontSize,
                    borderRadius: "10px",
                    width: props.width,
                }}
            />
        </div>
    );
}

export default BilboardTextField;