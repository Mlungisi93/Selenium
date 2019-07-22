package com.expleo.qe.PageObjects;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPageObjects extends PageObject {

    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement validate;

    public void home_Page() {

        myAccount.click();
    }

    public void loginOut() {
        
        logout.click();
    }

    public void logoutSuccessful() {

        String myStr = validate.getText();
        Assert.assertTrue(myStr.contains("logged off"));
    }
}
