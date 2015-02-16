package com.shpak.persistence.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shpak.persistence.model.UserAccount;

@Transactional(readOnly = true)
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
	
	List<UserAccount> findByFullname(String fullname);
	
	@Modifying
	@Transactional
	@Query("update UserAccount u set u.fullname=:f, u.description=:d, u.createdDate=:c, u.balance=:b, u.active=:a where u.id=:id")
	void updateUserAccountById(@Param("id")Long id,@Param("f")String f, @Param("d")String d,@Param("c")Date c, @Param("b")BigDecimal b, @Param("a")Boolean a);

}
