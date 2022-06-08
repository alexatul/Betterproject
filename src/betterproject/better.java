package betterproject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class better {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();   // open the chrome window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://betterqa.ro/top-movies/");    // open the site betterqa

            // enter the password
            driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
            driver.findElement(By.name("Submit")).submit();

        String expectedTitle = driver.getTitle();
        System.out.println("Title is: " + expectedTitle);   // view the title of the site

        // check the displayed title
        try {
            String actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/h2")).getText();
            if (expectedTitle.equalsIgnoreCase(actualTitle))
                System.out.println("Title Matched");
            else
                System.out.println("Title didn't match");
        }catch (Exception e) {}


        // check a list of movie's title are displayed
            boolean DisplayRedemption = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/h2")).isDisplayed();
            if (DisplayRedemption)
                System.out.println("Movie title displayed is: The Shawshank Redemption");
            else
                System.out.println("No movie title displayed");

            boolean DisplayDilwale = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/h2")).isDisplayed();
            if (DisplayDilwale)
                System.out.println("Movie title displayed is: Dilwale Dulhania Le Jayenge");
            else
                System.out.println("No movie title displayed");

            boolean DisplayGodfather = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/h2")).isDisplayed();
            if (DisplayGodfather)
                System.out.println("Movie title displayed is: The Godfather");
            else
                System.out.println("No movie title displayed");

            boolean DisplayImpossible = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/h2")).isDisplayed();
            if (DisplayImpossible)
                System.out.println("Movie title displayed is: Impossible Things");
            else
                System.out.println("No movie title displayed");

            //  click on "Learn more"
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button")).click();

            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getText();

            if (driver.getPageSource().contains("1994-09-23")) {
                System.out.println("Verification Successful - Correct realese date Redemption movie");
            } else {
                System.out.println("Verification Failed - Incorrect realesed date Redemption movie");
            }

            // verify the vote average
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input")).getText();
            if (driver.getPageSource().contains("8.7")) {
                System.out.println("Verification Successful - Correct vote average Redemption movie");
            } else {
                System.out.println("Verification Failed - Incorrect vote average Redemption movie");
            }

            //  click on "close"
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[3]/button")).click();

            //  click on "Learn more"
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[19]/div[3]/button")).click();

            // verify if the realese date is correct
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getText();
            if (driver.getPageSource().contains("2008-07-14")) {
                System.out.println("Verification Successful - Correct realese date The Dark Knight");
            } else {
                System.out.println("Verification Failed - Incorrect realese date The Dark Knight");
            }

            //  verify if the popularity value is correct
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[3]/div/input")).getText();
            if (driver.getPageSource().contains("83.708")) {
                System.out.println("Verification Successful - Correct popularity The Dark Knight");
            } else {
                System.out.println("Verification Failed - Incorrect popularity The Dark Knight");
            }

            //  verify if the vote average value is correct
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input")).getText();
            if (driver.getPageSource().contains("8.5"))  // the vote agerage of the "The Dark Knight is 8.6 (on internet) and on site appear 8.5
            {
                System.out.println("Verification Successful - Correct vote average 'The Dark Knight'");
            } else {
                System.out.println("Verification Failed - Incorrect vote average 'The Dark Knight'");
            }

            //  verify if the vote count is correct
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[5]/div/input")).getText();
            if (driver.getPageSource().contains("27649")) {
                System.out.println("Verification Successful - Correct vote count The Dark Knight");
            } else {
                System.out.println("Verification Failed - Incorrect vote count The Dark Knight");
            }

            //  click on "close"
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[3]/button")).click();

            //  search the "Star Trek: First Contact" movie
            try {
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("Star Trek Contact");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div")).submit();

                //  verify if the "Star Trek: First Contact" movie is displayed and the "The Shawshank Redemption" movie isn't displayed
                boolean DisplayStarTrekContact = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/h2")).isDisplayed();

                if (!DisplayRedemption && DisplayStarTrekContact)
                    System.out.println("No 'Star Trek: First Contact' movie title displayed");

                else
                    System.out.println("Movie title displayed is 'Star Trek: First Contact' and no 'The Shawshank Redemption' movie appear");
            } catch (Exception e) {
            }


            WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));

            // delete text from search box
            while (!searchBox.getAttribute("value").equals("")) {
                searchBox.sendKeys(Keys.BACK_SPACE);
            }

            // go back to home page
            driver.navigate().back();

            // The title "Dou kyu sei – Classmates" displayed is wrong and it should be "Doukyusei – Classmates"
            String expectedDoukyusei = "Doukyusei - Classmates";
            String displayDoukyusei = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[7]/div[2]/h2")).getText();
            if (expectedDoukyusei.equalsIgnoreCase(displayDoukyusei))
                System.out.println("The title 'Doukyusei - Classmates' is correct");
            else
                System.out.println("The title of 'Doukyusei - Classmates'  movie is wrong");

            //  if you enter a wrong title like "Star Treck" nothing appear and should appear a message
            try {
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("Star Treck");
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div")).submit();

                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/h2")).isDisplayed();
                if (driver.getPageSource().contains("Message display"))
                    System.out.println("Message displayed");

                else
                    System.out.println("Message error not display");
            } catch (Exception e) {
            }

            // delete text from search box
            try {
                while (!searchBox.getAttribute("value").equals("")) {
                    searchBox.sendKeys(Keys.BACK_SPACE);
                }

                driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("James Bond");
                boolean displayedSearchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/h2")).isDisplayed();
                WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/h2"));
                if (displayedSearchButton && searchButton.isEnabled())
                    System.out.println("Search button ok");
                else
                    System.out.println("Search button not work");
            } catch (Exception e) {
            }


            // search button don't work and it should work when it press
            try {
                WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/div"));
          if(searchButton.isEnabled())
              System.out.println("Error: search button doesn't work");
            } catch (Exception e) {
                System.out.println("Search button it's OK");
            }

            // if you press on title page you should go at home page of the website
            try {
                WebElement titlePage = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.className("jss39 jss45 jss58 title")));
            } catch (Exception e) {
                System.out.println("Error pressing title page");
            }
//new WebDriverWait(driver, Duration.ofSeconds(10))
//                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/div/span")));


        //  close the window
        driver.quit();

    }

}
