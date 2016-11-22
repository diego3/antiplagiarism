package utils;


import java.io.*;
import java.util.ArrayList;

public class FileSystem {
    
    protected ArrayList<String> lines = new ArrayList<>();
    
    protected String LastError;
    
    public ArrayList<String> ReadFile(String filename){
        try {
            lines = new ArrayList<>();
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
            return lines;
        } catch (FileNotFoundException ex) {
            LastError = "erro ao ler arquivo "+ filename +"\n" + ex.getMessage();
        } catch (IOException ex) {
            LastError = "IOException ao ler arquivo "+ filename +"\n"+ ex.getMessage();
        }
        return lines;
    }
    
    public boolean WriteFile(String contents, String filename){
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(filename);
            
            fout.write(contents.getBytes());
            
            return true;
        } catch (FileNotFoundException ex) {
            LastError = "Arquivo "+filename+" não encontrado";
        } catch(SecurityException sex){
            LastError = "Arquivo "+filename+" não pode ser criado por questões de segurança";
            LastError += "\n"+sex.getMessage();
        } catch (IOException ex) {
            LastError = "Erro ao tentar escrever arquivo "+filename+"";
            LastError += "\n" + ex.getMessage();
        }
        finally{
            if(fout!= null){
                try {
                    fout.close();
                } catch (IOException ex) {
                    LastError = "Não foi possível fechar o arquivo "+filename;
                    return false;
                }
            }
        }
        return false;
    }
    
    public String GetLastError(){
        return LastError;
    }
    
    public ArrayList<String> GetLines() {
        return lines;
    }
    
    public ArrayList<String> GetLinesFiltered() {
        ArrayList<String> str = new ArrayList<>();
        for (String line : lines) {
            if(!HasComments(line) && !line.trim().isEmpty()){
                str.add(line);
            }
        }
        return str;
    }
    
    private boolean HasComments(String line){
        return line.contains("//") || line.contains("/*") || line.contains("*/");
    }

}
