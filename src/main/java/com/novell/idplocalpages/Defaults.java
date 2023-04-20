package com.novell.idplocalpages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import static com.novell.idplocalpages.Contracts.contractName;
import static com.novell.factory.HelperClass.*;
import static com.novell.idplocalpages.UserStores.userName;

public class Defaults {
    final private Page page;
    final private FrameLocator iframe;

    final private String contractsLoc = "#tab_4";
    final private String defaultUserStore = "#DefaultUserStore";
    final private String defaultAuthContractLoc = "#defaultAuthContract";
//    final private String defaultNamePasswordContractLoc = "#defaultNamePasswordContract";
//    final private String defaultSecureNamePasswordContractLoc = "#defaultSecureNamePasswordContract";
//    final private String defaultX509ContractLoc = "#defaultX509Contract";
//    final private String defaultSmartCardContractLoc = "#defaultSmartCardContract";
//    final private String defaultSmartCardPKIContractLoc = "#defaultSmartCardPKIContract";
//    final private String defaultTokenContractLoc = "#defaultTokenContract";

    public Defaults(Page page) {
        this.page = page;
        this.iframe = iframeLocator(page);
        this.iframe.locator(contractsLoc).click();
    }

    public void defaults() {
        iframe.locator(defaultUserStore).selectOption(userName);
        iframe.locator(defaultAuthContractLoc).selectOption(contractName);
//        iframe.locator(defaultNamePasswordContractLoc).selectOption(contractName);
//        iframe.locator(defaultSecureNamePasswordContractLoc).selectOption(contractName);
//        iframe.locator(defaultX509ContractLoc).selectOption(contractName);
//        iframe.locator(defaultSmartCardContractLoc).selectOption(contractName);
//        iframe.locator(defaultSmartCardPKIContractLoc).selectOption(contractName);
//        iframe.locator(defaultTokenContractLoc).selectOption(contractName);
        iframe.locator(ApplyLoc).click();
        iframe.locator(okLoc).click();
    }
}