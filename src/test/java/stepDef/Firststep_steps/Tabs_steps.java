package stepDef.Firststep_steps;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tabs_steps extends env_target {
    @Given("I open browser")
    public void iOpenBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("I click menu Tabs")
    public void iClickMenuTabs() throws InterruptedException {
        WebElement btnTabs = driver.findElement(By.xpath("//*[@id=\"post-2715\"]/div[2]/div/div/div[2]/div[1]/ul/li[2]/a"));
        btnTabs.click();

        // handel ads
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id=\"ad_position_box\"]//div[@id=\"card\"]")));
        popup.findElement(By.xpath(".//div[@id='dismiss-button']")).click();
        System.out.println("ads showed");
        /*try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id=\"ad_position_box\"]//div[@id=\"card\"]")));
            popup.findElement(By.xpath(".//div[@id='dismiss-button']")).click();
            System.out.println("ads showed");
        } catch (TimeoutException e) {
            System.out.println("no ads");
        }*/

        WebElement simpleAccordion = driver.findElement(By.id("Simple Accordion"));
        String ariaSelectedValue = simpleAccordion.getAttribute("class");
        assert(ariaSelectedValue.contains("resp-tab-active"));
        System.out.println("I on simple accordion menu");
    }

    @And("I click section")
    public void iClickSection() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait waitAccordionPresent = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitAccordionPresent.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion")));

        WebElement section1 = driver.findElement(By.id("ui-id-1"));
        String ariaSelectedValue = section1.getAttribute("aria-selected");
        assert(ariaSelectedValue.equals("true"));
        System.out.println("I on simple accordion menu");

        WebElement section2 = driver.findElement(By.id("ui-id-3"));
        section2.click();
        String ariaSelectedValue2 = section2.getAttribute("aria-selected");
        assert(ariaSelectedValue2.equals("true"));

        WebElement section3 = driver.findElement(By.id("ui-id-5"));
        section3.click();
        String ariaSelectedValue3 = section3.getAttribute("aria-selected");
        assert(ariaSelectedValue3.equals("true"));

        WebElement section4 = driver.findElement(By.id("ui-id-7"));
        section4.click();
        String ariaSelectedValue4 = section4.getAttribute("aria-selected");
        assert(ariaSelectedValue4.equals("true"));
    }

    @Then("I verify section is opened")
    public void iVerifySectionIsOpened() {
        WebElement section4 = driver.findElement(By.id("ui-id-7"));
        String ariaSelectedValue4 = section4.getAttribute("aria-selected");
        assert(ariaSelectedValue4.equals("true"));

        driver.close();
        driver.quit();
    }
}
