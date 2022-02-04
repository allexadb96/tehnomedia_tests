package tehnomediaTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tehnomediaPages.menu;
import tehnomediaPages.addToCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class addToCartTest {

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
        wd.close();
    }

    @Test
    public void addtoCart() throws InterruptedException {

       menu menu = new menu(wd);
       addToCart add = new addToCart(wd);
       menu.clickOpenMenu();
       menu.hoverOnKucniAparati();
       menu.clickMikseri();
       add.addToCartGorenjeMikser();
       add.addToCart();
       add.zavrsiKupovinu();

       Assert.assertEquals(add.mikserIme(),"GORENJE M 420 CW", "Mikser should be 'GORENJE M 420 CW'");
        System.out.println("GORENJE M 420 CW added to cart.");

    }

    @Test
    public void deleteFromCart() throws InterruptedException {
        addtoCart();

        addToCart delete = new addToCart(wd);

        delete.deleteFromCart();

        WebElement emptyCart = wd.findElement(By.xpath("//p[contains(text(),'Vaša korpa je prazna!')]"));

        Assert.assertEquals(emptyCart.getText(),"VAŠA KORPA JE PRAZNA!", "Message should be 'VAŠA KORPA JE PRAZNA!'");
        System.out.println("GORENJE M 420 CW successfully deleted from cart.");

    }


}