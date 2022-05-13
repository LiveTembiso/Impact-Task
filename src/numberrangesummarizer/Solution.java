package numberrangesummarizer;
import java.util.*;

public class Solution implements NumberRangeSummarizer{
    
    //collect the input
    public Collection<Integer> collect(String input){
        ArrayList<Integer> csv = new ArrayList<Integer>(); 
        
        //Remove spaces in between characters
        //input = input.replaceAll("^[0-9,-] ", "");
        input = input.replaceAll(" ", "");
        String[] string_list = input.split(",");
        
        //Add numbers to list
        for(String num : string_list){
            csv.add(Integer.parseInt(num));
        }

        Collections.sort(csv);
        Collection<Integer> output = csv;

        return output;
    }

    //get the summarized string
    public String summarizeCollection(Collection<Integer> input){

        ArrayList<Integer> input_list = (ArrayList<Integer>)input;
        String output = "";

        int counter = 0;
        int size = input_list.size() - 1;

        for(int i = 0; i <= size; i++){
            if(i < size && input_list.get(i)+1 == input_list.get(i+1)){
                counter++;
            }
            else if(output.length() == 0){
                output = (i+counter > i) ? output + input_list.get(i-counter) + "-" + input_list.get(i) : output + input_list.get(i);
                counter = 0;
            }else if(i > 0){
                output = (i+counter > i) ? output + ", " + input_list.get(i-counter) + "-" + input_list.get(i) : output + ", " + input_list.get(i);
                counter = 0;
            }   
        }
        return output;
   
    }

    public static void main(String[] args){
            Solution solution = new Solution();
            String in = "1, 3, 6, 7, 8, 12, 13, 14,15,21,22,23,24,31";
            Collection<Integer> integer_list = solution.collect(in);
            String output = solution.summarizeCollection(integer_list);

            System.out.println(integer_list);
            System.out.println(output);
    }

}