package com.hi031.shh.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.hi031.shh.domain.Receipt;

public interface ReceiptRepository extends CrudRepository<Receipt, Integer> {
	boolean existsByStoreIdAndConsumerUserIdAndReceiptDate(int storeId, String consumerUserId, String receiptDate) throws DataAccessException;
}