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
@TableName("rx_locaload2")
public class RxLocaload2Entity implements Serializable {
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
	private Double loadx5;
	/**
	 * 
	 */
	private Double loady5;
	/**
	 * 
	 */
	private Double loadz5;
	/**
	 * 
	 */
	private Double loadx6;
	/**
	 * 
	 */
	private Double loady6;
	/**
	 * 
	 */
	private Double loadz6;
	/**
	 * 
	 */
	private Double loadx7;
	/**
	 * 
	 */
	private Double loady7;
	/**
	 * 
	 */
	private Double loadz7;
	/**
	 * 
	 */
	private Double loadx8;
	/**
	 * 
	 */
	private Double loady8;
	/**
	 * 
	 */
	private Double loadz8;
	/**
	 * 
	 */
	private Date time;

}
