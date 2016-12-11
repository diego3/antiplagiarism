
import java.util.ArrayList;
import java.util.Date;
import utils.FileSystem;

/**
 *
 * @author Diego
 */
public class TextReport implements IReport {

    @Override
    public void export(String result) {
        FileSystem fs = new FileSystem();
        String filename = "relatorio.txt";
        boolean status = fs.WriteFile(result, filename);
        
        if(!status){
            System.out.println(fs.GetLastError());
        }
    }
    
}
