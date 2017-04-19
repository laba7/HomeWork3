package AutoTests;


import javaBase.BaseScript;
import javaBase.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static javaBase.BaseScript.getConfiguredDriver;


/**
 * Created by User on 19.04.2017.
 */
public class CreateCategoryTest extends BaseScript {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "Test test";
    private static By lector = By.className("");

    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
        WebDriver driver = getConfiguredDriver();
        // ...
        GeneralActions actions = new GeneralActions(driver);
        actions.login(login, password);
        // login

        // create category
        actions.createCategory(categoryName);

        // check that new category appears in Categories table

        // finish script
    }
}
