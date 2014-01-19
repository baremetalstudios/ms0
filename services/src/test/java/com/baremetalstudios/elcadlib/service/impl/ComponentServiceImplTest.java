// ============================================================================
//  File          : ComponentServiceImplTest
//  Created       : 19.01.2014   
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.annotation.RegularMock;

import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertSame;


/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ComponentServiceImplTest {
    private ComponentService service;

    @RegularMock
    private ComponentDao dao;

    @Before
    public void init() {
        service = new ComponentServiceImpl(dao);
    }

    @Test
    public void componentSearchIsDelegatedToDao() {
        List<Component> components = Arrays.asList(new Component(1, "R32", "comp"));
        Filter filter = new Filter("test");
        expect(dao.findComponents(filter)).andReturn(components);
        replay(dao);

        assertSame(components, service.findComponents(filter));
    }
}
