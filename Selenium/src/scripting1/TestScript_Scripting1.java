package scripting1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript_Scripting1 {
	public static void main(String[] args) {
		ChromeDriver chrome = null;
		try {
			//1. Open browser and navigate URL for actitime & verify url navigated
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			chrome = new ChromeDriver();
			chrome.manage().window().maximize();
			chrome.navigate().to("http://localhost/login.do");
			Thread.sleep(2000);
			
			if(chrome.getTitle().equalsIgnoreCase("actiTIME - Login")) {
				System.out.println("actiTime login page has opened successful");
			}else {
				System.out.println("Failed to open the login page for actiTime");
				return;
			}
			
			
			//2. Login with valid credentials & verify login is successful
			chrome.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
			chrome.findElement(By.name("pwd")).sendKeys("manager");
			chrome.findElement(By.id("loginButton")).click();
			Thread.sleep(2000);
			
			if(chrome.findElement(By.xpath("//td[@class='pagetitle']")).getText().equalsIgnoreCase("Enter Time-Track"))
			{
				System.out.println("Login to actiTime was successful");
			}else {
				System.out.println("Failed to login to the actiTime application");
				return;
			}
			
			
			//3. Handle the shortcut window if exist
			if(chrome.findElements(By.xpath("//div[@style='display: block;']")).size() > 0) {
				chrome.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			}
			
			
			//4. go to user menu & click on add user & verify add user page opened successful
			chrome.findElement(By.xpath("//div[text()='USERS']")).click();
			chrome.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(2000);
			
			if(chrome.findElement(By.xpath("//span[text()='Add User']")).isDisplayed()) {
				System.out.println("The Add User page has opened successful");
			}else {
				System.out.println("Failed to open the Add User page.");
				return;
			}
			
			
			//5. Create user and verify user created successuful
			chrome.findElement(By.xpath("//input[@name='firstName']")).sendKeys("demo");
			chrome.findElement(By.xpath("//input[@name='lastName']")).sendKeys("user1");
			chrome.findElement(By.xpath("//input[@name='email']")).sendKeys("demo.user1@sg.com");
			chrome.findElement(By.xpath("//input[@name='username']")).sendKeys("demouser1");
			chrome.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury");
			chrome.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury");
			chrome.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
			
			if(chrome.findElements(
					By.xpath("//div[@class='name']/span[text()='user1, demo']")).size() > 0) {
				System.out.println("The user is created successful");
			}else {
				System.out.println("Failed to create the user in the actiTime");
				return;
			}
			
			
			//6. delete user and verify user deleted successful
			chrome.findElement(By.xpath("//div[@class='name']/span[text()='user1, demo']")).click();
			Thread.sleep(2000);
			
			chrome.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			
			chrome.switchTo().alert().accept();
			
			Thread.sleep(2000);
			
			if(chrome.findElements(By.xpath("//div[@class='name']/span[text()='user1, demo']")).size() > 0) {
				System.out.println("Failed to delete the user from the actiTime");
				return;
			}else {
				System.out.println("The user deleted from the actiTime successful");
			}
			
			
			
			//7. Logout from actiTime & verify logout was successful
			chrome.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
			
			if(chrome.findElement(By.id("headerContainer")).getText().equalsIgnoreCase("Please identify yourself"))
			{
				System.out.println("The logout from the actiTime was succesful");
			}else {
				System.out.println("Failed to logout form the actiTime");
				return;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			//8. Close the browser
			chrome.close();
			chrome = null;
		}
	}
}
