package jpabook.jpashop.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1075558965L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final jpabook.jpashop.domain.QBaseEntity _super = new jpabook.jpashop.domain.QBaseEntity(this);

    public final jpabook.jpashop.domain.QAddress address;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<jpabook.jpashop.domain.item.Item, jpabook.jpashop.domain.item.QItem> items = this.<jpabook.jpashop.domain.item.Item, jpabook.jpashop.domain.item.QItem>createList("items", jpabook.jpashop.domain.item.Item.class, jpabook.jpashop.domain.item.QItem.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModified = _super.lastModified;

    public final ListPath<jpabook.jpashop.domain.Order, jpabook.jpashop.domain.QOrder> orders = this.<jpabook.jpashop.domain.Order, jpabook.jpashop.domain.QOrder>createList("orders", jpabook.jpashop.domain.Order.class, jpabook.jpashop.domain.QOrder.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new jpabook.jpashop.domain.QAddress(forProperty("address")) : null;
    }

}

