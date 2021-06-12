package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddJobTitle extends CommonMethods {

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement jobTitleField;


}
