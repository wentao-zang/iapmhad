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
@TableName("productinfo")
public class ProductinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * ۺЍ
	 */
	private String aircraftId;
	/**
	 * ܜԎ
	 */
	private String flightId;
	/**
	 * ҺƷûӆ
	 */
	private String productName;
	/**
	 * ҺƷͼڅ
	 */
	private String productNum;
	/**
	 * ٤ҕҎʽ
	 */
	private String taskId;
	/**
	 * նޟѠڅ
	 */
	private String toolId;
	/**
	 * ߗڅ
	 */
	private String holeId;
	/**
	 * ܓ٤ʽ
	 */
	private Integer processNum;
	/**
	 * ܓ٤לʽ
	 */
	private Integer totalNum;
	/**
	 * 
	 */
	private Date time;

}
