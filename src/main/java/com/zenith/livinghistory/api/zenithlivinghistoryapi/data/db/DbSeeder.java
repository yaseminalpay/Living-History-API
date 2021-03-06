package com.zenith.livinghistory.api.zenithlivinghistoryapi.data.db;

//@Component
//public class DbSeeder implements CommandLineRunner {
//
//    /*
//    *
//    * This component runs on application start.
//    * It drops application database
//    * and populates it with test data.
//    *
//    * */
//
//    private AnnotationRepository annotationRepository;
//
//    public DbSeeder(AnnotationRepository annotationRepository) {
//        this.annotationRepository = annotationRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Annotation annotation = new Annotation(
//                "http://www.w3.org/ns/anno.jsonld",
//                "Annotation",   // TODO: replace with enum
//                "http://example.org/user1",
//                DateTime.now(),
//                null,
//                new AnnotationBody(
//                        "TextualBody",  // TODO: replace with enum
//                        "<p>Paragraf!</p>",
//                        "text/html",
//                        "tr",
//                        "http://example.net/user2",
//                        DateTime.now()
//                ),
//                new AnnotationTarget(
//                        "http://example.com/image1.jpg#xywh=100,100,300,300",
//                        "Image", // TODO: replace with enum
//                        "image/jpeg"
//                )
//        );
//
//        // TODO: add more annotation examples
//
//        // Drop existing annotations
//        annotationRepository.deleteAll();
//
//        // Add test data to the database
//        annotationRepository.save(annotation);
//    }
//}
