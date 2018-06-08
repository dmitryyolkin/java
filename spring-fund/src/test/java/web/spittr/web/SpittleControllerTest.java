package web.spittr.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import web.spittr.web.dto.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (15.05.18)
 */
public class SpittleControllerTest {

    @Test
    public void testSpittles() throws Exception {
        List<Spittle> spittles20 = createSpittles(20);
        List<Spittle> spittles50 = createSpittles(50);

        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findSpittles(anyLong(), eq(20))).thenReturn(spittles20);
        when(spittleRepository.findSpittles(anyLong(), eq(50))).thenReturn(spittles50);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("src/main/webapp/WEB-INF/views/spittles.jsp"))
                .build();

        // check spittles without request - params specified
        mockMvc
                .perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute(
                        "spittleList",
                        hasItems(spittles20.toArray(new Spittle[]{}))
                ));

        //check spittles with request param = count = 50 specified
        mockMvc
                .perform(MockMvcRequestBuilders.get("/spittles?count=50&"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model().attribute(
                        "spittleList",
                        hasItems(spittles50.toArray(new Spittle[]{}))
                ));

    }

    @Test
    public void testFindSpittle() throws Exception {
        Spittle spittle = createSpittles(1).get(0);

        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findOne(anyLong())).thenReturn(spittle);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(spittleController)
                .build();

        mockMvc
                .perform(MockMvcRequestBuilders.get("/spittles/123"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute(
                        "spittle",
                        spittle
                ));
    }

    private List<Spittle> createSpittles(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle(
                    "Spittle " + i,
                    new Date()
            ));
        }
        return spittles;
    }
}
