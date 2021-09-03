package com.hi031.shh.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.domain.Link;

@EnableJpaRepositories
public interface LinkRepository extends PagingAndSortingRepository<Link, Integer>, CrudRepository<Link, Integer>  {
	List<Link> findByLinkId(String linkId) throws DataAccessException;
	List<Link> findByProposer(BusinessAccount proposer) throws DataAccessException;
	List<Link> findByReceiver(BusinessAccount receiver) throws DataAccessException;
	public long countByProposer(BusinessAccount proposer) throws DataAccessException;
	Link findByProposerAndReceiver(BusinessAccount proposer, BusinessAccount receiverId) throws DataAccessException;
	
	
}
