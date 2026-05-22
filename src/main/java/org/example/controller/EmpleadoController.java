package org.example.controller;

import org.example.model.Empleado;
import org.example.util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoController {
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {while (rs.next()) {
            Empleado e = new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("salario")
            );
            empleados.add(e);
        }
        } catch (Exception e) {
            System.out.println("Error al obtener empleados");
        }
        return empleados;
    }
}
