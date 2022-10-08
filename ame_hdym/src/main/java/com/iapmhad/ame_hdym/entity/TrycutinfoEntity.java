package com.iapmhad.ame_hdym.entity;

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
 * @date 2022-09-15 11:02:30
 */
@Data
@TableName("trycutinfo")
public class TrycutinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * ʔǐХѠڅìΨһ
	 */
	private String code;
	/**
	 * 瀛旂洿寰?
	 */
	private Double width;
	/**
	 * 
	 */
	private Double height;
	/**
	 * 
	 */
	private Double thick;
	/**
	 * 鐎涙棁顢?
	 */
	private Double gap;
	/**
	 * 
	 */
	private Double diamter;
	/**
	 * 
	 */
	private Double point1x;
	/**
	 * 
	 */
	private Double point2x;
	/**
	 * 
	 */
	private Double point3x;
	/**
	 * 
	 */
	private Double point1y;
	/**
	 * 
	 */
	private Double point2y;
	/**
	 * 
	 */
	private Double point3y;
	/**
	 * 
	 */
	private Double point1z;
	/**
	 * 
	 */
	private Double point2z;
	/**
	 * 
	 */
	private Double point3z;
	/**
	 * 
	 */
	private Double point1a;
	/**
	 * 
	 */
	private Double point2a;
	/**
	 * 
	 */
	private Double point3a;
	/**
	 * 
	 */
	private Double point1b;
	/**
	 * 
	 */
	private Double point2b;
	/**
	 * 
	 */
	private Double point3b;
	/**
	 * 
	 */
	private Double point1c;
	/**
	 * 
	 */
	private Double point2c;
	/**
	 * 
	 */
	private Double point3c;
	/**
	 * 
	 */
	private Date time;

}
