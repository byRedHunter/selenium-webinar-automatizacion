import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelecomTest extends DriverConnection {
    private WebDriverWait wait;

    public TelecomTest() {
        wait = new WebDriverWait(driver, 60);
    }

    @Test
    public void AddCustomerDone() {
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        WebElement radioButton = driver.findElement(By.xpath("//*[@value=\"ACTIVE\"]//following-sibling::label"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();

        WebElement inputName = driver.findElement(By.id("fname"));
        inputName.sendKeys("Name");

        WebElement inputLastName = driver.findElement(By.id("lname"));
        inputLastName.sendKeys("LastName");

        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("email3@test.test");

        WebElement inputAddress = driver.findElement(By.name("addr"));
        inputAddress.sendKeys("This is a simple message");

        WebElement inputNumber = driver.findElement(By.id("telephoneno"));
        inputNumber.sendKeys("632548589");

        WebElement buttonSubmit = driver.findElement(By.name("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();

        WebElement messageSuccess = driver.findElement(By.xpath("/html/body/section/div/header/h1"));
        wait.until(ExpectedConditions.visibilityOf(messageSuccess));
        messageSuccess.isDisplayed();

        WebElement idRegister = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]/h3"));
        System.out.println("REGISTRO EXITOSO, SU ID ES : " + idRegister.getText());
    }

    @Test
    public void AddCustomerReset() {
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        WebElement radioButton = driver.findElement(By.xpath("//*[@value=\"ACTIVE\"]//following-sibling::label"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();

        WebElement inputName = driver.findElement(By.id("fname"));
        inputName.sendKeys("Name");

        WebElement inputLastName = driver.findElement(By.id("lname"));
        inputLastName.sendKeys("LastName");

        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("email3@test.test");

        WebElement inputAddress = driver.findElement(By.name("addr"));
        inputAddress.sendKeys("This is a simple message");

        WebElement inputNumber = driver.findElement(By.id("telephoneno"));
        inputNumber.sendKeys("632548589");

        WebElement buttonReset = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[9]/ul/li[2]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonReset));
        buttonReset.click();

        WebElement buttonSubmit = driver.findElement(By.name("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("please fill all fields", alert.getText());
    }

    @Test
    public void VerifyRegister() {
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        WebElement buttonSubmit = driver.findElement(By.name("submit"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        buttonSubmit.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("please fill all fields", alert.getText());
        alert.dismiss();
    }

    @Test
    public void selectComboBoxValue() {
        driver.get("https://demo.guru99.com/payment-gateway/index.php");

        WebElement selectQuantity = driver.findElement(By.name("quantity"));
        wait.until(ExpectedConditions.visibilityOf(selectQuantity));
        new Select(selectQuantity).selectByVisibleText("4");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        /*WebElement successProcess = driver.findElement(By.xpath("//*[@id=\"three\"]/div/header/h2"));
        wait.until(ExpectedConditions.visibilityOf(successProcess));
        successProcess.isDisplayed();*/
    }
}
