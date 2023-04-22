package com.novell.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.novell.pwfactory.initPlaywright;
import com.novell.pwfactory.HelperClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Paths;

import static com.novell.pwfactory.initPlaywright.*;

public class BaseClass {
    protected Page page;

    final private String usernameLoc = "input[name=\"username\"]";
    final private String passwordLoc = "input[name=\"password\"]";
    final private String submitLoc = "input[type=\"submit\"]";
    final private String dropdownLoc = ".menu-down-icon";
    final private String logoutLoc = "#logout2";

    @BeforeTest
    public void beforeTestSetUp() throws IOException {
        prop = initPlaywright.initProp();
        page = initPlaywright.initBrowser(prop);
        page.navigate(prop.getProperty("url"));
        page.fill(usernameLoc, prop.getProperty("username"));
        page.fill(passwordLoc, prop.getProperty("password"));
        page.click(submitLoc);
    }

    @AfterMethod (alwaysRun = true)
    public void afterMethodTearDown(ITestResult result){
        if(result.getStatus()!=1)
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("failedTest.png")).setFullPage(true));
    }

    @AfterTest
    public void afterTestTearDown() {
        HelperClass.frameLocator(page).locator(dropdownLoc).click();
        HelperClass.frameLocator(page).locator(logoutLoc).click();
        browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        page.close();
        browser.close();
        playwright.close();
    }
}