package com.training.core.training.swim;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimMonatView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer year;
	
	private Integer month;
	
	private Float totalDistance;

	@Override
	public boolean equals(Object obj) {
		SwimMonatView smv = (SwimMonatView)obj;
		if( this.month.equals(smv.month) && this.year.equals(smv.year) ) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	
	

}
