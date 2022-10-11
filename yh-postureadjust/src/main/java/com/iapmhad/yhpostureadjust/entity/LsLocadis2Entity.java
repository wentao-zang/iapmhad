package com.iapmhad.yhpostureadjust.entity;

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
 * @date 2022-10-11 15:11:17
 */
@Data
@TableName("ls_locadis2")
public class LsLocadis2Entity implements Serializable {
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
	private Double locax5;
	/**
	 * 
	 */
	private Double locay5;
	/**
	 * 
	 */
	private Double locaz5;
	/**
	 * 
	 */
	private Double locax6;
	/**
	 * 
	 */
	private Double locay6;
	/**
	 * 
	 */
	private Double locaz6;
	/**
	 * 
	 */
	private Double locax7;
	/**
	 * 
	 */
	private Double locay7;
	/**
	 * 
	 */
	private Double locaz7;
	/**
	 * 
	 */
	private Double locax8;
	/**
	 * 
	 */
	private Double locay8;
	/**
	 * 
	 */
	private Double locaz8;
	/**
	 * 
	 */
	private Date time;

}
