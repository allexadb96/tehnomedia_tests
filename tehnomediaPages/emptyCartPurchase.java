package tehnomediaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class emptyCartPurchase {
    private WebDriver wd;


    public emptyCartPurchase(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//button[@id='open_shopping_cart']")
    WebElement cart;

    @FindBy(xpath = "//a[contains(text(),'Završi kupovinu')]")
    WebElement purchase;

    @FindBy(xpath = "//p[contains(text(),'Vaša korpa je prazna!')]")
    WebElement message;


    public void clickCart() throws InterruptedException {
       this.cart.click();
    }

    public void clickPurchase()
    {
        this.purchase.click();
    }

    public String getMessage()
    {
       return message.getText();
    }
}