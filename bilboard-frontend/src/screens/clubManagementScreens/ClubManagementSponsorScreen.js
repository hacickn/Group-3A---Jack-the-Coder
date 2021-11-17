import {Grid, IconButton} from "@mui/material";
import React from 'react';
import Constants from "../../utils/Constants";
import BilboardButton from "../../components/BilboardButton";
import BilboardTextField from "../../components/BilboardTextField";
import SponsorCard from "./clubManagementComponents/SponsorCard";
import Colors from "../../utils/Colors";
import {AddOutlined, Image} from "@mui/icons-material";

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

    return <Grid container
                 style={{margin: 0, padding: 10, borderRadius: Constants.BORDER_RADIUS}}>
        <Grid style={{
            fontFamily: Constants.OXYGEN_FONT_FAMILY,
            fontSize: 48,
            paddingBottom: 20,
        }} item xs={12}>
            Sponsors
        </Grid>
        <Grid container style={{maxHeight: "60vh", overflowY: "scroll"}}>
            {sponsorList.map(sponsor => {
                return <SponsorCard sponsor={sponsor}/>
            })}
        </Grid>
        <Grid container style={{
            marginTop: 20,
            height:"10vh",
            padding: 12,
            borderRadius: Constants.BORDER_RADIUS,
            alignItems: "center",
            background: Colors.BILBOARD_BLUE_ALTERNATIVE
        }}>
            <Grid item xs={1}>
                <IconButton>
                    <Image style={{color: Colors.BILBOARD_BLUE}}/>
                </IconButton>
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField width={"14vw"} label={"Name"}/>
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField width={"14vw"} label={"Amount"}/>
            </Grid>
            <Grid item xs={3}>
                <BilboardTextField width={"14vw"} label={"Type"}/>
            </Grid>
            <Grid item xs={2}>
                <BilboardButton text={"Add"} width={"8vw"}/>
            </Grid>
        </Grid>
    </Grid>
}

export default ClubManagementSponsorScreen;