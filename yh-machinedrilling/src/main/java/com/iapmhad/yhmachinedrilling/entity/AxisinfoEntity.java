package com.iapmhad.yhmachinedrilling.entity;

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
 * @date 2022-10-11 15:15:34
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
	 * x轴
	 */
	private Double vel1;
	/**
	 * y轴
	 */
	private Double vel2;
	/**
	 * 工位切换轴
	 */
	private Double vel3;
	/**
	 * 孔探轴
	 */
	private Double vel4;
	/**
	 * 
	 */
	private Double x1;
	/**
	 * 
	 */
	private Double x2;
	/**
	 * 
	 */
	private Double x3;
	/**
	 * 
	 */
	private Double x4;
	/**
	 * 
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
	private Date time;

}
