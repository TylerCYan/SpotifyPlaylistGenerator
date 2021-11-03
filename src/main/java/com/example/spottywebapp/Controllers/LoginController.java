package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.LoginInputBoundary;
import com.example.spottywebapp.UseCases.LoginUseCase;
import com.example.spottywebapp.entities.UserList;

public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     * @param loginInputBoundary the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     * @param username the username
     * @param password the password attempt
     */
    public void runLogin(String username, String password) {
        // Note: hands off the work to the use case class.
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        switch (result) {
            case SUCCESS:
                // Should we be printing? How might you refactor this program
                // to fit the Clean Architecture?
                System.out.println("Logged in.");
                break;
            case FAILURE:
                System.out.println("Failed to login!");
                break;
            case NO_SUCH_USER:
                System.out.println("No such user... Try again.");

        }
    }
    public void userLogin(String username){

    }
}