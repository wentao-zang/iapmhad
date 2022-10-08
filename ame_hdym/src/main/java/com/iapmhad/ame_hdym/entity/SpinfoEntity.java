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
@TableName("spinfo")
public class SpinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ַ֡ЅϢ
	 */
	@TableId
	private Integer id;
	/**
	 * ת˙èr/min)
	 */
	private Double rotvel;
	/**
	 * ˙ֈ(mm/min)
	 */
	private Double vel;
	/**
	 * λփ(mm)
	 */
	private Double pos;
	/**
	 * ΂ֈ
	 */
	private Double temp;
	/**
	 * غԘ(KN)
	 */
	private Double spload;
	/**
	 * էw(A)
	 */
	private Double current;
	/**
	 * Ťޘ(Nm)
	 */
	private Double torque;
	/**
	 * ٦(W)
	 */
	private Double power;
	/**
	 * 
	 */
	private Date time;

}
