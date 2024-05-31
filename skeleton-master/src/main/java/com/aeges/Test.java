package com.aeges;


import com.aeges.exception.InvalidInputException;
import com.aeges.service.GenerateAsciiService;

public class Test {
    public static void main(String[] args) throws InvalidInputException {

        System.out.println(new GenerateAsciiService().evaluateOddSequences("6521714069616518831033"));

    }

}


