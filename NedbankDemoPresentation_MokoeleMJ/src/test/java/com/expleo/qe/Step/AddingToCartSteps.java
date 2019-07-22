package com.expleo.qe.Step;

import com.expleo.qe.PageObjects.AddingToCartPageObjects;
import net.thucydides.core.annotations.Step;

public class AddingToCartSteps {

    AddingToCartPageObjects addingToCartPageObjects;

    @Step("Hover To Select")
    public void hoverToSelect(){

        addingToCartPageObjects.Hover();
    }

    @Step("Selecting Product Type")
    public void selectProductType(){

        addingToCartPageObjects.ProductType();
    }

    @Step("Validate That You Navigate To Products")
    public void validProduct(){
        addingToCartPageObjects.validation();
    }
    @Step("Adding To Cart")
    public void addProduct(){

        addingToCartPageObjects.addToCart();
    }
    @Step("Checking If The Product Selected Was Added To Cart Successfully")
    public void validateCart(){

        addingToCartPageObjects.validProdAddedSuccess();
    }
}
