import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SignUpTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void navigate() {
        driver.get("https://www.sharelane.com/cgi-bin/zip_code");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void zipCodeTest() {
        driver.findElement(
                By.name("zip_code")).sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        continueButton.click();

        String testItemName = "Sauce Labs Bike Light";

        WebElement itemTitle = driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::a", testItemName)));
        WebElement itemTitle = driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::a", testItemName)));

                driver.findElement(By.cssSelector("[name='zip_code']"));





        Assert.assertEquals(isZipCodeDisplayed, true, "q3123234");
        Assert.assertTrue(isZipCodeDisplayed,
                "Zip code should not be displayed");
        Assert.assertTrue(driver.findElement(By.name("first_name")).isDisplayed(),
                "First Name input should be displayed");
    }

    @Test
    public void registrationPositiveTest() throws InterruptedException {
        navigateToRegistration("12345");

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password1"));
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        WebElement registerButton = driver.findElement(By.cssSelector("[value=\"Register\"]"));


        String expectedResult = "123abd";

        firstNameInput.sendKeys("123.abd$");

        String actualResult = firstNameInput.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);


        lastNameInput.sendKeys("b");
        emailInput.sendKeys("test@test.com");
        passwordInput.sendKeys("123456");
        confirmPasswordInput.sendKeys("123456");
        registerButton.click();

        SoftAssert softAssert = new SoftAssert();





        WebElement CONFIRMATION = driver.findElement(By.);









        softAssert.assertTrue(driver.findElements(By.name("first_name")).isEmpty(),
                "There should be no First name field");
        softAssert.assertTrue(CONFIRMATION.isDisplayed(),
                "Confirmation message should be displayed");
        softAssert.assertEquals(CONFIRMATION.getText(), "Account is created!", "There should be 'Account is created!");


        Thread.sleep(2000);

        softAssert.assertAll();
    }


    public void navigateToRegistration(String zipCode) {
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys(zipCode);
        WebElement continueButton = driver.findElement(By.cssSelector("[value=\"Continue\"]"));
        continueButton.click();
    }
}
