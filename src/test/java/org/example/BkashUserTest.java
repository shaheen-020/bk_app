package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class BkashUserTest {
    @Test
    public void testCashInSuccess() {
        BkashUser user = new BkashUser("01700000000", "1234");
        user.cashIn(500, "1234");
        assertEquals(500.0, user.getBalance());
    }
    @Test
    public void testTimeOut(){
        BkashUser user = new BkashUser("01792345238", "1234");
        user.cashIn(10000, "1234");
        assertTimeout(Duration.ofMillis(100), () ->{
            user.sendMoney("01792345238", 1500, "1234");
        });
    }
}