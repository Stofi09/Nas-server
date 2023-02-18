package com.nascon.server.unit;

import com.nascon.server.model.Customer;
import com.nascon.server.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ItemUnitTest {

    private static Item item;

    @BeforeAll
    static void setup() {
        item = new Item(2L,"name",2,true);
    }
    @Test
    void itemName(){
        assertEquals("name",item.getName());
    }

    @Test
    void itemId(){
        assertEquals(2L,item.getId());
    }

    @Test
    void itemAmount(){
        assertEquals(2,item.getAmount());
    }
    @Test
    void itemAvailability(){
        assertEquals(true,item.isAvailable());
    }

}
