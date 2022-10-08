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
@TableName("hole_process")
public class HoleProcessEntity implements Serializable {
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
	 * 加工类型（数字代表钻孔、铰孔、铆接等）
	 */
	private Integer processType;
	/**
	 * 材料
	 */
	private Integer material;
	/**
	 * 孔径（mm）
	 */
	private Float aperture;
	/**
	 * 锪窝深度（mm）
	 */
	private Float dimpleDepth;
	/**
	 * 锪窝主轴转速（r/min）
	 */
	private Float dimpleRotation;
	/**
	 * 锪窝进给速度（mm/min）
	 */
	private Float dimpleFeedRate;
	/**
	 * 制孔深度（mm）
	 */
	private Float holeDepth;
	/**
	 * 制孔主轴转速（r/min）
	 */
	private Float holeRotation;
	/**
	 * 制孔进给速度（mm/min）
	 */
	private Float holeFeedRate;
	/**
	 * 快进速度（mm/min）
	 */
	private Float rapidFeedRate;
	/**
	 * 加工起始位置（mm）
	 */
	private Float startPos;
	/**
	 * 刀具编号
	 */
	private String toolId;
	/**
	 * 工艺NC代码
	 */
	private String ncCode;

}
