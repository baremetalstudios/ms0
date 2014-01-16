// ============================================================================
//  File          : SeleniumExampleTest
//  Created       : 16.01.2014   
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
import static org.junit.Assert.assertTrue;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
public class SeleniumExampleTest extends AbstractSeleniumTest {
    @Test
    public void simpleTest() {
        driver.get("http://www.google.com");
        assertEquals("Google", driver.getTitle());

        searchForJavaKeyword();
        waitForPage(driver);

        assertTrue(driver.getTitle().startsWith("Java"));
    }

    private void searchForJavaKeyword() {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Java");
        element.submit();
    }

    private static void waitForPage(WebDriver driver) {
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("Java");
            }
        });
    }
}
