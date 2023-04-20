package com.novell.idplocalpages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.novell.factory.HelperClass.*;

public class UserStores {
    final Page page;
    final FrameLocator iframe;

    final private String idpClusterLoc = "#gwt-debug-LinkWithStatus_link_IDP-Cluster";
    final private String localLoc = "a[onclick=\"selectChapter('LocalChapter'); return false;\"] span[class=\"nidstab1u\"]";
    final private String adminNameLoc = "#AdminName";
    final private String adminPasswordLoc = "#AdminPassword";
    final private String confirmPasswordLoc = "#ConfirmPassword";
    final private String directoryTypeLoc = "#DirectoryType";
    final private String replicaDisplayNameLoc = "#replicaDisplayName";
    final private String ipAddressLoc = "#IPAddress";
    final private String doSslLoc = "#doSSL";
    final private String replicaOkLoc = "#addReplicaDialog_okButton";
    final private String searchContextLoc = "#SearchContext";
    final private String searchContextOkLoc = "#addSearchContext_okButton";

    final String admin = "cn=admin,o=novell";
    final String pwd = "novell";
    final String ipAdd = "164.99.184.51";
    final String searchContext = "o=novell";

    public UserStores(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        page.waitForLoadState(LoadState.LOAD);
        iframe.locator(idpClusterLoc).click();
        iframe.locator(localLoc).click();
    }

    public static String userName = getRandText();

    public void createUser() {
        iframe.locator(newLoc).click();
        iframe.locator(displayNameLoc).fill(userName);
        iframe.locator(adminNameLoc).fill(admin);
        iframe.locator(adminPasswordLoc).fill(pwd);
        iframe.locator(confirmPasswordLoc).fill(pwd);
        iframe.locator(directoryTypeLoc).selectOption("1");
        iframe.locator(newLoc).first().click();
        iframe.locator(newLoc).first().click();
        iframe.locator(replicaDisplayNameLoc).fill(userName + "Replica");
        iframe.locator(ipAddressLoc).fill(ipAdd);
        iframe.locator(doSslLoc).check();
        iframe.locator(replicaOkLoc).click();
        iframe.locator(newLoc).last().click();
        iframe.locator(searchContextLoc).fill(searchContext);
        iframe.locator(searchContextOkLoc).click();
        iframe.locator(finishLoc).click();
    }
}