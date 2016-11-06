package com.ppp.grade.minortable.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MinortableService")
public class MinortableServiceImpl implements MinortableService{
	@Autowired
	private MinortableDAO minortableDAO;

	public MinortableVO getMinortableWithMinorNum(String MinorNum) {
		return minortableDAO.getMinortableWithMinorNum(MinorNum);
	}
}
