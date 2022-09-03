package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			
			url = prop.getProperty("url");
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		public WebDriver init() {
			readConfig();
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
			return driver;
		}
	
	public WebDriver tearDown() {
		driver.close();
		driver.quit();
		return driver;
	}

}
