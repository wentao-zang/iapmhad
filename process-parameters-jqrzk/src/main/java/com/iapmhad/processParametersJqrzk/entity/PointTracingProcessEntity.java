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
@TableName("point_tracing_process")
public class PointTracingProcessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 工艺编号
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 描笔编号
	 */
	private String tracerPenId;
	/**
	 * 笔尖距离
	 */
	private Float penNoseDistance;
	/**
	 * 描点深度
	 */
	private Float pointDepth;
	/**
	 * 主轴转速
	 */
	private Float shaftRotaion;
	/**
	 * 进给速度
	 */
	private Float shaftFeedRate;
	/**
	 * 压脚压力
	 */
	private Float presserForce;
	/**
	 * 快进速度
	 */
	private Float rapidFeedRate;
	/**
	 * 描点起始位置
	 */
	private Float startPos;
	/**
	 * 刀库位置
	 */
	private Integer storehosePos;

}
