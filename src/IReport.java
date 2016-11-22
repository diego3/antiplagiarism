
import java.util.ArrayList;



/**
 *
 * @author Diego
 */
public interface IReport {
    
    /**
     * Who implement this interface should export to a file the results
     * 
     * @param result The results yeld by Analizador
     */
    public void export(ArrayList<String> result);
    
}
