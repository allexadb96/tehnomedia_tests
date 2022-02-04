package tehnomediaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchForm {
    private WebDriver wd;


    public searchForm(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//input[@id='search-text']")
    WebElement searchForm;

    @FindBy(xpath = "//b[contains(text(),'STELLA TELEVIZORI')]")
    WebElement televizor;


    public void clickSearchForm(){
        this.searchForm.click();
    }

    public void enterValueinSearchForm(String value){
        this.searchForm.sendKeys(value);
    }

    public void clickTelevizor(){
        this.televizor.click();
    }
}