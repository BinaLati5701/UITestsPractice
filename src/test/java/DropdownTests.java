import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTests {

    @Test
    public void selectDropdownOption() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        driver.manage().window().maximize();

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Option 1");

        WebElement selectedOption = dropdown.getFirstSelectedOption();

        assertEquals("Option 1", selectedOption.getText());

        driver.quit();
    }
}
