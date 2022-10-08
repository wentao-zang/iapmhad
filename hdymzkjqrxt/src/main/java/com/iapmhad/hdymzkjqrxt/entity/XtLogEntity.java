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
@TableName("xt_log")
public class XtLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 系统/设备ID
	 */
	private Integer deviceId;
	/**
	 * 更新时间(YYYY-MM-DDHH:MM:SS)
	 */
	private Date logTime;
	/**
	 * 操作人员(登录在系统中的用户名)
	 */
	private String operator;
	/**
	 * 飞机编号(跟踪加工的飞机型号及架次)
	 */
	private String aircraftId;
	/**
	 * 工艺流程(日志产生所在工艺流程步骤)
	 */
	private String task;
	/**
	 * 日志类型 0-操作日志 1-警告信息 2-报错信息
	 */
	private Integer logType;
	/**
	 * 日志内容（操作、警告、报错）
	 */
	private String logContent;

}
