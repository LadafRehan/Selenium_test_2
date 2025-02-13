package Demo.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    public static void loginIntoTechPanda() throws InterruptedException {
    	
        System.out.println("Hello");
        
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
         
        driver.get("https://demo.guru99.com/V1/");
        
        driver.manage().window().maximize();
        
        Thread.sleep(5);
        
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr609591");
        
        Thread.sleep(5);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("YbudAgU");
        
        Thread.sleep(5);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        
        Thread.sleep(5);
        
        
        // Closing the browser
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) {
        try {
            loginIntoTechPanda();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
