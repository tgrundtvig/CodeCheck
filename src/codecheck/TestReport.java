/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import codecheck.TestResult.Status;
import java.util.ArrayList;

/**
 *
 * @author Tobias Grundtvig
 */
public class TestReport
{

    private final Assignment assignment;
    private final ArrayList<TestResult> visibleResults;
    private final ArrayList<TestResult> hiddenResults;

    public TestReport(Assignment assignment)
    {
        this.assignment = assignment;
        visibleResults = new ArrayList<>();
        hiddenResults = new ArrayList<>();
    }

    void addVisibleResult(TestResult result)
    {
        visibleResults.add(result);
    }

    void addHiddenResult(TestResult result)
    {
        hiddenResults.add(result);
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        res.append("Report\n******\n");
        for(TestResult result : visibleResults)
        {
            res.append(result.getTestCase().getInput());
            res.append(" -> ");
            res.append(result.getTestCase().getExpectedOutput());
            if(null != result.getStatus())
            {
                switch(result.getStatus())
                {
                    case OK:
                        res.append(" (OK)");
                        break;
                    case FAILED:
                        res.append(" FAILED! Output was: ");
                        res.append(result.getMsg());
                        break;
                    default:
                        res.append(" TIMEOUT");
                        break;
                }
            }
            res.append("\n");
        }
        Status status = TestResult.Status.OK;
        for(TestResult result : hiddenResults)
        {
            if(result.getStatus() == Status.TIMEOUT)
            {
                status = Status.TIMEOUT;
            }
            else if(result.getStatus() == Status.FAILED)
            {
                status = Status.FAILED;
                break;
            }
        }
        res.append("Other tests: ");
        res.append(status);
        return res.toString();
    }

}
