package TodoistApp.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import com.aventstack.extentreports.ExtentReports;


public class TodoistAppTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	AndroidDriver<AndroidElement> driver = null;
	



@BeforeSuite
public void Start() throws MalformedURLException {
	
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("appium:deviceName", "Pixel_3a_API_33");
    desiredCapabilities.setCapability("appium:automationName", "appium");
    desiredCapabilities.setCapability("appium:appPackage", "com.todoist");
    desiredCapabilities.setCapability("appium:appActivity", "com.todoist.alias.HomeActivityDefault");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
			
		   driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);	
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}


@BeforeClass
public void TodoistAppTestReport() {
	  report = ExtentFactory.getInstance();
	  parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Todoist App Hoem Page</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
}

ExtentTest test;
public void ApplicationPage(ExtentTest test) {
	 PageFactory.initElements(driver, this);
	 this.test = test;
}


//Test Case 1:
@Test(priority=-1)

public void LogIn() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>GoogleButton Test</b></p>");
	 try {
		     
			 driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.todoist:id/btn_google']")).click();
			 Thread.sleep(5000);
			 
			 driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container']")).click();
			 Thread.sleep(20000);
			
			 
		 
	 }
	 catch(Exception e) {
		 test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>GoogleButton button is not ok</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(driver, "GoogleButton");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "GoogleButton.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue( driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.todoist:id/btn_google']")).isEnabled());
			driver.quit();
	 }
}

//Test Case 2:
@Test(priority=1)

public void AddTaskButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add-Task Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Quick add\"]")).click();
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>AddTaskButton button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "AddTaskButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AddTaskButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\\\"Quick add\\\"]")).isEnabled());
		driver.quit();
	}
}

//Test Case 3:
@Test(priority=3)

public void TaskNameField() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Task-Name Field Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/message']")).sendKeys("New Task");
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>TaskNameField button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "TaskNameField");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TaskNameField.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/message']")).isEnabled());
		driver.quit();
	}
}

//Test Case 4:
@Test(priority=4)

public void TaskDescriptionField() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Task-DescriptionField Field Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/description']")).sendKeys("This new task for Testing this Software");
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Task Description Field button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "TaskDescriptionField");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TaskDescriptionField.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.todoist:id/description']")).isEnabled());
		driver.quit();
	}
}
//Test Case 5:
@Test(priority=5)

public void SelectDateButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Select-Date Button Test</b></p>");
	try {
		
		driver.findElement(By.id("com.todoist:id/schedule")).click();
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Select Date Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "SelectDateButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SelectDateButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.id("com.todoist:id/schedule")).isEnabled());
		driver.quit();
	}
}

//Test Case 6:
@Test(priority=6)

public void TumorrowButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Tumorrow-Button Test</b></p>");
	try {
		
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(4000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Tumorrow Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "TumorrowButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TumorrowButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.id("android:id/text1")).isEnabled());
		driver.quit();
	}
}

//Test Case 7:
@Test(priority=7)

public void PriorityButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Priority-Button Test</b></p>");
	try {
		
		driver.findElement(By.id("com.todoist:id/priority")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout")).click();
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Tumorrow Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "TumorrowButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TumorrowButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.id("com.todoist:id/priority")).isEnabled());
		driver.quit();
	}
}

@Test(priority=8)


public void AddButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add-Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]")).click();
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Open Manu Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "AddButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "AddButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\\\"Add\\\"]")).isEnabled());
		driver.quit();
	}
}
//Test Case 9:
@Test(priority=9)


public void InboxButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Inbox-Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/breadcrumb']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/breadcrumb']")).click();
		Thread.sleep(5000);
		
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Open Manu Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "InboxButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "InboxButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/breadcrumb']")).isEnabled());
		driver.quit();
	}
}

//Test Case 10:
@Test(priority=10)


public void ThreeDotButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Three-Dot Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Overflow menu\"]")).click();
		Thread.sleep(6000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ThreeDot Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "ThreeDotButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ThreeDotButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Overflow menu\"]")).isEnabled());
		driver.quit();
	}
}


//Test Case 11:
@Test(priority=11)


public void DuplicateTask() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>DuplicateTask Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/duplicate']")).click();
		Thread.sleep(5000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ThreeDot Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "DuplicateTask");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "DuplicateTask.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.todoist:id/duplicate']")).isEnabled());
		driver.quit();
	}
}
//Test Case 12:
@Test(priority=12)


public void CompleteTask() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>CompleteTask Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("(//android.widget.CheckBox[@content-desc=\"Complete\"])[2]")).click();
		Thread.sleep(5000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>CompleteTask Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "CompleteTask");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "CompleteTask.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("(//android.widget.CheckBox[@content-desc=\"Complete\"])[2]")).isEnabled());
		driver.quit();
	}
}
//Test Case 13:
@Test(priority=13)


public void ThreeDotManuHome() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Three-Dot-Manu   Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]")).click();
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ThreeDotManuHome Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "ThreeDotManuHome");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ThreeDotManuHome.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"More options\"]")).isEnabled());
		driver.quit();
	}
}
//Test Case 14:
@Test(priority=14)


public void ActivityLog() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>ActivityLog Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).click();
		Thread.sleep(5000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>ActivityLog Button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "ActivityLog");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ActivityLog.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).isEnabled());
		driver.quit();
	}
}


//Test Case 15:
@Test(priority=15)


public void BackButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>BackButton Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
		Thread.sleep(4000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "BackButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "BackButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).isEnabled());
		driver.quit();
	}
}
//Test Case 16:
@Test(priority=16)


public void SearchBtn() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Search Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Search\"]")).click();
		Thread.sleep(5000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "SearchBtn");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "SearchBtn.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Search\"]")).isEnabled());
		driver.quit();
	}
}
//Test Case 17:
@Test(priority=17)


public void TodayBtn() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>TodayBtn Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Drag\"]")).click();
		Thread.sleep(5000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "TodayBtn");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "TodayBtn.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Drag\"]")).isEnabled());
		driver.quit();
	}
}
//Test Case 18:
@Test(priority=18)


public void NotificationButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Notification Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Notifications\"]")).click();
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "NotificationButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NotificationButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Notifications\"]")).isEnabled());
		driver.quit();
	}
}

//Test Case 19:
@Test(priority=19)


public void UnreadButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Notification Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Unread (0)\"]")).click();
		Thread.sleep(4000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "NotificationButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NotificationButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Unread (0)\"]")).isEnabled());
		driver.quit();
	}
}

//Test Case 20:
@Test(priority=20)


public void NotificationBackButton() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Notification Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.ImageView")).click();
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>BackButton is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "NotificationButton");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "NotificationButton.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.ImageView")).isEnabled());
		driver.quit();
	}
}




//Test Case 21:
@Test(priority=21)


public void Profile() throws IOException {
	childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Profile Button Test</b></p>");
	try {
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]")).click();
		Thread.sleep(2000);
		
	}
	catch(Exception e) {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Profile button is not ok</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(driver, "Profile");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "Profile.png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		Assert.assertTrue( driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]")).isEnabled());
		driver.quit();
	}
}


@AfterClass
public void afterClass() {
	report.flush();
}

@AfterSuite
public void Close() {
	driver.quit();
}
}
