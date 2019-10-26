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
public class Consumos extends Model {

    String CodigoProducto;

    public Consumos(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;

    }

    private double PromedioConsumos() throws IOException {
        FileReader reader = new FileReader("Consumos.csv");
        BufferedReader miBuffer = new BufferedReader(reader);
        String linea = miBuffer.readLine();
        double acumulador = 0;
        int contador = 0;
        double Promedio = 0;
        while (linea != null) {
            try {

                String[] columnas = linea.split(";");
                if (columnas[0].equals(this.CodigoProducto)) {
                    double Consumo = Double.parseDouble(columnas[1]);
                    acumulador = acumulador + Consumo;
                    contador++;

                }

            } catch (NumberFormatException e) {
                System.out.println("Se presentó un error  ");
            }
            //Leer la siguiente linea
            linea = miBuffer.readLine();
        }
        Promedio = acumulador / contador;
        return Promedio;
    }

    @Override
    public double promedioMensual() throws IOException {
        double ConsumoTotal = PromedioConsumos() * 30;
        try {

            ConsumoTotal = PromedioConsumos() * 30;
           
        } //Obtener el tipo                                     
        catch (Exception e) {
            System.out.println("Se presentó un error  ");
        }
        return ConsumoTotal;

    }

    @Override
    public double Suma() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
