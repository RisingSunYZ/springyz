package com.anotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        System.out.println(annotationMetadata.getAnnotationTypes());
        return new String[]{"com.anotation.model.Green"};
    }
}
