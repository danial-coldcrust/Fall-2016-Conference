package com.ppp.grade.history.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("historyService")
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryDAO historyDAO;
	
	public void deleteHistory(HistoryVO vo) {
		historyDAO.deleteHistory(vo);
		
	}
}
