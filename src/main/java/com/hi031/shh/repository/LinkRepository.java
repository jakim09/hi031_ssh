package com.hi031.shh.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hi031.shh.domain.Link;

public interface LinkRepository extends PagingAndSortingRepository<Link, Integer>, CrudRepository<Link, Integer>  {
	List<Link> findByLinkId(int linkId) throws DataAccessException;
	List<Link> findByProposerId(int proposerId) throws DataAccessException;
	List<Link> findByReceiverId(int receiverId) throws DataAccessException;
	public long countByProposerId(int proposerId) throws DataAccessException;
	Link findByProposerIdAndReceiverId(int proposerId, int receiverId) throws DataAccessException;
	
	
}
