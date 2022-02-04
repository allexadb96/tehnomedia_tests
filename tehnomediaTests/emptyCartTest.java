package tehnomediaTests;

import tehnomediaPages.emptyCartPurchase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class emptyCartTest {

    WebDriver wd;

    @BeforeMethod //before method initialize wd
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aleks\\Downloads\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("https://tehnomedia.rs");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        wd.manage().window().maximize();
    }

    @AfterMethod // close browser after method
    public void terminateBrowser() {
        //wd.close();
    }

    @Test
    public void emptyCartTest() throws InterruptedException {


        Assert.assertEquals(wd.getCurrentUrl(),"https://tehnomedia.rs/", "Page url should be 'https://tehnomedia.rs/'.");
        emptyCartPurchase cart = new emptyCartPurchase(wd);

        cart.clickCart();
        cart.clickPurchase();

        Assert.assertEquals(cart.getMessage(),"VAŠA KORPA JE PRAZNA!", "Message should be 'Vaša korpa je prazna!'");

    }


}