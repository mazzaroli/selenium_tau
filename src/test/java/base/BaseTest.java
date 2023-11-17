package base; // Package where the class resides

import org.openqa.selenium.By; // Import necessary Selenium classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List; // Import the List class

public class BaseTest { // Define the BaseTest class

    private WebDriver driver; // Declare an instance of WebDriver

    public void setUp(){ // Method to set up and execute the test
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // Set the location of the Chrome driver
        driver = new ChromeDriver(); // Initialize the Chrome driver

        driver.get("https://the-internet.herokuapp.com/"); // Open the web page

        WebElement inputsLink = driver.findElement(By.linkText("Shifting Content")); // Find the "Shifting Content" link
        inputsLink.click(); // Click the link

        WebElement Example1Link = driver.findElement(By.linkText("Example 1: Menu Element")); // Find the "Example 1: Menu Element" link
        Example1Link.click(); // Click the link

        List<WebElement> menuItems = driver.findElements(By.tagName("li")); // Find all <li> elements

        System.out.println(menuItems.size()); // Print the number of found elements

        for( WebElement menu : menuItems){ // Iterate through the found elements
            System.out.println(menu.getText()); // Print the text of each element
        }

        driver.quit(); // Close the browser upon test completion
    }

    public static void main(String[] args){ // Main method to run the test
        BaseTest test = new BaseTest(); // Create an instance of the BaseTest class
        test.setUp(); // Call the setUp method to execute the test
    }
}