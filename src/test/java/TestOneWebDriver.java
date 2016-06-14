import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestOneWebDriver {

    private String URL = null;
    private WebDriver Driver;

    @BeforeMethod
    public void initialize(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32/chromedriver.exe");
        URL = "https://192.168.100.26/";
        Driver = new ChromeDriver();
        Driver.get(URL);
    }

    @Test
    public void firstTaskWebDriverTest() throws IOException{
        WebElement usernameField = Driver.findElement(By.id("Username"));
        usernameField.sendKeys("");
        WebElement passwordField = Driver.findElement(By.id("Password"));
        passwordField.sendKeys("");
        WebElement loginButton = Driver.findElement(By.id("SubmitButton"));
        loginButton.click();
        WebElement nameField = Driver.findElement(By.id("name"));
        Assert.assertEquals(nameField.getText(), "Kontyava, Sergey", "Not the same value");
    }

    @Test
    public void byVariablesTest(){
        WebElement usernameInputID = Driver.findElement(By.id("Username"));
        WebElement usernameInputXPath = Driver.findElement(By.xpath(".//*[@id='Username']"));
        WebElement usernameInputCSS = Driver.findElement(By.cssSelector("#Username"));
        WebElement usernameInputName = Driver.findElement(By.name("Username"));
        WebElement formContainerClassName = Driver.findElement(By.className("login-form-container"));
        WebElement byInputTagName = Driver.findElement(By.tagName("input"));

        WebElement byLinkText = Driver.findElement(By.linkText("/Individual/Display?name=Kontyava Sergey&id=44316db6-adb8-45cb-84ac-ef1042ee2bea"));
        WebElement byPartialLinkText = Driver.findElement(By.linkText("/Individual/Display?name=Kontyava Sergey"));

        JavascriptExecutor jsexecutor = (JavascriptExecutor) Driver;
        WebElement byjQuery = (WebElement) jsexecutor.executeScript("return jQuery.find('#Username');");
    }

    @Test
    public void xpathCssFieldsTest(){
        WebElement usernameInputCSS = Driver.findElement(By.cssSelector("#Username"));
        WebElement usernameInputXPath = Driver.findElement(By.xpath(".//*[@id='Username']"));

        WebElement passwordInputCSS = Driver.findElement(By.cssSelector("#Password"));
        WebElement passwordInputXPath = Driver.findElement(By.xpath(".//*[@id='Password']"));

        WebElement rememberMeInputCSS = Driver.findElement(By.cssSelector("label[for='Remember']"));
        WebElement rememberMeInputXPath = Driver.findElement(By.xpath(".//*[@id='Remember']"));

        WebElement rememberMeLabelCSS = Driver.findElement(By.cssSelector(".editor-chbox>span"));
        WebElement rememberMeLabelXPath = Driver.findElement(By.xpath(".//span[contains(text(), \"Remember me\")]"));

        WebElement loginButtonCSS = Driver.findElement(By.cssSelector("#SubmitButton"));
        WebElement loginButtonXPath = Driver.findElement(By.xpath(".//*[@id='SubmitButton']"));

        WebElement signOutLinkCSS = Driver.findElement(By.cssSelector("a[title='Sign out']>ins"));
        WebElement signOutLinkXPath = Driver.findElement(By.xpath(".//a[@title='Sign out']"));

        WebElement allOfficesLinksCSS = Driver.findElement(By.cssSelector(".officeShortInfo a"));
        WebElement ollOfficesLinksXPath = Driver.findElement(By.xpath("//*[contains(@class, 'officeShortInfo')]/li/a"));

        WebElement chapaeve118LinkCSS = Driver.findElement(By.cssSelector(".officeShortInfo a"));
        WebElement chapaeve118LinkXPath = Driver.findElement(By.xpath(".//a[text()=\"Chapaeva 118\"]"));

        WebElement lunchVotingLinkCSS = Driver.findElement(By.cssSelector("a[href*=\"lunchvoting\"]"));
        WebElement lunchVotingLinkXPath = Driver.findElement(By.xpath(".//*[text()=\"Lunch Voting\"]"));

        WebElement notificationToInformationSpanCSS = Driver.findElement(By.cssSelector("#thirdContainer .question"));
        WebElement notificationToInformationSpanXPath = Driver.findElement(By.xpath(".//*[contains(@id, \"thirdContainer\")]/span"));

        WebElement notificationCCInformationSpanCSS = Driver.findElement(By.cssSelector("#fourthContainer .question"));
        WebElement notificationCCInformationSpanXPath = Driver.findElement(By.xpath(".//*[contains(@id, \"fourthContainer\")]/span"));

        WebElement allCompaniesContainerCSS = Driver.findElement(By.cssSelector("li[class|='company']"));
        WebElement allCompaniesContainerXPath = Driver.findElement(By.xpath(".//*[contains(@class, \"company-record\")]"));

        WebElement universalContactPaneCSS = Driver.findElement(By.cssSelector("#companyHeaders :nth-child(5)"));
        WebElement universalContactPaneXPath = Driver.findElement(By.xpath(".//*[@id='companyHeaders']/li[5]"));
    }
    @AfterMethod
    public void cleanup(){
        Driver.quit();
    }
}
