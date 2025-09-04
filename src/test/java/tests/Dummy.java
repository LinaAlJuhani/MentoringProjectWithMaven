package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dummy {

    @Test
    public  void test() {

        int age =19;
      // System.out.println(age>18);
       // Assertions.assertTrue(age<18);
      //  Assertions.assertFalse(true);


        String name1 = null;
        String name2 = "John";
        String name3 = "John";
        String name4 = new String("John");

        // Check if value is null
        Assertions.assertNull(name1);

        // Check if value is not null
        Assertions.assertNotNull(name2);

        // Compare values (using equals method)
        Assertions.assertEquals(name2, name3);   // same value
        Assertions.assertEquals(name2, name4);   // same value as well

        // Compare references (check if both point to the same object in memory)
        Assertions.assertSame(name2, name3);     // same reference (string pool)

        //Assertions.assertSame(name2, name4);   // this will FAIL, because name4 is a new object
    }
}

