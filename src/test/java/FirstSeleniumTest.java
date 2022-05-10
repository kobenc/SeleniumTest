import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

import res.*;


public class FirstSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
	private Configreader cr;
	private Locator loc;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
		cr=new Configreader("config//config.txt");
		this.driver.get(cr.geturl());
		loc=new Locator(driver);
    }

    
    @Test
    public void loginTest() {
		
		// Tests Login (4)
		// After Login Explicit wait happens(18)
		
        Authentication login = new Authentication(driver);
		assertEquals(login.isLoggedIn(),false);
		login.login();
		assertEquals(login.isLoggedIn(),true);
		
		
		
    }
	
	@Test 
	public void logoutTest(){
		
		//Tests Logout (6)
		
		Authentication login = new Authentication(driver);
		login.login();
		login.logout();
		assertEquals(login.isLoggedIn(),false);
		
	}
	
	@Test
	public void titleTest() {
		
		//Tests title(19)
		
		String t=this.driver.getTitle();
		
		/// There is a • character that I could not test successfully in the title
		assertEquals("lichess.org ",t.substring(0,12));
		assertEquals(" Ingyenes Online Sakk",t.substring(13,t.length())); 
    } 
	
	@Test
	public void StaticPageTest(){
		
		/// (9)
		
		By about=By.className("about-side");
		WebElement we=loc.locate(about);
		assertEquals(we.getText().substring(0,21),"Lichess egy ingyenes ");
		assertEquals(loc.safeLocate(By.id("top")),true);
	}
	
	@Test
	public void StudyTest() {
		
		/// Sends a form logged in (5)
		/// Uploads a file (31)
		
		Study s=new Study(driver);
		s.file_upload();
		
		By analyse=By.className("study__chapters");
		assertEquals(loc.safeLocate(analyse),true);
		By game=By.xpath("//div[@class='study__chapters']//div[1]");
		WebElement we=loc.locate(game);
		assertEquals("BERCZES",we.getText().substring(2,9));
    }
	
	
	@Test
	public void HoverTest(){
		/// Hover Test (29)
		
		Study s= new Study(driver);
		s.hover();
		
		By study = By.xpath("//header[@id='top']//div[@class='site-title-nav']//nav//section[3]//div//a[@href='/study']");
		assertEquals(loc.safeLocate(study),true);
		
		
	}
	
	
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
