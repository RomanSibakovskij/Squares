package lt.techin.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SquaresPage {

    @FindBy(css = ".icon")
    private List<WebElement> squares;
    WebDriver driver;

    public SquaresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // click all squares
    public void squareClicking() {
        for (WebElement square : squares) {
            square.click();
        }

        // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Handle the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // repeat the square clicking process multiple times
    public void repeatSquareClicking(int times) {
        for (int i = 0; i < times; i++) {
            squareClicking();
            System.out.println("Completed iteration: " + (i + 1));
        }
    }




}

