// ============================================================================
//  File          : ComponentService
//  Created       : 14.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.service;

import com.baremetalstudios.elcadlib.service.domain.Component;

import java.util.List;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
public interface ComponentService {
    List<Component> findComponents(Filter filter);
}
