package com.iapmhad.processParametersJqrzk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2022-05-27 13:13:31
 */
@Data
@TableName("hole_measurement")
public class HoleMeasurementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 测量编号
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 标准直径
	 */
	private Float standardAperture;
	/**
	 * 初始电压值
	 */
	private Float startVoltage;
	/**
	 * 零点位置
	 */
	private Float zeroPos;
	/**
	 * 测量深度
	 */
	private Float measureDepth;
	/**
	 * 测量速度
	 */
	private Float measureSpeed;
	/**
	 * 测量提前量
	 */
	private Float measureLead;

}
