import TextField from '@mui/material/TextField';
import React from 'react';

const BilboardTextField = (props) => {

    return (
        <div>
            <TextField id="outlined-basic"
                       value={props.value}
                       size="small"
                       onChange={props.onChange}
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