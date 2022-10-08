package com.iapmhad.ame_hdym.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:31
 */
@Data
@TableName("axisinfo")
public class AxisinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 位置信息
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Double vel1;
	/**
	 * 
	 */
	private Double vel2;
	/**
	 * 
	 */
	private Double vel3;
	/**
	 * 
	 */
	private Double vel4;
	/**
	 * 
	 */
	private Double vel5;
	/**
	 * 
	 */
	private Double vel6;
	/**
	 * 
	 */
	private Double velx1;
	/**
	 * 
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
	 * 
	 */
	private Double currentx1;
	/**
	 * 
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
	 * 
	 */
	private Double torquex1;
	/**
	 * 
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
	 * 
	 */
	private Double powerx1;
	/**
	 * 
	 */
	private Date time;

}
