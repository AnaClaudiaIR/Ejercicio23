package org.example.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controller.EmpleadoController;
import org.example.model.Empleado;
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        //Crear la tabla para ver los resultados
        TableView<Empleado> tabla = new TableView<>();
        TableColumn<Empleado, Integer> colId = new
                //Columna ID
                TableColumn<>("ID");
        colId.setCellValueFactory(
                data -> new javafx.beans.property.SimpleIntegerProperty(
                        data.getValue().getId()).asObject()
        );
        TableColumn<Empleado, String> colNombre = new
                //Columna nombre
                TableColumn<>("Nombre");
        colNombre.setCellValueFactory(
                data -> new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getNombre())
        );
        TableColumn<Empleado, Double> colSalario = new
                //Columna salario
                TableColumn<>("Salario");
        colSalario.setCellValueFactory(
                data -> new javafx.beans.property.SimpleDoubleProperty(
                        data.getValue().getSalario()).asObject()
        );
        //Añadir todas las columnas a la tabla
        tabla.getColumns().addAll(colId, colNombre, colSalario);
        //Botón para ejecutar el driver y que muestre todos los empleados
        Button btnCargar = new Button("Cargar empleados");
        btnCargar.setOnAction(e -> {
            EmpleadoController controller = new EmpleadoController();
            tabla.setItems(
                    FXCollections.observableArrayList(
                            controller.obtenerEmpleados()
                    )
            );
        });
        //Caja para meter los elementos
        VBox root = new VBox(10, tabla, btnCargar);
        //Ventana
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Empleados");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {launch(args);
    }
}
