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
 * @date 2022-10-19 22:02:25
 */
@Data
@TableName("lh_locaload3")
public class LhLocaload3Entity implements Serializable {
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
	private Double loadx9;
	/**
	 * 
	 */
	private Double loady9;
	/**
	 * 
	 */
	private Double loadz9;
	/**
	 * 
	 */
	private Double loadx10;
	/**
	 * 
	 */
	private Double loady10;
	/**
	 * 
	 */
	private Double loadz10;
	/**
	 * 
	 */
	private Double loadx11;
	/**
	 * 
	 */
	private Double loady11;
	/**
	 * 
	 */
	private Double loadz11;
	/**
	 * 
	 */
	private Double loadx12;
	/**
	 * 
	 */
	private Double loady12;
	/**
	 * 
	 */
	private Double loadz12;
	/**
	 * 
	 */
	private Date time;

}
