package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to reset password
 * @implNote DONE
 * @since 05.12.2021
 */
public class ResetPasswordRequest {
    private String token;
    private String newPassword;

    /**
     * get token method
     * @return token is String
     */
    public String getToken() {
        return token;
    }

    /**
     * Set token method
     * @param token is String
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * get newPassword method
     * @return newPassword is String
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Set newPassword method
     * @param newPassword is String
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
