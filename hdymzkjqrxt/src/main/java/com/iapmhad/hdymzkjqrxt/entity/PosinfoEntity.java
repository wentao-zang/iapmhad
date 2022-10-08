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
@TableName("posinfo")
public class PosinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 位置信息
	 */
	@TableId
	private Integer id;
	/**
	 * WCS-X
	 */
	private Double x;
	/**
	 * WCS-Y
	 */
	private Double y;
	/**
	 * WCS-Z
	 */
	private Double z;
	/**
	 * 位姿
	 */
	private Double a;
	/**
	 * 位姿
	 */
	private Double b;
	/**
	 * 位姿
	 */
	private Double c;
	/**
	 * 刀具坐标、进给轴坐标
	 */
	private Double x1;
	/**
	 * 工位切换坐标
	 */
	private Double x11;
	/**
	 * 孔探
	 */
	private Double z11;
	/**
	 * 孔探长度计第二编码
	 */
	private Double v2;
	/**
	 * 对刀长度计
	 */
	private Double v3;
	/**
	 * 关节角度
	 */
	private Double a1;
	/**
	 * 
	 */
	private Double a2;
	/**
	 * 
	 */
	private Double a3;
	/**
	 * 
	 */
	private Double a4;
	/**
	 * 
	 */
	private Double a5;
	/**
	 * 
	 */
	private Double a6;
	/**
	 * 加速度
	 */
	private Double ac1;
	/**
	 * 
	 */
	private Double ac2;
	/**
	 * 
	 */
	private Double ac3;
	/**
	 * 
	 */
	private Double ac4;
	/**
	 * 
	 */
	private Double ac5;
	/**
	 * 
	 */
	private Double ac6;
	/**
	 * 电流
	 */
	private Double current1;
	/**
	 * 
	 */
	private Double current2;
	/**
	 * 
	 */
	private Double current3;
	/**
	 * 
	 */
	private Double current4;
	/**
	 * 
	 */
	private Double current5;
	/**
	 * 
	 */
	private Double current6;
	/**
	 * 转矩
	 */
	private Double torque1;
	/**
	 * 
	 */
	private Double torque2;
	/**
	 * 
	 */
	private Double torque3;
	/**
	 * 
	 */
	private Double torque4;
	/**
	 * 
	 */
	private Double torque5;
	/**
	 * 
	 */
	private Double torque6;
	/**
	 * 功率
	 */
	private Double power1;
	/**
	 * 
	 */
	private Double power2;
	/**
	 * 
	 */
	private Double power3;
	/**
	 * 
	 */
	private Double power4;
	/**
	 * 
	 */
	private Double power5;
	/**
	 * 
	 */
	private Double power6;
	/**
	 * 温度
	 */
	private Double temp1;
	/**
	 * 
	 */
	private Double temp2;
	/**
	 * 
	 */
	private Double temp3;
	/**
	 * 
	 */
	private Double temp4;
	/**
	 * 
	 */
	private Double temp5;
	/**
	 * 
	 */
	private Double temp6;
	/**
	 * 
	 */
	private Date time;

}
