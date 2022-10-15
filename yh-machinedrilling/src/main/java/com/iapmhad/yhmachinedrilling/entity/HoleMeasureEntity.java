package com.iapmhad.yhmachinedrilling.entity;

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
 * @date 2022-10-11 15:15:34
 */
@Data
@TableName("holemeasure")
public class HoleMeasureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId
	private Integer id;
	/**
	 * 机型
	 */
	private String aircraftId;
	/**
	 * 架次
	 */
	private String flightId;
	/**
	 * 产品图号
	 */
	private String productNum;
	/**
	 * 孔号
	 */
	private String holeId;
	/**
	 * 孔径
	 */
	private Double holediaMea;
	/**
	 * 窝径
	 */
	private Double pitdiaMea;
	/**
	 * 齐平度
	 */
	private Double eevenness;
	/**
	 * 公称孔径
	 */
	private Double holeDia;
	/**
	 * 
	 */
	private Date time;

}
