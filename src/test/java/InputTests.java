import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTests {

    @Test
    public void typeNumbersIntoInputBox() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/inputs");

        driver.manage().window().maximize();

        // locate input box
        WebElement inputBox = driver.findElement(By.tagName("input"));

        // type numbers
        inputBox.sendKeys("12345");

        // validate typed value
        assertEquals("12345", inputBox.getAttribute("value"));

        // clear input
        inputBox.clear();

        // type new number
        inputBox.sendKeys("999");

        // validate new value
        assertEquals("999", inputBox.getAttribute("value"));

        // keyboard actions
        inputBox.sendKeys(Keys.ARROW_UP);

        // close browser
        driver.quit();
    }
}
