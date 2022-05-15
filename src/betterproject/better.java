package betterproject;
import dev.failsafe.internal.util.Assert;
import java.util.concurrent.TimeUnit;
import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class better {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();   // open the chrome window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://betterqa.ro/top-movies/");    // open the site betterqa
        String title = driver.getTitle();
        System.out.println("Title is: " + title);   // view the title of the site

        // enter the password
        driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
        driver.findElement(By.name("Submit")).submit();

        // check a list of movie's title are displayed
        Boolean DisplayRedemption = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/h2")).isDisplayed();
        if(DisplayRedemption)
            System.out.println("Movie title displayed is: The Shawshank Redemption");
        else
            System.out.println("No movie title displayed");

        Boolean DisplayDilwale = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/h2")).isDisplayed();
        if(DisplayDilwale)
            System.out.println("Movie title displayed is: Dilwale Dulhania Le Jayenge");
        else
            System.out.println("No movie title displayed");

        Boolean DisplayGodfather = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/h2")).isDisplayed();
        if(DisplayGodfather)
            System.out.println("Movie title displayed is: The Godfather");
        else
            System.out.println("No movie title displayed");

        Boolean DisplayImpossible = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/h2")).isDisplayed();
        if(DisplayImpossible)
            System.out.println("Movie title displayed is: Impossible Things");
        else
            System.out.println("No movie title displayed");

        //  click on "Learn more"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button")).click();

        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getText();

        if (driver.getPageSource().contains("1994-09-23"))
        {
            System.out.println("Verification Successful - Correct realese date Redemption movie");
        }
        else
        {
            System.out.println("Verification Failed - Incorrect realesed date Redemption movie");
        }
        //  click on "close"
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[3]/button")).click();

        //  click on "Learn more"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[19]/div[3]/button")).click();
        // verify if the realese date is correct
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getText();
        if (driver.getPageSource().contains("2008-07-18"))
        {
            System.out.println("Verification Successful - Correct realese date The Dark Knight");
        }
        else
        {
            System.out.println("Verification Failed - Incorrect realese date The Dark Knight");
        }
        //  verify if the popularity value is correct
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[3]/div/input")).getText();
        if (driver.getPageSource().contains("78.724"))
        {
            System.out.println("Verification Successful - Correct popularity The Dark Knight");
        }
        else
        {
            System.out.println("Verification Failed - Incorrect popularity The Dark Knight");
        }
        //  verify if the vote average value is correct
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input")).getText();
        if (driver.getPageSource().contains("8.6"))  // the vote agerage of the "The Dark Knight is 8.6 (on internet) and on site appear 8.5
        {
            System.out.println("Verification Successful - Correct vote average The Dark Knight");
        }
        else
        {
            System.out.println("Verification Failed - Incorrect vote average The Dark Knight");
        }
        //  verify if the vote count is correct
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[5]/div/input")).getText();
        if (driver.getPageSource().contains("27511"))
        {
            System.out.println("Verification Successful - Correct vote count The Dark Knight");
        }
        else
        {
            System.out.println("Verification Failed - Incorrect vote count The Dark Knight");
        }
        //  click on "close"
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[3]/button")).click();


        //  search the "Star Trek: First Contact" movie
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("Star Trek Contact");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div")).submit();
        //  verify if the "Star Trek: First Contact" movie is displayed and the "The Shawshank Redemption" movie isn't displayed
        Boolean DisplayStarTrekContact = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/h2")).isDisplayed();
        if(!DisplayRedemption && DisplayStarTrekContact)
            System.out.println("No 'Star Trek: First Contact' movie title displayed");
        else
            System.out.println("Movie title displayed is 'Star Trek: First Contact' and no 'The Shawshank Redemption' movie appear");

        //  close the window
        driver.quit();

    }

}
