package com.creditCardManagement.repository;

import com.creditCardManagement.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Account, Long>{
}
