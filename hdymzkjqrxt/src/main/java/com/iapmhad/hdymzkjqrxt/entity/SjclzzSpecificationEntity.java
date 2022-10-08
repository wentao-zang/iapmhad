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
@TableName("sjclzz_specification")
public class SjclzzSpecificationEntity implements Serializable {
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
	 * 工业摄像机型号
	 */
	private String cameraCode;
	/**
	 * 工业摄像机生产商
	 */
	private String cameraManufacturer;
	/**
	 * 测量精度上限（mm）
	 */
	private Float measureAccuracyU;
	/**
	 * 测量精度下限（mm）
	 */
	private Float measureAccuracyL;
	/**
	 * 重复定位精度（mm）
	 */
	private Float reposErr;
	/**
	 * 进给定位精度（mm）
	 */
	private Float feedPosErr;

}
