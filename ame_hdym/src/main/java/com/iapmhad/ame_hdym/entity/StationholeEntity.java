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
@TableName("stationhole")
public class StationholeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * ٤װ۹׼ߗ-X׸Ѫ
	 */
	private String theoryx;
	/**
	 * 
	 */
	private String theoryy;
	/**
	 * 
	 */
	private String theoryz;
	/**
	 * 
	 */
	private String theorya;
	/**
	 * 
	 */
	private String theoryb;
	/**
	 * 
	 */
	private String theoryc;
	/**
	 * ٤װ۹׼ߗʵ܊X׸Ѫ
	 */
	private String actualx;
	/**
	 * 
	 */
	private String actualy;
	/**
	 * 
	 */
	private String actualz;
	/**
	 * 
	 */
	private String actuala;
	/**
	 * 
	 */
	private String actualb;
	/**
	 * 
	 */
	private String actualc;
	/**
	 * 
	 */
	private Date time;

}
