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
@TableName("drilltool")
public class DrilltoolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * նܢޠ+
	 */
	private String dis;
	/**
	 * Ӥֈ܆ӵʼցʽ
	 */
	private String oridata;
	/**
	 * 
	 */
	private String v3data;
	/**
	 * նޟֱ޶
	 */
	private String diameter;
	/**
	 * նޟȐӤ
	 */
	private String length;
	/**
	 * նߢλփ
	 */
	private String pos;
	/**
	 * նޟʙü
	 */
	private String live;
	/**
	 * 
	 */
	private Date time;

}
