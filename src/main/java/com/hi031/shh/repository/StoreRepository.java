package com.hi031.shh.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hi031.shh.domain.Store;


public interface StoreRepository extends PagingAndSortingRepository<Store, Integer>{
	List<Store> findByBusinessUserId(String businessUserId) throws DataAccessException;
	public long countByBusinessUserId(String businessUserId) throws DataAccessException;
	
	@Query("select s.storeId "
			+ "from Store s inner join s.businessUser bu "
			+ "where bu.businessNum = :businessNum and s.name = :storeName")
	int findStoreIdByBusinessNumAndStoreName(@Param("businessNum") String businessNum, @Param("storeName")  String storeName)throws DataAccessException;
}
