package com.bridgeit.dto;

public class UserCount {

	private long active;
	
	private long inactive;

	public long getActive() {
		return active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public long getInactive() {
		return inactive;
	}

	public void setInactive(long inactive) {
		this.inactive = inactive;
	}

	@Override
	public String toString() {
		return "UserCount [active=" + active + ", inactive=" + inactive + "]";
	}
	
	
	
}
