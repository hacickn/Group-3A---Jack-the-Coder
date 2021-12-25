package com.jack_the_coder.bilboard_backend.service;

public interface EmailService {

    boolean sendEmail ( String email , String messageOfMail , String head );

}
