package data;

import utils.FileSystem;


/**
 *
 * @author a400897
 */
public class Teste {
    public String test = "Indexes are enormously important. With the right indexes in place, MongoDB can\n" +
                            "use its hardware efficiently and serve your application’s queries quickly. But the\n" +
                            "wrong indexes produce the opposite result: slow queries, slow writes, and poorly\n" +
                            "utilized hardware. It stands to reason that anyone wanting to use MongoDB effectively\n" +
                            "must understand indexing.\n" +
                            " But for many developers, indexes are a topic shrouded in mystery. This need\n" +
                            "not be the case. Once you’ve finished this chapter, you should have a good mental\n" +
                            "model for thinking clearly about indexes. To introduce the concepts of indexing,\n" +
                            "we’ll begin with a modest thought experiment. We’ll then explore some core\n" +
                            "indexing concepts and provide an overview of the B-tree data structure underlying\n" +
                            "MongoDB indexes";
    
    public void VoidEmptyMethod(){
        
    }
    
    /**
     * Some dummy comment
     * 
     * @param p1
     * @param s2
     * @return a fake and shit number
     */
    public int CompleteMethod(int p1, String s2){
        FileSystem fs = new FileSystem();
        //Date now = new Date();  some cool comments over here :)
        //int hours = now.getHours();
        //int min = now.getMinutes();
        String filename = "relatorio.txt";
        boolean status = fs.WriteFile("this is bullshit", filename);
        
        if(!status){
            System.out.println(fs.GetLastError());
        }
        
        return 1548552;
    }
    
}
