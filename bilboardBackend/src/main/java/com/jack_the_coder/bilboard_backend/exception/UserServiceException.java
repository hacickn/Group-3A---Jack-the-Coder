package com.jack_the_coder.bilboard_backend.exception;


/**
 * @author Hacı Çakın
 * @apiNote Common error service
 * @implNote DONE
 * @since 22.11.2021
 */
public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = 1348771109171435607L;

    public UserServiceException(String message)
    {
        super(message);
    }
}
