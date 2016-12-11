
import utils.FileSystem;


/**
 *
 * @author Diego
 */
public class HtmlReport implements IReport {

    @Override
    public void export(String result) {
        String out = "<!DOCTYPE html>"+
        "<html lang='en'>"+
          "<head>"+
            "<meta charset='utf-8'>"+
            "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"+
            "<meta name='viewport' content='width=device-width, initial-scale=1'>"+
            "<title>Relatório de Igualdade</title>"+

            "<link href='relatorio/bootstrap.min.css' rel='stylesheet'>"+
          "</head>"+
          "<body>"+
            "<h1>Relatório de Igualdade </h1>"+

                "<table class='table table-hover'>"+
                        "<tr>"+
                                "<th>Arquivo 1</th>"+
                                "<th title='Arquivo que foi comparado'>Arquivo 2</th>"+
                                "<th>Igualdade</th>"+
                        "</tr>";
                        out+= result;
                        out += "</table>"+

                " </body>"
            + "</html>";
                        
        FileSystem fs = new FileSystem();
        String filename = "relatorio.html";
        boolean status = fs.WriteFile(out, filename);
        
        if(!status){
            System.out.println(fs.GetLastError());
        }
    }
    
}
