package testCases;

import com.framework.CustomWebDriverManager;
import com.framework.UserActions;
import com.framework.Utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaselineSetupAndTearDown {

    UserActions actions = new UserActions();

    @BeforeClass
    public static void setupBrowser() {
        UserActions.loadBrowser();
    }

//    @After
//    public static void quitBrowser() {
//        UserActions.quitBrowser();
//    }



}
