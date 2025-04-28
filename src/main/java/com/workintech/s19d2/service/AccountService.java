package com.workintech.s19d2.service;

import com.workintech.s19d2.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    // Buraya servis fonksiyonlarını yazabilirsin.
    // Repository'de yazdıklarını buraya getirmeni öneririm.
    List<Account> findAll();

    Account save(Account account);

    Optional<Account> findById(long id);
}
