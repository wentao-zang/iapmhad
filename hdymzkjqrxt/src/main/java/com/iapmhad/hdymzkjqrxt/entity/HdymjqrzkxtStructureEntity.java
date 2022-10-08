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
@TableName("hdymjqrzkxt_structure")
public class HdymjqrzkxtStructureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 系统或设备ID主键
	 */
	private Integer deviceId;
	/**
	 * 父系统/设备ID -1代表无父系统/设备
	 */
	private Integer parentId;
	/**
	 * 设备编码 设备为内部设备编码 软件为版本号
	 */
	private String deviceCode;
	/**
	 * 系统或设备名
	 */
	private String deviceName;
	/**
	 * 安装/更新时间
	 */
	private Date updateTime;

}
