// ============================================================================
//  File          : ComponentSearchTest
//  Created       : 19.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
public class ComponentSearchTest extends AbstractSeleniumTest {
    @Test
    public void simpleTest() {
        driver.get("http://localhost:8085/webtest");
        assertEquals("Electronic CAD Library", driver.getTitle());

        searchForKeyword("");
        assertResultCount(10);

        searchForKeyword("NOC-R42");
        assertResultCount(1);
    }

    private void assertResultCount(int resultNumber) {
        assertEquals("Total : " + resultNumber, driver.findElement(By.id("resTotal")).getText());
    }

    private void searchForKeyword(String val) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(val);
        element.submit();
        waitForPage(driver);
    }

    private static void waitForPage(WebDriver driver) {
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver drv) {
                return drv.getTitle().startsWith("Elcadlib search result");
            }
        });
    }
}
