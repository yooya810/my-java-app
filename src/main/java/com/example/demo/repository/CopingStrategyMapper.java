package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.CopingStrategy;

@Mapper
public interface CopingStrategyMapper {
	/**すべてのユーザーのコーピングを取得*/
	List<CopingStrategy> selectAll();
	
	/**指定されたユーザーのコーピングを取得*/
	List<CopingStrategy> selectByUserId(@Param("userId") Integer userId);
	
	/**指定されたユーザーの特定のカテゴリのコーピングを取得*/
	
	/**指定されたコーピングidのコーピングを取得*/
	CopingStrategy selectByCopingId(@Param("copingId") Integer copingId,@Param("userId") Integer userId);
	
	/**コーピングを作成*/
	void insertCoping(CopingStrategy copingStrategy);
	
	/**コーピングを更新*/
	void updateCoping(CopingStrategy copingStrategy);
	
	/**コーピングを削除*/
	void deleteCoping(Integer copingId);
	

}
