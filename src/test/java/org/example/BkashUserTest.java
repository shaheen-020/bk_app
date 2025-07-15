package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BkashUserTest {
    @Test
    public void testCashInSuccess() {
        BkashUser user = new BkashUser("01700000000", "1234");
        user.cashIn(500, "1234");
        assertEquals(500.0, user.getBalance());
    }
    @Test
    public void testAssertSame(){
        BkashUser user = new BkashUser("01320807492","1234");
        BkashUser another = user;
        assertSame(user, another);

    }


}