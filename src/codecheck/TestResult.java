/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

/**
 *
 * @author Tobias Grundtvig
 */
public class TestResult
{
    private final TestCase testCase;
    private final Status status;
    private final String msg;

    public TestResult(TestCase testCase, Status status, String msg)
    {
        this.testCase = testCase;
        this.status = status;
        this.msg = msg;
    }
    
    public TestCase getTestCase()
    {
        return testCase;
    }

    public Status getStatus()
    {
        return status;
    }

    public String getMsg()
    {
        return msg;
    }
    
    public enum Status {OK, FAILED, TIMEOUT}
}
