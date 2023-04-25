package com.novell.certificatespages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static com.novell.pwfactory.HelperClass.iframeLocator;
import static com.novell.pwfactory.initPlaywright.prop;

public class ImportSignedCert {
    final Page page;
    final FrameLocator iframe;

    final String demoCertECALoc = "a:text('demoCertECA')";
    final String csrTextLoc = "#csrText";
    final String importSignedCertLabelLoc = "#importSignedCert_Label";
    final String certTextLoc = "#pasteCertText0";
    final String certTextRadioBtnLoc = "#pasteTextRB0";
    final String trustedRootExpandLoc = "#certChainHref1";
    final String trustedRootTextLoc = "#pasteCertText1";
    final String trustedRootTextRadioBtnLoc = "#pasteTextRB1";
    final String importSignedCertCloseLoc = "img[title='Close']";
    final String importSignedCertOkLoc = "div[title='OK']";
    final String confirmOkLoc = "#buttondiv";
    final String certCloseLoc = "div[title='Close']";

    public ImportSignedCert(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        iframe.locator(demoCertECALoc).click();
    }

    public void importSignedCert() {
        String csrText = iframe.locator(csrTextLoc).textContent();
        GetACert getACertObj = new GetACert(prop);
        getACertObj.getACert(csrText);
        iframe.locator(importSignedCertLabelLoc).click();
        iframe.locator(certTextRadioBtnLoc).click();
        iframe.locator(certTextLoc).fill(getACertObj.signedPublicKey);
        iframe.locator(trustedRootExpandLoc).click();
        iframe.locator(trustedRootTextRadioBtnLoc).click();
        iframe.locator(trustedRootTextLoc).fill(getACertObj.getACertPublicKey);
        iframe.locator(importSignedCertCloseLoc).click();
        iframe.locator(importSignedCertLabelLoc).click();
        iframe.locator(importSignedCertOkLoc).click();
        iframe.locator(confirmOkLoc).click();
        iframe.locator(certCloseLoc).click();
    }
}