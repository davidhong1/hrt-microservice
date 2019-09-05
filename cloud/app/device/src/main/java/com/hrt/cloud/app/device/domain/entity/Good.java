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
 * 商品表
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Good extends Model<Good> {

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
     * 商品编号
     */
    private String goodNo;

    /**
     * 商品名
     */
    private String goodName;

    /**
     * 商品价格
     */
    private Integer goodPrice;

    /**
     * 商品特征
     */
    private String feature;

    /**
     * 图片URL
     */
    private String imgUrl;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
