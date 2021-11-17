import {Grid} from "@mui/material";
import React from 'react';
import Constants from "../../utils/Constants";
import Colors from "../../utils/Colors";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";

const ClubManagementSponsorScreen = (props) => {

    const sponsorList = [
        {
            name: "Garanti",
            amount: "10.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "http://w3.bilkent.edu.tr/logo/ing-amblem.png"
        },
        {
            name: "Google",
            amount: "12.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/500px-Google_2015_logo.svg.png"
        },
        {
            name: "Microsoft",
            amount: "500.000TL",
            type: "http://assets.stickpng.com/images/580b585b2edbce24c47b2af3.png",
            photo: "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Microsoft_logo_%282012%29.svg/2560px-Microsoft_logo_%282012%29.svg.png"
        },
        {
            name: "Cyberpark",
            amount: "1.000TL",
            type: "https://www.diastar.com.tr/images/thumbnails/465/465/detailed/6/bronz_madalya_diastar.png",
            photo: "https://www.cyberpark.com.tr/content/upload/settings/cyberparklogo-20190409135404.png"
        },
        {
            name: "Mobiversite",
            amount: "100.000TL",
            type: "http://assets.stickpng.com/images/580b585b2edbce24c47b2af3.png",
            photo: "https://static.wixstatic.com/media/c764a4_9979938f5f2447b1b0b94425b5d4cb99~mv2.png/v1/fill/w_512,h_512,al_c/c764a4_9979938f5f2447b1b0b94425b5d4cb99~mv2.png"
        },
        {
            name: "Facebook",
            amount: "10.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "https://space-fun.com/wp-content/uploads/2018/08/logo-facebook-transparent.png"
        },
        {
            name: "Garanti",
            amount: "10.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "http://w3.bilkent.edu.tr/logo/ing-amblem.png"
        },
        {
            name: "Google",
            amount: "12.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/500px-Google_2015_logo.svg.png"
        },
        {
            name: "Microsoft",
            amount: "500.000TL",
            type: "http://assets.stickpng.com/images/580b585b2edbce24c47b2af3.png",
            photo: "https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Microsoft_logo_%282012%29.svg/2560px-Microsoft_logo_%282012%29.svg.png"
        },
        {
            name: "Cyberpark",
            amount: "1.000TL",
            type: "https://www.diastar.com.tr/images/thumbnails/465/465/detailed/6/bronz_madalya_diastar.png",
            photo: "https://www.cyberpark.com.tr/content/upload/settings/cyberparklogo-20190409135404.png"
        },
        {
            name: "Mobiversite",
            amount: "100.000TL",
            type: "http://assets.stickpng.com/images/580b585b2edbce24c47b2af3.png",
            photo: "https://static.wixstatic.com/media/c764a4_9979938f5f2447b1b0b94425b5d4cb99~mv2.png/v1/fill/w_512,h_512,al_c/c764a4_9979938f5f2447b1b0b94425b5d4cb99~mv2.png"
        },
        {
            name: "Facebook",
            amount: "10.000TL",
            type: "https://www.pngall.com/wp-content/uploads/2017/03/Silver-Medal-Free-Download-PNG.png",
            photo: "https://space-fun.com/wp-content/uploads/2018/08/logo-facebook-transparent.png"
        }
    ]

    function addSponsor(sponsorObject) {
        let temp = [...sponsorList]

        temp.push({
            name: sponsorObject.name,
            amount: sponsorObject.amount,
            photo: sponsorObject.photo,
            type: sponsorObject.type
        })
    }

    return <Grid container
                 style={{margin: 10, padding: 10, borderRadius: Constants.BORDER_RADIUS}}>
        <Grid style={{
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            fontSize: 48,
            paddingBottom: 20,
        }} item xs={12}>
            Sponsors
        </Grid>
        <Grid container style={{maxHeight: "60vh", overflowY: "scroll", paddingBottom:10,paddingTop:10,}}>
            {sponsorList.map(sponsor => {
                return <Grid container
                             style={{
                                 width:"70vw",
                                 marginBottom: 5,
                                 marginTop: 5,
                                 paddingTop: 20,
                                 paddingBottom: 20,
                                 borderRadius: Constants.BORDER_RADIUS,
                                 background: Colors.BILBOARD_BLUE_ALTERNATIVE,
                                 alignItems: "center",
                             }}>
                    <Grid item xs>
                        <img
                            src={sponsor.photo}
                            style={{maxHeight: 50, maxWidth: 60}}
                        />
                    </Grid>
                    <Grid item xs>
                        {sponsor.name}
                    </Grid>
                    <Grid item xs>
                        {sponsor.amount}
                    </Grid>
                    <Grid item xs>
                        <img
                            src={sponsor.type}
                            style={{maxHeight: 50, maxWidth: 60}}
                        />
                    </Grid>
                </Grid>
            })}
        </Grid>
        <Grid container>
            <Grid item xs={1}>
                add photo
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField/>
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField/>
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField/>
            </Grid>
            <Grid item xs={2}>
                <BilboardButton text={"Add"}/>
            </Grid>
        </Grid>
    </Grid>
}

export default ClubManagementSponsorScreen;