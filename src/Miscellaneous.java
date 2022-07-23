import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {


	public static void main(String []args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();//maximize the window.
		//driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("sessionkey"); selected cookiew will be deleted
		//session cookie is specific cookie have to delte and-
		//-if you click on any link on the page have to redirect to login page
		
		driver.get("http://google.com");
		
		//2.how to take sceen shot.
		//-->have to do casting of driver to- (TakeScreenshot)driver ,, -take screen shot method object
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//getScreenshotAs-->is a method visible only when you cast your driver object to takesscreenshot method.
		//here telling the browser to take the screen shot in file format and storing in src object now that-
		//-src has to bring on our desktop to view
		FileUtils.copyFile(src, new File("E://screenshot.png"));
		//https://commons.apache.org/proper/commons-io/download_io.cgi--->to get external jar
		
	}
	
	
}
