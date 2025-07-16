package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BkashTest {
    private BkashUser user1;
    private BkashUser user2;
    private Bkash app;
    @Test
    public void TestAssertNotSame(){
        app = new Bkash();
        user1 = new BkashUser("01320807492","1234");
        user2 = new BkashUser("01320807492","1234");
        assertNotSame(user1, user2);
    }

}