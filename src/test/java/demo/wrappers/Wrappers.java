package demo.wrappers;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    //click action
    public void clickAction(WebElement element){
        element.click();
    }

    public void inputText(String str,WebElement element){
        element.sendKeys(Keys.CLEAR,str);
    }

    public void selectOption(String text, List<WebElement> elements,WebDriver driver) throws InterruptedException {
        for(int i=0;i<elements.size();i++){
            if(elements.get(i).getText().trim().equalsIgnoreCase(text)){
                clickAction(elements.get(i));
                break;
            }
        }
    }

    public void selectCheckbox(List<String> options, List<WebElement> elements){
//        for(String option : options){
//            for(int i=0;i<elements.size();i++){
//                if(elements.get(i).getText().trim().equals(option)){
//                    clickAction(elements.get(i));
//                    break;
//                }
//            }
//        }

        Map<String, WebElement> elementMap = new HashMap<>();
        for (WebElement element : elements) {
            elementMap.put(element.getText().trim(), element);
        }

        // Iterate over each option
        for (String option : options) {
            // Check if the option exists in the map
            WebElement elementToClick = elementMap.get(option);
            if (elementToClick != null) {
                // Perform the click action
                elementToClick.click();
            }
        }
    }

    public void getCurrentDateMinusSeven(WebElement element){
        //get current date
        LocalDate currentDate = LocalDate.now(); // Create a date object
        System.out.println(currentDate);
        LocalDate currentDateMinusSeven = currentDate.minusDays(7);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myFormatObj.format(currentDateMinusSeven);
        System.out.println("After formatting: " + currentDateMinusSeven);
        //clickAction(element);
        inputText(formattedDate,element);
    }

    //Get current Time
    public void getCurrentHour(WebElement element){
     //get current time using LocalTime
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
        String formatedCurrenHour = myFormatObj.format(currentTime);
        System.out.println("Formated date : "+ formatedCurrenHour);
        inputText(formatedCurrenHour,element);
    }

    public void getCurrentMinute(WebElement element){
        //get current time using LocalTime
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("mm");
        String formatedCurrentMinute = myFormatObj.format(currentTime);
        System.out.println("Formated Minute : "+ formatedCurrentMinute);
        inputText(formatedCurrentMinute,element);
    }

    public String getCurrentMeridiem(){
        //get current time using LocalTime
        LocalTime currentTime  = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("a");
        String formatedCurrentMeridiem= myFormatObj.format(currentTime);
        System.out.println("Formated Meridiem : "+ formatedCurrentMeridiem);
        return formatedCurrentMeridiem;
    }
}