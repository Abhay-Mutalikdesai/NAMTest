package com.novell.certificatespages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.util.Properties;

import static com.novell.pwfactory.initPlaywright.browser;

public class GetACert {
    BrowserContext browserContext;
    Page page;

    final String csrTextAreaLoc = "textarea[name='CSR']";
    final String submitCsrLoc = "input[value='Submit CSR']";
    final String publicKeyExpandLoc = "button[class='collapsible2']";
    final String publicKeyContentLoc = "div.content2";

    final String submitCsrUrl = "signacert.html";
    String signedPublicKey;
    String getACertPublicKey;

    public GetACert(Properties prop) {
        browserContext = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
        page = browserContext.newPage();
        page.navigate(prop.getProperty("signACertUrl") + submitCsrUrl);
    }

    public void getACert(String csr) {
        page.fill(csrTextAreaLoc, csr);
        page.click(submitCsrLoc);
        page.locator(publicKeyExpandLoc).first().click();
        signedPublicKey = page.locator(publicKeyContentLoc).first().textContent();
        page.locator(publicKeyExpandLoc).last().click();
        getACertPublicKey = page.locator(publicKeyContentLoc).last().textContent();
        page.close();
    }
}