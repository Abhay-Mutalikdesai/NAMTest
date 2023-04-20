package com.novell.tests;

import com.novell.base.BaseClass;
import com.novell.idplocalpages.*;
import org.testng.annotations.Test;

public class IDPLocalTests extends BaseClass {

    @Test(priority = 1)
    public void userStoresTest() {
        new UserStores(page).createUser();
    }

    @Test(priority = 2)
    public void classesTest() {
        new Classes(page).createClass();
    }

    @Test(priority = 3)
    public void methodsTest() {
        new Methods(page).createClass();
    }

    @Test(priority = 4)
    public void contractsTest() {
        new Contracts(page).createContract();
    }

    @Test(priority = 5)
    public void defaultsTest() {
        new Defaults(page).defaults();
    }
}