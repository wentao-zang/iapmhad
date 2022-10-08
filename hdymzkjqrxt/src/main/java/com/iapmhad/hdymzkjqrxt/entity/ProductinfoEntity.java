package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("productinfo")
public class ProductinfoEntity implements Serializable {
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
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品图号
	 */
	private String productNum;
	/**
	 * 工艺参数
	 */
	private String taskId;
	/**
	 * 刀具编号
	 */
	private String toolId;
	/**
	 * 孔号
	 */
	private String holeId;
	/**
	 * 加工数量
	 */
	private Integer processNum;
	/**
	 * 加工总数
	 */
	private Integer totalNum;
	/**
	 * 数据采集时刻（YYYY-MM-DDHH:MM:SS）
	 */
	private Date time;

}
