package com.hrt.cloud.app.device.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Device extends Model<Device> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer deleted;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 设备名字
     */
    private String devName;

    /**
     * 通道货品最大个数
     */
    private Integer chanMax;

    /**
     * 通道个数
     */
    private Integer chanNum;

    /**
     * 设备状态 online outline unknown
     */
    private String devStatus;

    /**
     * 0 设备不锁 1 设备锁定
     */
    private Integer lockDev;

    /**
     * 描述
     */
    private String descriptions;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
