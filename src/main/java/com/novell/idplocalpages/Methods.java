package com.novell.idplocalpages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static com.novell.factory.HelperClass.*;
import static com.novell.idplocalpages.UserStores.userName;

public class Methods {
    final private Page page;
    final private FrameLocator iframe;

    final private String methodsLoc = "#tab_2";
    final private String classLoc = "#AuthClass";
    final private String identifiesUserLoc = "#IdentifiesUser";
    final private String availableUserStoresLoc = "#availableStores";

    public Methods(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        this.iframe.locator(methodsLoc).click();
    }

    public static String methodName = getRandText();

    public void createClass() {
        iframe.locator(newLoc).click();
        iframe.locator(displayNameLoc).fill(methodName);
        iframe.locator(classLoc).selectOption(Classes.className);
        iframe.locator(identifiesUserLoc).check();
        iframe.locator(availableUserStoresLoc).selectOption(userName);
        iframe.locator(methodsMoveLeftLoc).click();
        iframe.locator(finishLoc).click();
    }
}