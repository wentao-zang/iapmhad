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
@TableName("ydptinfo")
public class YdptinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Ѡڅ
	 */
	@TableId
	private Integer id;
	/**
	 * λփ
	 */
	private Float pos;
	/**
	 * ˙ֈ
	 */
	private Float vel;
	/**
	 * ܓ˙ֈ
	 */
	private Float ac;
	/**
	 * էۺת˙
	 */
	private Float rotvel;
	/**
	 * էw
	 */
	private Float current;
	/**
	 * Ťޘ
	 */
	private Float torque;
	/**
	 * ΂ֈ
	 */
	private Float temp;
	/**
	 * 
	 */
	private Date time;

}
