package com.expleo.qe.PageObjects;
import jxl.Cell;
import jxl.Sheet;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.concurrent.TimeUnit;


@DefaultUrl("http://tutorialsninja.com/demo/")
public class RegistrationPageObjects extends PageObject {

    //WebElement To Navigate To Register Page
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement myAccount;

    //*[@id="top-links"]/ul/li[2]/a
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement mySelector;

    //Verify You On The Correct Registration Page
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement myRegistrationPage;

    //Registration Page - Page Objects
    @FindBy(name = "firstname")
    private WebElement fname;

    @FindBy(name = "lastname")
    private WebElement Lname;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "telephone")
    private WebElement telephone;

    @FindBy(css = "#input-password")
    private WebElement password;

    @FindBy(css = "#input-confirm")
    private WebElement confirmPassword;

    @FindBy(css = "#content > form > div > div > input[type=\"checkbox\"]:nth-child(2)")
    private WebElement checkbox1;

    //Submit Button
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    //Text To Validate That Registration Was Successful
    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement regSuccessful;

    //Logging Out


    //Login WebElement

    public void OpenTheBrowser() {

        try {

            open();
            getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            getDriver().manage().window().maximize();
            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public void registerPage() {

        myAccount.click();


    }
    public void register(){

        registerPage();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mySelector.click();
    }

    public void registerPageVerify() {

        Assert.assertEquals(myRegistrationPage.getText(),"Account");
    }

    public void provideRegisterDetails(Sheet mySheet) {


        int count = 0;

        for (int i = 0; i < mySheet.getRows(); i++) {

            for (int j = 0; j < mySheet.getColumns(); j++) {

                if(count != 0){

                    Cell myCell = mySheet.getCell(j, i);

                    switch (j){

                        case 0:
                            fname.clear();
                            fname.sendKeys(myCell.getContents());
                            break;
                        case 1:
                            Lname.clear();
                            Lname.sendKeys(myCell.getContents());
                            break;
                        case 2:
                            email.clear();
                            email.sendKeys(myCell.getContents());
                            break;
                        case 3:
                            telephone.clear();
                            telephone.sendKeys(myCell.getContents());
                            break;
                        case 4:
                            password.clear();
                            password.sendKeys(myCell.getContents());

                            confirmPassword.clear();
                            confirmPassword.sendKeys(myCell.getContents());
                            break;
                        default:
                            break;
                    }
                }
            }
            count++;
        }

        checkbox1.click();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        continueButton.click();
    }

    public void successfulRegistration() {

        Assert.assertEquals(regSuccessful.getText(),"Congratulations! Your new account has been successfully created!");

        registerPage();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        //getDriver().close();
    }
}
