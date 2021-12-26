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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
