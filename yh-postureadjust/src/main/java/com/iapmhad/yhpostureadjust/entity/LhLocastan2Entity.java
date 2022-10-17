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
@TableName("lh_locastan2")
public class LhLocastan2Entity implements Serializable {
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
	private Double locasx5;
	/**
	 * 
	 */
	private Double locasy5;
	/**
	 * 
	 */
	private Double locasz5;
	/**
	 * 
	 */
	private Double locasx6;
	/**
	 * 
	 */
	private Double locasy6;
	/**
	 * 
	 */
	private Double locasz6;
	/**
	 * 
	 */
	private Double locasx7;
	/**
	 * 
	 */
	private Double locasy7;
	/**
	 * 
	 */
	private Double locasz7;
	/**
	 * 
	 */
	private Double locasx8;
	/**
	 * 
	 */
	private Double locasy8;
	/**
	 * 
	 */
	private Double locasz8;
	/**
	 * 
	 */
	private Date time;

}
