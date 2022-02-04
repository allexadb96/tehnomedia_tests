package tehnomediaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class menu {
    private WebDriver wd;


    public menu(WebDriver wd){
        this.wd = wd;
        PageFactory.initElements(this.wd,this);
    }

    @FindBy(xpath = "//header/div[@id='main_navigation_wrap']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
    WebElement menuButon;

    @FindBy(xpath = "//a[contains(text(),'Kućni aparati')]")
    WebElement linkKucniAparati;

    @FindBy(xpath = "//a[contains(text(),'Mikseri')]")
    WebElement mikseri;


    public void clickOpenMenu(){
        this.menuButon.click();
    }

    public void hoverOnKucniAparati(){
        Actions action = new Actions(wd);
        action.moveToElement(this.linkKucniAparati).perform();
    }

    public void clickMikseri(){
        this.mikseri.click();
    }
}
