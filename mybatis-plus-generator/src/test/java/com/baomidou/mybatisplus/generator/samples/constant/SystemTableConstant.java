/**
 * @Project:
 * @Author: leegoo
 * @Date: 2022年02月07日
 */
package com.baomidou.mybatisplus.generator.samples.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: SystemTableConstant
 * @Description:
 * @author leegoo
 * @date 2022年02月07日
 */
@Getter
public enum SystemTableConstant {
    STATION_TABLE_NAME("tz_table3","StationInfo");

    private final String tableSourceName;
    private final String tableCode;

    SystemTableConstant(String tableSourceName, String tableCode) {
        this.tableSourceName = tableSourceName;
        this.tableCode = tableCode;
    }
}
