package eg.edu.alexu.csd.oop.cs71.db;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TableView table = new TableView();
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        TextField textField =new TextField();
        Button button =new Button("Run");
        Parser parser=new Parser();
        button.setOnAction(e->{
            String query=textField.getText();
            query = query.replaceAll("( )+", " ");
            if(parser.validateQuery(query))
            {
                parser.parse(query);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid query");
                alert.setContentText("Please try again!");
                alert.showAndWait();
            }
        });


        table.setEditable(true);

        //-LOOP ON TABLE COLUMNS-
        //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm

        /*TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");*/

       // table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(textField,button, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }
}
