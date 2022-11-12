import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Email {
//
	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		//WebDriver dr = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("firstName")).sendKeys("Usman");
		
		driver.findElement(By.id("lastName")).sendKeys("Ali");
		
		driver.findElement(By.id("userEmail")).sendKeys("123@.com");
		
		WebElement RadioButton = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]"));
	    RadioButton.click();
	    
	    driver.findElement(By.id("userNumber")).sendKeys("0123456789");
	    
	    driver.findElement(By.id("subjectsInput")).sendKeys("English");
	    
	    driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).click();
	    new WebDriverWait (driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("react-datepicker__month")));
	    String monthYearVal = driver.findElement(By.className("react-datepicker__current-month")).getText();
	    System.out.println(monthYearVal);
	    String month = monthYearVal.split(" ")[0].trim();
	    String year = monthYearVal.split(" ")[1].trim();
	    while(!(month.equals("June") && year.equals("2021"))) {
		   driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/button[1]")).click();
		    monthYearVal = driver.findElement(By.className("react-datepicker__current-month")).getText();
		   System.out.println(monthYearVal);
		    month = monthYearVal.split(" ")[0].trim();
		    year = monthYearVal.split(" ")[1].trim();
	   }
	    driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[4]")).click();
        
        driver.findElement(By.id("subjectsInput")).sendKeys("English");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.TAB);
		
		
		  
		
		/*
		 * WebElement checkBoxSelected =
		 * driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
		 * boolean isSelected = checkBoxSelected.isSelected();
		 * 
		 * // performing click operation if element is not selected
		 * if(isSelected==false) {
		 * 
		 * checkBoxSelected.click(); }
		 */
 
		 
	        WebElement element = driver.findElement(By.xpath("//*[@id=\"hobbies-checkbox-1\"]"));
	        Actions actions = new Actions(driver);
	        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        actions.moveToElement(element).click();
        
      
        WebElement UploadImg = driver.findElement(By.id("uploadPicture"));
        UploadImg.sendKeys("C:\\Users\\Usman-DPA\\Desktop\\app.png");
        
        driver.findElement(By.id("currentAddress")).sendKeys("House, Street, City, Country");
        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.TAB);
        driver.findElement(By.id("react-select-4-input")).sendKeys("Delhi");
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.TAB);
        
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        
       
        //String color = driver.findElement(By.id("firstName")).getCssValue("border-color");
        //assertTrue(color.equals("rgb(220, 53, 69)"));
        
        String color = driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).getCssValue("border-color");
        String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        System.out.println("r: " + r + "g: " + g + "b: " + b);
        String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        System.out.println(hex);
        
        //String color = driver.findElement(By.id("firstName")).getCssValue("border-color");
        AssertJUnit.assertTrue(hex.equals("#dc3545"));
        
        String img = driver.findElement(By.id("userEmail")).getCssValue("background-image");
        AssertJUnit.assertTrue(img.equals("url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
        
        
        
		//driver.close();
		
	}

}
