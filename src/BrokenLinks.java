import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// broken URL
		// Step 1 - IS to get all urls tied up to the links using Selenium
		// Java methods will call URL's and gets you the status code
		// if status code >400 then that url is not working-> link which tied to url is
		// broken
		// a[href*="soapui"]' regular expression css is created here.

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();

		for (WebElement link : links)

		{

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			//URL(url).openConnection()---> URL is class. and openConnection() is method. and passsing argument url
			//Cast it with Http
			//calling openconnection method present in URL class with object.method-->it's return type is HTTPURL connection
			
			
			
			conn.setRequestMethod("HEAD");//making call to that url using head method.
			conn.connect();//make a call and response you get in conn.

			int respCode = conn.getResponseCode();

			System.out.println(respCode);

			a.assertTrue(respCode < 400, "The link with Text" + link.getText() + " is broken with code" + respCode);//-->soft assertion

		}

		a.assertAll(); //here assertall even if it found 4 link failed but checks all the 20 links can stop execution. at the end we have to mention this

	}

	private static Object getReturnCode(WebElement link) {

// TODO Auto-generated method stub

		return null;

	}

}
