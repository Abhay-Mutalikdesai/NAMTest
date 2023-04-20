package com.novell.certificatespages;

import com.microsoft.playwright.Page;

public class EditCertSubject {
    final Page page;

    final private String commonNameLoc = "#cn";
    final private String orgUnitLoc = "#ou";
    final private String orgLoc = "#org";
    final private String cityLoc = "#city";
    final private String stateLoc = "#state";
    final private String countryLoc = "#country";
    final private String okBtnLoc = "div[title='OK']";

    final private String CommonName = "Demo Cert";
    final private String orgUnit = "Novell";
    final private String org = "Micro Focus";
    final private String city = "Bengaluru";
    final private String state = "Karnataka";
    final private String country = "India";

    public EditCertSubject(Page popUpPage) {
        this.page = popUpPage;
    }

    public void editSub() {
        page.locator(commonNameLoc).fill(CommonName);
        page.locator(orgUnitLoc).fill(orgUnit);
        page.locator(orgLoc).fill(org);
        page.locator(cityLoc).fill(city);
        page.locator(stateLoc).fill(state);
        page.locator(countryLoc).fill(country);
        page.locator(okBtnLoc).click();
    }
}
