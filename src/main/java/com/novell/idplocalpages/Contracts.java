package com.novell.idplocalpages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.novell.pwfactory.HelperClass;

public class Contracts {
    final private Page page;
    final private FrameLocator iframe;

    final private String contractsLoc = "#tab_3";
    final private String uriLoc = "#URL";
    final private String satisfiableByExternalProviderLoc = "#satisfiableByExternalProvider";
    final private String availableMethodsLoc = "#availableMethods";
    final private String cardTextLoc = "#cardText";
    final private String selectedAuthCardLoc = "#selectedAuthCard";
    final private String cardShowLoc = "#cardShow";


    public Contracts(Page page) {
        this.page = page;
        this.iframe = HelperClass.iframeLocator(page);
        this.iframe.locator(contractsLoc).click();
    }

    public static String contractName = HelperClass.getRandText();

    public void createContract() {
        iframe.locator(HelperClass.newLoc).click();
        iframe.locator(HelperClass.displayNameLoc).fill(contractName);
        iframe.locator(uriLoc).fill("novell/namapp/" + contractName);
        iframe.locator(satisfiableByExternalProviderLoc).check();
        iframe.locator(availableMethodsLoc).selectOption(Methods.methodName);
        iframe.locator(HelperClass.methodsMoveLeftLoc).click();
        iframe.locator(HelperClass.nextLoc).click();
        iframe.locator(cardTextLoc).fill(contractName);
        iframe.locator(selectedAuthCardLoc).selectOption("Basic Auth Username Password");
        iframe.locator(cardShowLoc).check();
        iframe.locator(HelperClass.finishLoc).click();
    }
}