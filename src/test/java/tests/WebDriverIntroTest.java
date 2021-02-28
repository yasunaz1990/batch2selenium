package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverIntroTest {

    @Test
    public void gotoSpecifiedWebPage() {
        //1. Prepare the WebDriver executables
        //   Downloading the chromedriver exe
        WebDriverManager.chromedriver().setup();
        // 1) download the chromedriver executable file
        // 2) Run the chromedriver exe ---> service

        //2. Create an object of ChromeDriver
        ChromeDriver chrome = new ChromeDriver();
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
}
