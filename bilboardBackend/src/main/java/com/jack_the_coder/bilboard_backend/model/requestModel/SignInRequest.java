package com.jack_the_coder.bilboard_backend.model.requestModel;

/**
 * @author Aslı Dinç
 * @apiNote This class consists of the parameters needed to sign in
 * @implNote DONE
 * @since 05.12.2021
 */
public class SignInRequest {
    private String password;
    private String email;

    /**
     * get password method
     * @return password is String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password method
     * @param password is String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get email method
     * @return email is String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email method
     * @param email is String
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
