package seleniumtraining.rediffmail;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumtraining.base.Base;

public class Rediffactions extends Base {
	public void signupToRediff(WebDriver d) throws IOException {
		ArrayList<String>ids=new ArrayList<String>();
		ids.add("");
		d.get("https://mail.rediff.com");
		d.findElement(By.linkText("Rediffmail")).click();
		if(d.getTitle().equals("Rediffmail")&&d.getCurrentUrl().equals("https://mail.rediff.com/cgi-bin/login.cgi")) {
			d.findElement(By.linkText("Create a new account")).click();
			d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//d.findElement(By.xpath("//input[contains(@name,'named')]")).sendKeys("QA");
//				for(int i=0;i<ids.size();i++){
//					ids.add(p.getProperty(""));
//				}
			}
			do {
				d.findElement(By.xpath("//input[contains(@name,'logind')]")).sendKeys("qaops");
				d.findElement(By.xpath("//input[contains(@name,'btnchk')]")).click();
			}while(d.findElement(By.xpath("div#check_availability")).getText().equals("Yippie! The ID you've chosen is available."));
			
			if(d.findElement(By.xpath("div#check_availability")).isDisplayed()) {
				if(d.findElement(By.xpath("div#check_availability")).getText().equals("Yippie! The ID you've chosen is available.")){
					
			}
		}
	}
}
