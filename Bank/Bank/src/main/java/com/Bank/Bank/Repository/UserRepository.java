package com.Bank.Bank.Repository;

import com.Bank.Bank.Model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AccountDetails, Long> {

}
