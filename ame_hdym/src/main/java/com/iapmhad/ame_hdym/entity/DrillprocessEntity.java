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
@TableName("drillprocess")
public class DrillprocessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * ٫ӆߗ޶
	 */
	private String diameter;
	/**
	 * 鍒跺瓟涓昏酱杞₿
	 */
	private String rotvel1;
	/**
	 * 鍒跺瓟杩涚粰閫熷宿
	 */
	private String vel1;
	/**
	 * 
	 */
	private String rotvel2;
	/**
	 * 
	 */
	private String vel2;
	/**
	 * 
	 */
	private String rotvel3;
	/**
	 * 
	 */
	private String vel3;
	/**
	 * 
	 */
	private String socketrotvel;
	/**
	 * 
	 */
	private String socketvel;
	/**
	 * 快进速度
	 */
	private String fastvel;
	/**
	 * 制孔深度
	 */
	private String deep;
	/**
	 * ݴٌܾ Ѝ
	 */
	private String fastentype;
	/**
	 * 压脚压力
	 */
	private String press;
	/**
	 * ̡ǰ
	 */
	private String advance;
	/**
	 * 
	 */
	private String toolname;
	/**
	 * 
	 */
	private String remark0;
	/**
	 * 
	 */
	private Date time;

}
