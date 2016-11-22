
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.FileSystem;
import utils.Levensthein;



/**
 * 
 * Analizar cada metodo da classe: contar qtd de parametros,
 * contar qtd de variaves, contar estruturas de repeticao(for, while, do while)
 * contar estruturas de decisão ( principalmente if elses vs switch cases) 
 * 
 * usar algoritmo de Leveinsth para analizar similaridade: peso 
 * 
 * 
 * @author Diego
 */
public class Analizador {
    
    private ArrayList<ArrayList<String>> methodList;
    private final FileSystem fs;
    
    public Analizador(){
        fs = new FileSystem();
    }
    
    public int CountMethodParameters(ArrayList<String> methodLines){
        String line = methodLines.get(0);
        String paramsArea = line.substring(line.indexOf("("), line.indexOf(")"));
        //(int v1
        String[] params = paramsArea.split(",");
        return params.length;
    }
    
    public int CountMethodVariables(ArrayList<String> methodLines){
        
        return 0;
    }
    
    public int CountMethodLoops(ArrayList<String> methodLines){
        
        return 0;
    }
    
    /**
     * PESO: 
     * 
     * @param m1
     * @param m2
     * @return 
     */
    public int AnalyzeSimilarity(ArrayList<String> m1, ArrayList<String> m2){
        // importar alguma lib  q implementa o algoritmo de Leveinsthein
        //Levensthein.d
        return 0;
    }
    
    public FileSystem GetFileSystem(){
        return fs;
    }
    
    public double Calculate(ArrayList<String> linesFile1, ArrayList<String> linesFile2){
        double simPeso = 0.3;
        double parPeso = 0.3;
        double lopPeso = 0.2;
        double varPeso = 0.2;
        
        methods(linesFile1);
        ArrayList<ArrayList<String>> methodsFile1 = methodList;
        methods(linesFile2);
        ArrayList<ArrayList<String>> methodsFile2 = methodList;
        
        //considerar quando não há métodos no código fonte
        
        double percent = 0;
        for (ArrayList<String> methodLinesFile1 : methodsFile1) {
            
            for (ArrayList<String> methodLinesFile2 : methodsFile2) {
                int countm1 = CountMethodParameters(methodLinesFile1);
                int countm2 = CountMethodParameters(methodLinesFile2);
                percent += countm1 > countm2 ? ( countm2 / countm1) * 100 : (countm1 / countm2) * 100;
                
//                int countp1 = CountMethodVariables(methodLinesFile1);
//                int countp2 = CountMethodVariables(methodLinesFile2);
//                percent += countp1 > countp2 ? ( countp2 / countp1) * 100 : (countp1 / countp2) * 100;
                
                
                
                // soma arquivo1  soma arquiv2 = 0.8%
            }
            
            
            
        }
        
        //int simVal = AnalyzeSimilarity(linesFile1, linesFile2);
        //int parVal =
        
        return percent * parPeso;
    }
    
    /**
     * 
     * @param param All the lines read from FileSystem
     */
    public void methods(ArrayList<String> param)
    {   
        methodList = new ArrayList<>();
        String[] lines = (String[])param.toArray( new String[0]);
        ArrayList<String> method = new ArrayList<>();
        boolean methodFounded = false;
        
        for (int i = 0; i < lines.length; i++) 
        {
            if(!methodFounded){
                if(matchModifiers(lines[i])){
                    methodFounded = true;
                }
                else {
                    continue;
                }
            }
            
            if(methodFounded) {
                method.add(lines[i]);
            }
            
            if(lines[i].contains("}")){
                //ArrayList<String> copy = method;
                methodList.add(method);
                method = new ArrayList<>();
                methodFounded = false;//we need find next method
            }
        }
    }
    
    private boolean matchModifiers(String str){
        return (str.contains("public") || str.contains("protected") || str.contains("private")) && str.contains("(");
    }
    
    public ArrayList<ArrayList<String>> GetMethodList(){
        return methodList;
    }
    
    
    
    public double analityc(String file1, String file2) {
        //verificar o nível de similaridade entre o código
        //fonte dos dois arquivos
        //definir quais algoritmos utilizar
        fs.ReadFile(file1);
        ArrayList<String> linhas1 = fs.GetLinesFiltered();
        
        fs.ReadFile(file2);
        ArrayList<String> linhas2 = fs.GetLinesFiltered();
        
        return Calculate(linhas1, linhas2);
    }
    
    public void AnalizeRecursive(String file, String rootPath){
        
        
        
        //TextReport report = new TextReport();
        
        //report.export(result);
    }
}
