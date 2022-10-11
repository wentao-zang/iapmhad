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
@TableName("rs_basedis")
public class RsBasedisEntity implements Serializable {
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
	private Double basex1;
	/**
	 * 
	 */
	private Double basez1;
	/**
	 * 
	 */
	private Double basex2;
	/**
	 * 
	 */
	private Double basez2;
	/**
	 * 
	 */
	private Double basex3;
	/**
	 * 
	 */
	private Double basez3;
	/**
	 * 
	 */
	private Double basex4;
	/**
	 * 
	 */
	private Double basez4;
	/**
	 * 
	 */
	private Double basex5;
	/**
	 * 
	 */
	private Double basez5;
	/**
	 * 
	 */
	private Double basesqux;
	/**
	 * 
	 */
	private Double basesquz;

}
