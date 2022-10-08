package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 刀库规格信息表
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("dk_specification")
public class DkSpecificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 刀具编号
	 */
	private String toolId;
	/**
	 * 刀具牌号
	 */
	private String toolCode;
	/**
	 * 所在刀库位置
	 */
	private Integer storehosePos;
	/**
	 * 刀具直径(mm)
	 */
	private Float toolDiameter;
	/**
	 * 刀具长度(mm)
	 */
	private Float toolLength;
	/**
	 * 切削长度(mm)
	 */
	private Float cuttingLength;
	/**
	 * 刀尖距离(mm)
	 */
	private Float noseLength;
	/**
	 * 安装长度(mm)
	 */
	private Float installLength;
	/**
	 * 螺旋角度（°）
	 */
	private Float sprialAngel;
	/**
	 * 刀具齿数
	 */
	private Integer toolTeeth;
	/**
	 * 刀具类型
	 */
	private String toolType;
	/**
	 * 刀具材料
	 */
	private String toolMaterial;
	/**
	 * 生产商
	 */
	private String manufacturer;
	/**
	 * 刀具总寿命
	 */
	private Float toolLife;
	/**
	 * 刀具加工时间
	 */
	private Float toolWorktime;
	/**
	 * 加工次数（加工孔数）
	 */
	private Integer processNum;

}
