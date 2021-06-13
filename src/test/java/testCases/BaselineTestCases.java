package testCases;

import org.junit.Test;

public class BaselineTestCases extends BaselineSetupAndTearDown {

    @Test
    public void Test_01() {

        String username = "test";
        String password = "test";

        actions.waitForElementVisible("xpath.homePage.adCancer", 3);
        actions.waitForElementClickable("xpath.homePage.UserNameField", 3);
        actions.clickElement("xpath.homePage.UserNameField");
        actions.typeValueInField(username, "xpath.homePage.UserNameField");
        actions.waitForElementClickable("xpath.homePage.PasswordField", 3);
        actions.clickElement("xpath.homePage.PasswordField");
        actions.typeValueInField(password, "xpath.homePage.PasswordField");
        actions.waitForElementVisible("xpath.homePage.LoginButton", 3);
        actions.clickElement("xpath.homePage.LoginButton");
        actions.waitForElementClickable("xpath.logged.inbox", 3);
        actions.clickElement("xpath.logged.inbox");
        for (int i = 0; i <30; i++) {
            for (int j = 0; j < 5; j++) {
                actions.waitForElementVisible("xpath.inbox.allEmails", 3);
                actions.waitForElementClickable("xpath.inbox.allEmails", 3);
                actions.clickElement("xpath.inbox.allEmails");
                actions.waitForElementVisible("xpath.inbox.deleteAvailable", 3);
                actions.waitForElementClickable("xpath.inbox.deleteAvailable", 3);
                actions.clickElement("xpath.inbox.deleteAvailable");
                actions.waitForElementVisible("xpath.inbox.deleteDisabled", 3);
            }
            actions.refreshPage();
        }
    }
}
