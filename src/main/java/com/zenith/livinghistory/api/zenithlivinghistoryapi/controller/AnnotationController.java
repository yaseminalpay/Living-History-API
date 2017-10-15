package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.request.Annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/annotations/")
public class AnnotationController {

    // TODO: Move this to a database
    private static List<Annotation> annotations;

    @Autowired
    private AnnotationController() {
        this.annotations = new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Void> create(@RequestBody Annotation annotation) {
        // TODO: Remove this and generate Id programatically.
        Integer index = this.annotations.size();
        annotation.setId("http://localhost:8080/api/v1/annotations/" + ++index);

        annotations.add(annotation);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow", "PUT,GET,OPTIONS,HEAD,DELETE,PATCH");
        headers.add("Location", "http://example.org/annotations/anno1");
        headers.add("Content-Type", "application/ld+json; profile=\"http://www.w3.org/ns/anno.jsonld\"");

        return new ResponseEntity(annotation, headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Annotation> create(@PathVariable("id") Integer id) {
        Annotation annotation = this.annotations.get(--id);
        return new ResponseEntity<>(annotation, HttpStatus.OK);
    }
}
