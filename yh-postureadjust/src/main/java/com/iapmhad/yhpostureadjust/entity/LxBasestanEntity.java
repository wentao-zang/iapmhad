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
@TableName("lx_basestan")
public class LxBasestanEntity implements Serializable {
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
	private Double basesx1;
	/**
	 * 
	 */
	private Double basesz1;
	/**
	 * 
	 */
	private Double basesx2;
	/**
	 * 
	 */
	private Double basesz2;
	/**
	 * 
	 */
	private Double basesx3;
	/**
	 * 
	 */
	private Double basesz3;
	/**
	 * 
	 */
	private Double basesx4;
	/**
	 * 
	 */
	private Double basesz4;
	/**
	 * 
	 */
	private Double basesx5;
	/**
	 * 
	 */
	private Double basesz5;
	/**
	 * 
	 */
	private Double basesqusx;
	/**
	 * 
	 */
	private Double basesqusz;

}
