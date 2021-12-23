import TextField from '@mui/material/TextField';
import React from 'react';

/**
 * Bilboard Multiline TextField
 *
 * Date: 14.11.2021
 * Metehan Saçakçı
 */

const BilboardMultilineTextField = ( props ) => {

    return (
        <div>
            <TextField
                id="outlined-multiline-static"
                value={ props.value }
                size="small"
                onChange={ ( event ) => {
                    props.onChange(event.target.value)
                } }
                type={ props.type }
                label={ props.label }
                multiline
                rows={ props.rows }
                defaultValue="Default Value"
                variant={ props.variant ? props.variant : "outlined" }
                style={ {
                    color: props.color,
                    fontSize: props.fontSize,
                    borderRadius: "10px",
                    width: props.width,
                } }
            />
        </div>
    );
}

export default BilboardMultilineTextField;