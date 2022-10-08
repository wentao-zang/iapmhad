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
@TableName("holediameas")
public class HolediameasEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * Ѫ׼ֱ޶
	 */
	private String diameter;
	/**
	 * ӵʼէѹֵ
	 */
	private String orivol;
	/**
	 * cգλփ
	 */
	private String oripos;
	/**
	 * Ң̡ǰ
	 */
	private String advance;
	/**
	 * Ңɮֈ
	 */
	private String deep;
	/**
	 * Ң˙ֈ
	 */
	private String vel;

}
