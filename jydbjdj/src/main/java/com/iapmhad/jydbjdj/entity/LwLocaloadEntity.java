package com.iapmhad.jydbjdj.entity;

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
 * @date 2022-10-20 15:50:00
 */
@Data
@TableName("lw_locaload")
public class LwLocaloadEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String aircraftId;
	/**
	 * 
	 */
	private String flightId;
	/**
	 * 
	 */
	private String fixtureId;
	/**
	 * 
	 */
	private Double loadx1;
	/**
	 * 
	 */
	private Double loady1;
	/**
	 * 
	 */
	private Double loadz1;
	/**
	 * 
	 */
	private Double loadx2;
	/**
	 * 
	 */
	private Double loady2;
	/**
	 * 
	 */
	private Double loadz2;
	/**
	 * 
	 */
	private Double loadx3;
	/**
	 * 
	 */
	private Double loady3;
	/**
	 * 
	 */
	private Double loadz3;
	/**
	 * 
	 */
	private Double loadx4;
	/**
	 * 
	 */
	private Double loady4;
	/**
	 * 
	 */
	private Double loadz4;
	/**
	 * 
	 */
	private Date time;

}
