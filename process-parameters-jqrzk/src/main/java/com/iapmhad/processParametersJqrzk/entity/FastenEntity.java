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
@TableName("fasten")
public class FastenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预紧固件编号
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 预紧固件牌号
	 */
	private String prefastenBrand;
	/**
	 * 预紧固件直径
	 */
	private Float prefastenAperture;
	/**
	 * 预紧固件长度
	 */
	private Float prefastenLength;
	/**
	 * 钉库位置
	 */
	private Integer storehosePos;

}
