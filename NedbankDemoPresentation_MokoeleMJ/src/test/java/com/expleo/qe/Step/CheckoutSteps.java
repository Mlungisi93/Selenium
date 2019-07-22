package com.expleo.qe.Step;

import com.expleo.qe.PageObjects.CheckoutPageObjects;
import net.thucydides.core.annotations.Step;

public class CheckoutSteps {

    CheckoutPageObjects checkoutPageObjects;

    @Step("Navigate To Cart")
    public void navToCart(){

        checkoutPageObjects.goToCart();
    }

    @Step("Performing Checkout")
    public void performCheckout(){

        checkoutPageObjects.checkCart();
    }
    @Step("Validate If The Checkout Was Successful")
    public void checkoutSuccess(){

        checkoutPageObjects.checkoutConfirmation();
    }


}
