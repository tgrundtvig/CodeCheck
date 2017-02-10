/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import java.util.ArrayList;

/**
 *
 * @author Tobias Grundtvig
 */
public class Assignment
{
    private final String description;
    private final ArrayList<TestCase> visibleTests;
    private final ArrayList<TestCase> hiddenTests;

    public Assignment(String description)
    {
        this.description = description;
        visibleTests = new ArrayList<>();
        hiddenTests = new ArrayList<>();
    }
    
    public void addVisibleTestCase(String input, String expectedOutput, int timeout)
    {
        visibleTests.add(new TestCase(input, expectedOutput, timeout));
    }
    
    public void addHiddenTestCase(String input, String expectedOutput, int timeout)
    {
        hiddenTests.add(new TestCase(input, expectedOutput, timeout));
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList<TestCase> getVisibleTests()
    {
        return visibleTests;
    }

    public ArrayList<TestCase> getHiddenTests()
    {
        return hiddenTests;
    }
}
