package com.novell.certificatespages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static com.novell.pwfactory.HelperClass.iframeLocator;

public class CleanupCert {
    final Page page;
    final FrameLocator iframe;

    final private String certLCACheckboxLoc = "input[type='checkbox']:left-of(a:text('demoCertLCA'))";
    final private String certECACheckboxLoc = "input[type='checkbox']:left-of(a:text('demoCertECA'))";
    final private String deleteLoc = "a[title='Delete']";
    final private String deleteOkLoc = "#buttondiv:has-text('OK')";

    public CleanupCert(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
    }

    public void deleteCert() {
        if (iframe.locator(certLCACheckboxLoc).first().isVisible())
            iframe.locator(certLCACheckboxLoc).first().check();
        if (iframe.locator(certECACheckboxLoc).first().isVisible())
            iframe.locator(certECACheckboxLoc).first().check();
        iframe.locator(deleteLoc).click();
        iframe.locator(deleteOkLoc).click();
    }
}