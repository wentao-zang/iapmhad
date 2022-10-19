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
 * @date 2022-10-17 18:27:31
 */
@Data
@TableName("lhf_locadis")
public class LhfLocadisEntity implements Serializable {
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
	private Double locay6;
	/**
	 * 
	 */
	private Date time;

}
