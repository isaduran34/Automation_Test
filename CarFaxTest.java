package AutomationProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
public class CarFaxTest<old> {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //1.Go  to carfax.com
        driver.get("https://www.carfax.com/");
        System.out.println("step 1-----------------------------------------------------------------------------------");

        //2.Click on Find a Used Car
        driver.findElement(By.xpath("//a[@class='button button--green']")).click();
        System.out.println("step 2-----------------------------------------------------------------------------------");

        //3.Verify the page title contains the word "Used Cars"
        driver.findElement(By.xpath("//title[.='Used Cars for Sale | with Free CARFAX']"));
        System.out.println(driver.getTitle().contains("Used Cars for Sale | with Free CARFAX") ? "PASS" : "FAIL");
        System.out.println("step 3-----------------------------------------------------------------------------------");

        //4.Choose "Tesla" for  Make.
        System.out.println("step 4-----------------------------------------------------------------------------------");
        driver.findElement(By.name("make")).sendKeys("Tesla" + Keys.ENTER + Keys.TAB);
        Thread.sleep(2000);
        driver.findElement(By.name("make")).sendKeys("Tesla" + Keys.ENTER + Keys.TAB);
        System.out.println("step 4-----------------------------------------------------------------------------------");

        //5.Verify that the Select Model dropdown box contains 3 current Tesla models - (Model 3, Model S, Model X).
        System.out.println(driver.findElement(By.xpath("//option[@id= 'model_Model-3']")).getText().contains("Model 3") ? "Model 3 is : PASS" : "FAIL");
        System.out.println(driver.findElement(By.xpath("//option[@id= 'model_Model-S']")).getText().contains("Model S") ? "Model S is : PASS" : "FAIL");
        System.out.println(driver.findElement(By.xpath("//option[@id='model_Model-X']")).getText().contains("Model X") ? "Model X is : PASS" : "FAIL");
        System.out.println("step 5-----------------------------------------------------------------------------------");

        //6.Choose "Model S" for Model.
        driver.findElement(By.xpath("//option[@id= 'model_Model-S']")).click();
        System.out.println("step 6-----------------------------------------------------------------------------------");

        //7.Enter the zipcode as 22182 and click Next
        driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("22182" + Keys.ENTER);
        System.out.println("step 7-----------------------------------------------------------------------------------");

        //8. Verify that the page has "Step 2 – Show me cars with" text
        System.out.println(driver.getPageSource().contains("Step 2 - Show me cars with"));
        System.out.println("step 8-----------------------------------------------------------------------------------");

        //9.Click on all 4 checkboxes.
        driver.findElement(By.xpath("//div[@class= 'noAccident']")).click();
        driver.findElement(By.xpath("//div[@class= 'owner1']")).click();
        driver.findElement(By.xpath("//div[@class= 'personal']")).click();
        driver.findElement(By.xpath("//span[@aria-label='Toggle serviceRecords']")).click();
        System.out.println("step 9-----------------------------------------------------------------------------------");

        //10.Save the result of "Show me X Results" button to a variable. In this case it is 6.
        String result = driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText();
        System.out.println(result);
        System.out.println("step 10----------------------------------------------------------------------------------");

        //11.Click on "Show me x Results" button.
        driver.findElement(By.xpath("//button[@class='button large primary-green show-me-search-submit']")).click();
        System.out.println("step 11----------------------------------------------------------------------------------");

        //12.On the next page, verify that the results page has the same number of results as indicated in
        // Step 10 by extracting the number and comparing the result
        String confirm = driver.findElement(By.id("totalResultCount")).getText();
        System.out.println(confirm);
        System.out.println(result.equals(confirm) ? "PASS" : "FAIL");
       // System.out.println("step 12----------------------------------------------------------------------------------");

        //13.Verify the results also by getting the actual number of results displayed in the page with the number in the
        // Step 10. For this step get the count the number of WebElements related to each result.
        //driver.findElement(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        List<WebElement> elements = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        int count =0;
        for (WebElement el :
                elements) {
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(result)==(count) ? "WebElement count : " + count+  "  PASS" : "FAIL");

        //14.Verify that each result contains String “Tesla Model S”.
        System.out.println("Tesla Model S-----------------------------------------------------------------------------");
        List<WebElement> element = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement el :
                element)
            if(el.getText().contains("Tesla")){
                System.out.println("Tesla Model S");
                System.out.println("step 16---------------------------------------------------------------------------");
            }

        //15.Get the price of each result and save them into a list in the order of their appearance.
        List<WebElement> element1 = driver.findElements(By.xpath("//span[@class= 'srp-list-item-price']"));
        for (WebElement price :
                element1){
            System.out.println(price.getText().substring(7));
            System.out.println("step 15-------------------------------------------------------------------------------");
        }

        //16.Choose "Price - High to Low" option from Sort menu
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Price"+ Keys.ENTER+ Keys.TAB);
        System.out.println("Hig to Low Price--------------------------------------------------------------------------");
        System.out.println("step 16----------------------------------------------------------------------------------");

        //17.Verify that the results are displayed from high to low price.
        Thread.sleep(1000);
        List<WebElement> element2 = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));
        for (WebElement price1 :
                element2) {
            System.out.println(price1.getText().substring(7));
            System.out.println("results are displayed from high to low price-----------------------------------step 17");
        }


        //18.Choose "Mileage - Low to High" option from Sort menu
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Mil"+ Keys.ENTER + Keys.TAB);
        System.out.println("Mileage - Low to High\" option from Sort menu-------------------------------------step 18");


        //19.Verify that the results are displayed from low to high mileage.
        Thread.sleep(1000);
        System.out.println("");
        List<WebElement> elements5 = driver.findElements(By.xpath("//div[@class='srp-list-item-basic-info srp-list-item-special-features']"));
        for (WebElement el2: elements5) {
            System.out.println( el2.getText().substring(9,  (el2.getText().indexOf("mil"))));
            System.out.println("Low to High mileage----------------------------------------------------------- step 19");
        }

        //20.Choose "Year - New to Old" option from Sort menu

        driver.findElement(By.xpath("//select[@class='srp-header-sort-select ']")).sendKeys("Y"+ Keys.ENTER + Keys.TAB);
        driver.navigate().refresh();
        System.out.println("step 20----------------------------------------------------------------------------------");


        //21.Verify that the results are displayed from new to old year.
        Thread.sleep(1000);
        List<String> actualList21 = new ArrayList<>();
        List<WebElement> elements21 = driver.findElements(By.xpath("//article//div//h4[@class='srp-list-item-basic-info-model']"));
        for (WebElement e21: elements21) {
            System.out.println(e21.getText());
        System.out.println("from new to old year----------------------step 21-------------------------------------");
        }

    }}



