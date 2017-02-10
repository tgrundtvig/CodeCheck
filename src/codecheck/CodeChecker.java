/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Tobias Grundtvig
 */
public class CodeChecker
{
    private final File directory;

    public CodeChecker(File directory)
    {
        this.directory = directory;
    }
    
    public TestReport generateReport(Assignment assignment, String jarFile) throws IOException
    {
        TestReport report = new TestReport(assignment);
        for(TestCase tc : assignment.getVisibleTests())
        {
            report.addVisibleResult(doTest(tc, jarFile));
        }
        for(TestCase tc : assignment.getHiddenTests())
        {
            report.addHiddenResult(doTest(tc, jarFile));
        }
        return report;
    }
    
    private TestResult doTest(TestCase testCase, String jarFile) throws IOException
    {
        ProcessBuilder builder = new ProcessBuilder("java", "-Djava.security.manager", "-Djava.security.policy=studentpolicy", "-jar", jarFile);
        builder.directory(directory);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        long startTime = System.currentTimeMillis();
        PrintStream out = new PrintStream(process.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        out.println(testCase.getInput());
        out.flush();
        while(System.currentTimeMillis() - startTime < testCase.getTimeout() && process.isAlive())
        {
            //Busy wait...
        }
        if(process.isAlive())
        {
            process.destroyForcibly();
            try
            {
                process.waitFor();
            }
            catch(InterruptedException ex)
            {
            }
            return new TestResult(testCase, TestResult.Status.TIMEOUT, null);
        }
        
        String result = in.readLine();
        if(result.equals(testCase.getExpectedOutput()))
        {
            return new TestResult(testCase, TestResult.Status.OK, null);
        }
        return new TestResult(testCase, TestResult.Status.FAILED, result);
    }
    
}
