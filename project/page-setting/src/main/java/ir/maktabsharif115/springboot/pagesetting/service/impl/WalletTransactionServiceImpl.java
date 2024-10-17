package ir.maktabsharif115.springboot.pagesetting.service.impl;

import com.github.javafaker.Faker;
import ir.maktabsharif115.springboot.pagesetting.document.UserInfo;
import ir.maktabsharif115.springboot.pagesetting.document.WalletTransaction;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionPurpose;
import ir.maktabsharif115.springboot.pagesetting.repository.WalletTransactionRepository;
import ir.maktabsharif115.springboot.pagesetting.service.WalletTransactionService;
import ir.maktabsharif115.springboot.pagesetting.service.dto.extra.WalletTransactionSearch;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository baseRepository;

    private final Faker faker = new Faker();

    @PostConstruct
    public void init() {
        if (baseRepository.count() == 0) {
            insertFakeData();
        }
    }

    @Override
//    @PreAuthorize("hasAuthority(T(ir.maktabsharif115.springboot.usermanagement.constants.AuthorityNames).WALLET_MANAGE)")
    public Page<WalletTransaction> findAll(WalletTransactionSearch search, Pageable pageable) {
        return baseRepository.findAll(search, pageable);
    }

    private void insertFakeData() {
        Random random = new Random();
        List<UserInfo> users = initFakeUsers();
        List<WalletTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            addNewTransaction(random, users, transactions);
        }
        baseRepository.saveAll(transactions);
    }

    private void addNewTransaction(Random random, List<UserInfo> users, List<WalletTransaction> transactions) {
        UserInfo user = users.get(random.nextInt(0, users.size()));
        WalletTransaction transaction = new WalletTransaction();
        transaction.setUserId(user.getId());
        transaction.setUser(user);
        transaction.setPerformerId(user.getId());
        transaction.setPerformer(user);

//        transaction.setWalletTotal();
//        transaction.setWalletCash();
//        transaction.setWalletCredit();
        transaction.setPurpose(
                WalletTransactionPurpose.getUserPurpose()[random.nextInt(0, 2)]
        );
        transaction.setType(transaction.getPurpose().getType());
        transaction.setTotalChange(random.nextLong(10_000, 1_000_000));
        transaction.setCashChange(transaction.getTotalChange());
        transaction.setCreditChange(0L);
        transaction.setCreateDate(ZonedDateTime.now());
        transactions.add(transaction);
    }

    private List<UserInfo> initFakeUsers() {
        List<UserInfo> userInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userInfos.add(
                    new UserInfo(
                            (long) faker.number().numberBetween(2, 10000),
                            faker.name().firstName(),
                            faker.name().lastName(),
                            faker.name().username(),
                            "09".concat(RandomStringUtils.randomNumeric(9)),
                            "CUSTOMER"
                    )
            );
        }
        return userInfos;
    }
}
