package com.hi031.shh.domain;

import java.util.List;

public class ResponseWrapper {
	private long total;
	private List<Object> results;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Object> getResults() {
		return results;
	}
	public void setResults(List<Object> results) {
		this.results = results;
	}
	
	public ResponseWrapper() {
		super();
	}
	public ResponseWrapper(long total, List<Object> results) {
		super();
		this.total = total;
		this.results = results;
	}
	
	
}
