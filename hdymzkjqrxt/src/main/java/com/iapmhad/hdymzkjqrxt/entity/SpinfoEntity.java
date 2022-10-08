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
@TableName("spinfo")
public class SpinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主轴信息
	 */
	@TableId
	private Integer id;
	/**
	 * 转速（r/min)
	 */
	private Double rotvel;
	/**
	 * 速度(mm/min)
	 */
	private Double vel;
	/**
	 * 位置(mm)
	 */
	private Double pos;
	/**
	 * 温度
	 */
	private Double temp;
	/**
	 * 负载(KN)
	 */
	private Double spload;
	/**
	 * 电流(A)
	 */
	private Double current;
	/**
	 * 扭矩(Nm)
	 */
	private Double torque;
	/**
	 * 功率(W)
	 */
	private Double power;
	/**
	 * 
	 */
	private Date time;

}
