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
@TableName("robot_process")
public class RobotProcessEntity implements Serializable {
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
	 * 产品于装配坐标系位姿（mm）
	 */
	private Float productPosX;
	/**
	 * 产品于装配坐标系位姿（mm）
	 */
	private Float productPosY;
	/**
	 * 产品于装配坐标系位姿（mm）
	 */
	private Float productPosZ;
	/**
	 * 产品于装配坐标系位姿（°）
	 */
	private Float productYaw;
	/**
	 * 产品于装配坐标系位姿（°）
	 */
	private Float productPitch;
	/**
	 * 产品于装配坐标系位姿（°）
	 */
	private Float productRoll;
	/**
	 * 产品坐标系在基座中位姿（mm）
	 */
	private Float productBaseX;
	/**
	 * 产品坐标系在基座中位姿（mm）
	 */
	private Float productBaseY;
	/**
	 * 产品坐标系在基座中位姿（mm）
	 */
	private Float productBaseZ;
	/**
	 * 产品坐标系在基座中位姿（°）
	 */
	private Float productBaseYaw;
	/**
	 * 产品坐标系在基座中位姿（°）
	 */
	private Float productBasePitch;
	/**
	 * 产品坐标系在基座中位姿（°）
	 */
	private Float productBaseRoll;
	/**
	 * 工具坐标系（mm）
	 */
	private Float toolPosX;
	/**
	 * 工具坐标系（mm）
	 */
	private Float toolPosY;
	/**
	 * 工具坐标系（mm）
	 */
	private Float toolPosZ;
	/**
	 * 工具坐标系（°）
	 */
	private Float toolYaw;
	/**
	 * 工具坐标系（°）
	 */
	private Float toolPitch;
	/**
	 * 工具坐标系（°）
	 */
	private Float toolRoll;
	/**
	 * 点对点运动速度（%）
	 */
	private Float ptpSpeed;
	/**
	 * 点对点加速度（%）
	 */
	private Float ptpAcceleration;
	/**
	 * 直线运动速度（m/s）
	 */
	private Float speed;
	/**
	 * 直线加速度（%）
	 */
	private Float acceleration;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a1;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a2;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a3;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a4;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a5;
	/**
	 * 机器人旋转轴角度（°）
	 */
	private Float a6;
	/**
	 * 机器人运动代码
	 */
	private String motionCode;

}
