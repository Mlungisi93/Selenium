package com.expleo.qe.PageObjects;
import jxl.Cell;
import jxl.Sheet;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPageObjects extends PageObject {

    RegistrationPageObjects rPageObject = new RegistrationPageObjects();

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement myLogin;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/h2")
    private WebElement validateLoginPage;

    @FindBy(name = "email")
    private WebElement e_mail;

    @FindBy(name = "password")
    private WebElement passwrd;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/h2[2]")
    private WebElement vLogin; //Validate Login With Text

    public void Login() {

        rPageObject.registerPage();
        myLogin.click();
    }

    public void loginCredentials(Sheet mySheet) {

        Assert.assertEquals(validateLoginPage.getText(),"Returning Customer");

       /* int count = 0;

        for (int i = 0; i < mySheet.getRows(); i++) {
            for (int j = 0; j < mySheet.getColumns(); j++) {

                Cell myCell = mySheet.getCell(j, i);

                if (count != 0) {
                    switch (j) {

                        case 2:
                            e_mail.clear();
                            e_mail.sendKeys(myCell.getContents());
                            break;
                        case 4:
                            passwrd.clear();
                            passwrd.sendKeys(myCell.getContents());
                            break;
                        default:
                            break;
                    }
                }
            }
            count++;
        }*/

        e_mail.clear();
        e_mail.sendKeys("chichi@gmail.com");

        passwrd.clear();
        passwrd.sendKeys("P@ssW0rd1");
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        loginBtn.click();
    }

    public void loggedIn() {

        assertThat("My Orders",is(vLogin.getText()));

        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
