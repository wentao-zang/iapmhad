package com.iapmhad.ame_hdym.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("hole_measure")
public class HoleMeasureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
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
	private Double holeDia;
	/**
	 * 窝深
	 */
	private Double pitDepth;
	/**
	 * 时间戳
	 */
	private Date time;

}
