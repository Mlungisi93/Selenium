package com.expleo.qe.PageObjects;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckoutPageObjects extends PageObject {

    RegistrationPageObjects registrationPageObjects;
    FileInputStream eFile;
    Workbook myBook;
    Sheet mySheet;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/span")
    private WebElement myCart;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table")
    private WebElement myTable;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private WebElement validateCheckoutPage;

    //---------------------------------Billing Details--------------------------------------

    @FindBy(xpath = "//*[@id=\"collapse-payment-address\"]/div/form/div[3]/label/input")
    private WebElement setAddress;

    @FindBy(name = "firstname")
    private WebElement firstname;

    @FindBy(name = "lastname")
    private WebElement lastname;

    @FindBy(name = "address_1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "postcode")
    private WebElement postalcode;

    @FindBy(name = "country_id")
    private WebElement country;

    @FindBy(name = "zone_id")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"button-payment-address\"]")
    private WebElement continue1;

    //--------------------------------Delivery Details----------------------------------------

    @FindBy(xpath = "//*[@id=\"collapse-shipping-address\"]/div/form/div[3]/label/input")
    private WebElement shippingAddress;

    @FindBy(xpath = "//*[@id=\"input-shipping-firstname\"]")
    private WebElement fname;

    @FindBy(xpath = "//*[@id=\"input-shipping-lastname\"]")
    private WebElement lname;

    @FindBy(xpath = "//*[@id=\"input-shipping-address-1\"]")
    private WebElement deliveryAddress;

    @FindBy(xpath = "//*[@id=\"input-shipping-city\"]")
    private WebElement deliveryCity;

    @FindBy(xpath = "//*[@id=\"input-shipping-postcode\"]")
    private WebElement deliveryPostalCode;

    @FindBy(xpath = "//*[@id=\"input-shipping-country\"]")
    private WebElement deliveryCountry;

    @FindBy(xpath = "//*[@id=\"input-shipping-zone\"]")
    private WebElement deliveryState;

    @FindBy(xpath = "//*[@id=\"button-shipping-address\"]")
    private WebElement continue2;

    //--------------------------------Delivery Method------------------------------------------

    @FindBy(name = "shipping_method")
    private WebElement shippingMethod;

    @FindBy(name = "comment")
    private WebElement comment1;

    @FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
    private WebElement continue3;

    //-------------------------------Payment Method---------------------------------------------

    @FindBy(name = "payment_method")
    private WebElement payMethod;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/p[3]/textarea")
    private WebElement comment2;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
    private WebElement conditions;

    @FindBy(xpath = "//*[@id=\"button-payment-method\"]")
    private WebElement continue4;

    //-------------------------------Confirm Order------------------------------------------------

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table")
    private WebElement table;

    @FindBy(xpath = "//*[@id=\"button-confirm\"]")
    private WebElement confirmButton;

    //--------------------------------------------------------------------------------------------

    @FindBy(xpath = "//*[@id=\"content\"]/p[1]")
    private WebElement checkSuccessful;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    private WebElement contBtn;

    public void goToCart() {

        myCart.click();
    }

    public boolean checkIfCartIsNotEmpty(){

        boolean addedProduct;

        if(myTable.isDisplayed()){

            addedProduct = true;
        }else{

            addedProduct = false;
        }

        return addedProduct;
    }

    public void billingDetails(Sheet mySheet) {


        int count = 0;

        setAddress.click();

        for (int i = 0; i < mySheet.getRows(); i++) {

            for (int j = 0; j < mySheet.getColumns(); j++) {

                if (count != 0) {

                    Cell myCell = mySheet.getCell(j, i);

                    switch (j) {

                        case 0:
                            firstname.clear();
                            firstname.sendKeys(myCell.getContents());
                            break;
                        case 1:
                            lastname.clear();
                            lastname.sendKeys(myCell.getContents());
                            break;
                        case 2:
                            address.clear();
                            address.sendKeys(myCell.getContents());
                            break;
                        case 3:
                            city.clear();
                            city.sendKeys(myCell.getContents());
                            break;
                        case 4:
                            postalcode.clear();
                            postalcode.sendKeys(myCell.getContents());
                            break;
                        case 5:
                            Select myCountry = new Select(country);
                            myCountry.selectByVisibleText(myCell.getContents());
                            break;
                        case 6:
                            Select myState = new Select(state);
                            myState.selectByVisibleText(myCell.getContents());
                            break;
                    }

                }
            }
            count++;
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        continue1.click();
    }
    public void deliveryDetails(Sheet mySheet) {



        waitABit(5000);
        int count =0;

        if(shippingAddress.isEnabled()){

            shippingAddress.click();

            for (int i = 0; i < mySheet.getRows(); i++) {

                for (int j = 0; j < mySheet.getColumns(); j++) {

                    if (count != 0) {

                        Cell myCell = mySheet.getCell(j, i);

                        switch (j){

                            case 0:
                                fname.clear();
                                fname.sendKeys(myCell.getContents());
                                break;
                            case 1:
                                lname.clear();
                                lname.sendKeys(myCell.getContents());
                                break;
                            case 2:
                                deliveryAddress.clear();
                                deliveryAddress.sendKeys(myCell.getContents());
                                break;
                            case 3:
                                deliveryCity.clear();
                                deliveryCity.sendKeys(myCell.getContents());
                                break;
                            case 4:
                                deliveryPostalCode.clear();
                                deliveryPostalCode.sendKeys(myCell.getContents());
                                break;
                            case 5:
                                Select myCountry = new Select(deliveryCountry);
                                myCountry.selectByVisibleText(myCell.getContents());
                                break;
                            case 6:
                                Select myState = new Select(deliveryState);
                                myState.selectByVisibleText(myCell.getContents());
                                break;
                        }

                    }
                }
                count++;
            }
        }else{

            for (int i = 0; i < mySheet.getRows(); i++) {

                for (int j = 0; j < mySheet.getColumns(); j++) {

                    if (count != 0) {

                        Cell myCell = mySheet.getCell(j, i);

                        switch (j){

                            case 0:
                                firstname.clear();
                                firstname.sendKeys(myCell.getContents());
                                break;
                            case 1:
                                lastname.clear();
                                lastname.sendKeys(myCell.getContents());
                                break;
                            case 2:
                                address.clear();
                                address.sendKeys(myCell.getContents());
                                break;
                            case 3:
                                city.clear();
                                city.sendKeys(myCell.getContents());
                                break;
                            case 4:
                                postalcode.clear();
                                postalcode.sendKeys(myCell.getContents());
                                break;
                            case 5:
                                Select myCountry = new Select(country);
                                myCountry.selectByVisibleText(myCell.getContents());
                                break;
                            case 6:
                                Select myState = new Select(state);
                                myState.selectByVisibleText(myCell.getContents());
                                break;
                        }

                    }
                }
                count++;
            }
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        continue2.click();
    }
    public void deliveryMethod(){

        if(shippingMethod.isSelected()){

            comment1.clear();
            comment1.sendKeys("I Like This Product. Kindly Deliver It As Soon As Possible!!");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            continue3.click();
        }else{

            System.out.println("The Radio Button For"+ "\""+"Flat Shipping Rate"+"\""+" Is Not Checked");
        }
    }
    public void paymentMethod(){

        if(payMethod.isSelected()){
            if(comment2.getText() != null){

                conditions.click();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                continue4.click();
            }else{

                System.out.println("Comment Entered In Delivery Method Did Not Pull Through.");
            }
        }else{

            System.out.println("The Radio Button For"+ "\""+"Cash On Delivery"+"\""+" Is Not Checked.");
        }
    }
    public void confirmOrder(){

        if(table.isDisplayed()){

            confirmButton.click();
        }else{

            System.out.println("The Order Table Is Not Available");
        }
    }

    public void checkCart() {


        try {

            this.eFile = new FileInputStream("C:\\Users\\7390\\IdeaProjects\\NedbankDemoPresentation_MokoeleMJ\\Data.xls");
            this.myBook = Workbook.getWorkbook(eFile);
            this.mySheet = myBook.getSheet("Billing and Delivery Details");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (BiffException e) {

            e.printStackTrace();
        }

        checkIfCartIsNotEmpty();
        checkoutBtn.click();

        Assert.assertEquals( validateCheckoutPage.getText(),"Checkout");

        billingDetails(mySheet);
        deliveryDetails(mySheet);
        deliveryMethod();
        paymentMethod();
        confirmOrder();



    }


    public void checkoutConfirmation() {

        Assert.assertTrue(checkSuccessful.getText().contains("successfully processed!"));

        contBtn.click();
    }
}
