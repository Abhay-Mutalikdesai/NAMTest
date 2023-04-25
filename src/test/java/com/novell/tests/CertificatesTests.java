package com.novell.tests;

import com.novell.base.BaseClass;
import com.novell.certificatespages.CleanupCert;
import com.novell.certificatespages.CreateCertificate;
import com.novell.certificatespages.ImportSignedCert;
import org.testng.annotations.Test;

public class CertificatesTests extends BaseClass {
    @Test(priority = 1)
    public void createCertUsingLocalCATest() {
        new CreateCertificate(page)
                .createCert("LocalCA");
    }

    @Test(priority = 2)
    public void createCertUsingExternalCATest() {
        new CreateCertificate(page)
                .createCert("ExternalCA");
        new ImportSignedCert(page)
                .importSignedCert();
    }

    @Test(priority = 3)
    public void CleanUpCertTest() {
        new CleanupCert(page)
                .deleteCert();
    }
}