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

import java.util.List;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.treegrid.TreeGridPro;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * View for {@link PaperInput} demo.
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
@Route("")
public class TreeGridProDemoView extends DemoView {

    @Override
    public void initView() {
        createBasicPaperInputDemo();

        addCard("Additional code used in the demo",
                new Span("These methods are used in the demo."));
    }

    private void createBasicPaperInputDemo() {
        Div message = createMessageDiv("simple-paper-input-demo-message");

        // begin-source-example
        // source-example-heading: Simple paper input
        List<Person> managers = DataService.getManagers();
        TreeGridPro<Person> treeGridPro = new TreeGridPro<>();
        treeGridPro.setItems(managers, this::getStaff);
        treeGridPro.addHierarchyColumn(Person::getFirstName)
                .setHeader("First name");
        treeGridPro.addEditColumn(Person::getLastName).text(Person::setLastName).setHeader("Last name");
        treeGridPro.addEditColumn(Person::getEmail).text(Person::setEmail).setHeader("Email");
        // end-source-example

        treeGridPro.setId("tree-grid-pro");

        addCard("TreeGrid Pro", treeGridPro, message);
    }

   
    // begin-source-example
    // source-example-heading: Additional code used in the demo
    /**
     * Additional code used in the demo
     */
    private Div createMessageDiv(String id) {
        Div message = new Div();
        message.setId(id);
        message.getStyle().set("whiteSpace", "pre");
        return message;
    }
    
    public List<Person> getStaff(Person manager) {
        return DataService.getPeople(manager.getId());
    }
    // end-source-example
}
