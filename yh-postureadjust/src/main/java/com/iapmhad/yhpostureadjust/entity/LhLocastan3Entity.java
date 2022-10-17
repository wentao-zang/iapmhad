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
@TableName("lh_locastan3")
public class LhLocastan3Entity implements Serializable {
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
	private Double locasx9;
	/**
	 * 
	 */
	private Double locasy9;
	/**
	 * 
	 */
	private Double locasz9;
	/**
	 * 
	 */
	private Double locasx10;
	/**
	 * 
	 */
	private Double locasy10;
	/**
	 * 
	 */
	private Double locasz10;
	/**
	 * 
	 */
	private Double locasx11;
	/**
	 * 
	 */
	private Double locasy11;
	/**
	 * 
	 */
	private Double locasz11;
	/**
	 * 
	 */
	private Double locasx12;
	/**
	 * 
	 */
	private Double locasy12;
	/**
	 * 
	 */
	private Double locasz12;
	/**
	 * 
	 */
	private Date time;

}
