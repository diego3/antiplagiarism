
import utils.FileSystem;
import java.io.*;

public class Main {
    
    public String al;
    
    public static void main(String[] args) {
        
        Analizador a = new Analizador();
        
        if(args.length < 2){
            System.out.println("Quantidade de parâmetros incorretos");
            System.out.println("Exemplo: arquivo1  arquivo2");
            return;
        }
        
        double resultado = a.analityc(args[0], args[1]);
        String error = a.GetFileSystem().GetLastError();
        System.out.println("resultado = " + resultado);
        System.out.println("error="+error);
    }

   
   
}
