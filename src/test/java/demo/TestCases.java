package demo;

import demo.wrappers.Wrappers;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;



public class TestCases {
    ChromeDriver driver;
    Wrappers wrapper = new Wrappers();

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //Open URL
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        //Enter name
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i1']/../../following-sibling::div//input")));
        WebElement nameInput = driver.findElement(By.xpath("//div[@id='i1']/../../following-sibling::div//input"));
        wrapper.clickAction(nameInput);
        //nameInput.click();
        //nameInput.clear();
        //nameInput.sendKeys(Keys.CLEAR,"Crio Learner");
        wrapper.inputText("Crio Learner",nameInput);
//
//        //Enter Why are you practicing Automation?
//        //Getting current currentEpochTime
        long currentTimeMillis = System.currentTimeMillis();
//        LocalTime myObj = LocalTime.now();
        long currentEpochTime = currentTimeMillis/1000;
        System.out.println(currentEpochTime);
//
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i5']/../../following-sibling::div//textarea")));
        WebElement whyAutomationInput = driver.findElement(By.xpath("//div[@id='i5']/../../following-sibling::div//textarea"));
        wrapper.clickAction(whyAutomationInput);
        //Actions actions = new Actions(driver);

        // Perform a click action on the element
        //actions.click(whyAutomationInput).perform();
        //whyAutomationInput.click();
        wrapper.inputText("I want to be the best QA Engineer!"+currentEpochTime,whyAutomationInput);
        //whyAutomationInput.sendKeys(Keys.CLEAR,"I want to be the best QA Engineer! "+currentEpochTime);
//
//        //Select radio button: How much experience do you have in Automation Testing?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='radiogroup']/descendant::span[@class='aDTYNe snByac OvPDhc OIC90c']")));
        List<WebElement> expOptins = driver.findElements(By.xpath("//div[@role='radiogroup']/descendant::span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        wrapper.selectOption("0 - 2",expOptins,driver);
//
//        //Select checkbox : Which of the following have you learned in Crio.Do for Automation Testing?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='list']/descendant::span[@class='aDTYNe snByac n5vBHf OIC90c']")));
        List<WebElement> skillList = driver.findElements(By.xpath("//div[@role='list']/descendant::span[@class='aDTYNe snByac n5vBHf OIC90c']"));
        List<String> optionsToSelect = new ArrayList<>(Arrays.asList("Java", "Selenium", "TestNG"));
        wrapper.selectCheckbox(optionsToSelect,skillList);
//
//        //Select option from dropdown : How should you be addressed?
//        //Click on dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'addressed?')]/../../../following-sibling::div/div[@role='listbox']")));
        WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'addressed?')]/../../../following-sibling::div/div[@role='listbox']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",dropdown);
        wrapper.clickAction(dropdown);
//
//        //Select option from list
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']/span")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']")));
        List<WebElement> titles = driver.findElements(By.xpath("//div[@role='option']/span"));
        wrapper.selectOption("Rather not say",titles,driver);

        //Select date : What was the date 7 days ago?

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='date']")));
        WebElement date = driver.findElement(By.xpath("//input[@type='date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",date);
        wrapper.getCurrentDateMinusSeven(date);

        //Select currentTime
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Hour']")));
        WebElement hourInput = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",hourInput);
//        wrapper.getCurrentHour(hourInput);
        hourInput.sendKeys("07");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Minute']")));
        WebElement minuteInput = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        //wrapper.getCurrentMinute(minuteInput);
        minuteInput.sendKeys("30");

//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Time']/../following-sibling::div[@role='listbox']")));
//        WebElement timeFormatDropdown = driver.findElement(By.xpath("//div[text()='Time']/../following-sibling::div[@role='listbox']"));
//        wrapper.clickAction(timeFormatDropdown);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Time']/../following-sibling::div[@role='listbox']//div[@role='option']//span")));
//        List<WebElement> meridiemFormat = driver.findElements(By.xpath("//div[text()='Time']/../following-sibling::div[@role='listbox']//div[@role='option']//span"));
//        String currentMeridiem = wrapper.getCurrentMeridiem();
//        wrapper.selectOption(currentMeridiem,meridiemFormat);

        //Submit form
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Submit']")));
        WebElement submitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        wrapper.clickAction(submitButton);

        //Verify successfull submission
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Thanks for your response')]")));
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Thanks for your response')]"));
        if(confirmationMessage.getText().trim().equalsIgnoreCase("Thanks for your response, Automation Wizard!")){
            System.out.println(confirmationMessage.getText());
            System.out.println("Google form submitted successfully");
        }else{
            System.out.println("Error occured : please check");
        }

    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}