# HBV202GFinalProject
In this project I will be using the TakeAway Application that I created in Interface Design class this semester. I will use this opportunity to create a UML, a README file, a site, as well as refactor where needed to create self-explaining code. This will also allow me to fix any GUI details that made the program less easy to use.

This project is a Maven project, i.e. it uses the standard Maven project structure that your IDE hopefully understands when you `git clone` it. The provided Maven POM includes the JUnit4 dependency.

Both the implementation and the tests are in Java package `cms5.frontend` and `backend`,  but in the usual separate Maven `src` directories:

- `src/main/java`:
    - `cms5.frontend.TakeawayApplication`: Where the GUI can be started.
    - `cms5.frontend.OrderController`: Where the GUI is initiated and buttons programmed.
    - `cms5.frontend.ClientDialog`: To create dialogs asking the client for their information to create an account.
    - `cms5.frontend.MenuView`: Customized class that allows the Menu part of the GUI to be independent.
    - `cms5.frontend.PayController`: Initializes and updates the total amount due information when the order is changed.
    - `cms5.frontend.UserDialog`: The person using the application already has an existing account.
    - `cms5.frontend.view`: An enumeration of the fxml files for better organization.
    - `cms5.frontend.ViewSwitcher`: This class was used to switch between scenes,but it was not created by us, due credit is given to its author.
    - `cms5.backend.Client`: Creates a client and saves their information.
    - `cms5.backend.Foods`: Creates all the food items.
    - `cms5.frontend.Menu`: Part of the customized class which used foods to create itself.
    - `cms5.frontend.Order`: Where the foods selected from the menu are stored,so they can later be paid for.
    

#### Maven:

- `mvn compile` compiles all implementation classes.
- `mvn exec` runs the program
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends with `Test`, `Tests`, or `TestCase`).

#### License:

The project is subject to a [license](LICENSE.txt) which can be viewed here.

#### UML Class Diagram:

The project UML class diagram can be found [here](src/site/markdown/markdown.md).


