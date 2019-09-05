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
 * 设备-商品表
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeviceGoods extends Model<DeviceGoods> {

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
     * 商品ID
     */
    private Long goodId;

    /**
     * 库存数量
     */
    private Integer quantity;

    /**
     * 所在通道
     */
    private Integer chan;

    /**
     * 通道是否锁定
     */
    private Integer disabled;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
