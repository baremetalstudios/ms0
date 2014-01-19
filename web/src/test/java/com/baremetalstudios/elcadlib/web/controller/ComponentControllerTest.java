// ============================================================================
//  File          : ComponentControllerTest
//  Created       : 19.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.web.controller;

import com.baremetalstudios.elcadlib.service.ComponentService;
import com.baremetalstudios.elcadlib.service.Filter;
import com.baremetalstudios.elcadlib.service.domain.Component;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.annotation.RegularMock;

import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.unitils.easymock.EasyMockUnitils.refEq;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ComponentControllerTest {
    @RegularMock
    private ComponentService service;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.mvc = standaloneSetup(new ComponentController(service)).setUseSuffixPatternMatch(false)
                .setUseTrailingSlashPatternMatch(false).build();
    }

    @Test
    public void componentsFoundAndAddedToModel() throws Exception {
        List<Component> components = Arrays.asList(new Component(1, "Component B52", "The best component"));
        expect(service.findComponents(refEq(new Filter("B52")))).andReturn(components);
        replay(service);

        ResultActions results = mvc.perform(get("/component/find").param("q", "B52"));
        results.andExpect(status().isOk()).andExpect(model().attribute("components", components))
                .andExpect(view().name("component/componentList"));
    }
}
