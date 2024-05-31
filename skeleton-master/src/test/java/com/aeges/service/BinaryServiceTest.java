package com.aeges.service;

import com.aeges.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryServiceTest {

    BinaryService binaryService = new BinaryService();

    @Test
    public void checkInputIsAsExpected1() {
        int value = binaryService.getTotalCount("11");
        int value1 = binaryService.getTotalCount("1101");
        assertTrue(value ==3);
        assertTrue(value1 ==11);
    }

    @Test
    public void shouldNotContainOtherthan0and1New()  {
        int value = binaryService.getTotalCount("121");
        assertTrue(value ==0);
    }

}