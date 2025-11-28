package org.example.service;

import org.example.entity.Account;


public interface AuditService {
    void analyseAll();
    boolean overdrawn(Account account);
}
