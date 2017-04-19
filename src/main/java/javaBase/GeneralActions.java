package javaBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Properties;

/**
 * Contains main script actions that may be used in scripts.
 */
/**
 * Created by User on 19.04.2017.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.cssSelector("#subtab-AdminCategories");
    private By newCategories = By.cssSelector("#page-header-desc-category-new_category");
    private By nameCategories = By.cssSelector("#name_1");
    private By saveCategories = By.cssSelector("#category_form_submit_btn");
    private By sorted = By.cssSelector(".active");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */

    public void login(String login, String password) throws InterruptedException {
        driver.navigate().to(Properties.getBaseAdminUrl());
        Thread.sleep(1000l);
        WebElement loginInput = driver.findElement(By.cssSelector("#email"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        WebElement loginButton  = driver.findElement(By.cssSelector("[name='submitLogin']"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**[
     * Adds new category in Admin Panel.
     * @param categoryName
     */

    public void createCategory(String categoryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueLink));
        WebElement catalogueLink = driver.findElement(this.catalogueLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogueLink)
                .moveToElement(categoriesLink)
                .click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCategories));
        WebElement newCategories = driver.findElement(this.newCategories);

        actions.moveToElement(newCategories)
                .click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameCategories));
        WebElement nameCategories = driver.findElement(this.nameCategories);
        nameCategories.sendKeys(categoryName);
        WebElement saveCategories = driver.findElement(this.saveCategories);
        actions.moveToElement(saveCategories)
                .click().build().perform();
        WebElement sorted = driver.findElement(this.sorted);
        actions.moveToElement(sorted)
                .click().build().perform();
    }
    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until(...);
        // ...
    }
}
