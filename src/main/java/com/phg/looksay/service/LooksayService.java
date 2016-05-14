package com.phg.looksay.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by milesporter on 5/13/16.
 */
@Component
public class LooksayService {

    public ArrayList<String> generateLines(int startNum, int rows) {
        ArrayList<String> output = new ArrayList<String>();
        output.add(Integer.toString(startNum));
        for (int i=1;i<rows;i++) {
            String newLine = generateOutput(output.get(i-1));
            output.add(newLine);
        }
        return output;
    }

    public String generateOutput(String input) {
        String output="";
        String[] splitInput = input.split(",");
        String currentVal =  splitInput[0];
        int currentCount = 0;
        for(int c=0;c<splitInput.length;c++) {
            if(splitInput[c].equals(currentVal)) {
                currentCount++;
            } else {
                output=output+currentCount+","+currentVal + ",";
                currentVal=splitInput[c];
                currentCount=1;
            }
        }
        output=output+currentCount+","+currentVal;
        return output;
    }
}
