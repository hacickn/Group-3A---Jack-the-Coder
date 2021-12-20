package com.jack_the_coder.bilboard_backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String save ( MultipartFile file , String fileType , String fileName );

}

