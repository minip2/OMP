package com.omp.store.dao;

import java.util.ArrayList;
import java.util.List;

import com.omp.store.domain.ShBoardDM;

public class test {
	public static void main(String[] args) {
		
		ShBoardDAO dao = new ShBoardDAO();
		List<ShBoardDM> list = dao.ShBoardList();
		
		for(ShBoardDM s : list) {
		int i = s.getNo();
		System.out.println(i);
		}
		
	}
}
