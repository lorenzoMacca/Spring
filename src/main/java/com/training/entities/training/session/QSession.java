package com.training.entities.training.session;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSession is a Querydsl query type for Session
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSession extends EntityPathBase<Session> {

    private static final long serialVersionUID = 766784016L;

    public static final QSession session = new QSession("session");

    public final ListPath<com.training.entities.training.exercise.Exercise, com.training.entities.training.exercise.QExercise> exercises = this.<com.training.entities.training.exercise.Exercise, com.training.entities.training.exercise.QExercise>createList("exercises", com.training.entities.training.exercise.Exercise.class, com.training.entities.training.exercise.QExercise.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.training.entities.training.swim.IndoorSwim, com.training.entities.training.swim.QIndoorSwim> indoorSwims = this.<com.training.entities.training.swim.IndoorSwim, com.training.entities.training.swim.QIndoorSwim>createList("indoorSwims", com.training.entities.training.swim.IndoorSwim.class, com.training.entities.training.swim.QIndoorSwim.class, PathInits.DIRECT2);

    public final ListPath<com.training.entities.training.Run, com.training.entities.training.QRun> runs = this.<com.training.entities.training.Run, com.training.entities.training.QRun>createList("runs", com.training.entities.training.Run.class, com.training.entities.training.QRun.class, PathInits.DIRECT2);

    public QSession(String variable) {
        super(Session.class, forVariable(variable));
    }

    public QSession(Path<? extends Session> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSession(PathMetadata metadata) {
        super(Session.class, metadata);
    }

}

