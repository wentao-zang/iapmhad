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
@TableName("cold_extrusion_hole_tool")
public class ColdExtrusionHoleToolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 刀具编号
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 刀具名称
	 */
	private String toolName;
	/**
	 * 刀具直径
	 */
	private Float toolAperture;
	/**
	 * 刀具刃长
	 */
	private Float edgeLength;
	/**
	 * 刀具寿命
	 */
	private Float toolLife;
	/**
	 * 刀尖距离
	 */
	private Float noseLength;
	/**
	 * 长度计初始读数
	 */
	private Float lengthmeter;
	/**
	 * 刀库位置
	 */
	private Integer storehosePos;

}
