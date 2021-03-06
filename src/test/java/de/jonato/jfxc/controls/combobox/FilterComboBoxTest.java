package de.jonato.jfxc.controls.combobox;

/*
 * #%L
 * JFXC
 * %%
 * Copyright (C) 2016 Jonato IT Solutions
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;


public class FilterComboBoxTest extends ApplicationTest {

    private FilterComboBox<String> filterComboBox;
    private String[] data = {"Tobias", "Jonas", "UNIT", "Test", "IN", "FX"};

    @Override
    public void start(Stage stage) throws Exception {

        filterComboBox = new FilterComboBox<>(FXCollections.observableArrayList(data));
        filterComboBox.setId("filterCbo");

        Scene scene = new Scene(filterComboBox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testFindKey() throws Exception {
        clickOn(filterComboBox);
        push(KeyCode.J);

        assertTrue(filterComboBox.getSelectionModel().getSelectedItem().equals("Jonas"));
    }

    @Test
    public void testFindAlternativeKey() throws Exception {
        clickOn(filterComboBox);
        type(KeyCode.T, 2);

        assertTrue(filterComboBox.getSelectionModel().getSelectedItem().equals("Test"));
    }
}