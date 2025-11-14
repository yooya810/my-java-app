package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CopingStrategy;

public interface CopingService {

	/**ユーザーのコーピング一覧を取得*/
	List<CopingStrategy> findAllByUserId(Integer userId);

	/**コーピングidで指定したコーピング1件取得*/
	CopingStrategy findByCopingIdAndUserId(Integer copingId,Integer userId);

	/**コーピングを新規登録*/
	void insertCopingStrategy(CopingStrategy copingStrategy);

	/**コーピングを編集*/
	void updateCopingStrategy(CopingStrategy copingStrategy);

	/**コーピングを削除*/
	void deleteCopingStrategy(Integer copingId);
}
