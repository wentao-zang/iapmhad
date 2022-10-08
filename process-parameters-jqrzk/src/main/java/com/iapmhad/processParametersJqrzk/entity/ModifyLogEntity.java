package com.iapmhad.processParametersJqrzk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2022-05-27 13:13:31
 */
@Data
@TableName("modify_log")
public class ModifyLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 日志类型
	 */
	private String logType;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 操作类型
	 */
	private String opType;
	/**
	 * 操作内容
	 */
	private String opContent;
	/**
	 * 操作结果
	 */
	private String opResult;
	/**
	 * 操作时间
	 */
	private String logTime;

}
