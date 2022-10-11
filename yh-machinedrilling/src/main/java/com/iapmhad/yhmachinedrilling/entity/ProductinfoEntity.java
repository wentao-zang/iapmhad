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
@TableName("productinfo")
public class ProductinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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
	 * 任务代号
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
	 * 已加工孔数
	 */
	private Integer processNum;
	/**
	 * 总孔数
	 */
	private Integer totalNum;
	/**
	 * 公称孔径
	 */
	private Double holedia;
	/**
	 * 
	 */
	private Date time;

}
