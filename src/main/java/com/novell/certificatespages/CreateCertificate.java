package com.novell.certificatespages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.novell.pwfactory.HelperClass.*;

public class CreateCertificate {
    final Page page;
    final FrameLocator iframe;
    Page popUpPage;

    final private String dashboardLoc = "#menu0";
    final private String certificatesLoc = "#gwt-debug-StatusWithLink_link_Certificates";
    final private String useLocalCALoc = "input[value='useLocalCA']";
    final private String useExternalCALoc = "input[value='useExternalCA']";
    final private String certNameLoc = "#certName";
    final private String editSubjectLoc = "img[title='Edit Subject']";
    final private String okBtnLoc = ".button[align='center'][onclick='doNew();return false;return false;']";

    public CreateCertificate(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        frameLocator(page).locator(dashboardLoc).click();
        page.waitForLoadState(LoadState.LOAD);
        iframe.locator(certificatesLoc).click();
    }

    public void createCert(String certUsing) {
        iframe.locator(newLoc).click();
        if (certUsing.equals("LocalCA")) {
            iframe.locator(useLocalCALoc).click();
            iframe.locator(certNameLoc).fill("demoCertLCA");
        }
        if (certUsing.equals("ExternalCA")) {
            iframe.locator(useExternalCALoc).click();
            iframe.locator(certNameLoc).fill("demoCertECA");
        }
        popUpPage = page.waitForPopup(() -> iframe.locator(editSubjectLoc).click());
        new EditCertSubject(popUpPage).editSub();
        iframe.locator(okBtnLoc).click();
    }
}