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
@TableName("trycutholes")
public class TrycutholesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer holeid;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private Integer holerow;
	/**
	 * 
	 */
	private Integer holecol;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private Double holex;
	/**
	 * 
	 */
	private Double holey;
	/**
	 * 
	 */
	private Double holez;
	/**
	 * 
	 */
	private Double holea;
	/**
	 * 
	 */
	private Double holeb;
	/**
	 * 
	 */
	private Double holec;
	/**
	 * 
	 */
	private Double pholex;
	/**
	 * 
	 */
	private Double pholey;
	/**
	 * 
	 */
	private Date time;

}
