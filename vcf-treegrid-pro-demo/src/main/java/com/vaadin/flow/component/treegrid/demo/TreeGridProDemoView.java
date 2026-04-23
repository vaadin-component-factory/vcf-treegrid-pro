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
package com.vaadin.flow.component.treegrid.demo;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGridPro;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import java.util.List;

/**
 * View for {@link TreeGridPro} demo.
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
@Route("")
@StyleSheet(Lumo.STYLESHEET)
public class TreeGridProDemoView extends VerticalLayout {
    
    public TreeGridProDemoView() {
        createBasicTreeGridProDemo();
    }

    private void createBasicTreeGridProDemo() {
        List<Person> managers = DataService.getManagers();
        TreeGridPro<Person> treeGridPro = new TreeGridPro<>();
        treeGridPro.setItems(managers, this::getStaff);
        treeGridPro.addHierarchyColumn(Person::getFirstName)
                .setHeader("First name");
        treeGridPro.addEditColumn(Person::getLastName).text(Person::setLastName).setHeader("Last name");
        treeGridPro.addEditColumn(Person::getEmail).text(Person::setEmail).setHeader("Email");
      
        treeGridPro.setId("tree-grid-pro");

        add(treeGridPro);
    }
   
    public List<Person> getStaff(Person manager) {
        return DataService.getPeople(manager.getId());
    }

}
