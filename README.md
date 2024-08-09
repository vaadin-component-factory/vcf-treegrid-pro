# TreeGrid Pro Addon for Vaadin Flow

This project is an addon that provides a TreeGrid version of Grid Pro

This component is part of Vaadin Component Factory

## Running the component demo
Run from the command line:
- `mvn  -pl vcf-treegrid-pro-demo -Pwar install jetty:run`

Then navigate to `http://localhost:8080/`

## Installing the component
Run from the command line:
- `mvn clean install -DskipTests`

## Profiles
### Profile "directory"
This profile, when enabled, will create the zip file for uploading to Vaadin's directory

### Profile "production"
This profile, when enabled, will execute a production build for the demo

## Using the component in a Flow application
To use the component in an application using maven,
add the following dependency to your `pom.xml`:

	<dependency>
	    <groupId>org.vaadin.addons.componentfactory</groupId>
	    <artifactId>vcf-treegrid-pro</artifactId>
	    <version>${component.version}</version>
	</dependency>

Then use it as a regular tree grid, but you can also add edit columns in the following way:

        TreeGridPro<Person> treeGridPro = new TreeGridPro<>();
        treeGridPro.setItems(managers, this::getStaff);
        treeGridPro.addHierarchyColumn(Person::getFirstName)
                .setHeader("First name");
        treeGridPro.addEditColumn(Person::getLastName).text(Person::setLastName).setHeader("Last name");
        treeGridPro.addEditColumn(Person::getEmail).text(Person::setEmail).setHeader("Email");

## Flow documentation
Documentation for flow can be found in [Flow documentation](https://vaadin.com/docs/v14/flow/overview).

## License

Apache Licence 2