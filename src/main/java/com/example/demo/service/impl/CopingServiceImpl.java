/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CopingStrategy;
import com.example.demo.repository.CopingStrategyMapper;
import com.example.demo.service.CopingService;

import lombok.RequiredArgsConstructor;

/**
 * CopingStrategy:サービス実行クラス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CopingServiceImpl implements CopingService {
	
	/** DI */
	private final CopingStrategyMapper mapper;

	@Override
	public List<CopingStrategy> findAllByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}

	@Override
	public CopingStrategy findByCopingIdAndUserId(Integer copingId,Integer userId) {	
		return mapper.selectByCopingId(copingId,userId);
	}

	@Override
	public void insertCopingStrategy(CopingStrategy copingStrategy) {
		mapper.insertCoping(copingStrategy);

	}

	@Override
	public void updateCopingStrategy(CopingStrategy copingStrategy) {
		mapper.updateCoping(copingStrategy);

	}

	@Override
	public void deleteCopingStrategy(Integer copingId) {
		mapper.deleteCoping(copingId);

	}

}
