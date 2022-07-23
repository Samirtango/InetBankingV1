import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basepractice {
	
	public static void main(String []args)
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] item = {"Brocolli"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		
		int J=0;
		for(int i=0;i<items.size();i++)
		{
			String[] name = items.get(i).getText().split("-");
			String formattedname = name[0].trim();
			
			List itemsNeededList = Arrays.asList(item);
			if(itemsNeededList.contains(formattedname))
			{
					J++;
					for (int k=0; k<2 ;k++)
					{
						driver.findElement(By.xpath("//a[@class='increment']")).click();
					}
					driver.findElement(By.xpath("//div[@class='product-action']/button")).click();
					if(J == item.length)
					{
						break;
					}
				
			}
			
		}
		
		
	}

}
