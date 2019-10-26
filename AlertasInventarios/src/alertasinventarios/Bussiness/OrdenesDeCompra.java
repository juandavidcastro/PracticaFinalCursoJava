/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertasinventarios.Bussiness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author s109e18
 */
public class OrdenesDeCompra extends Model {

    String CodigoProducto;

    public OrdenesDeCompra(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }


    @Override
    public double Suma() throws IOException {
       FileReader reader = new FileReader("Ordenes de Compra Mes.csv");
        BufferedReader miBuffer = new BufferedReader(reader);
        String linea = miBuffer.readLine();
        double acumulador = 0;
        double contador = 0;
        while (linea != null) {
            try {

                String[] columnas = linea.split(";");
                if (columnas[0].equals(this.CodigoProducto)) {
                    double InventarioActual = Double.parseDouble(columnas[1]);
                    acumulador = acumulador + InventarioActual;
                    contador++;

                }
    
            } catch (Exception e) {
                System.out.println("Se presentó un error");
            }
            //Leer la siguiente linea
            linea = miBuffer.readLine();
        }
         
        return acumulador;
    }

    @Override
    public double promedioMensual() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
