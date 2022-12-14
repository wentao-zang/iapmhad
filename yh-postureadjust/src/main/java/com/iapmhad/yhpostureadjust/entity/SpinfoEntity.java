package com.iapmhad.yh_postureadjust.entity;

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
 * @date 2022-12-13 21:37:47
 */
@Data
@TableName("spinfo")
public class SpinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 主轴转速
	 */
	private Double rotvel;
	/**
	 * 进给速度
	 */
	private Double vel;
	/**
	 * 主轴温度
	 */
	private Double temp;
	/**
	 * 主轴电流
	 */
	private Double current;
	/**
	 * 主轴转矩
	 */
	private Double torque;
	/**
	 * 主轴功率
	 */
	private Double power;
	/**
	 * 主轴位置x
	 */
	private Double posx;
	/**
	 * 主轴位置y
	 */
	private Double posy;
	/**
	 * 主轴位置z
	 */
	private Double posz;

}
