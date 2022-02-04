package tehnomediaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactForm {
    private WebDriver wd;


    public ContactForm(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//input[@id='cf_name']")
    WebElement imePrezime;

    @FindBy(xpath = "//input[@id='cf_email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@id='cf_message']")
    WebElement message;

    @FindBy(xpath = "//button[contains(text(),'Pošalji')]")
    WebElement submit;

    public void enterImePrezime(String imePrezime){
        Actions action = new Actions(wd);
        action.moveToElement(this.imePrezime).perform();
        this.imePrezime.sendKeys(imePrezime);
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }
    public void enterMessage(String message){
        Actions action = new Actions(wd);
        action.moveToElement(this.message).perform();
        this.message.sendKeys(message);
    }

    public void clickSend(){
        Actions action = new Actions(wd);
        action.moveToElement(this.submit).perform();

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,250)", "");
        this.submit.click();
    }


}
