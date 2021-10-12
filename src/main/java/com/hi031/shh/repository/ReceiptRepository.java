package com.hi031.shh.repository;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hi031.shh.domain.Receipt;

public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {
}