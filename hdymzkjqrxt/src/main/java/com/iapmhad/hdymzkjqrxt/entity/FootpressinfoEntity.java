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
@TableName("footpressinfo")
public class FootpressinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 压脚信息
	 */
	@TableId
	private Integer id;
	/**
	 * 压力（kg)
	 */
	private Double footpress;
	/**
	 * 位置（mm)
	 */
	private Double footout;
	/**
	 * 长度计（mm)
	 */
	private Double footlength;
	/**
	 * Beta
	 */
	private Double normalbeta;
	/**
	 * Theata
	 */
	private Double normaltheata;
	/**
	 * Gamma
	 */
	private Double normalgamma;
	/**
	 * 位移传感器1（mm)
	 */
	private Double normal1;
	/**
	 * 位移传感器2(mm)
	 */
	private Double normal2;
	/**
	 * 位移传感器3(mm)
	 */
	private Double normal3;
	/**
	 * 位移传感器4(mm)
	 */
	private Double normal4;
	/**
	 * 
	 */
	private Date time;

}
