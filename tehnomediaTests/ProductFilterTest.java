package tehnomediaTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tehnomediaPages.ProductFilter;
import tehnomediaPages.menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ProductFilterTest {

    WebDriver wd;

    @BeforeMethod //before method initialize wd
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aleks\\Downloads\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("https://www.tehnomedia.rs/");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        wd.manage().window().maximize();
    }

    @AfterMethod // close browser after method
    public void terminateBrowser() {
        wd.close();
    }

    @Test
    public void ProductFilterTest() throws InterruptedException {
        menu menu = new menu(wd);
        ProductFilter product = new ProductFilter(wd);
        menu.clickOpenMenu();
        menu.hoverOnKucniAparati();
        menu.clickMikseri();
        product.clickKlasicni();
        product.clickBosch();
        product.clickOstaleBoje();
        Assert.assertEquals(product.boschMikserText(), "BOSCH MFQ36450S", "Product should be 'BOSCH MFQ36450S'");
        System.out.println(product.boschMikserText()+ ", Cena: "+ product.boschCena());


    }
}

