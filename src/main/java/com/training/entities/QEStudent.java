package com.training.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEStudent is a Querydsl query type for EStudent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEStudent extends EntityPathBase<EStudent> {

    private static final long serialVersionUID = -1692039620L;

    public static final QEStudent eStudent = new QEStudent("eStudent");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<ENote, QENote> noten = this.<ENote, QENote>createList("noten", ENote.class, QENote.class, PathInits.DIRECT2);

    public QEStudent(String variable) {
        super(EStudent.class, forVariable(variable));
    }

    public QEStudent(Path<? extends EStudent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEStudent(PathMetadata metadata) {
        super(EStudent.class, metadata);
    }

}

