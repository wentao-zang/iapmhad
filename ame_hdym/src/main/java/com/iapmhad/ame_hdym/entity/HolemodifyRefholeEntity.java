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
@TableName("holemodify_refhole")
public class HolemodifyRefholeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String sortiecode;
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
	private Double theorya;
	/**
	 * 
	 */
	private Double theoryb;
	/**
	 * 
	 */
	private Double theoryc;
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
	private Double actuala;
	/**
	 * 
	 */
	private Double actualb;
	/**
	 * 
	 */
	private Double actualc;
	/**
	 * 
	 */
	private Double errorx;
	/**
	 * 
	 */
	private Double errory;
	/**
	 * 
	 */
	private Double errorz;
	/**
	 * 
	 */
	private Double errora;
	/**
	 * 
	 */
	private Double errorb;
	/**
	 * 
	 */
	private Double errorc;
	/**
	 * 
	 */
	private Date time;

}
