package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 移动平台规格信息表
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("ydpt_specification")
public class YdptSpecificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号
	 */
	@TableId
	private Integer id;
	/**
	 * 系统或设备ID
	 */
	private Integer deviceId;
	/**
	 * 设备编码
	 */
	private String deviceCode;
	/**
	 * 系统或设备名
	 */
	private String deviceName;
	/**
	 * 质量（Kg）
	 */
	private Float mass;
	/**
	 * 平台X向尺寸（mm）
	 */
	private Float platformSizeX;
	/**
	 * 平台Y向尺寸
	 */
	private Float platformSizeY;
	/**
	 * 平台Z向尺寸
	 */
	private Float platformSizeZ;
	/**
	 * 导轨型号
	 */
	private String railCode;
	/**
	 * 导轨向行程
	 */
	private Float railRange;
	/**
	 * 导轨向移动速度
	 */
	private Float railSpeed;
	/**
	 * 全行程定位精度
	 */
	private Float posErr;
	/**
	 * 重复定位精度（每3m）
	 */
	private Float reposErr;
	/**
	 * 电机型号
	 */
	private String moterCode;
	/**
	 * 减速机型号
	 */
	private String reductorCode;
	/**
	 * 齿条型号
	 */
	private String rackCode;

}
