package com.iapmhad.ame_hdym.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author wtzang
 * @email w_t_zang1016@163.com
 * @date 2022-09-15 11:02:30
 */
@Data
@TableName("statusinfo")
public class StatusinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ״̬ЅϢ
	 */
	@TableId
	private Integer id;
	/**
	 * նޟ״̬
	 */
	private String toolstatus;
	/**
	 * ѹ݅ƸؗɬӶ
	 */
	private String footopenstatus;
	/**
	 * ѹ݅Ƹؗ˵ۘ
	 */
	private String footclosestatus;
	/**
	 * Ϡۺ؇Բߪ
	 */
	private String cameracoveropenstatus;
	/**
	 * Ϡۺ؇٘ѕ
	 */
	private String cameracoverclosestatus;
	/**
	 * նߢ؇Բߪ
	 */
	private String toolcoveropenstatus;
	/**
	 * նߢ؇٘ѕ
	 */
	private String toolcoverclosestatus;
	/**
	 * նߢ̧ɽ؋ɬӶ
	 */
	private String toolsopenstatus;
	/**
	 * նߢ̧ɽ؋˵ۘ
	 */
	private String toolsclosestatus;
	/**
	 * ߗ̽ƸؗɬӶ
	 */
	private String holemeaopenstatus;
	/**
	 * ߗ̽Ƹؗ˵ۘ
	 */
	private String holemeaclosestatus;
	/**
	 * 主轴开
	 */
	private String spopenstatus;
	/**
	 * 主轴兿
	 */
	private String spclosestatus;
	/**
	 * 油雾开关开吿
	 */
	private String oilopenstatus;
	/**
	 * 油雾开关关闿
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
	 * 快换法兰兿
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
