package tehnomediaPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFilter {
    private WebDriver wd;


    public ProductFilter(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    @FindBy(xpath = "//label[contains(text(),'Klasicni (52)')]")
    WebElement klasicni;
    @FindBy(xpath = "//label[contains(text(),'BOSCH (6)')]")
    WebElement bosch;
    @FindBy(xpath = "//label[contains(text(),'ostale boje (1)')]")
    WebElement color;
    @FindBy(xpath = "//body/div[4]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")
    WebElement boschMikser;
    @FindBy(xpath = "//b[contains(text(),'6.199,00')]")
    WebElement cena;

    public void clickKlasicni(){
        this.klasicni.click();
    }

    public void clickBosch() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,50)", "");
        Thread.sleep(500);
        this.bosch.click();
    }

    public void clickOstaleBoje() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(500);
        this.color.click();
        js.executeScript("window.scrollBy(0,80)", "");
    }

    public String boschMikserText() throws InterruptedException {

       return boschMikser.getText();
    }

    public String boschCena(){
        return cena.getText();
    }
}
