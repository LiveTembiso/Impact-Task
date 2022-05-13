package test;

import static org.junit.Assert.*;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.matchers.JUnitMatchers.*;
// import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import java.util.*;

import numberrangesummarizer.Solution;

public class Tester {

    Solution solution = new Solution();

    Collection<Integer> test1 = new ArrayList(Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));
    Collection<Integer> test2 = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    Collection<Integer> test3 = new ArrayList(Arrays.asList(1, 3, 5, 7, 9, 11, 15, 29, 231, 1002));
    Collection<Integer> test4 = new ArrayList(Arrays.asList(3, 4, 6, 7, 8, 12, 21, 22, 25, 27, 28, 29));
    Collection<Integer> test5 = new ArrayList(Arrays.asList(-34, -2, -1, 0, 1, 3, 22, 25, 27, 28, 29));

    //Test collect metod
    /*
    *Assuming input strings don't have non numeric characters other than commas and spaces
    */
    @Test
    public void testCollect(){
        //Test 1
        String input1 = "1,3,6 ,7,8,12,13, 14 ,15 ,21,22,23,24, 31";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(test1.equals(solution.collect(input1)));

        //Test 2
        String input2 = "1, 2, 3,4, 5,6,7, 8, 9,10";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(test2.equals(solution.collect(input2)));

        //Test 3
        String input3 = "1, 3, 5, 7, 9, 11, 15, 29, 231, 1002";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(test3.equals(solution.collect(input3)));

        //Test 4
        String input4 = "3, 4, 6, 7, 8, 12, 21, 22, 25, 27, 28, 29";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(test4.equals(solution.collect(input4)));

        //Test 5
        Collection<Integer> expected_output5 = new ArrayList(Arrays.asList(3, 4, 6, 7, 8, 12, 21, 22, 25, 27, 28, 29));
        String input5 = "25, 4, 29, 7, 22, 12, 21, 8, 6, 27, 28, 3";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(expected_output5.equals(solution.collect(input5)));

        //Test 6
        String input6 = "-34, -2, -1, 0, 1, 3, 22, 25, 27, 28, 29";
        // Collection<Integer> test1 = new ArrayList(Arrays.asList(array1));
        assertTrue(test5.equals(solution.collect(input6)));
    }

    //Test summarizeCollection method
    @Test
    public void testSummarizeCollection(){
        //Test 1
        String expected_output1 = "1, 3, 6-8, 12-15, 21-24, 31";
        String solution1 = solution.summarizeCollection(test1);
        assertEquals(expected_output1,solution1);

        //Test 2
        String expected_output2 = "1-10";
        String solution2 = solution.summarizeCollection(test2);
        assertEquals(expected_output2,solution2);

        //Test 3
        String expected_output3 = "1, 3, 5, 7, 9, 11, 15, 29, 231, 1002";
        String solution3 = solution.summarizeCollection(test3);
        assertEquals(expected_output3,solution3);

        //Test 4
        String expected_output4 = "3-4, 6-8, 12, 21-22, 25, 27-29";
        String solution4 = solution.summarizeCollection(test4);
        assertEquals(expected_output4,solution4);

        //Test 5
        String expected_output5 = "-34, -2-1, 3, 22, 25, 27-29";
        String solution5 = solution.summarizeCollection(test5);
        assertEquals(expected_output5,solution5);
    }
}
