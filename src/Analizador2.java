
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
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
public class Analizador2 {
    
    private ArrayList<ArrayList<String>> methodList;
    private final FileSystem fs;
    private String html = "";
    
    public JProgressBar progressbar;
    
    public Analizador2(JProgressBar progress){
        fs = new FileSystem();
        progressbar = progress;
        
    }
    
    public FileSystem GetFileSystem(){
        return fs;
    }
    
    public String analityc2(String file1, String file2) {
        fs.ReadFile(file1);
        ArrayList<String> linhas1 = fs.GetLinesFiltered();
        
        fs.ReadFile(file2);
        ArrayList<String> linhas2 = fs.GetLinesFiltered();
        
        String str = linhas1.toString();
        String str2 = linhas2.toString();
        System.out.println("tamanho arquivo 1 = "+ str.length());
        System.out.println("tamanho arquivo 2 = "+ str2.length());
        float r = (float)Levensthein.distance(str, str2);
        
        int l = str.length();
        double p = (r/l) * 100;
        //0 identico
        System.out.println("r =  "+r);
        System.out.println("p =  "+(100- p));
        double resultado = 100.f - p;
        if(resultado < 0){
            resultado = 0;
        }
        
        String cssClass = "";
        if(resultado == 100){
            cssClass="danger";
        }
        if(resultado >= 50 && resultado < 100){
            cssClass = "warning";
        }
        if(resultado == 0){
            cssClass="success";
        }
        String rel = "<tr class="+cssClass+">";
        rel += "<td>" + file1 + "</td>";
        rel += "<td>" + file2 + "</td>";
        rel += "<td>" +  String.format( "%.2f", resultado ) + "%</td>";
        rel += "</tr>";
        
        return rel;
    }
    
    public void analityc(String file1, String file2) {
        String rel = analityc2(file1, file2);
        
        HtmlReport report = new HtmlReport();
        report.export(rel);
    }
    
    public void analitycRecursive(String targetFile, String rootPath){
        countFiles(rootPath);
        progressbar.setMaximum(qtdFiles);
        
        
        walk(targetFile, rootPath);
        HtmlReport report = new HtmlReport();
        report.export(html);
    }
    
    private void walk(String targetFile, String path) {
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk(targetFile, f.getAbsolutePath() );
            }
            else {
                System.out.println( "File:" + f.getAbsoluteFile() );
                
                String rel = analityc2(targetFile, f.getAbsolutePath());
                
                html += rel;
                
                progressbar.setValue(progressbar.getValue()+1);
            }
        }
    }
    
    private int qtdFiles = 0;
    
    private void countFiles(String path) {
        File root = new File( path );
        File[] list = root.listFiles();
        if (list == null) return;
        for ( File f : list ) {
            if ( f.isDirectory() ) {
                countFiles(f.getAbsolutePath());
            }
            else {
                qtdFiles++;
            }
        }
    }
}
