package tehnomediaTests;

import tehnomediaPages.searchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class searchFormTest {

    WebDriver wd;

    @BeforeMethod //before method initialize wd
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aleks\\Downloads\\chromedriver_win32\\chromedriver.exe");

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        wd.manage().window().maximize();
    }

    @AfterMethod // close browser after method
    public void terminateBrowser() {
        wd.close();
    }
    /**
     * Testing menu functionality, clicking on one of the menu links, opening/closing menu button.
     * */
    @Test
    public void searchForm() throws InterruptedException {
        wd.get("https://tehnomedia.rs");

        Assert.assertEquals(wd.getCurrentUrl(),"https://tehnomedia.rs/", "Page url should be 'https://tehnomedia.rs/'.");
        searchForm search = new searchForm(wd);

        search.clickSearchForm();
        search.enterValueinSearchForm("tel");
        search.clickTelevizor();

        Assert.assertEquals(wd.getCurrentUrl(), "https://www.tehnomedia.rs/tv-video-i-foto-tehnika/televizor/STELLA", "Page url should be 'https://www.tehnomedia.rs/tv-video-i-foto-tehnika/televizor/STELLA'");
    }

}