package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverIntroTest {

    @Test
    public void prehistoricDriverBrowserSetUp() {
        // Java ----> Chromedriver.exe
        String exePath = System.getProperty("user.dir") + "/executables/chromedriver.exe";
        System.setProperty("webdriver.firefox.driver", exePath);
        ChromeDriver chrome = new ChromeDriver();
        chrome.get("https://github.com");
    }


    @Test
    public void gotoSpecifiedWebPage() {
        //1. Prepare the WebDriver executables
        //   Downloading the chromedriver exe
        WebDriverManager.chromedriver().setup();
        ChromeDriver chrome = new ChromeDriver();
        // 1) download the chromedriver executable file
        // 2) Run the chromedriver exe ---> service

        //2. Create an object of ChromeDriver
        chrome.get("https://trello.com");
        chrome.close();           // closes the chrome browser window
        chrome.quit();            // terminates the chromedriver exe
    }


    @Test(invocationCount = 10)
    public void changeBrowserWidnowSize() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chrome = new ChromeDriver();
        chrome.get("https://trello.com");

        // 1. Max the window size
        chrome.manage().window().maximize();

        // 2. Full screen
        chrome.manage().window().fullscreen();

        // 3. Size specs
        Dimension ipadDim = new Dimension(768, 1024);
        chrome.manage().window().setSize(ipadDim);

        chrome.close();           // closes the chrome browser window
        chrome.quit();
    }

    @Test
    public void getSystemInformation() {
        // 1. Detecting OS system that test is running
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        if(osName.equalsIgnoreCase("Windows 10")) {
            System.out.println("Do something for windows");
        }
        else if(osName.equalsIgnoreCase("Mac OS X")) {
            System.out.println("Do something for Macbook");
        }
        else if(osName.equalsIgnoreCase("Linux")) {
            System.out.println("Do somthing for Linux");
        }

        // 2. Detecting the root path for your project
        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath);

        // 3. Detecting the user account name
        String user = System.getProperty("user.name");
        System.out.println(user);
    }


    @Test
    public void findingAnWebElement() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chrome = new ChromeDriver();
        chrome.get("https://trello.com");

        // Element location info
        By email_input = By.xpath("/html/body/section[@id='hero']/div/div/div[2]/form/div[1]/input");
        WebElement emailInputElement = chrome.findElement(email_input);
        System.out.println( emailInputElement.getTagName() );

        By signup_button = By.xpath("/html/body/section[@id='hero']/div/div/div[2]/form/div[2]/button");
        WebElement signUpButtonElement = chrome.findElement(signup_button);
        String bttnText = signUpButtonElement.getText();
        System.out.println(bttnText);
        signUpButtonElement.click();
    }

}
