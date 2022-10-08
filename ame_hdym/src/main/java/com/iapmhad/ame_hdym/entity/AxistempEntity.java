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
 * @date 2022-09-15 11:02:31
 */
@Data
@TableName("axistemp")
public class AxistempEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Double temp1;
	/**
	 * 
	 */
	private Double temp2;
	/**
	 * 
	 */
	private Double temp3;
	/**
	 * 
	 */
	private Double temp4;
	/**
	 * 
	 */
	private Double temp5;
	/**
	 * 
	 */
	private Double temp6;
	/**
	 * 
	 */
	private Double tempx1;
	/**
	 * 
	 */
	private Date time;

}
