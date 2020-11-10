import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Before");
    }

    @Test
    public void firstTest() {
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String expected = "Hello, my name is";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Input Forms")));
        WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
        inputForms.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("No, thanks!")));
        WebElement noThanksPopup = driver.findElement(By.linkText("No, thanks!"));
        noThanksPopup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Simple Form Demo")));
        WebElement simpleFormDemo = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormDemo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-message")));
        WebElement userMessage = driver.findElement(By.id("user-message"));
        userMessage.sendKeys("Hello, my name is ");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath('//*[@id="get-input"]/button')));
        WebElement showMessage = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        showMessage.click();

        String actualResult = driver.findElement(By.xpath("//*[@id=\"display\"]")).getText();
        System.out.println(actualResult);
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @Test
    public void secondTest() {
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        String expected = "Total a + b = 3";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Input Forms")));
        WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
        inputForms.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("No, thanks!")));
        WebElement noThanksPopup = driver.findElement(By.linkText("No, thanks!"));
        noThanksPopup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Simple Form Demo")));
        WebElement simpleFormDemo = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormDemo.click();

        WebElement inputTwoElementsHeader = driver.findElement(By.id("displayvalue"));
        Actions actions = new Actions(driver);
        actions.moveToElement(inputTwoElementsHeader);
        actions.perform();

        WebElement inputFieldA = driver.findElement(By.id("sum1"));
        inputFieldA.sendKeys("1");

        WebElement inputFieldB = driver.findElement(By.id("sum2"));
        inputFieldB.sendKeys("2");

        WebElement getTotal = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
        getTotal.click();

        String actualResult = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div")).getText();
        System.out.println(actualResult);
        Assertions.assertThat(actualResult).isEqualTo(expected);
    }

    @Test
    public void thirdTest() {
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Input Forms")));
        WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
        inputForms.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("No, thanks!")));
        WebElement noThanksPopup = driver.findElement(By.linkText("No, thanks!"));
        noThanksPopup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkbox Demo")));
        WebElement simpleFormDemo = driver.findElement(By.linkText("Checkbox Demo"));
        simpleFormDemo.click();

        WebElement checkCheckBox = driver.findElement(By.id("check1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkCheckBox);
        actions.perform();

        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input"));
        checkBox1.click();

        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input"));
        checkBox3.click();

        Assertions.assertThat(checkBox1.isEnabled()).isEqualTo(true);
        Assertions.assertThat(checkBox3.isEnabled()).isEqualTo(true);
    }

    @Test
    public void fourthTest(){
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Input Forms")));
        WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
        inputForms.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("No, thanks!")));
        WebElement noThanksPopup = driver.findElement(By.linkText("No, thanks!"));
        noThanksPopup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[3]/a")));
        WebElement radioButtonNavBar = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[3]/a"));
        radioButtonNavBar.click();

        WebElement getValuesButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(getValuesButton);
        actions.perform();

        //div[text()='Group Radio Buttons Demo']/parent::div//input[@value='Male']

        driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input")).click();
        getValuesButton.click();

        String actualResult = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).getText();
        System.out.println(actualResult);
        Assertions.assertThat(actualResult).isEqualTo("Sex : Male\n" + "Age group: 15 - 50");
    }

    @Test
    public void fifthTest(){
        driver.get("https://www.seleniumeasy.com/test/");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Input Forms")));
        WebElement inputForms = driver.findElement(By.linkText("Input Forms"));
        inputForms.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("No, thanks!")));
        WebElement noThanksPopup = driver.findElement(By.linkText("No, thanks!"));
        noThanksPopup.click();

        driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[4]/a")).click();
    }
}