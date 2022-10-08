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
@TableName("statusinfo")
public class StatusinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 状态信息
	 */
	@TableId
	private Integer id;
	/**
	 * 刀具状态
	 */
	private String toolstatus;
	/**
	 * 压脚气缸伸出
	 */
	private String footopenstatus;
	/**
	 * 压脚气缸缩回
	 */
	private String footclosestatus;
	/**
	 * 相机盖打开
	 */
	private String cameracoveropenstatus;
	/**
	 * 相机盖关闭
	 */
	private String cameracoverclosestatus;
	/**
	 * 刀库盖打开
	 */
	private String toolcoveropenstatus;
	/**
	 * 刀库盖关闭
	 */
	private String toolcoverclosestatus;
	/**
	 * 刀库抬升杆伸出
	 */
	private String toolsopenstatus;
	/**
	 * 刀库抬升杆缩回
	 */
	private String toolsclosestatus;
	/**
	 * 孔探气缸伸出
	 */
	private String holemeaopenstatus;
	/**
	 * 孔探气缸缩回
	 */
	private String holemeaclosestatus;
	/**
	 * 主轴开
	 */
	private String spopenstatus;
	/**
	 * 主轴关
	 */
	private String spclosestatus;
	/**
	 * 油雾开关开启
	 */
	private String oilopenstatus;
	/**
	 * 油雾开关关闭
	 */
	private String oilclosestatus;
	/**
	 * 回刀阀门开
	 */
	private String recuropenstatus;
	/**
	 * 回刀阀门关
	 */
	private String recurclosestatus;
	/**
	 * 快换法兰开
	 */
	private String flangeopenstatus;
	/**
	 * 快换法兰关
	 */
	private String flangeclosestatus;
	/**
	 * 换刀阀门开
	 */
	private String toolchangeropenstatus;
	/**
	 * 换刀阀门关
	 */
	private String toolchangerclosestatus;
	/**
	 * 
	 */
	private Date time;

}
