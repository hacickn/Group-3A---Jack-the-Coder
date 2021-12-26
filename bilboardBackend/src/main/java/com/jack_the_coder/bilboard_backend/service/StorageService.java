package com.jack_the_coder.bilboard_backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface StorageService {

    String saveEventPhoto ( MultipartFile file , String fileType , String fileName );

    String saveProfilePhoto ( MultipartFile file , String fileType , long id );

}

