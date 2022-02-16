/**
 * @Project:
 * @Author: leegoo
 * @Date: 2021年12月29日
 */
package com.baomidou.mybatisplus.generator.samples.convert;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.samples.ConvertInput;
import com.baomidou.mybatisplus.generator.samples.NameConvert;
import com.baomidou.mybatisplus.generator.samples.constant.DBConstant;
import com.baomidou.mybatisplus.generator.samples.constant.MainFanTableConstant;
import com.baomidou.mybatisplus.generator.samples.constant.SystemTableConstant;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: OfflinePacketReceiveTmpNameConvert
 * @Description:
 * @author leegoo
 * @date 2021年12月29日
 */
public class OfflinePacketReceiveTmpNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","receiveTime");
        MAP.put("a3","packetName");
        MAP.put("a4","packetMd5");
        MAP.put("a5","packetPath");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), DBConstant.DB_MAIN) && StrUtil.equals(input.getTableName(), MainFanTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableSourceName());
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig,@NotNull TableInfo tableInfo) {
        return MainFanTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableCode();
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
