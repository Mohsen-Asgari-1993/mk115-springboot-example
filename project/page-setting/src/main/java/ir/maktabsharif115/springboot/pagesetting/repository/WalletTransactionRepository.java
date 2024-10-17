package ir.maktabsharif115.springboot.pagesetting.repository;

import ir.maktabsharif115.springboot.mongo.crud.repository.BaseDocumentRepository;
import ir.maktabsharif115.springboot.pagesetting.document.UserInfo;
import ir.maktabsharif115.springboot.pagesetting.document.WalletTransaction;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionPurpose;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionType;
import ir.maktabsharif115.springboot.pagesetting.service.dto.extra.WalletTransactionSearch;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface WalletTransactionRepository extends BaseDocumentRepository<WalletTransaction, String>,
        WalletTransactionCustomRepository {

//    Page<WalletTransaction> findAllByUserId(Long userId, Pageable pageable);

//    @Query(value = "{userId: ?1}")
//    Page<WalletTransaction> findAllByUserIdCustom(Long userId, Pageable pageable);
}

interface WalletTransactionCustomRepository {

    Page<WalletTransaction> findAll(WalletTransactionSearch search, Pageable pageable);

    List<Document> aggregateUserTransactionByPurpose();

    List<Document> getSimpleFacetData();

}

@RequiredArgsConstructor
class WalletTransactionCustomRepositoryImpl implements WalletTransactionCustomRepository {

    private final MongoTemplate mongoTemplate;

    private final MongoOperations mongoOperations;

