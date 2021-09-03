package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	@JoinColumn(name="proposer_id")
	private BusinessAccount proposer;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private BusinessAccount receiver;
	
	private @NonNull String state;
	private @NonNull String management;

	@Column(name="proposal_date")
	private @NonNull String proposalDate;

}
