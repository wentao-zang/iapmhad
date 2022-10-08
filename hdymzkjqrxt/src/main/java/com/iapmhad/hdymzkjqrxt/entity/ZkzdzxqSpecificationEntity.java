package com.iapmhad.hdymzkjqrxt.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 制孔终端执行器规格信息表
 * 
 * @author ynd
 * @email 3361725156@qq.com
 * @date 2022-07-04 09:04:25
 */
@Data
@TableName("zkzdzxq_specification")
public class ZkzdzxqSpecificationEntity implements Serializable {
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
	 * 质量（kg）
	 */
	private Float mass;
	/**
	 * 加工孔径范围上限（mm）
	 */
	private Float apertureU;
	/**
	 * 加工孔径范围下限（mm）
	 */
	private Float apertureL;
	/**
	 * 加工进给行程（mm）
	 */
	private Float feedRange;
	/**
	 * 窝深偏差（mm）
	 */
	private Float pitDepthErr;
	/**
	 * 孔位测量精度（mm）
	 */
	private Float holePosErr;
	/**
	 * 法向测量精度（°）
	 */
	private Float nErr;
	/**
	 * 主轴转速（r/min）
	 */
	private Float shaftRotation;
	/**
	 * 主轴型号
	 */
	private String shaftCode;
	/**
	 * 机体直径（mm）
	 */
	private Float bodyDiameter;
	/**
	 * 机体长度（mm）
	 */
	private Float bodyLength;
	/**
	 * 主轴润滑方式
	 */
	private String lubricationType;
	/**
	 * 主轴冷却方式
	 */
	private String refrigerationType;
	/**
	 * 主轴最大功率（kW）
	 */
	private Float shaftPower;
	/**
	 * 主轴最大输出扭矩（NM）
	 */
	private Float shaftTorque;
	/**
	 * 主轴电压（V）
	 */
	private Float shaftVoltage;
	/**
	 * 主轴电流（A）
	 */
	private Float shaftElectricity;
	/**
	 * 刀柄型号
	 */
	private String handleCode;

}
