package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.StateDTO;

public interface StateService {
	/**
	 * 
	 * @return
	 */
	List<StateDTO> getState();
	
	/**
	 * 
	 * @param stateId
	 * @return
	 */
	StateDTO getStateById(Long StateId);
	
	/**
	 * 
	 * @param state
	 * @return
	 */
	boolean createState(StateDTO satate);
	
	/**
	 * 
	 * @param state
	 * @return
	 */
	StateDTO updateState(StateDTO state);
	
	/**
	 * 
	 * @param state
	 * @return
	 */
	boolean deleteState(StateDTO state);
	
}
