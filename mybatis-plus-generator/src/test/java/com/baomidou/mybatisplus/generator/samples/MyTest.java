/**
 * @Project:
 * @Author: leegoo
 * @Date: 2021年11月18日
 */
package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.samples.table.TableInfoHandle;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * ClassName: MyTest
 *
 * @author leegoo
 * @Description:
 * @date 2021年11月18日
 */
public class MyTest {

    private static final String DB_IP = "192.168.7.22";
    private static final String DB_PORT = "3306";
    //private static final String DB_TADABASE = "main_fan";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "tzdata123.";
    //private static final String DB_URL = "jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_TADABASE;
    private static final String DB_URL = "jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" ;

    private static final String OUT_PUT_FILE = "D://mybatis-plus-generator";
    private static final String author = "liming";
    private static final String base_package = "com.tzkj.jk21421import";

    public static com.baomidou.mybatisplus.generator.samples.table.TableInfo getTableInfo() {
        return TableInfoHandle.getTableInfo();
    }

    public void globalConfig(GlobalConfig.Builder config) {
        config.fileOverride();
        config.outputDir(OUT_PUT_FILE);
        config.author(author);
    }

    public static void packageConfig(PackageConfig.Builder config) {
        config.parent(base_package);
        //config.moduleName(base_package);
        config.entity("business.entity");
        config.service("business.services.interfaces");
        config.serviceImpl("business.services.impl");
        config.mapper("business.dao.interfaces");
        config.xml(getTableInfo().getXmlName()+".xml");
        config.controller("business.controller");
        config.pathInfo(Collections.singletonMap(OutputFile.mapperXml, OUT_PUT_FILE));
    }

    public void templateConfig(TemplateConfig.Builder config) {
        //config.disable(TemplateType.ENTITY,TemplateType.SERVICE,TemplateType.SERVICEIMPL,TemplateType.MAPPER,TemplateType.XML);
        //config.entity("/templates/entity.java");
        //config.service("/templates/service.java");
        //config.serviceImpl("/templates/serviceImpl.java");
        //config.mapper("/templates/mapper.java");
        //config.mapperXml("/templates/mapper.xml");
        // config.controller("/templates/controller.java");
    }

    public void strategyConfig(StrategyConfig.Builder config) {
        config.enableSkipView();
        config.addInclude(getTableInfo().getTableName());
        INameConvert iNameConvert = this.createNameConvert(config.build());
        config.entityBuilder().enableColumnConstant().enableChainModel().enableLombok().enableTableFieldAnnotation().fileOverride().nameConvert(iNameConvert);
        config.controllerBuilder().enableRestStyle();
        config.serviceBuilder()
            //.superServiceClass(BaseService.class)
            //.superServiceImplClass(BaseServiceImpl.class)
            .formatServiceFileName("%sService")
            .formatServiceImplFileName("%sServiceImpl")
            .build();
        config.mapperBuilder()
            .superClass(BaseMapper.class)
            .enableMapperAnnotation()
            .enableBaseResultMap()
            .enableBaseColumnList()
            //.cache(MyMapperCache.class)
            .formatMapperFileName("%sDao")
            .formatXmlFileName("%sMapper");
    }


    private INameConvert createNameConvert(StrategyConfig strategyConfig) {
        ServiceLoader<NameConvert> loader = ServiceLoader.load(NameConvert.class);
        Iterator<NameConvert> iterator = loader.iterator();
        ConvertInput convertInput = ConvertInput.builder().dataBase(getTableInfo().getDatabaseName()).tableName(getTableInfo().getTableName()).build();
        NameConvert nameConvert = null;
        while (iterator.hasNext()) {
            NameConvert nameConvertTmp = iterator.next();
            NameConvert convert = nameConvertTmp.match(convertInput);
            if (null != convert) {
                nameConvert = convert;
                break;
            }
        }
        if (null != nameConvert) {
            NameConvert finalNameConvert = nameConvert;
            return new INameConvert() {
                @Override
                public @NotNull String entityNameConvert(@NotNull TableInfo tableInfo) {
                    return finalNameConvert.entityNameConvert(strategyConfig, tableInfo);
                }

                @Override
                public @NotNull String propertyNameConvert(@NotNull TableField field) {
                    return finalNameConvert.propertyNameConvert(strategyConfig, field);
                }
            };
        }
        return new INameConvert.DefaultNameConvert(strategyConfig);
    }

    ;


    public void create() {
        FastAutoGenerator.create(DB_URL + TableInfoHandle.getTableInfo().getDatabaseName(), DB_USER, DB_PASSWORD)
            .globalConfig(config -> this.globalConfig(config))
            .packageConfig(config -> this.packageConfig(config))
            .templateConfig(config -> {
                this.templateConfig(config);
            })
/*            .injectionConfig(config -> {
                config.beforeOutputFile((tableInfo, objectMap) -> {
                    System.err.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.toString());
                });
            })*/
            .strategyConfig(config -> {
                this.strategyConfig(config);
            }).execute();

    }

    public static void main(String[] args) {
        new File(OUT_PUT_FILE).delete();
        MyTest myTest = new MyTest();
        myTest.create();

    }
}
