package webdrivermaven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LoginTest {

	 private WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        //WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://accounts.google.com/");
	    }

	    @Test
	    public void testGmailLogin() throws InterruptedException {
	        // Enter email or phone
	        WebElement emailField = driver.findElement(By.id("identifierId"));
	        emailField.sendKeys("your-email@gmail.com");
	        driver.findElement(By.id("identifierNext")).click();
	        Thread.sleep(2000); // Wait for password field to load

	        // Enter password
	        WebElement passwordField = driver.findElement(By.name("password"));
	        passwordField.sendKeys("your-password"); // Replace with your password
	        driver.findElement(By.id("passwordNext")).click();
	        driver.findElement(By.id("SignIn")).click();
	        
	        Thread.sleep(3000); // Wait for login to complete

	        // Validate login by checking for Gmail Inbox URL
	        Assert.assertTrue(driver.getCurrentUrl().contains("mail.google.com"), "Login failed!");
	    }

	    @AfterClass
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
