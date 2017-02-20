package com.phg.looksay.dao;

/**
 * Created by milesporter on 2/20/17.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MessageDaoTest {

    @Before
    public void cleanup() {
        MessageDao m = new MessageDao();
        m.delete(999,1);
    }

    @Test
    public void assertTrue() {
        assert true;
    }

    @Test
    public void testSaveRecord() {
        MessageDao m = new MessageDao();
        int device = 999;
        int channel = 1;
        String message = "This is a test.";
        boolean x = m.save(device, channel, message);
        assert(x);
    }

    @Test
    public void testGetRecord() {
        int device = 999;
        int channel = 1;
        String message = "This is a test.";
        MessageDao m = new MessageDao();
        boolean result = m.save(device, channel, message);
        assert(result);
        String foundMessage = m.get(device, channel);
        assert(foundMessage.equals("This is a test."));
    }

}
