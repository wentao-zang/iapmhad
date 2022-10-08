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
@TableName("fasten_hole_process")
public class FastenHoleProcessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 工艺编号
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 公称孔径
	 */
	private Float aperture;
	/**
	 * 紧固件类型
	 */
	private String fastenType;
	/**
	 * 预紧固件编号
	 */
	private String prefastenDode;
	/**
	 * 刀具编号
	 */
	private String toolId;
	/**
	 * 制孔深度
	 */
	private Float holeDepth;
	/**
	 * 锪窝深度
	 */
	private Float dimpleDepth;
	/**
	 * 最大孔深
	 */
	private Float holeDepthMax;
	/**
	 * 最小孔深
	 */
	private Float holeDepthMin;
	/**
	 * 制孔主轴转速
	 */
	private Float shaftRotaion;
	/**
	 * 制孔进给速度
	 */
	private Float shaftFeedRate;
	/**
	 * 锪窝主轴转速
	 */
	private Float dimpleRotation;
	/**
	 * 锪窝进给速度
	 */
	private Float dimpleFeedRate;
	/**
	 * 压脚压力
	 */
	private Double presserForce;
	/**
	 * 快进速度
	 */
	private Float rapidFeedRate;
	/**
	 * 加工起始位置
	 */
	private Float startPos;
	/**
	 * 插钉速度
	 */
	private Double insertSpeed;
	/**
	 * 拧紧扭矩
	 */
	private Float torque;

}
