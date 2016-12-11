
package utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class LevenstheinTest {
    
    

    @Test
    public void testDistance() {
        String s1 = "StringSystem";
        String s2 = "StrSys";
        int r = Levensthein.distance(s1, s2);
        assertEquals(1, r);
        
    }
    
}
