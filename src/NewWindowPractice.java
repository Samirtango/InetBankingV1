import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

//version 4 new stuff

public class NewWindowPractice {
	
	public static void main(String []args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		//pass the control using below code cause we have to pass the window id.
		Set<String> handles = driver.getWindowHandles();
		//now both parent and child id's are present in handles.
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");

		String CourseName=	driver.findElement(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).getTagName();
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(CourseName);
		File file =name.getScreenshotAs(OutputType.FILE);//object of File class.
	

		FileUtils.copyFile(file, new File("logo.png"));//source, destination
		
		
		
	}

}
