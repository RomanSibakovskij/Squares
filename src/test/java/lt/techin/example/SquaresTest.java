package lt.techin.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SquaresTest {

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/greiz/Desktop/QApraktinisALL.html");
    }
    @Test
    void testClickAllSquares() throws InterruptedException {
        SquaresPage squaresPage = new SquaresPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> squares = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".icon")));

        //repeat 6 times in a row
        squaresPage.repeatSquareClicking(7);

        System.out.println("The square was clicked");

    }


    @AfterEach
    void close() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }
}
