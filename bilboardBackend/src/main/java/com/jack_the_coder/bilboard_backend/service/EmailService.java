package com.jack_the_coder.bilboard_backend.service;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface EmailService {

    boolean sendEmail ( String email , String messageOfMail , String head );

}
