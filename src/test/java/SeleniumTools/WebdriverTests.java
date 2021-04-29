package SeleniumTools;

import SeleniumTools.Drivers.BrowserList;
import SeleniumTools.Drivers.LoggingBrowser;
import SeleniumTools.Drivers.WebBrowser;
import SeleniumTools.Elements.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

public class WebdriverTests
{
    @Test
    public void CanCreateAWebDriver() {
        // Test assumes that chromedriver is installed and on the PATH, and able to be run.
        WebBrowser b = new WebBrowser();
        b.Start(BrowserList.Chrome);
        Assertions.assertNotNull(b.GetDriver());
        b.Quit();
    }

    @Test
    public void CanCreateALoggingBrowser() {
        // Test assumes that chromedriver is installed and on the PATH, and able to be run.
        WebBrowser b = new LoggingBrowser(new WebBrowser());
        b.Start(BrowserList.Chrome);
        Assertions.assertNotNull(b.GetDriver());
        b.Quit();
    }

    @Test
    public void CanNavigateThroughAUserFlow() {

        WebBrowser browser = new LoggingBrowser(new WebBrowser());
        browser.Start(BrowserList.Chrome);
        browser.GoTo("https://www.reddit.com");
        By loginBtnBy = By.xpath("//*[text() = 'Log In']");
        browser.FindElement(loginBtnBy).click();
        browser.Quit();
    }

    @Test
    @Disabled("skipping this as it doesn't seem to be reliably passing.")
    public void iFramesTest() {
        By loginBtnBy = By.xpath("//*[text() = 'Log In']");
        By loginTxtBy = By.xpath("//*[@id='loginUsername']");

        String url = "http://www.reddit.com";
        WebBrowser browser = new LoggingBrowser(new WebBrowser());
        browser.Start(BrowserList.Chrome);
        browser.GoTo(url);

        browser.FindElement(loginBtnBy).click();

        Element usernameTextField = browser.FindElement(loginTxtBy);

        usernameTextField.typeText("derp");

        browser.Quit();
    }

}