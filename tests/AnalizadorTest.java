
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.FileSystem;

/**
 *
 * @author Diego
 */
public class AnalizadorTest {
    
    public static String TEST_FILE = "tests/data/Teste.java";
    public static String TEST_FILE2 = "tests/data/ClasseComMetodos.java";
    public static String TEST_FILE3 = "tests/data/MetodosComParametros.java";
    
    /**
     * Test of CountMethodParameters method, of class Analizador.
     */
    @Test
    public void testCountMethodParameters() {
        Analizador a = new Analizador();
        FileSystem fs = new FileSystem();
        
        ArrayList<String> param = fs.ReadFile(TEST_FILE3);
        
        a.methods(param);
        
        ArrayList<ArrayList<String>> list = a.GetMethodList();
        
        ArrayList<String> methodLines = list.get(1);
        
        int expResult = 2;
        int result = a.CountMethodParameters(methodLines);
        
        assertEquals(expResult, result);
       
    }

    /**
     * Test of CountMethodVariables method, of class Analizador.
     */
    @Test
    public void testCountMethodVariables() {
        ArrayList<String> methodLines = null;
        Analizador instance = new Analizador();
        int expResult = 0;
        int result = instance.CountMethodVariables(methodLines);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of CountMethodLoops method, of class Analizador.
     */
    @Test
    public void testCountMethodLoops() {
        ArrayList<String> methodLines = null;
        Analizador instance = new Analizador();
        int expResult = 0;
        int result = instance.CountMethodLoops(methodLines);
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }
    
   
    
    /**
     * Test of methods method, of class Analizador.
     */
    @Test
    public void testMethods() {
        Analizador a = new Analizador();
        
        FileSystem fs = new FileSystem();
        
        ArrayList<String> param = fs.ReadFile(TEST_FILE2);
        
        a.methods(param);
        
        ArrayList<ArrayList<String>> list = a.GetMethodList();
        
        for (ArrayList<String> list1 : list) {
            for (String list11 : list1) {
                System.out.println(list11);
            }
        }
        
    }

    /**
     * Test of analizarSimilaridade method, of class Analizador.
     */
    @Test
    public void testAnalizarSimilaridade() {
        ArrayList<String> m1 = null;
        ArrayList<String> m2 = null;
    }

    /**
     * Test of analityc method, of class Analizador.
     */
    @Test
    public void testAnalityc() throws Exception {
        String file1 = "";
        String file2 = "";
        
    }
    
    
    
     /*@Test
    public void testRegex(){
        Pattern p = Pattern.compile("[public|private|protected]");
        
        String methoOK = "protected void soma(int p1, int p2) { ";
        String packageDeclaratoin = "package data;";
        
        Matcher m2 = p.matcher(methoOK);
        boolean status2 = m2.find();
        assertEquals(true, status2);
        
        Matcher m = p.matcher(packageDeclaratoin);
        boolean status = m.find();
        assertEquals(false, status);
        
    }*/
}
