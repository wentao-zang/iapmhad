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
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String pwd;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private Date time;
	/**
	 * 
	 */
	private Integer r1;
	/**
	 * 
	 */
	private Integer r2;
	/**
	 * 
	 */
	private Integer r3;
	/**
	 * 
	 */
	private Integer r4;
	/**
	 * 
	 */
	private Integer r5;
	/**
	 * 
	 */
	private Integer r6;
	/**
	 * 
	 */
	private Integer r7;
	/**
	 * 
	 */
	private Integer r8;
	/**
	 * 
	 */
	private Integer r9;
	/**
	 * 
	 */
	private Integer r10;
	/**
	 * 
	 */
	private Integer r11;
	/**
	 * 
	 */
	private Integer r12;
	/**
	 * 
	 */
	private Integer r13;
	/**
	 * 
	 */
	private Integer r14;
	/**
	 * 
	 */
	private Integer r15;
	/**
	 * 
	 */
	private Integer r16;
	/**
	 * 
	 */
	private Integer r17;
	/**
	 * 
	 */
	private Integer r18;
	/**
	 * 
	 */
	private Integer r19;
	/**
	 * 
	 */
	private Integer r20;

}
