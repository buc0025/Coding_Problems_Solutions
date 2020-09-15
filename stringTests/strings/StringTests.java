package strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringTests {

    @Test
    public void doubleExistsTest() {
        DoubleExists test = new DoubleExists();
        int[] arr = {10,2,3,5};
        boolean result = test.checkIfExist(arr);
        assertEquals(true, result);

    }

}