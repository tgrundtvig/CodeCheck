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
public class TestCase
{
    private final String input;
    private final String expectedOutput;
    private final int timeout;

    public TestCase(String input, String expected, int timeout)
    {
        this.input = input;
        this.expectedOutput = expected;
        this.timeout = timeout;
    }

    public String getInput()
    {
        return input;
    }

    public String getExpectedOutput()
    {
        return expectedOutput;
    }

    public int getTimeout()
    {
        return timeout;
    }
}
