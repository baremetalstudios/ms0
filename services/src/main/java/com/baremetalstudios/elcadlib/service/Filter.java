// ============================================================================
//  File          : Filter
//  Created       : 18.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.service;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
public class Filter {
    private final String fullTextSearchValue;

    public Filter(String fullTextSearchValue) {
        this.fullTextSearchValue = fullTextSearchValue;
    }

    public String getFullTextSearchValue() {
        return fullTextSearchValue;
    }
}
