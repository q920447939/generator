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
import com.baomidou.mybatisplus.generator.samples.constant.MainFanMegerTableConstant;
import com.baomidou.mybatisplus.generator.samples.constant.MainFanTableConstant;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: OfflinePacketReceiveTmpNameConvert
 * @Description: 离线温度趋势合并
 * @author leegoo
 * @date 2021年12月29日
 */
public class OfflineTemperatureMergeNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","cityCode");
        MAP.put("a3","lineCode");
        MAP.put("a4","stationCode");
        MAP.put("a5","fanCode");
        MAP.put("a6","fanType");
        MAP.put("a7","packetId");
        MAP.put("a8","packetDate");
        MAP.put("a9","mergeTime");
        MAP.put("a10","pointThreeATemperatureAvg");
        MAP.put("a11","pointThreeATemperatureMax");
        MAP.put("a12","pointThreeBTemperatureAvg");
        MAP.put("a13","pointThreeBTemperatureMax");
        MAP.put("a14","pointThreeCTemperatureAvg");
        MAP.put("a15","pointThreeCTemperatureMax");
        MAP.put("a16","pointFrontBearTemperatureAvg");
        MAP.put("a17","pointFrontBearTemperatureMax");
        MAP.put("a18","pointBackBearTemperatureAvg");
        MAP.put("a19","pointBackBearTemperatureMax");
        MAP.put("a20","createTime");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), DBConstant.DB_MERGE) && StrUtil.equals(input.getTableName(), MainFanMegerTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableSourceName());
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig,@NotNull TableInfo tableInfo) {
        return MainFanMegerTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableCode();
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
