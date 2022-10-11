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
@TableName("rq_locadis")
public class RqLocadisEntity implements Serializable {
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
	private Double locax1;
	/**
	 * 
	 */
	private Double locay1;
	/**
	 * 
	 */
	private Double locax2;
	/**
	 * 
	 */
	private Double locay2;
	/**
	 * 
	 */
	private Double locax3;
	/**
	 * 
	 */
	private Double locay3;
	/**
	 * 
	 */
	private Double locax4;
	/**
	 * 
	 */
	private Double locay4;
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
	private Double locax6;
	/**
	 * 
	 */
	private Double locapz1;
	/**
	 * 
	 */
	private Double locapz2;
	/**
	 * 
	 */
	private Date time;

}
