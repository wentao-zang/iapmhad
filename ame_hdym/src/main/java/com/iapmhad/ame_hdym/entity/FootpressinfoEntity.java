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
@TableName("footpressinfo")
public class FootpressinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ѹ݅ЅϢ
	 */
	@TableId
	private Integer id;
	/**
	 * ѹfèkg)
	 */
	private Double footpress;
	/**
	 * λփèmm)
	 */
	private Double footout;
	/**
	 * Ӥֈ܆èmm)
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
	 * λ҆ԫؐƷ1èmm)
	 */
	private Double normal1;
	/**
	 * λ҆ԫؐƷ2(mm)
	 */
	private Double normal2;
	/**
	 * λ҆ԫؐƷ3(mm)
	 */
	private Double normal3;
	/**
	 * λ҆ԫؐƷ4(mm)
	 */
	private Double normal4;
	/**
	 * 
	 */
	private Date time;

}
