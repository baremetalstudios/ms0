// ============================================================================
//  File          : TestController
//  Created       : 14.01.2014   
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
@Controller
public class ComponentController {
    private final ComponentService service;

    @Autowired
    public ComponentController(ComponentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/component/find", method = RequestMethod.GET)
    public String findComponents(@RequestParam("q") String query, Map<String, Object> model) {
        Filter filter = new Filter(query);
        List<Component> components = service.findComponents(filter);
        model.put("components", components);
        return "component/list";
    }
}
