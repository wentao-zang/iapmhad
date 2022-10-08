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
@TableName("jgzz_specification")
public class JgzzSpecificationEntity implements Serializable {
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
	 * 伺服电机型号
	 */
	private String moterCode;
	/**
	 * 伺服电机生产商
	 */
	private String moterManufacturer;
	/**
	 * 滚珠丝杆型号
	 */
	private String ballscrewCode;
	/**
	 * 滚珠丝杆生产商
	 */
	private String ballscrewManufacturer;
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

}
