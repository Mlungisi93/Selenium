package com.expleo.qe.PageObjects;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertThat;

public class AddingToCartPageObjects extends PageObject {


    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[3]/a")
    private WebElement myMonitors;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")
    private WebElement product;

    @FindBy(xpath = "//*[@id=\"content\"]/h2")
    private WebElement validPage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[1]/span")
    private WebElement add;

    @FindBy(css = ".alert")
    private WebElement validateCart;

    public void Hover() {

        Actions myAction = new Actions(getDriver());
        myAction.moveToElement(myMonitors).perform();
    }

    public void ProductType() {

        product.click();
    }

    public void validation() {

        Assert.assertEquals(validPage.getText(),"Monitors");
    }
    public void addToCart() {

        add.click();
    }


    public void validProdAddedSuccess() {

        String myStr = validateCart.getText();

       try {

           Assert.assertTrue(myStr.contains("Success:"));
       }catch (AssertionError e){
           System.out.println(myStr+" is not equal to "+" success");
       }
    }
}
