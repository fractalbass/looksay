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
        m.delete(1);
    }

    @Test
    public void assertTrue() {
        assert true;
    }

    @Test
    public void testSaveRecord() {
        MessageDao m = new MessageDao();
        int x = m.save(1, "This is a test");
        assert(x>0);
    }

    @Test
    public void testGetRecord() {
        int id = 1;
        MessageDao m = new MessageDao();
        int x = m.save(1, "This is a test");
        assert(x>0);
        String message = m.get(id);
        assert(message!=null);
    }

}
