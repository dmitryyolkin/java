package web.spittr.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import web.spittr.web.dto.Spitter;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.05.18)
 */
public class SpitterControllerTest {

    @Test
    public void testRegister() throws Exception {
        SpitterController spittleController = new SpitterController(mock(SpittleRepository.class));

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(spittleController)
                .build();
        mockMvc
                .perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void processRegisterTest() throws Exception {
        SpittleRepository spittleRepository = mock(SpittleRepository.class);

        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(spittleRepository.save(unsaved)).thenReturn(saved);

        SpitterController spittleController = new SpitterController(spittleRepository);

        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(spittleController)
                .build();

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/spitter/register")
                        .param("firstName", unsaved.getFirstName())
                        .param("lastName", unsaved.getLastName())
                        .param("userName", unsaved.getUserName())
                        .param("password", unsaved.getPassword())
                ).andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));

        verify(spittleRepository, atLeastOnce()).save(eq(unsaved));

    }

    @Test
    public void testValidation() throws Exception {
        SpitterController spitterController = new SpitterController(mock(SpittleRepository.class));
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(spitterController)
                .build();

        //to make this test case possible we have to add a few dependencies
        //please see pom.xml
        // 1. hibernate-validator - to be able to use @Valid
        // 2. javax.el-api - to pass some params in requests like 'password' below
        // 3. el-impl - to avoid ClassNotFoundException:com.sun.el.ExpressionFactoryImpl

        mockMvc
                .perform(MockMvcRequestBuilders
                                .post("/spitter/register")
                                //too long password
                                .param("password", "12345678910111213141516")
                ).andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }


}