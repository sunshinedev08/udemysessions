package seleniumtraining.entrypoint;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

import seleniumtraining.base.Base;
import seleniumtraining.utils.Utilities;
import seleniumtraining.rediffmail.Rediffactions;

public class Entry {

	public static void main(String[] args) throws IOException {
		Base base=new Base();
		Properties p=new Properties();
		p=Utilities.readPropertiesFiles("driverpaths",System.getProperty("user.dir")+"//src//main//java//seleniumtraning//properties");
		WebDriver driver=base.selectWebDriver("chrome",p);
		Rediffactions rda=new Rediffactions();
		try {
			rda.signupToRediff(driver);	
		}catch(NoSuchSessionException nss) {
			System.out.println("Browser is closed due to above reason");
			System.exit(0);
		}
		Base.closeWebdriver();
	}
}
