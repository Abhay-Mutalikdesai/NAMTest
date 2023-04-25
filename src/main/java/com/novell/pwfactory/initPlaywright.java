package com.novell.pwfactory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class initPlaywright {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;
    public static Properties prop;
    private static String propPath = "./src/test/resources/config/config.properties";

    public static Properties initProp() throws IOException {
        FileInputStream input = new FileInputStream(propPath);
        prop = new Properties();
        prop.load(input);
        return prop;
    }

    public static Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(100));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(100));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(100));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless).setSlowMo(1000));
                break;
            case "edge":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headless).setSlowMo(100));
                break;
            default:
                System.out.println("please pass the right browser name.");
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
        browserContext.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        page = browserContext.newPage();
        return page;
    }
}