/**
 * 
 */
package com.youplus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manish
 *
 */
public class JSONResponse {

	private Boolean anyError;

	private String errorReason;

	private List<Object> dataList = new ArrayList<Object>();

	/**
	 * @return the anyError
	 */
	public Boolean getAnyError() {
		return anyError;
	}

	/**
	 * @param anyError
	 *            the anyError to set
	 */
	public void setAnyError(Boolean anyError) {
		this.anyError = anyError;
	}

	/**
	 * @return the errorReason
	 */
	public String getErrorReason() {
		return errorReason;
	}

	/**
	 * @param errorReason
	 *            the errorReason to set
	 */
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	/**
	 * @return the dataList
	 */
	public List<Object> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList
	 *            the dataList to set
	 */
	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
}
