
import java.util.ArrayList;
import java.util.Date;
import utils.FileSystem;

/**
 *
 * @author Diego
 */
public class TextReport implements IReport {

    @Override
    public void export(ArrayList<String> result) {
        FileSystem fs = new FileSystem();
        //Date now = new Date();
        //int hours = now.getHours();
        //int min = now.getMinutes();
        String filename = "relatorio.txt";
        boolean status = fs.WriteFile(result.toString(), filename);
        
        if(!status){
            System.out.println(fs.GetLastError());
        }
    }
    
}
