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
public class InventarioActual extends Model {

    String CodigoProducto;
     boolean SkuEstáEnBaseDeDatos;

    public boolean isSkuEstáEnBaseDeDatos() {
        return SkuEstáEnBaseDeDatos;
    }

    public void setSkuEstáEnBaseDeDatos(boolean SkuEstáEnBaseDeDatos) {
        this.SkuEstáEnBaseDeDatos = SkuEstáEnBaseDeDatos;
    }

    public InventarioActual(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }
    
    @Override
    public double Suma() throws IOException {
        this.SkuEstáEnBaseDeDatos=false;   
        FileReader reader = new FileReader("Inventario Actual.csv");
        BufferedReader miBuffer = new BufferedReader(reader);
        String linea = miBuffer.readLine();
        double acumulador = 0;
        int contador = 0;
        while (linea != null) {
            try {

                String[] columnas = linea.split(";");
                if (columnas[0].equals(this.CodigoProducto)) {
                    this.SkuEstáEnBaseDeDatos=true;
                    double InventarioActual = Double.parseDouble(columnas[1]);
                    acumulador = acumulador + InventarioActual;
                    contador++;

                }
    
            } catch (Exception e) {
                System.out.println("Se presentó un error");
            }
            
            linea = miBuffer.readLine();
        }
        
        return acumulador;
    }

    @Override
    public double promedioMensual() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  

    
    
}
