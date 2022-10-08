package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("cp_product")
public class CpProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 产品内部id（各活动翼面内部id）
	 */
	private String productId;
	/**
	 * 产品名
	 */
	private String productName;
	/**
	 * 产品X向尺寸（mm）
	 */
	private Float productSizeX;
	/**
	 * 产品Y向尺寸（mm）
	 */
	private Float productSizeY;
	/**
	 * 产品Z向尺寸（mm）
	 */
	private Float productSizeZ;
	/**
	 * 工装X向尺寸（mm）
	 */
	private Float fixtureSizeX;
	/**
	 * 工装Y向尺寸（mm）
	 */
	private Float fixtureSizeY;
	/**
	 * 工装Z向尺寸（mm）
	 */
	private Float fixtureSizeZ;
	/**
	 * 加工类型（制孔、铆接等）
	 */
	private Integer processType;
	/**
	 * 加工数量（产品上各孔径孔总个数）
	 */
	private Integer processNum;
	/**
	 * 加工孔径范围上限（mm）
	 */
	private Float processRangeU;
	/**
	 * 加工孔径范围下限（mm）
	 */
	private Float processRangeL;
	/**
	 * 定位精度要求上限（mm）
	 */
	private Float posErrU;
	/**
	 * 定位精度要求下限（mm）
	 */
	private Float posErrL;
	/**
	 * 材料型号（复材/铝合金型号）
	 */
	private String material;

}
