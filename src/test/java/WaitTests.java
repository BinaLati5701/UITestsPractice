import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTests {

    @Test
    public void implicitAndExplicitWaits() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.manage().window().maximize();

        // click start button
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));

        startButton.click();

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement helloText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );

        System.out.println(helloText.getText());

        driver.quit();
    }
}