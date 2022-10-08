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
@TableName("gy_process")
public class GyProcessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 数据条编号 自增
	 */
	@TableId
	private Integer id;
	/**
	 * 工艺编号
	 */
	private String taskId;
	/**
	 * 工艺流程名称
	 */
	private String taskName;
	/**
	 * 工艺规定耗时(min)
	 */
	private Integer time;

}
