package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class IssueCreation {

    WebDriver driver;

    @Given("the student is logged in")
    public void student_is_logged_in() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://akmalice.pythonanywhere.com/login");
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        usernameField.sendKeys("issue");
        passwordField.sendKeys("issue1234");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div/div[1]/button"));
        loginButton.click();
    }

    @When("the student goes to the issue creation page")
    public void student_goes_to_issue_creation_page() {
        driver.get("https://akmalice.pythonanywhere.com/raise-issue");
    }

    @And("the student enters an issue description")
    public void student_enters_issue_description() {
        WebElement issueDescription = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div[1]/textarea"));
        issueDescription.sendKeys("This is a test issue created by a student.");
    }

    @And("the student clicks the \"Send\" button")
    public void student_clicks_send_button() {
        WebElement sendButton = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div/div[2]/button"));
        sendButton.click();
    }

    @Then("the issue should be created successfully")
    public void issue_created_successfully() {
        WebElement successMessage = driver.findElement(By.xpath("/html/body/div[2]/strong"));
        String message = successMessage.getText();
        assertEquals("Issue Raised Successfully", message);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
