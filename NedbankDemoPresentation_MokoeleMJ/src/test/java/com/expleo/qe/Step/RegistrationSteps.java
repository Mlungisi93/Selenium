package com.expleo.qe.Step;
import com.expleo.qe.PageObjects.RegistrationPageObjects;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.thucydides.core.annotations.Step;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RegistrationSteps {

    RegistrationPageObjects registrationPageObjects;
    FileInputStream eFile;
    Workbook myBook;
    Sheet mySheet;

    @Step("Open The Browser And Navigate To Home Page")
    public void openBrowser(){

        registrationPageObjects.OpenTheBrowser();
    }

    @Step("Navigate To Registration Page")
    public void goToRegistration() {

        registrationPageObjects.register();
    }

    @Step("Verify We On The Correct Registration Page")
    public void verifyRegisterPage(){

        registrationPageObjects.registerPageVerify();
    }
    @Step("Provide Required Details For Registration")
    public void enterRegistrationDetails() {

        try {

            this.eFile = new FileInputStream("C:\\Users\\7390\\IdeaProjects\\NedbankDemoPresentation_MokoeleMJ\\Data.xls");
            this.myBook = Workbook.getWorkbook(eFile);
            this.mySheet = myBook.getSheet("Register Details");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (BiffException e) {

            e.printStackTrace();
        }

        registrationPageObjects.provideRegisterDetails(mySheet);
    }

    @Step("Validating If User Managed To Register Successfully")
    public void registerSuccess() {

        registrationPageObjects.successfulRegistration();
    }
}
