/**
 * @Project:
 * @Author: leegoo
 * @Date: 2022年01月13日
 */
package com.baomidou.mybatisplus.generator.samples.table;

import com.baomidou.mybatisplus.generator.samples.constant.DBConstant;
import com.baomidou.mybatisplus.generator.samples.constant.MainFanMegerTableConstant;
import com.baomidou.mybatisplus.generator.samples.constant.MainFanTableConstant;
import com.baomidou.mybatisplus.generator.samples.constant.SystemTableConstant;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: TableInfo
 *
 * @author leegoo
 * @Description:
 * @date 2022年01月13日
 */
@Setter
@Getter
public class TableInfoHandle {
    public static final String MAN_FAN_DATA_BASE = "main_fan";
    public static final String TZ450_DATA1 = "tz450_data1";
    /*
    离线导入历史记录表
     */
    public static TableInfo offlineImportHistory = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName("tz_table31_2021").xmlName("OfflinePacketImportHistory").build();
    /*
    离线报警记录表
     */
    public static TableInfo offlineAlarmHistory = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName("tz_table30_2021").xmlName("OfflineAlarmHistory").build();
    /*
    离线温度记录表
     */
    public static TableInfo offlineTemperatureHistory = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName("tz_table32_2022").xmlName("OfflineAlarmHistory").build();
    /*
    离线联合趋势表
     */
    public static TableInfo offlineEntiretrendHistory = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName("tz_table33_2022").xmlName("OfflineEntiretrendHistory").build();
    /*
    离线导入历史扩展记录表
     */
    public static TableInfo offlineImportHistoryExt = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName("tz_table31_ext_2021").xmlName("OfflinePacketImportHistoryExt").build();
    /*
    数据包临时接收信息表
     */
    public static TableInfo offlinePacketReceiveTmp = TableInfo.builder().databaseName(MAN_FAN_DATA_BASE).tableName(MainFanTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableSourceName()).xmlName(MainFanTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableCode()).build();


    /*
 数据字段表
  */
    public static TableInfo sysDict = TableInfo.builder().databaseName(TZ450_DATA1).tableName("tz_table53").xmlName("SysDict").build();

    //站点信息表
    public static TableInfo sysStation = TableInfo.builder().databaseName(DBConstant.DB_SYS).tableName(SystemTableConstant.STATION_TABLE_NAME.getTableSourceName()).xmlName(SystemTableConstant.STATION_TABLE_NAME.getTableCode()).build();


    // 数据加工数据库设计
    /*
风机温度趋势30分钟合并记录表
 */
    public static TableInfo offlineTemperature30MinMergeMap = TableInfo.builder().databaseName(DBConstant.DB_MERGE).tableName(MainFanMegerTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableSourceName()).xmlName(MainFanMegerTableConstant.OFFLINE_PACKET_RECEIVE_TMP.getTableCode()).build();

    public static TableInfo getTableInfo() {
        return offlineTemperature30MinMergeMap;
    }
}
