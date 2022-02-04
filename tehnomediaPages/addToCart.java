package tehnomediaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addToCart {
    private WebDriver wd;


    public addToCart(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement GorenjeM420;
    @FindBy (xpath = "//body/div[4]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/div[3]/button[1]")
    WebElement addToCart;
    @FindBy(xpath = "//a[contains(text(),'Završi Kupovinu')]")
    WebElement zavrsi;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]")
    WebElement mikser;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]/i[1]")
    WebElement deleteProduct;


   public void addToCartGorenjeMikser() throws InterruptedException {

       ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", GorenjeM420);
       Thread.sleep(500);
       this.GorenjeM420.click();
   }

   public void addToCart(){
       this.addToCart.click();
   }

   public void zavrsiKupovinu(){
       this.zavrsi.click();
   }

   public String mikserIme(){
     return this.mikser.getText();
   }

   public void deleteFromCart(){
       this.deleteProduct.click();
   }
}