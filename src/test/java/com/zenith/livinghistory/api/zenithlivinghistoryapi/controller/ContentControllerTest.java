package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.ContentRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Annotation;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Content;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ContentControllerTest {

    @InjectMocks
    private ContentController sut = new ContentController();

    @Mock
    private Content mockContent;

    @Mock
    private ContentRepository mockRepo;

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initialState_createContent_repoCallsInsert() {
        sut.create(mockContent);
        Mockito.verify(mockRepo, Mockito.times(1)).insert(mockContent);

    }

    @Test
    public void initialState_getContents_repoCallsFindAll() {
        List<Content> annotations = sut.getAll();
        Mockito.verify(mockRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void initialState_getContent_repoCallsFindOne() {
        Content content = sut.get(Mockito.anyString());
        Mockito.verify(mockRepo, Mockito.times(1)).findOne(Mockito.anyString());
    }
}
