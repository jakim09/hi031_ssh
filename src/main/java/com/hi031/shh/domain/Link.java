package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@ToString
@Builder
public class Link implements Serializable{
	@Id
	@Column(name="link_id")
	private @NonNull String linkId;

	@Column(name="proposer_id", table="businessaccount") 
	private @NonNull String proposerId;
	
	@Column(name="receiver_id", table="businessaccount") 
	private @NonNull String receiverId;
	
	private @NonNull String state;
	private @NonNull String management;

	@Column(name="proposal_date")
	private @NonNull String proposalDate;

}
