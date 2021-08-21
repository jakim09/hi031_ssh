package com.hi031.shh.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hi031.shh.domain.Store;


public interface StoreRepository extends PagingAndSortingRepository<Store, Integer>{
	List<Store> findByBusinessUserId(String businessUserId) throws DataAccessException;
	public long countByBusinessUserId(String businessUserId);
}
