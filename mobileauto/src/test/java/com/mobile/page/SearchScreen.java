package com.mobile.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchScreen extends MobilePage {

    @AndroidFindBy(id = "iasCardContents")
    @iOSXCUITFindBy(accessibility = "browse_products_by_type_instant_saver_button")
    private WebElement instantSaverCard;

    @AndroidFindBy(id = "cardContents")
    private WebElement fixedSaverCard;

    @AndroidFindBy(id = "mortgageCardContents")
    private WebElement mortgagesCard;

    public SearchScreen(WebDriver driver) {
        super(driver);
    }

    public void selectInstantSaverProduct() {
        instantSaverCard.click();
    }

    public void selectFixedSaverProduct() {
        fixedSaverCard.click();
    }

    public void selectMortgageProduct() {
        mortgagesCard.click();
    }
}
