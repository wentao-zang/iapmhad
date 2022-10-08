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
@TableName("hole_normalmodify")
public class HoleNormalmodifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String fixtureid;
	/**
	 * 
	 */
	private Integer pointname;
	/**
	 * 
	 */
	private Double theoryX;
	/**
	 * 
	 */
	private Double theoryY;
	/**
	 * 
	 */
	private Double theoryZ;
	/**
	 * 
	 */
	private Double theoryA;
	/**
	 * 
	 */
	private Double theoryB;
	/**
	 * 
	 */
	private Double theoryC;
	/**
	 * 
	 */
	private Double actualX;
	/**
	 * 
	 */
	private Double actualY;
	/**
	 * 
	 */
	private Double actualZ;
	/**
	 * 
	 */
	private Double actualA;
	/**
	 * 
	 */
	private Double actualB;
	/**
	 * 
	 */
	private Double actualC;
	/**
	 * 
	 */
	private Date time;

}
