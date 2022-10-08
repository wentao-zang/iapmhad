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
@TableName("baseframe")
public class BaseframeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String stationcode;
	/**
	 * 
	 */
	private Double x;
	/**
	 * 
	 */
	private Double y;
	/**
	 * 
	 */
	private Double z;
	/**
	 * 
	 */
	private Double a;
	/**
	 * 
	 */
	private Double b;
	/**
	 * 
	 */
	private Double c;
	/**
	 * 
	 */
	private Date time;

}
