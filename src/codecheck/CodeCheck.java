/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Tobias Grundtvig
 */
public class CodeCheck
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        //String jarFile = "CodeCheckExample\\dist\\CodeCheckExample.jar";
        //CodeChecker checker = new CodeChecker(new File("C:\\Users\\Tobias Grundtvig\\Google Drive\\CBA\\ProjectCodeCheck"));
        
        //On rasperry pi
        String jarFile = "CodeCheckExample.jar";
        CodeChecker checker = new CodeChecker(new File("/home/pi/CodeCheck"));
        
        Assignment assign = new Assignment("Read two integers from stdin and write their sum to stdout.");
        assign.addVisibleTestCase("2 3", "5", 1000);
        assign.addVisibleTestCase("22 12", "34", 1000);
        assign.addVisibleTestCase("-32 24", "-8", 1000);
        assign.addVisibleTestCase("7 8", "15", 1000);
        assign.addVisibleTestCase("1234 5678", "6912", 1000);
        assign.addVisibleTestCase("-2 -3", "-5", 1000);
        assign.addHiddenTestCase("90 3", "93", 1000);
        assign.addHiddenTestCase("56 -34", "22", 1000);
        assign.addHiddenTestCase("56 4", "60", 1000);
        assign.addHiddenTestCase("43 -34", "9", 1000);
        assign.addHiddenTestCase("-6 -3", "-9", 1000);
        assign.addHiddenTestCase("42 13", "55", 1000);
        
        TestReport report = checker.generateReport(assign, jarFile);
        System.out.println(report);
    }
    
    
    
}
