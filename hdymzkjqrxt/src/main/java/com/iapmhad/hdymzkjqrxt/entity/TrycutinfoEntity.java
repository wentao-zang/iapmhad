package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
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
	 * 试切板编号，唯一
	 */
	private String code;
	/**
	 * 瀛旂洿寰?
	 */
	private Float dia;
	/**
	 * 
	 */
	private Float oriholedis;
	/**
	 * 
	 */
	private Float holegap;
	/**
	 * 鐎涙棁顢?
	 */
	private Integer holerow;
	/**
	 * 瀛斿垪
	 */
	private Integer holecol;
	/**
	 * 刀具编号
	 */
	private String toolcode;
	/**
	 * 
	 */
	private Date time;

}
