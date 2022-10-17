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
 * @date 2022-10-17 18:27:30
 */
@Data
@TableName("lh_locastan1")
public class LhLocastan1Entity implements Serializable {
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
	private Double locasx1;
	/**
	 * 
	 */
	private Double locasy1;
	/**
	 * 
	 */
	private Double locasz1;
	/**
	 * 
	 */
	private Double locasx2;
	/**
	 * 
	 */
	private Double locasy2;
	/**
	 * 
	 */
	private Double locasz2;
	/**
	 * 
	 */
	private Double locasx3;
	/**
	 * 
	 */
	private Double locasy3;
	/**
	 * 
	 */
	private Double locasz3;
	/**
	 * 
	 */
	private Double locasx4;
	/**
	 * 
	 */
	private Double locasy4;
	/**
	 * 
	 */
	private Double locasz4;
	/**
	 * 
	 */
	private Date time;

}
