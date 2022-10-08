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
@TableName("fxclzz_specification")
public class FxclzzSpecificationEntity implements Serializable {
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
	 * 激光位移传感器型号
	 */
	private String sensorCode;
	/**
	 * 激光位移传感器生产商
	 */
	private String sensorManufacturer;
	/**
	 * 激光位移传感器数量
	 */
	private Integer sensorNum;

}
