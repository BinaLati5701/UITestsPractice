import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxTests {
    @Test
    public void selectCheckboxes() {
        WebDriverManager.chromedriver().setup();
        // open browser
        WebDriver driver = new ChromeDriver();

        // open website
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // maximize browser
        driver.manage().window().maximize();

        // locate checkbox 1
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        // locate checkbox 2
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // click checkbox 1
        checkbox1.click();

        // validate checkbox 1 selected
        assertTrue(checkbox1.isSelected());

        // validate checkbox 2 selected
        assertTrue(checkbox2.isSelected());

        // close browser
        driver.quit();
    }
}
