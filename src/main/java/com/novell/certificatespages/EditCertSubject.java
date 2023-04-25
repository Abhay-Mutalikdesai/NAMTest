package com.novell.certificatespages;

import com.microsoft.playwright.Page;

public class EditCertSubject {
    final Page page;

    private String commonNameLoc = "#cn";
    final private String orgUnitLoc = "#ou";
    final private String orgLoc = "#org";
    final private String cityLoc = "#city";
    final private String stateLoc = "#state";
    final private String countryLoc = "#country";
    final private String okBtnLoc = "div[title='OK']";

    public EditCertSubject(Page popUpPage) {
        this.page = popUpPage;
    }

    public void editSub() {
        page.locator(commonNameLoc).fill("Demo Cert");
        page.locator(orgUnitLoc).fill("Novell");
        page.locator(orgLoc).fill("Micro Focus");
        page.locator(cityLoc).fill("Bengaluru");
        page.locator(stateLoc).fill("Karnataka");
        page.locator(countryLoc).fill("India");
        page.locator(okBtnLoc).click();
    }
}