    @Override
    public Page<WalletTransaction> findAll(WalletTransactionSearch search, Pageable pageable) {
        Query query = new Query();
//        query.skip(pageable.getOffset());
//        query.limit(pageable.getPageSize());
//        query.with(pageable.getSort());
        query.with(pageable);
        List<Criteria> criteriaList = new ArrayList<>();
        fillUserIdCriteria(criteriaList, search.getUserId());
        fillUserFirstNameCriteria(criteriaList, search.getUserFirstName());
        fillUserLastNameCriteria(criteriaList, search.getUserLastName());
        fillUserUsernameCriteria(criteriaList, search.getUserUsername());
        fillTypeCriteria(criteriaList, search.getType());
        fillPurposeCriteria(criteriaList, search.getPurpose());
        fillCreateDateCriteria(criteriaList, search.getFromCreateDate(), search.getToCreateDate());
        fillTotalChangeCriteria(criteriaList, search.getFromTotalChange(), search.getToTotalChange());
        if (!criteriaList.isEmpty()) {
            query.addCriteria(
                    new Criteria().andOperator(
                            criteriaList.toArray(new Criteria[0])
                    )
            );
        }
//        List<WalletTransaction> transactions = mongoOperations.find(query, WalletTransaction.class);
//        List<WalletTransaction> transactions = mongoTemplate.find(query, WalletTransaction.class);

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, WalletTransaction.class),
                pageable,
                () -> mongoTemplate.count(query.skip(-1).limit(-1), WalletTransaction.class)
        );
    }

    @Override
    public List<Document> aggregateUserTransactionByPurpose() {
        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.match(
                                Criteria.where(WalletTransaction.PURPOSE).is(WalletTransactionPurpose.WALLET_INCREASE_BY_USER)
                        ),
                        Aggregation.group(WalletTransaction.USER_ID)
                                .sum(WalletTransaction.TOTAL_CHANGE).as("total"),
                        Aggregation.sort(
//                            Sort.by("total")
//                            Sort.by("total").descending(),
                                Sort.Direction.DESC, "total"
                        )
                ),
                WalletTransaction.class,
                Document.class
        ).getMappedResults();
    }

    @Override
    public List<Document> getSimpleFacetData() {
        return mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.facet(
                                        Aggregation.match(
                                                Criteria.where(WalletTransaction.PURPOSE).is(WalletTransactionPurpose.WALLET_INCREASE_BY_USER)
                                        ),
                                        Aggregation.group(WalletTransaction.USER_ID)
                                                .sum(WalletTransaction.TOTAL_CHANGE).as("total"),
                                        Aggregation.sort(
                                                Sort.Direction.DESC, "total"
                                        )
                                ).as("first")
                                .and(
                                        Aggregation.match(
                                                Criteria.where(WalletTransaction.PURPOSE).is(WalletTransactionPurpose.WALLET_INCREASE_BY_USER)
                                        ),
                                        Aggregation.group(WalletTransaction.USER_ID)
                                                .sum(WalletTransaction.TOTAL_CHANGE).as("total"),
                                        Aggregation.sort(
                                                Sort.Direction.DESC, "total"
                                        )
                                ).as("second")
                                .and(
                                        Aggregation.match(
                                                Criteria.where(WalletTransaction.PURPOSE).is(WalletTransactionPurpose.WALLET_INCREASE_BY_USER)
                                        ),
                                        Aggregation.group(WalletTransaction.USER_ID)
                                                .sum(WalletTransaction.TOTAL_CHANGE).as("total"),
                                        Aggregation.sort(
                                                Sort.Direction.DESC, "total"
                                        )
                                ).as("third")
                ),
                WalletTransaction.class,
                Document.class
        ).getMappedResults();
    }

    private void fillUserIdCriteria(List<Criteria> criteriaList, Long userId) {
        if (userId != null) {
            criteriaList.add(
                    Criteria.where(WalletTransaction.USER_ID).is(userId)
            );
        }
    }

    private void fillUserFirstNameCriteria(List<Criteria> criteriaList, String userFirstName) {
        if (StringUtils.isNotBlank(userFirstName)) {
            criteriaList.add(
                    Criteria.where(
                                    String.join(
//                                            user.firstName
                                            ".",
                                            WalletTransaction.USER,
                                            UserInfo.FIRST_NAME
                                    )

                            )
                            .regex(userFirstName)
            );
        }
    }

    private void fillUserLastNameCriteria(List<Criteria> criteriaList, String userLastName) {
        if (StringUtils.isNotBlank(userLastName)) {
            criteriaList.add(
                    Criteria.where(
                                    String.join(
//                                            user.lastName
                                            ".",
                                            WalletTransaction.USER,
                                            UserInfo.LAST_NAME
                                    )

                            )
                            .regex(userLastName)
            );
        }
    }

    private void fillUserUsernameCriteria(List<Criteria> criteriaList, String userUsername) {
        if (StringUtils.isNotBlank(userUsername)) {
            criteriaList.add(
                    Criteria.where(
                                    String.join(
//                                            user.username
                                            ".",
                                            WalletTransaction.USER,
                                            UserInfo.USERNAME
                                    )
                            )
                            .regex(userUsername)
            );
        }
    }

    private void fillTypeCriteria(List<Criteria> criteriaList, WalletTransactionType type) {
        if (type != null) {
            criteriaList.add(
                    Criteria.where(WalletTransaction.TYPE).is(type)
            );
        }
    }

    private void fillPurposeCriteria(List<Criteria> criteriaList, WalletTransactionPurpose purpose) {
        if (purpose != null) {
            criteriaList.add(
                    Criteria.where(WalletTransaction.PURPOSE).is(purpose)
            );
        }
    }

    private void fillCreateDateCriteria(List<Criteria> criteriaList, ZonedDateTime fromCreateDate,
                                        ZonedDateTime toCreateDate) {
        if (fromCreateDate != null) {
            criteriaList.add(
                    Criteria.where(
                            "createDate.millis"
                    ).gte(fromCreateDate.toInstant().toEpochMilli())
            );
        }
        if (toCreateDate != null) {
            criteriaList.add(
                    Criteria.where(
                            "createDate.millis"
                    ).lte(toCreateDate.toInstant().toEpochMilli())
            );
        }
    }

    private void fillTotalChangeCriteria(List<Criteria> criteriaList, Long fromTotalChange, Long toTotalChange) {
        if (fromTotalChange != null && fromTotalChange >= 0) {
            criteriaList.add(
                    Criteria.where(WalletTransaction.TOTAL_CHANGE).gte(fromTotalChange)
            );
        }
        if (toTotalChange != null && toTotalChange >= 0) {
            criteriaList.add(
                    Criteria.where(WalletTransaction.TOTAL_CHANGE).lte(toTotalChange)
            );
        }
    }
}
