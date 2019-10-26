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
public abstract class Model {
    
    
      String CodigoProducto;

   public abstract double Suma()throws IOException;
   
   public abstract double promedioMensual()throws IOException;
   
    
    
}
