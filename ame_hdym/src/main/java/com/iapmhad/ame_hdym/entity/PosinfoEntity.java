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
@TableName("posinfo")
public class PosinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * λփЅϢ
	 */
	@TableId
	private Integer id;
	/**
	 * WCS-X
	 */
	private Double x;
	/**
	 * WCS-Y
	 */
	private Double y;
	/**
	 * WCS-Z
	 */
	private Double z;
	/**
	 * 
	 */
	private Double x1;
	/**
	 * 
	 */
	private Double x11;
	/**
	 * 
	 */
	private Double z11;
	/**
	 * 
	 */
	private Double v2;
	/**
	 * 
	 */
	private Double v3;
	/**
	 * 
	 */
	private Double a1;
	/**
	 * 
	 */
	private Double a2;
	/**
	 * 
	 */
	private Double a3;
	/**
	 * 
	 */
	private Double a4;
	/**
	 * 
	 */
	private Double a5;
	/**
	 * 
	 */
	private Double a6;
	/**
	 * 
	 */
	private Date time;

}
