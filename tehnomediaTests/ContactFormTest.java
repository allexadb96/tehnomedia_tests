package tehnomediaTests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import tehnomediaPages.ContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactFormTest {

    WebDriver wd;

    @BeforeMethod //before method initialize wd
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\aleks\\Downloads\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("https://www.tehnomedia.rs/pages/kontakt.html");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        wd.manage().window().maximize();
    }

    @AfterMethod // close browser after method
    public void terminateBrowser() {
        wd.close();
    }

    @AfterSuite
    public void terminateBrowserAfterSuite() {
        wd.close();
    }

    @Test //Sending message with all correct data
    public void sendMessage(){
        ContactForm contact = new ContactForm(wd);

        contact.enterImePrezime("Pera Peric");
        contact.enterEmail("Pera123123434k@gmail.com");
        contact.enterMessage("Test");
        contact.clickSend();

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
       Assert.assertEquals( alert.getText(),"Vaša poruka je poslata", "Message should be 'Vaša poruka je poslata'");
        alert.accept();
    }

    @Test //found bug
    public void sendMessageNoName(){
        ContactForm contact = new ContactForm(wd);


        contact.enterEmail("Pera123123434k@gmail.com");
        contact.enterMessage("Test");
        contact.clickSend();

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals( alert.getText(),"Error", "Message should not be sent! Bug");
        alert.accept();
    }

    @Test //found bug
    public void sendMessageNoEmail(){
        ContactForm contact = new ContactForm(wd);

        contact.enterImePrezime("Pera Peric");
        contact.enterMessage("Test");
        contact.clickSend();

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals( alert.getText(),"Error", "Message should not be sent! Bug");
        alert.accept();
    }

    @Test //found bug
    public void sendMessageNoData(){
        ContactForm contact = new ContactForm(wd);

        contact.clickSend();

        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals( alert.getText(),"Error", "Message should not be sent! Bug");
        alert.accept();
    }



}