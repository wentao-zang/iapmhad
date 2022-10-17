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
 * @date 2022-10-17 18:27:31
 */
@Data
@TableName("lh_locadis3")
public class LhLocadis3Entity implements Serializable {
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
	private Double locax9;
	/**
	 * 
	 */
	private Double locay9;
	/**
	 * 
	 */
	private Double locaz9;
	/**
	 * 
	 */
	private Double locax10;
	/**
	 * 
	 */
	private Double locay10;
	/**
	 * 
	 */
	private Double locaz10;
	/**
	 * 
	 */
	private Double locax11;
	/**
	 * 
	 */
	private Double locay11;
	/**
	 * 
	 */
	private Double locaz11;
	/**
	 * 
	 */
	private Double locax12;
	/**
	 * 
	 */
	private Double locay12;
	/**
	 * 
	 */
	private Double locaz12;
	/**
	 * 
	 */
	private Date time;

}
