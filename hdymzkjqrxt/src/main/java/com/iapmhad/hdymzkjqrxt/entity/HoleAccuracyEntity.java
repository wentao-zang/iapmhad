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
@TableName("hole_accuracy")
public class HoleAccuracyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 孔号（孔在工艺加工中的编号）
	 */
	private String holeId;
	/**
	 * 孔名称
	 */
	private String holeName;
	/**
	 * 孔位边距误差上限（mm）
	 */
	private Float marginErrU;
	/**
	 * 孔位边距误差下限（mm）
	 */
	private Float marginErrL;
	/**
	 * 间距误差上限（mm）
	 */
	private Float spacingErrU;
	/**
	 * 间距误差下限（mm）
	 */
	private Float spacingErrL;
	/**
	 * 垂直度误差上限（°）
	 */
	private Float perpendErrU;
	/**
	 * 垂直度误差下限（°）
	 */
	private Float perpendErrL;
	/**
	 * 孔径误差上限（mm）
	 */
	private Float apertureErrU;
	/**
	 * 孔径误差下限（mm）
	 */
	private Float apertureErrL;
	/**
	 * 材料上孔及窝表面Ra粗糙度要求（um）
	 */
	private Float roughness;
	/**
	 * 锪窝深度偏差上限（mm）
	 */
	private Float depthErrU;
	/**
	 * 锪窝深度偏差下限（mm）
	 */
	private Float depthErrL;
	/**
	 * 锪窝角度偏差上限（°）
	 */
	private Float angleErrU;
	/**
	 * 锪窝角度偏差下限（°）
	 */
	private Float angleErrL;

}
