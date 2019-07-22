package com.expleo.qe.Step;

import com.expleo.qe.PageObjects.LogoutPageObjects;
import net.thucydides.core.annotations.Step;

public class LogoutSteps {

    LogoutPageObjects logoutPageObjects;

    @Step("Am On Home Page")
    public void homePage(){

        logoutPageObjects.home_Page();
    }
    @Step("I click On Logout")
    public void logout(){

        logoutPageObjects.loginOut();
    }
    @Step("Validate If Logout Was Successful")
    public void validateLogout(){

        logoutPageObjects.logoutSuccessful();
    }
}
