package res;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class Locator {

    private WebDriver driver;
    private WebDriverWait wait;

    public Locator(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement locate(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
	
	public Boolean safeLocate(By locator) {
        Boolean ret = false;
	    if (driver.findElements(locator).size() != 0) {
            ret = true;
        }
        return ret;
    }
}
