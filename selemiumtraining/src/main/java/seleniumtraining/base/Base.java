package seleniumtraining.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	private static WebDriver driver;
	private static FileReader fr;
	
	public WebDriver selectWebDriver(String choice,Properties prop) {
		try {
			if(choice.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath")+".exe");
				driver=new ChromeDriver();
			}else if(choice.equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath")+".exe");
				driver=new FirefoxDriver();
			}else {
				System.setProperty("webdriver.ie.driver", prop.getProperty("iepath")+".exe");
				driver=new InternetExplorerDriver();
			}
		}catch(NullPointerException npe) {
			//System.out.println();
		}
		return driver;
	}
	public static void closeWebdriver() throws IOException {
		try {
			driver.quit();
			fr.close();
		}catch(NullPointerException npe) {
			
		}
	}
}
