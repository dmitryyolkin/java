package com.yolkin.springbootdemo;

import com.yolkin.springbootdemo.entities.Book;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadingListApplication.class)

// it shows that appContext created with SpringRunner should be WebAppContext
// by default non-WebAppContext is created
@WebAppConfiguration
public class ReadingListControllerUTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void homePage() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/users/testUser"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.is(Matchers.empty())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(post("/users/testUser")
                // When posting the book, we must make sure we set the content type to “application/ x-www-form-urlencoded”
                // (with MediaType.APPLICATION_FORM_URLENCODED) as that will be the content type that a browser will send
                // when the book is posted in the running application.
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("title", "BOOK TITLE")
                    .param("author", "BOOK AUTHOR")
                    .param("isbn", "1234567890")
                    .param("description", "DESCRIPTION"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/testUser")); // redirect to "redirect:/{reader}"

        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setReader("testUser");
        expectedBook.setTitle("BOOK TITLE");
        expectedBook.setAuthor("BOOK AUTHOR");
        expectedBook.setIsbn("1234567890");
        expectedBook.setDescription("DESCRIPTION");

        mockMvc.perform(MockMvcRequestBuilders.get("/users/testUser"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("readingList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.hasSize(1))) //  because collection is returned
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.contains(Matchers.samePropertyValuesAs(expectedBook))));
    }
}
