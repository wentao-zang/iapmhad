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
@TableName("setstation")
public class SetstationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String fixtureid;
	/**
	 * 
	 */
	private Double pointname;
	/**
	 * 
	 */
	private Double theoryx;
	/**
	 * 
	 */
	private Double theoryy;
	/**
	 * 
	 */
	private Double theoryz;
	/**
	 * 
	 */
	private Double actualx;
	/**
	 * 
	 */
	private Double actualy;
	/**
	 * 
	 */
	private Double actualz;
	/**
	 * 
	 */
	private Date time;

}
