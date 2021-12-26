package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.jack_the_coder.bilboard_backend.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImp implements StorageService {

    /**
     * Method for saving event photo
     * @param file is a MultipartFile
     * @param fileType is a String
     * @param fileName is a String
     * @return String
     * @apiNote Method for saving event photo
     */
    @Override
    public String saveEventPhoto ( MultipartFile file , String fileType , String fileName ) {

        try {

            long millis = System.currentTimeMillis();
            AWSCredentials credentials =
                    new BasicAWSCredentials( "AKIAYZNHCDMMVNUAYCOY" , "Iv5QLogCJQlyx42xQjoQomsIMvphNilHSPS1P8ho" );
            AmazonS3 s3client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials( new AWSStaticCredentialsProvider( credentials ) )
                    .withRegion( Regions.EU_CENTRAL_1 )
                    .build();

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength( IOUtils.toByteArray( file.getInputStream() ).length );

            String newFileName = fileType + "/" + fileName + "/" +
                    millis + "." + file.getContentType().split( "/" )[ 1 ];

            s3client.putObject(
                    new PutObjectRequest( "bilboard" , newFileName , file.getInputStream() , meta )
                            .withCannedAcl( CannedAccessControlList.PublicRead ) );

            return newFileName;
        } catch ( Exception e ) {
            throw new RuntimeException( "Could not store the file. Error: " + e.getMessage() );
        }
    }

    /**
     * Method for saving profile photo
     * @param file is a MultipartFile
     * @param fileType is a String
     * @param id is a long
     * @return String
     * @apiNote Method for saving profile photo
     */
    @Override
    public String saveProfilePhoto ( MultipartFile file , String fileType , long id ) {
        try {


            AWSCredentials credentials =
                    new BasicAWSCredentials( "AKIAYZNHCDMMVNUAYCOY" , "Iv5QLogCJQlyx42xQjoQomsIMvphNilHSPS1P8ho" );
            AmazonS3 s3client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials( new AWSStaticCredentialsProvider( credentials ) )
                    .withRegion( Regions.EU_CENTRAL_1 )
                    .build();

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength( IOUtils.toByteArray( file.getInputStream() ).length );


            String newFileName = fileType + "/" + id + "." + file.getContentType().split( "/" )[ 1 ];

            s3client.putObject(
                    new PutObjectRequest( "bilboard" , newFileName , file.getInputStream() , meta )
                            .withCannedAcl( CannedAccessControlList.PublicRead ) );


            return newFileName;
        } catch ( Exception e ) {
            throw new RuntimeException( "Could not store the file. Error: " + e.getMessage() );
        }
    }
}
