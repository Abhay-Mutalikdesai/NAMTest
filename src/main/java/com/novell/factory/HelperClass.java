package com.novell.factory;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import java.util.UUID;

public class HelperClass {
    final public static String frameLoc = "internal:attr=[title=\"${requestScope['FrameTitle.Mainscreen']}\"i]";
    final public static String iframeLoc = "#content1";
    final public static String newLoc = "a:text('New')";
    final public static String displayNameLoc = "#displayName";
    final public static String nextLoc = "img[title=\"Next\"]";
    final public static String finishLoc = "#finishButton";
    final public static String ApplyLoc = "img[title=\"Apply\"]";
    final public static String okLoc = "img[title=\"OK\"]";
    final public static String methodsMoveLeftLoc = "a[onclick='methods_moveLeft()']";

    public static FrameLocator iframeLocator(Page page) {
        return page.frameLocator(HelperClass.frameLoc).frameLocator(HelperClass.iframeLoc);
    }

    public static FrameLocator frameLocator(Page page) {
        return page.frameLocator(HelperClass.frameLoc);
    }

    public static String getRandText() {
        String randText = UUID.randomUUID().toString();
        return randText.replaceAll("_", "a").replaceAll("-", "z").substring(0, 10);
    }

    public static String getCurTime() {
        return java.time.ZonedDateTime.now(java.time.ZoneId.of("Asia/Kolkata")).format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss"));
    }
}