
import utils.FileSystem;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a400897
 */
public class LerArquivoTest {
    public static String TEST_FILE = "tests/data/Teste.java";
    
    @Test
    public void testaAlgoritmoQuandoArquivosSaoIdenticos() throws FileNotFoundException{
        Analizador a = new Analizador();
        
        double result = a.analityc(TEST_FILE, TEST_FILE);
        assertEquals(100, result, 0.0001);
        
    }
}
