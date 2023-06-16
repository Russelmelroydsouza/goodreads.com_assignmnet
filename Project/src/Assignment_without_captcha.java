
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import net.sourceforge.tess4j.TesseractException;


public class Assignment_without_captcha {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
		System.setProperty("webdriver.chrome.driver", "/Users/Russel/Downloads/chromedriver_win322/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.goodreads.com/");
		
		//To Login 
		driver.findElement(By.xpath("//div[@id='signInUsingContent']/a[@class='gr-button gr-button--fullWidth gr-button--auth gr-button--dark']")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Russel Dsouza");
		driver.findElement(By.id("ap_email")).sendKeys("Dsouzarusselrussel00@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Assignment_1");
		driver.findElement(By.id("ap_password_check")).sendKeys("Assignment_1");
		driver.findElement(By.xpath("//div[@class='a-row a-spacing-extra-large']//span[@class='a-button-inner']//input[@class='a-button-input']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(), "Important Message!");
		driver.findElement(By.xpath("//a[@class='a-link-emphasis']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email")).sendKeys("Dsouzarusselrussel00@gmail.com");
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Assignment_1");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		//driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Assignment_1");
		
		//To Read Captcha code and Print in text box
		//WebElement imageelement=driver.findElement(By.xpath("//div[@id='auth-captcha-image-container']/img[@id='auth-captcha-image']"));
	    // File src = 	imageelement.getScreenshotAs(OutputType.FILE);
	    // String path = "C:\\Users\\Russel\\Seleniumtrainings\\Project1\\Project\\captchaimg\\captcha.png";
	    // FileUtils.copyFile(src,new File(path));
	    // Thread.sleep(1000);
	    //ITesseract image =new Tesseract();
	    //String str = image.doOCR(new File(path));
	    //System.out.println(str);
	    // driver.findElement(By.xpath("//input[@id='auth-captcha-guess']")).sendKeys(str);
	    
	    
		//}catch (Exception e) {
		//	System.out.println("Exception Caught"+e.getMessage());
		//}
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(1000);
		
		//To Search Particular book [In my case 2 States]
		driver.findElement(By.xpath("//input[@class='searchBox__input searchBox__input--navbar']")).sendKeys("2 States: The Story of My Marriage");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='searchBox__icon--magnifyingGlass gr-iconButton searchBox__icon searchBox__icon--navbar']")).click();
		driver.findElement(By.xpath("//table[@class='tableList']//tr[1]//button[@class='wtrToRead'][1]")).click();
		Thread.sleep(1000);
		
		//To Remove book from My Books
		driver.findElement(By.xpath("//nav[@class='siteHeader__primaryNavInline']//li[@class='siteHeader__topLevelItem'][contains(.,'My Books')]")).click();
		driver.findElement(By.xpath("//img[@title='Remove from my books']")).click();
		
		Alert alert = driver.switchTo().alert();
		//String alertMessage= driver.switchTo().alert().getText();
		//System.out.println(alertMessage);
		Thread.sleep(1000);
		alert.accept();
		
		//To Sign out 
		driver.findElement(By.xpath("//a[@class='dropdown__trigger dropdown__trigger--profileMenu dropdown__trigger--personalNav']")).click();	
		driver.findElement(By.xpath("//div[@class='dropdown__menu dropdown__menu--profileMenu gr-box gr-box--withShadowLarge dropdown__menu--show']//li[@role='menuitem Sign out']")).click();	
	}

}
