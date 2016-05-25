package interpolacion;

import java.io.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Interpolacion {
     private static final ScriptEngineManager manager = new ScriptEngineManager();
    private static final ScriptEngine engine = manager.getEngineByName("js");

    public static String[] funcion(int n,double[][] matriz) {
        String [] L=new String[n];
         int cont = 0;
      L[0]="1*";
        while (cont < n) {
            L[cont]="+";
            for (int i = 0; i < n; i++) {
                if (i!=cont) {
                   
                    L[cont] = L[cont]+("((x - " + matriz[i][0]+")/("+matriz[cont][0]+" - "+matriz[i][0]+"))*");
                    
                    }
            }
            
            cont++;
        }
        return L;
    
}
    public static double Evaluar(double x, String f) {
         double sumatoria = 0;

        Object oa = "-1";
        
            engine.put("x",x);
            try {
                oa = engine.eval(f);
            } catch (ScriptException ex) {
                System.out.println("Error al evaluar");
            }
            sumatoria = Double.parseDouble(oa+"");
        
        return sumatoria;

    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese numero de puntos");
        int n = Integer.parseInt(lectura.readLine());

        double[][] matriz = new double[n][2];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Ingrese punto");
                matriz[i][j] = Double.parseDouble(lectura.readLine());
            }

        }
 String [] L=funcion(n,matriz);
       

        for (int i = 0; i < n; i++) {
            
            System.out.println(""+L[i]+""+matriz[i][1]);
            
           
        

    }

    }
}
