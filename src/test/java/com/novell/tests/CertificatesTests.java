package com.novell.tests;

import com.novell.base.BaseClass;
import com.novell.certificatespages.CreateCertUsingLocalCA;
import org.testng.annotations.Test;

public class CertificatesTests extends BaseClass {
    @Test(priority = 1)
    public void createCertUsingLocalCATest() {
        new CreateCertUsingLocalCA(page)
                .createCert();
    }

    @Test
    public void createCertUsingExternalCA() {
    }

    @Test
    public void CleanUpCert() {
    }
}