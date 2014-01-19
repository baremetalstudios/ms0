// ============================================================================
//  File          : FakeComponentDao
//  Created       : 19.01.2014   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2014 Bare Metal Studios, Ukraine
// ============================================================================
package com.baremetalstudios.elcadlib.dao.fake;

import com.baremetalstudios.elcadlib.dao.ComponentDao;
import com.baremetalstudios.elcadlib.service.Filter;
import com.baremetalstudios.elcadlib.service.domain.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan Bondarenko
 * @version 1.0
 */
@org.springframework.stereotype.Component
public class FakeComponentDao implements ComponentDao {
    private final static Map<String, Component> components = new HashMap<>();
    private static int count;

    static {
        add("UDZSTE-175.1BDKR-ND", "DIODE ZENER 5.1V 200MW UMD2");
        add("FFB3904TR-ND", "TRANS DUAL NPN 40V 200MA SC70-6");
        add("Q4N3TR-ND", "TRIAC SENS GATE 400V 1A DO214");
        add("MCC95-16IO1B-ND", "THYRISTOR MODULE 1600V 2X116A");
        add("MMBD301-TPMSTR-ND", "DIODE SCHOTTKY 30V 200MW SOT23-3");
        add("IXGH32N170-ND", "IGBT 1700V 75A 350W TO247AD");
        add("399-4024-2-ND", "CAP ALUM 10UF 50V 20% RADIAL");
        add("TLJ32", "TLJ Series (Small and Large Cap)");
        add("NOC-R42", "Niobium Oxide Capacitors");
        add("OxiCap-54", "Tantalum Capacitors");
    }

    private static void add(String name, String description) {
        count++;
        String indexValue = (name + description).toLowerCase();
        components.put(indexValue, new Component(count, name, description));
    }

    @Override
    public List<Component> findComponents(Filter filter) {
        List<Component> result = new ArrayList<>();
        for (Map.Entry<String, Component> entry : components.entrySet()) {
            String searchValue = filter.getFullTextSearchValue();
            if (entry.getKey().contains(searchValue.toLowerCase())) {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
