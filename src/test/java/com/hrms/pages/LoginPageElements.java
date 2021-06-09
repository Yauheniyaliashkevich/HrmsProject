package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements  extends CommonMethods {
    @FindBy (xpath = "//div[@id='divLogo']/img")
    public WebElement logo;

    @FindBy (id ="txtUsername")
    public WebElement username;

    @FindBy (id = "txtPassword")
    public WebElement password;

    public LoginPageElements(){
        PageFactory.initElements(driver,this);
    }

}
