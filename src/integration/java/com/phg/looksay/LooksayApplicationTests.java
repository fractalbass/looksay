package com.phg.looksay;

import com.phg.looksay.service.LooksayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LooksayApplication.class)
@WebAppConfiguration
public class LooksayApplicationTests {

	@Autowired
	LooksayService looksayService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void generateFiveLines() {
		ArrayList<String> lines = looksayService.generateLines(1,5);
		assertEquals(lines.size(),5);
		assertEquals("1",lines.get(0));
		assertEquals("1,1",lines.get(1));
		assertEquals("2,1",lines.get(2));
		assertEquals("1,2,1,1",lines.get(3));
		assertEquals("1,1,1,2,2,1", lines.get(4));
	}

	@Test
	public void generateFiveNonTrivialCase() {
		ArrayList<String> lines = looksayService.generateLines(3,5);
		assertEquals(lines.size(),5);
		assertEquals("3",lines.get(0));
		assertEquals("1,3",lines.get(1));
		assertEquals("1,1,1,3",lines.get(2));
		assertEquals("3,1,1,3",lines.get(3));
		assertEquals("1,3,2,1,1,3", lines.get(4));
	}

}
