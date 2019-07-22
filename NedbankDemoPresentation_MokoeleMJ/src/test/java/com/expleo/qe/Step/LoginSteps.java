package com.expleo.qe.Step;

import com.expleo.qe.PageObjects.LoginPageObjects;
import net.thucydides.core.annotations.Step;

public class LoginSteps {

    RegistrationSteps regSteps = new RegistrationSteps();
    LoginPageObjects loginPageObjects;

    @Step("Navigate To Login Page")
    public void goToLogin() {

        loginPageObjects.Login();
    }

    @Step("Enter Login Credentials")
    public void loginDetails() {

        loginPageObjects.loginCredentials(regSteps.mySheet);
    }

    @Step("Validate If User Logged In Successfully")
    public void validateLogin() {

        loginPageObjects.loggedIn();
    }
}
