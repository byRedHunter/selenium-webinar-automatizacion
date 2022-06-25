import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends DriverConnection {
    private WebDriverWait wait;

    public FirstTest() {
        wait = new WebDriverWait(driver, 60);
    }

    @Test
    public void GoogleTest() {
        driver.get("https://google.com.pe");

        WebElement textSearcher = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(textSearcher));
        textSearcher.sendKeys("oso panda");

        WebElement btnSearch = driver.findElement(By.name("btnK"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        btnSearch.click();

        WebElement result = driver.findElement(By.id("hdtb"));
        wait.until(ExpectedConditions.visibilityOf(result));
        result.isDisplayed();
    }
}
