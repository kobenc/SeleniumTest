package res;

import org.openqa.selenium.interactions.*;
import res.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class Study {

    private WebDriver driver;
    private Locator loc;
	private Configreader cr;
	
	public Study(WebDriver driver) {
        this.driver  = driver;
        loc = new Locator(driver);
		cr=new Configreader("config//config.txt");
    }
    
    public void hover() {
		
		Authentication login = new Authentication(driver);
		login.login();
		
		By hover = By.xpath("//header[@id='top']//div[@class='site-title-nav']//nav//section[3]//a");
		
		WebElement we= loc.locate(hover);
		Actions action = new Actions(driver);
		action.moveToElement(we).perform();
	}
	
	public void click_on_hover(){
		this.hover();
		By study = By.xpath("//header[@id='top']//div[@class='site-title-nav']//nav//section[3]//div//a[@href='/study']");
		WebElement we=loc.locate(study);
		we.click();
	}
	
	public void new_study_button_click(){
		this.click_on_hover();
		By addStudy = By.cssSelector("button.button.button-green");
		WebElement we=loc.locate(addStudy);
		we.click();
	}

	public void first_step(){
		
		// Explicit wait here too
		
		this.new_study_button_click();
		By nextButton = By.xpath("//form[@class='form3']//div[6]//button[@class='button']");
		WebElement we=loc.locate(nextButton);
		we.click();
		By tabs = By.className("tabs-horiz");
		we=loc.locate(tabs);
	}
	
	public void file_upload(){
		this.first_step();
		
		By pgn = By.className("pgn");
		WebElement we=loc.locate(pgn);
		we.click();
		
		By fileupload = By.id("chapter-pgn-file");
		we=loc.locate(fileupload);
		we.sendKeys(cr.getpgn());
		
		By finalButton = By.xpath("//form[@class='form3']//div[6]//button");
		we=loc.locate(finalButton);
		we.click();
		
		By playername=By.xpath("//div[@class='study__chapters']//div[3]");
		we=loc.locate(playername);
	}
}
