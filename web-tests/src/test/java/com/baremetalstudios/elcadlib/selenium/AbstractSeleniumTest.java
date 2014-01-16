// ============================================================================
//  File          : AbstractSeleniumTest
//  Created       : 16.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
public abstract class AbstractSeleniumTest {
    protected WebDriver driver;

    @Before
    public void openBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        driver = new FirefoxDriver();
    }

    @After
    public void cleanup() {
        driver.quit();
    }
}
