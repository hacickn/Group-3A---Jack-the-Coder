package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to create a reset password creation
 * @implNote DONE
 * @since 05.12.2021
 */
public class ResetPasswordCreationRequest {
    private String email;

    /**
     * get email method
     * @return email is String
     */
    public String getEmail () {
        return email;
    }

    /**
     * Set email method
     * @param email is String
     */
    public void setEmail ( String email ) {
        this.email = email;
    }
}
