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
@TableName("jqr_specification")
public class JqrSpecificationEntity implements Serializable {
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
	 * 工作负载（kg）
	 */
	private Float workLoad;
	/**
	 * 附加负载（kg）
	 */
	private Float addLoad;
	/**
	 * 重复精确度上限
	 */
	private Float reposErrU;
	/**
	 * 重复精确度下限
	 */
	private Float reposErrL;
	/**
	 * 安装形式
	 */
	private String installForm;
	/**
	 * 控制系统
	 */
	private String controlSys;
	/**
	 * A1轴运动范围上限（°）
	 */
	private Float a1RangeU;
	/**
	 * A1轴运动范围下限（°）
	 */
	private Float a1RangeL;
	/**
	 * A1轴速度(°/S)
	 */
	private Float a1Speed;
	/**
	 * A2轴运动范围上限（°）
	 */
	private Float a2RangeU;
	/**
	 * A2轴运动范围下限（°）
	 */
	private Float a2RangeL;
	/**
	 * A2轴速度(°/S)
	 */
	private Float a2Speed;
	/**
	 * A3轴运动范围上限（°）
	 */
	private Float a3RangeU;
	/**
	 * A3轴运动范围下限（°）
	 */
	private Float a3RangeL;
	/**
	 * A3轴速度(°/S)
	 */
	private Float a3Speed;
	/**
	 * A4轴运动范围上限（°）
	 */
	private Float a4RangeU;
	/**
	 * A4轴运动范围下限（°）
	 */
	private Float a4RangeL;
	/**
	 * A4轴速度(°/S)
	 */
	private Float a4Speed;
	/**
	 * A5轴运动范围上限（°）
	 */
	private Float a5RangeU;
	/**
	 * A5轴运动范围下限（°）
	 */
	private Float a5RangeL;
	/**
	 * A5轴速度(°/S)
	 */
	private Float a5Speed;
	/**
	 * A6轴运动范围上限（°）
	 */
	private Float a6RangeU;
	/**
	 * A6轴运动范围下限（°）
	 */
	private Float a6RangeL;
	/**
	 * A6轴速度(°/S)
	 */
	private Float a6Speed;

}
