package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.Example;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Annotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.access.SecurityConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes={SecurityConfig.class})
public class AnnotationControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnnotationRepository mockAnnotationRepository;

    @Test
    public void initialState_createAnnotation_repoCanCreate() throws Exception {

        List<Annotation> annotationList = new ArrayList<>();
        Annotation annotation = Example.GetAnnotationInstance();
        annotation.setCreator("Hello Mock");
        annotationList.add(Example.GetAnnotationInstance());
        when(mockAnnotationRepository.findAll()).thenReturn(annotationList);

        this.mockMvc.perform(get("/api/v1/annotations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(containsString("Hello Mock")));;


    }


}
