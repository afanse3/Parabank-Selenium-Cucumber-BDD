package StepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Registration extends env_target {
    @Given("User is on homepage")
    public void userIsOnHomepage() {
        //Set driver path
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        //Maximize the window driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set URL
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"leftPanel\"]/h2"))
        );
    }

    @When("User click on register link")
    public void userClickOnRegisterLink() {
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
    }

    @And("User fill their name and address info")
    public void userFillTheirNameAndAddressInfo() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/h1"))
        );
        driver.findElement(By.xpath("//*[@id=\"customer.firstName\"]")).sendKeys("Arfan");
        driver.findElement(By.xpath("//*[@id=\"customer.lastName\"]")).sendKeys("Ahmad");
        driver.findElement(By.xpath("//*[@id=\"customer.address.street\"]")).sendKeys("Panda");
        driver.findElement(By.xpath("//*[@id=\"customer.address.city\"]")).sendKeys("City");
        driver.findElement(By.xpath("//*[@id=\"customer.address.state\"]")).sendKeys("Indo");
        driver.findElement(By.xpath("//*[@id=\"customer.address.zipCode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"customer.phoneNumber\"]")).sendKeys("082212348790");
        driver.findElement(By.xpath("//*[@id=\"customer.ssn\"]")).sendKeys("123");

    }

    @And("User fill the username, password, and confirm password")
    public void userFillTheUsernamePasswordAndConfirmPassword() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;

        driver.findElement(By.xpath("//*[@id=\"customer.username\"]")).sendKeys("admin" + randomNumber);
        driver.findElement(By.xpath("//*[@id=\"customer.password\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"repeatedPassword\"]")).sendKeys("12345");
    }

    @And("User fill the wrong username, password, and confirm password")
    public void userFillTheWrongUsernamePasswordAndConfirmPassword() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;

        driver.findElement(By.xpath("//*[@id=\"customer.username\"]")).sendKeys("admin" + randomNumber);
        driver.findElement(By.xpath("//*[@id=\"customer.password\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"repeatedPassword\"]")).sendKeys("1234");
    }

    @And("User click register button")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("User is on dashboard page")
    public void userIsOnDashboardPage() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/p"))
        );
        driver.quit();
    }

    @Then("User got error message")
    public void userGotErrorMessage() {
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"repeatedPassword.errors\"]"))
        );
        driver.quit();
    }


}
