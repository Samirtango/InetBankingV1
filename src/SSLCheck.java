import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String []args) {
		
		//ChromeOptions--->used to set up behaviour for chrome browser. how brower should behave.
		//use the ChromeOptions object and pass it as argument in webdriver
		ChromeOptions options = new ChromeOptions();//ChomeOptions is a class.
		//chromedriver.chromium.org/capabilities visit this site to learn more how to use chrome effectively
		
		options.setAcceptInsecureCerts(true);
		options.addExtensions();//--->add any plugins and stuff
		options.setProxy(null);
		
		Proxy proxy = new Proxy();
		proxy.getHttpProxy(); //set proxy like this
		options.setCapability("proxy", false);//("proxy", value)
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		

		
		
		
	}
	
}
