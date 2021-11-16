import Grid from "@mui/material/Grid";

const EventDetailScreen = () => {
    return (

        <div>
            <Grid container>
                <Grid item xs={4}>
                    <Grid container>
                        <Grid container>
                            <Grid item xs={4} style={
                                {
                                    marginTop: "20px",
                                    marginLeft: "20px",
                                    color: "black",
                                    display: "flex",
                                    justifyContent: "left",
                                    alignItems: "left",
                                    fontSize: "120%",

                                }}>
                                Event Name      
                            </Grid>
                            <Grid item xs={8} style={
                                {
                                    marginRight: "20px",
                                    color: "black",
                                    display: "flex",
                                    justifyContent: "right",
                                    alignItems: "right",
                                    fontSize: "120%",

                                }}>
                              🔯 🔯  🔯  🔯  🔯

                            </Grid>
                        </Grid>
                        <Grid item xs={12} style={
                            {
                                marginTop: "20px",
                                marginLeft: "20px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "120%",
                            }}>
                            Club Name
                        </Grid>
                        <Grid item xs={12} style={
                            {
                                marginTop: "20px",
                                marginLeft: "20px",
                                color: "black",
                                display: "flex",
                                justifyContent: "left",
                                alignItems: "left",
                                fontSize: "120%",

                            }}>
                            No. of
                        </Grid>
                    </Grid>
                    <Grid item >              
                        <img src ="
                        https://relearnalanguage.com/wp-content/uploads/2021/01/language-club-activities.jpg"style ={
                            {
                                marginTop: "40px",
                                marginLeft: "20px",
                                backgroundSize: "cover",
                                width: "460px",
                                height: "460px",
                                borderRadius: "10px",

                            }}>  
                            </img>
                    </Grid>
                </Grid>
                <Grid item xs={8}>
                    <Grid container style ={
                            {
                                marginTop: "40px",
                                marginLeft: "20px",                           
                             }}>  

                    </Grid >
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.


                    <Grid container style ={
                            {
                                marginTop: "40px",
                                marginLeft: "20px", 
                                fontWeight: "bold",                          
                             }}>  
                    EVENT LOCATION
                    </Grid>

                    <Grid container>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </Grid>
                </Grid>
            </Grid>
        </div>
    )
}

export default EventDetailScreen;