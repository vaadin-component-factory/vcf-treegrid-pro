package org.vaadin.addons.componentfactory.template;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.flow.component.treegrid.TreeGridPro;

public class SerializableTest {

	  private void testSerializationOf(Object obj) throws IOException, ClassNotFoundException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
	      oos.writeObject(obj);
	    }
	    try (ObjectInputStream in =
	        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
	      obj.getClass().cast(in.readObject());
	    }
	  }

	  @Test
	  public void testSerialization() throws ClassNotFoundException, IOException {
	    try {
	      testSerializationOf(new TreeGridPro<String>());
	    } catch (Exception e) {
	      Assert.fail("Problem while testing serialization: " + e.getMessage());
	    }
	  }
	}
