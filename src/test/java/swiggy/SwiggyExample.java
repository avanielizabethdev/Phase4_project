package swiggy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SwiggyExample {
	
	private AndroidDriver driver;

	  @BeforeMethod
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:platformVersion", "12");
	    desiredCapabilities.setCapability("appium:deviceName", "Galaxy A71");
	    desiredCapabilities.setCapability("appium:appPackage", "in.swiggy.android");
	    desiredCapabilities.setCapability("appium:appActivity", "in.swiggy.android.activities.HomeActivity");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	  }
	  
	  @Test
	  public void SwiggyTest() {
		
		MobileElement el1 = (MobileElement) driver.findElementById("in.swiggy.android:id/tv_primary_cta");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
		el2.click();
	  
		MobileElement change = (MobileElement) driver.findElementById("in.swiggy.android:id/item_menu_top_header_restaurant_name1");
		change.click();
		MobileElement search = (MobileElement) driver.findElementById("in.swiggy.android:id/location_description");
		search.sendKeys("Delhi");
		search.click();
		MobileElement option = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
		option.click();
		MobileElement confirm = (MobileElement) driver.findElementById("in.swiggy.android:id/google_place_search_title_text1");
		confirm.click();
		
	  
		MobileElement food = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"explore food deliveries\"]");
		food.click();
		MobileElement offer = (MobileElement) driver.findElementByAccessibilityId("GET 50% OFF ON FIRST ORDER");
		offer.click();
		MobileElement item = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup");
		item.click();
		MobileElement add = (MobileElement) driver.findElementById("in.swiggy.android:id/quantity_text_1");
		add.click();
		MobileElement viewCart = (MobileElement) driver.findElementById("in.swiggy.android:id/tv_checkout");
		viewCart.click();

		
	  }
		
	  
	  @AfterMethod
	  public void tearDown()throws Throwable {
		  
		  Thread.sleep(10000);
	    driver.quit();
	  }

}
