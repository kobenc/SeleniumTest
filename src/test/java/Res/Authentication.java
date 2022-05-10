package res;

import res.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class Authentication {

    private WebDriver driver;
    private Locator loc;
	private Configreader cr;
    
	private final By userTag = By.id("user_tag");
	
	public Authentication(WebDriver driver) {
        this.driver  = driver;
        loc = new Locator(driver);
		cr=new Configreader("config//config.txt");
    }
    
    public void login() {
        
		By login = By.className("signin");
		By userName = By.id("form3-username");
		By password = By.id("form3-password");
		By loginSubmit = By.className("submit");

		WebElement loginElement = loc.locate(login);
        loginElement.click();
		
		WebElement userNameElement = loc.locate(userName);
        userNameElement.sendKeys(cr.getusername());
		
		WebElement passwordElement = loc.locate(password);
        passwordElement.sendKeys(cr.getpassword());
		
		WebElement loginSubmitElement = loc.locate(loginSubmit);
        loginSubmitElement.click();
		
		loc.locate(userTag);
	}
	
	public void logout(){
		
		WebElement userTagElement = loc.locate(userTag);
		userTagElement.click();
		
		By logout = By.xpath("//div[@id='dasher_app']//div//div[@class='links']//form//button");
		
		WebElement logoutElement = loc.locate(logout);
		logoutElement.click();
    }
	
	public boolean isLoggedIn(){
		return loc.safeLocate(userTag);
	}
}
