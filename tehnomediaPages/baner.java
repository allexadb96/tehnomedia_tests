package tehnomediaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class baner {
    private WebDriver wd;


    public baner(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//a[contains(text(),'❯')]")
    WebElement arrowRight;

    @FindBy(xpath = "//a[contains(text(),'❮')]")
    WebElement arrowLeft;


    public void clickBanerRight() throws InterruptedException {
        for(int i = 0; i<15; i++)
        {
           this.arrowRight.click();
           Thread.sleep(100);
        }
    }

    public void clickBanerLeft() throws InterruptedException {

        for(int i = 15; i>1; i--)
        {
            this.arrowLeft.click();
            Thread.sleep(100);
        }
    }

    public void clickBanerDots() throws InterruptedException {
        for(int i = 1; i<15; i++){
            wd.findElement(By.xpath("//body/div[4]/div[1]/div[16]/span["+i+"]")).click();
            Thread.sleep(150);
        }
    }


}