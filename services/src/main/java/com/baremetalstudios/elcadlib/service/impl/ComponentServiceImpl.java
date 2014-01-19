// ============================================================================
//  File          : ComponentServiceImpl
//  Created       : 18.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.service.impl;

import com.baremetalstudios.elcadlib.dao.ComponentDao;
import com.baremetalstudios.elcadlib.service.ComponentService;
import com.baremetalstudios.elcadlib.service.Filter;
import com.baremetalstudios.elcadlib.service.domain.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
@Service
public class ComponentServiceImpl implements ComponentService {
    private final ComponentDao dao;

    @Autowired
    public ComponentServiceImpl(ComponentDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Component> findComponents(Filter filter) {
        return dao.findComponents(filter);
    }
}
