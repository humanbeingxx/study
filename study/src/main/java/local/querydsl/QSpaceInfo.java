package local.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSpaceInfo is a Querydsl query type for SpaceInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSpaceInfo extends EntityPathBase<SpaceInfo> {

    private static final long serialVersionUID = -283975842L;

    public static final QSpaceInfo spaceInfo = new QSpaceInfo("spaceInfo");

    public final NumberPath<Long> area = createNumber("area", Long.class);

    public final StringPath boundaryGeometryText = createString("boundaryGeometryText");

    public final ListPath<java.util.List<?>, SimplePath<java.util.List<?>>> boundaryList = this.<java.util.List<?>, SimplePath<java.util.List<?>>>createList("boundaryList", java.util.List.class, SimplePath.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath parentName = createString("parentName");

    public QSpaceInfo(String variable) {
        super(SpaceInfo.class, forVariable(variable));
    }

    public QSpaceInfo(Path<? extends SpaceInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSpaceInfo(PathMetadata metadata) {
        super(SpaceInfo.class, metadata);
    }

}

