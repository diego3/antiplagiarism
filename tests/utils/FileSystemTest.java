/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class FileSystemTest {
    
    public static String TEST_FILE = "tests/data/Teste.java";
    public static String TEST_FILE2 = "tests/data/ClasseComMetodos.java";
    
    /**
     * Test of ReadFile method, of class FileSystem.
     */
    @Test
    public void testReadFile() {
        System.out.println("ReadFile");
        String filename = "";
        FileSystem instance = new FileSystem();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ReadFile(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of WriteFile method, of class FileSystem.
     */
    @Test
    public void testWriteFile() {
        System.out.println("WriteFile");
        String contents = "";
        String filename = "";
        FileSystem instance = new FileSystem();
        boolean expResult = false;
        boolean result = instance.WriteFile(contents, filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetLastError method, of class FileSystem.
     */
    @Test
    public void testGetLastError() {
        System.out.println("GetLastError");
        FileSystem instance = new FileSystem();
        String expResult = "";
        String result = instance.GetLastError();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetLines method, of class FileSystem.
     */
    @Test
    public void testGetLines() {
        System.out.println("GetLines");
        FileSystem instance = new FileSystem();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.GetLines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetLinesFiltered method, of class FileSystem.
     */
    @Test
    public void testGetLinesFiltered() {
        System.out.println("GetLinesFiltered");
        FileSystem fs = new FileSystem();
        ArrayList<String> rawLines =  fs.ReadFile(TEST_FILE2);
        ArrayList<String> result = fs.GetLinesFiltered();
        
        assertEquals(rawLines, result);
        
    }
    
}
