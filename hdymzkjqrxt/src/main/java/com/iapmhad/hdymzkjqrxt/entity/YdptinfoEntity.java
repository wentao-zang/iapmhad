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
@TableName("ydptinfo")
public class YdptinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Integer id;
	/**
	 * 位置
	 */
	private Float pos;
	/**
	 * 速度
	 */
	private Float vel;
	/**
	 * 加速度
	 */
	private Float ac;
	/**
	 * 电机转速
	 */
	private Float rotvel;
	/**
	 * 电流
	 */
	private Float current;
	/**
	 * 扭矩
	 */
	private Float torque;
	/**
	 * 温度
	 */
	private Float temp;
	/**
	 * 
	 */
	private Date time;

}
