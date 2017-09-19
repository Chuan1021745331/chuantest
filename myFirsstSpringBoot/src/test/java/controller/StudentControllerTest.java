package controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@AutoConfigureMockMvc
public class StudentControllerTest {
	/*@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() {
		System.out.println("xxx");
	}
	
	@Test
	public void getStudentList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/students"))
						.andExpect(MockMvcResultMatchers.status().isOk());
	}*/

}
