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
        SpitterController spittleController = new SpitterController(
                mock(SpittleRepository.class)
        );

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

}
