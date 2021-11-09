import TextField from '@mui/material/TextField';
import React from 'react';

const BilboardTextField = (props) => {
    const [value, setValue] = React.useState("")

    return ( <TextField id="outlined-basic"
            value={value}
            onChange={(event) => { setValue(event.target.value) }}
            label={props.label}
            variant={props.variant ? props.variant : "outlined"}
            style={{
                color: props.color,
                fontSize: props.fontSize
            }}
        />
    )
}

export default BilboardTextField;