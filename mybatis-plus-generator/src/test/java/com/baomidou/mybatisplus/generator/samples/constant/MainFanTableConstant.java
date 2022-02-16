/**
 * @Project:
 * @Author: leegoo
 * @Date: 2022年02月07日
 */
package com.baomidou.mybatisplus.generator.samples.constant;

import lombok.Getter;

/**
 * ClassName: SystemTableConstant
 * @Description:
 * @author leegoo
 * @date 2022年02月07日
 */
@Getter
public enum MainFanTableConstant {
    OFFLINE_PACKET_RECEIVE_TMP("tz_table29","OfflinePacketReceiveTmp");

    private final String tableSourceName;
    private final String tableCode;

    MainFanTableConstant(String tableSourceName, String tableCode) {
        this.tableSourceName = tableSourceName;
        this.tableCode = tableCode;
    }
}
