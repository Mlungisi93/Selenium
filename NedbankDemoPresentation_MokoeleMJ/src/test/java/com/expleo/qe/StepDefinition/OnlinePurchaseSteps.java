package com.expleo.qe.StepDefinition;
import com.expleo.qe.Step.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OnlinePurchaseSteps {

    @Steps
    RegistrationSteps registrationSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AddingToCartSteps addingToCart;

    @Steps
    CheckoutSteps checkout;

    @Steps
    LogoutSteps logoutSteps;


    @Given("^I am on tutotialninja home page$")
    public void i_am_on_tutotialninja_home_page() {

        registrationSteps.openBrowser();
    }


    @Given("^I navigate to registration page$")
    public void i_navigate_to_registration_page() {

        registrationSteps.goToRegistration();
    }

    @When("^I register with valid registration details$")
    public void i_register_with_valid_registration_credentials() {

        registrationSteps.verifyRegisterPage();
        registrationSteps.enterRegistrationDetails();
    }

    @Then("^I should be registered successfully$")
    public void i_should_be_registered_successfully() {

        registrationSteps.registerSuccess();
    }

    @Given("^I navigate to login page$")
    public void i_navigate_to_login_page() {

        loginSteps.goToLogin();
    }

    @When("^I enter valid login credentials$")
    public void i_enter_valid_login_credentials() {

        loginSteps.loginDetails();
    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() {

        loginSteps.validateLogin();
    }
    @Given("^I logged in successfully$")
    public void i_logged_in_successfully() {
        loginSteps.goToLogin();
        loginSteps.loginDetails();
        loginSteps.validateLogin();
    }


    @Given("^I navigate through products to buy$")
    public void i_navigate_through_products_to_buy() {

        addingToCart.hoverToSelect();
        addingToCart.selectProductType();
        addingToCart.validProduct();
    }

    @When("^I select product$")
    public void i_select_product() {

        addingToCart.addProduct();
    }

    @Then("^The product should be added to cart$")
    public void the_product_should_be_added_to_cart() {

        addingToCart.validateCart();
    }

    @Given("^The product is added to cart$")
    public void the_product_is_added_to_cart() {

        loginSteps.goToLogin();
        loginSteps.loginDetails();
        loginSteps.validateLogin();
        checkout.navToCart();
    }


    @When("^I perform checkout for the product$")
    public void i_perform_checkout_for_the_product() {

        checkout.performCheckout();
    }

    @Then("^The product should be checked out successful$")
    public void the_product_should_be_checked_out_successful() {

        checkout.checkoutSuccess();
    }


    @Given("^I am on home page$")
    public void i_am_on_home_page() {

        loginSteps.goToLogin();
        loginSteps.loginDetails();
        loginSteps.validateLogin();
        logoutSteps.homePage();
    }


    @When("^I click on logout$")
    public void i_click_on_logout() {

        logoutSteps.logout();
    }

    @Then("^I should be logged out successfully$")
    public void i_should_be_logged_out_successfully() {

        logoutSteps.validateLogout();
    }
}
