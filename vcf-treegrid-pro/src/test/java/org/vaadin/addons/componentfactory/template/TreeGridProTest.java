/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.addons.componentfactory.template;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.flow.component.treegrid.TreeGridPro;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;

public class TreeGridProTest {

    private static TreeGridPro<Person> treeGrid;

    @BeforeClass
    public static void setUp() {
        treeGrid = new TreeGridPro<>(Person.class);
    }

    @Test
    public void testSetDataProvider() {
    	List<Person> managers = DataService.getManagers();
        TreeGridPro<Person> treeGridPro = new TreeGridPro<>();
        treeGridPro.setItems(managers, this::getStaff);
        treeGridPro.addHierarchyColumn(Person::getFirstName)
                .setHeader("First name").setKey("firstName");
        treeGridPro.addEditColumn(Person::getLastName).text(Person::setLastName).setHeader("Last name").setKey("lastName");
        treeGridPro.addEditColumn(Person::getEmail).text(Person::setEmail).setHeader("Email").setKey("email");
        assertEquals(TreeDataProvider.class.getName(), treeGrid.getDataProvider().getClass().getName());
        assertEquals("First name",treeGridPro.getColumnByKey("firstName").getHeaderText());
        assertEquals("Last name",treeGridPro.getColumnByKey("lastName").getHeaderText());
        assertEquals("Email",treeGridPro.getColumnByKey("email").getHeaderText());
    }
    
    public List<Person> getStaff(Person manager) {
        return DataService.getPeople(manager.getId());
    }
}
