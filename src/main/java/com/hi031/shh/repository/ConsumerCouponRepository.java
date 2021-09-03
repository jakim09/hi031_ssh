package com.hi031.shh.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hi031.shh.domain.ConsumerCoupon;
import com.hi031.shh.domain.Coupon;

public interface ConsumerCouponRepository extends PagingAndSortingRepository<Coupon, Integer>{
	//List<ConsumerCoupon> findByConsumerUserIdAndStateOrderByDownloadDate(int consumerUserId, int state) throws DataAccessException; //발급순 정렬
//	
//	@Query("select c from ConsumerCoupon c " + 
//			"where c.consumer.consumerUserId = ?1 order by c.finishDate desc")
//	List<ConsumerCoupon> findByConsumerUserIdOrderByCoupon_(int consumerUserId) throws DataAccessException; //마감임박순 정렬

	//List<ConsumerCoupon> findByConsumerUserIdAndStateNot(int consumerUserId, int state) throws DataAccessException; //만료 쿠폰
	
}
