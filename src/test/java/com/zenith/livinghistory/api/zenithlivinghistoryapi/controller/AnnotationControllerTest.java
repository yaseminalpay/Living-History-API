package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.data.repository.AnnotationRepository;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.Annotation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class AnnotationControllerTest {

    @InjectMocks
    private AnnotationController sut = new AnnotationController();

    @Mock
    private Annotation mockAnnotation;

    @Mock
    private AnnotationRepository mockRepo;

    private List<Annotation> testAnnotations = new ArrayList<>();

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mockRepo.findOne(Mockito.anyString())).thenReturn(mockAnnotation);
        Mockito.when(mockRepo.findAll()).thenReturn(testAnnotations);
    }

    @Test
    public void initialState_createAnnotation_repoCallsInsert() {
        sut.create(mockAnnotation);
        Mockito.verify(mockRepo, Mockito.times(1)).insert(mockAnnotation);

    }

    @Test
    public void initialState_getAnnotations_repoCallsFindAll() {
        List<Annotation> annotations = sut.getAll();
        Mockito.verify(mockRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void initialState_getAnnotation_repoCallsFindOne() {
        Annotation annotation = sut.get(Mockito.anyString());
        Mockito.verify(mockRepo, Mockito.times(1)).findOne(Mockito.anyString());
    }


}
