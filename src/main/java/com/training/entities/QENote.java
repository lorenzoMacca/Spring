package com.training.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QENote is a Querydsl query type for ENote
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QENote extends EntityPathBase<ENote> {

    private static final long serialVersionUID = 521540497L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QENote eNote = new QENote("eNote");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> note = createNumber("note", Integer.class);

    public final QEStudent student;

    public QENote(String variable) {
        this(ENote.class, forVariable(variable), INITS);
    }

    public QENote(Path<? extends ENote> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QENote(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QENote(PathMetadata metadata, PathInits inits) {
        this(ENote.class, metadata, inits);
    }

    public QENote(Class<? extends ENote> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new QEStudent(forProperty("student")) : null;
    }

}

