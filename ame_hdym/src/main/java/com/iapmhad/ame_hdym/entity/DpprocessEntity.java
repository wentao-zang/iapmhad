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
@TableName("dpprocess")
public class DpprocessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * èъѠڅ
	 */
	private String code;
	/**
	 * ݸظ˙ֈ
	 */
	private String vel;
	/**
	 * ַ֡ת˙
	 */
	private String rotvel;
	/**
	 * ߬ݸ˙ֈ
	 */
	private String fastvel;
	/**
	 * èգɮֈ
	 */
	private String deep;
	/**
	 * èգưʼλփ
	 */
	private String oripos;
	/**
	 * ѹ݅ѹf
	 */
	private String press;
	/**
	 * ъܢޠ+
	 */
	private String dis;
	/**
	 * նߢλփ
	 */
	private String pos;
	/**
	 * 
	 */
	private Date time;

}
