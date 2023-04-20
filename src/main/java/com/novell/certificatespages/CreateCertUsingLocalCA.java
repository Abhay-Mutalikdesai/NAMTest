package com.novell.certificatespages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.novell.factory.HelperClass.*;

public class CreateCertUsingLocalCA {
    final Page page;
    final FrameLocator iframe;
    final FrameLocator frame;
    Page popUpPage;

    final private String dashboardLoc = "#menu0";
    final private String certificatesLoc = "#gwt-debug-StatusWithLink_link_Certificates";
    final private String certNameLoc = "#certName";
    final private String editSubjectLoc = "img[title='Edit Subject']";
    final private String okBtnLoc = ".button[align='center'][onclick='doNew();return false;return false;']";

    public CreateCertUsingLocalCA(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        this.frame = frameLocator(page);
        frame.locator(dashboardLoc).click();
        page.waitForLoadState(LoadState.LOAD);
        iframe.locator(certificatesLoc).click();
    }

    public void createCert() {
        iframe.locator(newLoc).click();
        iframe.locator(certNameLoc).fill("demoCertLCA");
        popUpPage = page.waitForPopup(() -> {
            iframe.locator(editSubjectLoc).click();
        });
        new EditCertSubject(popUpPage).editSub();
        iframe.locator(okBtnLoc).click();
    }
}
