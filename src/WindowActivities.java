import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class WindowActivities {

//Auto mate browser code -Broswer activities

public static void main(String[] args) {

// TODO Auto-generated method stub



	System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
driver.manage().window().maximize();

driver.get("http://google.com");
driver.navigate().to("https://rahulshettyacademy.com");
driver.navigate().back();
driver.navigate().forward();

}



}

