package com.africa.semicolon.ewallet.data.repositories;

import com.africa.semicolon.ewallet.data.models.KYC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface kycRepository extends JpaRepository<KYC, Long>{
}
