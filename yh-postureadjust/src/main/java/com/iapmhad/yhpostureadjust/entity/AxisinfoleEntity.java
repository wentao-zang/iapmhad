package com.iapmhad.yh_postureadjust.entity;

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
 * @date 2022-12-13 21:37:47
 */
@Data
@TableName("axisinfole")
public class AxisinfoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 位置信息
	 */
	@TableId
	private Integer id;
	/**
	 * x轴
	 */
	private Double xvel;
	/**
	 * y轴
	 */
	private Double yvel;
	/**
	 * z轴
	 */
	private Double zvel;
	/**
	 * A轴
	 */
	private Double avel;
	/**
	 * B轴
	 */
	private Double bvel;
	/**
	 * 工位切换轴
	 */
	private Double gvel;
	/**
	 * 
	 */
	private Double xdis;
	/**
	 * 
	 */
	private Double ydis;
	/**
	 * 
	 */
	private Double zdis;
	/**
	 * 
	 */
	private Double adis;
	/**
	 * 
	 */
	private Double bdis;
	/**
	 * 
	 */
	private Double gdis;
	/**
	 * 
	 */
	private Double xtemp;
	/**
	 * 
	 */
	private Double ytemp;
	/**
	 * 
	 */
	private Double ztemp;
	/**
	 * 
	 */
	private Double atemp;
	/**
	 * 
	 */
	private Double btemp;
	/**
	 * 
	 */
	private Double gtemp;
	/**
	 * 
	 */
	private Double xpower;
	/**
	 * 
	 */
	private Double ypower;
	/**
	 * 
	 */
	private Double zpower;
	/**
	 * 
	 */
	private Double apower;
	/**
	 * 
	 */
	private Double bpower;
	/**
	 * 
	 */
	private Double gpower;
	/**
	 * 
	 */
	private Double xcurrent;
	/**
	 * 
	 */
	private Double ycurrent;
	/**
	 * 
	 */
	private Double zcurrent;
	/**
	 * 
	 */
	private Double acurrent;
	/**
	 * 
	 */
	private Double bcurrent;
	/**
	 * 
	 */
	private Double gcurrent;
	/**
	 * 
	 */
	private Date time;

}
