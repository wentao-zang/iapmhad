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
@TableName("yjzz_specification")
public class YjzzSpecificationEntity implements Serializable {
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
	 * 驱动气缸型号
	 */
	private String cylinderCode;
	/**
	 * 驱动气缸生产商
	 */
	private String cylinderManufacturer;
	/**
	 * 光栅尺型号
	 */
	private String rasterCode;
	/**
	 * 光栅尺生产商
	 */
	private String rasterManufacturer;
	/**
	 * 光栅尺测量长度（mm）
	 */
	private Float rasterRange;
	/**
	 * 导轨型号
	 */
	private String railCode;
	/**
	 * 导轨向行程（mm）
	 */
	private Float railRange;
	/**
	 * 导轨向移动速度（m/s）
	 */
	private Float railSpeed;
	/**
	 * 压脚行程（mm）
	 */
	private Float presserTravel;
	/**
	 * 压紧力上限（kg）
	 */
	private Float presserForceU;
	/**
	 * 压紧力下限（kg）
	 */
	private Float presserForceL;
	/**
	 * 载荷精度上限（%）
	 */
	private Float loadErrU;
	/**
	 * 载荷精度下限（%）
	 */
	private Float loadErrL;

}
