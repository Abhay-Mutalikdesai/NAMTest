package com.novell.idplocalpages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static com.novell.factory.HelperClass.*;

public class Classes {
    final private Page page;
    final private FrameLocator iframe;

    final private String classesLoc = "#tab_1";
    final private String javaClassLoc = "#JavaClassName_Select";

    final String javaClass = "com.novell.nidp.authentication.local.BasicClass";

    public Classes(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        this.iframe.locator(classesLoc).click();
    }

    public static String className = getRandText();

    public void createClass() {
        iframe.locator(newLoc).click();
        iframe.locator(displayNameLoc).fill(className);
        iframe.locator(javaClassLoc).selectOption(javaClass);
        iframe.locator(nextLoc).click();
        iframe.locator(finishLoc).click();
    }
}