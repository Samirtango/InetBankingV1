import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LiveDemo {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");

// click on column

		driver.findElement(By.xpath("//tr/th[1]")).click();

// capture all webelements into list

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

// capture text of all webelements into new(original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		//on list apply stream. then map applying iteration storing in s by using gettext. And then collect in list all those elemetns
		//all string their and comes in original list.
		
// sort on the original list of step 3 -> sorted list
		
		//

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//above just sort and collect and store in new list.
		

// compare original list vs sorted list

		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;

// scan the name column with getText ->Beans->print the price of the Rice

		do

		{

			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Rice"))

					.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
				//herer map only receive the price of only beans from all the other elements. and send it to collectors

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1)

			{

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}

		} while (price.size() < 1);

		
		//do while is fist we are doing then if you doing find then do again.
		//Until unless this condition fails then it will terminate.
		//above is pagination concept.
	}

	
	private static String getPriceVeggie(WebElement s) {
		//here webelement ---> till the particul beans already there then move to sibling next to it. so below opration.

// TODO Auto-generated method stub

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		//above if the searching element is not in 1st page then click next in the page and search in the nex page.

		return pricevalue;

	}

}
