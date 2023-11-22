/*
 Navicat Premium Data Transfer

 Source Server         : 才风智慧阿里云
 Source Server Type    : MySQL
 Source Server Version : 50742
 Source Host           : 47.100.11.151:3306
 Source Schema         : caifeng

 Target Server Type    : MySQL
 Target Server Version : 50742
 File Encoding         : 65001

 Date: 21/11/2023 20:20:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cf_access_token_manage
-- ----------------------------
DROP TABLE IF EXISTS `cf_access_token_manage`;
CREATE TABLE `cf_access_token_manage`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `appid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'appid',
  `token_value` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token值',
  `application_scenes` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用场景(wx_web-微信公众号/wx_mp-微信小程序/wx_app-微信app/ali_web-阿里公众号/ali_mp-阿里小程序/ali_app-阿里app)',
  `expired_time` bigint(20) UNSIGNED NOT NULL COMMENT '过期时间',
  `token_notes` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'token备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `appid`(`appid`, `application_scenes`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '第三方平台token管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_account
-- ----------------------------
DROP TABLE IF EXISTS `cf_account`;
CREATE TABLE `cf_account`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `score_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分类型',
  `balance` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '余额',
  `freeze` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '冻结解封时间',
  `type` tinyint(3) NOT NULL DEFAULT 0 COMMENT '账号类型(0-个人/1-商户/2-企业机构)',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '开户时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_account_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_account_log`;
CREATE TABLE `cf_account_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `value` decimal(10, 2) NOT NULL COMMENT '变化值',
  `source_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变动来源id',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `score_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分变动记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_ad
-- ----------------------------
DROP TABLE IF EXISTS `cf_ad`;
CREATE TABLE `cf_ad`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告标题',
  `subtitle` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '广告副标题',
  `cover` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '封面',
  `platform` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '平台(web-网页/wxmp-微信小程序/app-手机应用)',
  `material_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '素材类型(image-图片/video-视频)',
  `sort_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `source_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '源地址',
  `appid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '第三方应用id',
  `show_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '展示次数',
  `click_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '点击次数',
  `start_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始投放时间',
  `end_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束投放时间',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_ad_links
-- ----------------------------
DROP TABLE IF EXISTS `cf_ad_links`;
CREATE TABLE `cf_ad_links`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ad_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告id',
  `scenes` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场景(carpark-bind-car 车牌绑定页面/carpark-order 停车账单结算页面/pay-success 支付成功页面)',
  `platform` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '平台(web-网页/wxmp-微信小程序/app-手机应用)',
  `carrier_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '载体id',
  `sort_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '广告排序',
  `start_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始投放时间',
  `end_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束投放时间',
  `show_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '展示次数',
  `click_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '点击次数',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ad_id`(`ad_id`, `scenes`, `platform`, `start_time`, `end_time`, `sort_index`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_app_version_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_app_version_log`;
CREATE TABLE `cf_app_version_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `platform` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用平台，例如android,ios等',
  `version_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '版本号',
  `level` tinyint(3) UNSIGNED NOT NULL COMMENT '级别(0-普通更新/1-推荐更新/2-强制更新)',
  `note` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '版本描述',
  `publish_time` bigint(19) UNSIGNED NOT NULL COMMENT '发布时间',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'app安装包下载地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `platform`(`platform`, `version_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'app版本发行记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_areas
-- ----------------------------
DROP TABLE IF EXISTS `cf_areas`;
CREATE TABLE `cf_areas`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `short_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level_type` int(11) UNSIGNED NOT NULL,
  `city_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `zip_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `merger_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position_x` decimal(16, 12) NOT NULL,
  `position_y` decimal(16, 12) NOT NULL,
  `pin_yin` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`, `level_type`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_auth
-- ----------------------------
DROP TABLE IF EXISTS `cf_auth`;
CREATE TABLE `cf_auth`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `module` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '模块名称',
  `controller` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控制器名称',
  `method` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '方法名称',
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限路径',
  `level` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前所处层级数',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限描述',
  `sort_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `router_path` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '路由路径',
  `show_menu` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否显示菜单(0-否/1-是)',
  `component` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '路由组件',
  `router_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '路由名称',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '路由图标',
  `breadcrumb_hidden` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否隐藏面包屑(0-否/1-是)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `path`(`path`) USING BTREE,
  INDEX `sort_index`(`sort_index`) USING BTREE,
  INDEX `module`(`module`) USING BTREE,
  INDEX `controller`(`controller`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_car_park
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park`;
CREATE TABLE `cf_car_park`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场名字',
  `image` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车场照片',
  `position_x` decimal(16, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '纬度',
  `start_business_hours` bigint(19) UNSIGNED NOT NULL COMMENT '开始营业时间',
  `end_business_hours` bigint(19) UNSIGNED NOT NULL COMMENT '结束营业时间',
  `parking_space_number` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车位数',
  `used_parking_space_number` int(11) NOT NULL DEFAULT 0 COMMENT '已用车位数',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车场地址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机',
  `landline` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '座机',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-正常/1-车位已满/2-暂停营业)',
  `country_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '国家id',
  `province_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省份id',
  `state_or_city_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '州或城市id',
  `zone_or_county_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '区或县id',
  `township_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '乡镇id',
  `free_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '免费时长',
  `score` decimal(3, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '评分',
  `number_of_comments` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论数',
  `fee_upper_limit` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '单日费用封顶',
  `starting_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '起步价',
  `unit_duration` bigint(19) UNSIGNED NOT NULL COMMENT '单位时长(单位-毫秒)',
  `billing_model` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '计费模式(static-静态/dynamic-动态)',
  `min_advance_subscribe_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '允许提前预约的最小时间',
  `max_advance_subscribe_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '允许提前预约的最大时间',
  `subscribe_free_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '预约后多少时间免责取消',
  `subscribe_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '预约费用(预付)',
  `subscribe_timeout_fee` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '预约后超时但未使用扣费比例(百分比)',
  `creater_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建者id',
  `special_fee_expired_car` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '过期套餐车辆特殊计费(0-不支持/1-支持)',
  `show_expired_car_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否显示过期套餐车的车辆类型(0-不显示h/1-显示)',
  `expired_car_free_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '过期车辆免费时间',
  `show_remarks` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否显示停车记录备注(0-否/1-是)',
  `collection_carpark_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '代收费用停车场id',
  `limit_parking_space_number` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车位满时限制进入(0-否/1-是)',
  `allow_edit_use_log` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许收费员修改停车记录(0-否/1-是)',
  `abnormal_auto_release` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '异常记录是否自动放行(0-否/1-是)',
  `auto_issued_whitelist` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动下发白名单(0-否/1-是)',
  `adminer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员',
  `forbid_group_flag_same_time_in` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否禁止家庭组同时入内(0-否/1-是)',
  `current_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '当前价格(默认取临时车最低价格显示)',
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '充电站id',
  `data_report_platform` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车数据上报平台',
  `leave_time_limit` bigint(19) UNSIGNED NOT NULL DEFAULT 1800000 COMMENT '离场时间限制',
  `special_number_plate` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '特殊车牌号',
  `storehouse_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '仓库物流id',
  `number_plate_color_to_car_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车牌号颜色判定车辆类型(0-否/1-是)',
  `package_group_flag_free_time_change` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '家庭组免停期自动切换(0-否/1-是)',
  `visit_process_mode` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车辆预约到访审核模式(0-关闭/1-业主审核/2-物业审核/3-双重审核)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `start_business_hours`(`start_business_hours`, `end_business_hours`) USING BTREE,
  INDEX `country_id`(`country_id`, `province_id`, `state_or_city_id`, `zone_or_county_id`, `township_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_car
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_car`;
CREATE TABLE `cf_car_park_car`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '汽车主人id',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '汽车品牌(缩写关键字)',
  `model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '型号',
  `purchase_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '购买时间',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '购买价格',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(19) UNSIGNED NOT NULL COMMENT '更新时间',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态(0-已删除/1-审核中/2-正常)',
  `identity_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '证件照',
  `identity_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '证件号',
  `car_type_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆类型',
  `car_type_start_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车辆类型有效期开始时间',
  `car_type_end_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车辆类型有效期结束时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `number_plate`(`number_plate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_car_limit
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_car_limit`;
CREATE TABLE `cf_car_park_car_limit`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `car_type_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆类型',
  `free_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '免费时间',
  `give_free_time` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否赠送免停时间(0-否/1-是)',
  `auto_open_door` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动开闸(0-否/1-是)',
  `forbid_in` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否禁止进入(0-否/1-是)',
  `free_release` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '免费放行(0-否/1-是)',
  `upper_limit_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上限时间',
  `billing_model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '计费模式',
  `fee_upper_limit` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '费用上限',
  `leave_time_limit` bigint(19) UNSIGNED NOT NULL DEFAULT 1800000 COMMENT '离场时间限制',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `car_type_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场车型限制' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_car_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_car_type`;
CREATE TABLE `cf_car_park_car_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `flag_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关键字',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `flag_key`(`flag_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场车辆类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_car_park_charging_rules
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_charging_rules`;
CREATE TABLE `cf_car_park_charging_rules`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `start_time` bigint(19) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(19) UNSIGNED NOT NULL COMMENT '结束时间',
  `fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '实时单价',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(19) UNSIGNED NOT NULL COMMENT '更新时间',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-弃用/1-启用)',
  `car_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'temporary_car' COMMENT '适用车辆类型',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'unit_of_time' COMMENT '类型(unit_of_time-单位时间/each-每次)',
  `group_flag` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分租标识',
  `fee_upper_limit` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '费用上限',
  `billing_model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收费模式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `car_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场计费规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_checkpoint
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_checkpoint`;
CREATE TABLE `cf_car_park_checkpoint`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '(关卡/出入口)名称',
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `position_x` decimal(16, 12) NOT NULL COMMENT '卡点位置经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '卡点位置纬度',
  `position_describe` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '位置描述',
  `floor` tinyint(3) NOT NULL COMMENT '所在楼层',
  `mode` tinyint(2) UNSIGNED NOT NULL COMMENT '模式(0-完全无人值守/1-半自动/2-完全人工值守)',
  `status` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '卡点状态(0-正常/1-关闭通行)',
  `duty_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '值班人员id',
  `direction` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方向(in-入口/out-出口)',
  `allow_temporary_car` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '允许临时车通行(0-不允许/1-允许)',
  `allow_unconditional_open` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '允许无条件开闸(0-不允许/1-允许)',
  `default_check_point` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为默认通道(0-否/1-是)',
  `add_forbidden_data` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否录入禁止车辆数据(0-否/1-是)',
  `allow_expired_car` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '允许过期车通过(0-不允许/1-允许)',
  `allow_package_car` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否允许月卡车通行(0-否/1-是)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_device
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_device`;
CREATE TABLE `cf_car_park_device`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `bar_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备条形码',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `model` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '型号',
  `status` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0-已下线/1-正常/2-故障维护/3-占用',
  `last_online_time` bigint(19) UNSIGNED NOT NULL COMMENT '最近上线时间',
  `link_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '连接模式(poll-轮询/socket-长连接)',
  `type` tinyint(2) UNSIGNED NOT NULL COMMENT '1-匝道/2-相机',
  `checkpoint_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关卡(出入口)id',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品id',
  `direction` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方向',
  `play_contents` varchar(5120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示内容',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备ip',
  `video_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备视频流地址',
  `history_video_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备视频回放地址',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录密码',
  `index_no` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `noticed` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已通知设备掉线',
  `video_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'local' COMMENT '视频模式(local-本地/remote-远程)',
  `rows` tinyint(3) UNSIGNED NOT NULL DEFAULT 4 COMMENT '行数(显示屏内容行数)',
  `mac_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备mac地址',
  `device_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备名称',
  `device_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`) USING BTREE,
  INDEX `last_online_time`(`last_online_time`) USING BTREE,
  INDEX `bar_code`(`bar_code`, `username`, `password`) USING BTREE,
  INDEX `mac_address`(`mac_address`) USING BTREE,
  INDEX `device_no`(`device_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_device_brand
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_device_brand`;
CREATE TABLE `cf_car_park_device_brand`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备品牌名称',
  `image` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '封面/logo',
  `sort_index` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_device_link_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_device_link_user`;
CREATE TABLE `cf_car_park_device_link_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `device_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备id',
  `check_point_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关卡id',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_id`(`device_id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备关联用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_device_vendor
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_device_vendor`;
CREATE TABLE `cf_car_park_device_vendor`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商名称',
  `country_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在国家',
  `province_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省份id',
  `state_or_city_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '州或市id',
  `county_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '县id',
  `position_x` decimal(16, 12) NOT NULL COMMENT '厂商位置经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '厂商位置纬度',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商简介',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场设备厂商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_link_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_link_user`;
CREATE TABLE `cf_car_park_link_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `allow_edit` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许编辑(0-否/1-是)',
  `allow_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许删除(0-否/1-是)',
  `creater` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为创建者(0-否/1-是)',
  `check_point_ids` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '绑定的通道id(多个,半角逗号隔开)',
  `start_duty_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始值班时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场与用户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_package
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_package`;
CREATE TABLE `cf_car_park_package`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `type_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆类型',
  `start_time` bigint(19) UNSIGNED NOT NULL COMMENT '套餐开始时间',
  `end_time` bigint(19) UNSIGNED NOT NULL COMMENT '套餐结束时间',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `special_give` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是内部指定套餐(0-否/1-是)',
  `package_price_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐价格表id',
  `trans_regional` tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否为跨区(0-否/1-是)',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '父级id',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `main_car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主停车场id',
  `remarks` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `car_owner_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车主姓名',
  `group_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分组',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-禁用/1-正常)',
  `issued_whitelist` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已下发白名单(0-否/1-是)',
  `issued_whitelist_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '白名单下发时间',
  `notice_expiring_soon` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已通知套餐快过期(0-否/1-是)',
  `notice_expired` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已通知套餐已过期(0-否/1-是)',
  `special_car_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '特殊车辆id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`) USING BTREE,
  INDEX `number_plate`(`number_plate`) USING BTREE,
  INDEX `start_time`(`start_time`) USING BTREE,
  INDEX `end_time`(`end_time`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  INDEX `group_flag`(`group_flag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆对应车场套餐表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_car_park_package_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_package_log`;
CREATE TABLE `cf_car_park_package_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_type_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_type_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_start_time` bigint(20) NOT NULL,
  `after_start_time` bigint(20) NOT NULL,
  `before_end_time` bigint(20) NOT NULL,
  `after_end_time` bigint(20) NOT NULL,
  `before_create_time` bigint(20) NOT NULL,
  `after_create_time` bigint(20) NOT NULL,
  `before_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_number_plate` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_number_plate` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_special_give` tinyint(3) UNSIGNED NOT NULL,
  `after_special_give` tinyint(3) UNSIGNED NOT NULL,
  `before_package_price_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_package_price_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_trans_regional` tinyint(4) NOT NULL,
  `after_trans_regional` tinyint(4) NOT NULL,
  `before_parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_main_car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_main_car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_remarks` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_remarks` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_car_owner_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `after_car_owner_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_group_flag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `before_status` tinyint(4) NOT NULL,
  `after_status` tinyint(3) UNSIGNED NOT NULL,
  `handle_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `package_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action_time` bigint(16) UNSIGNED NOT NULL COMMENT '操作时间',
  `after_group_flag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `package_id`(`package_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '套餐修改记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_package_price
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_package_price`;
CREATE TABLE `cf_car_park_package_price`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题(名称)',
  `subtitle` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '副标题',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `flag_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐类型关键字',
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `original_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '原价',
  `current_price` decimal(10, 2) NOT NULL COMMENT '现价',
  `time_quota` bigint(19) UNSIGNED NOT NULL COMMENT '时间额度，购买后套餐增加的时间值',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `special_give` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为内部指定套餐(0-否/1-是)',
  `grace_period` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '宽限期(当月卡过期后宽限几天开始催收临停费)',
  `use_grace_period` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否使用宽限期(0-否/1-是)',
  `special_car_package` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为特殊车辆套餐(0-否/1-是)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `flag_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场套餐费用表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_car_park_payment_agency
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_payment_agency`;
CREATE TABLE `cf_car_park_payment_agency`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `user_payment_agency` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户与支付机构的关联表id',
  `sort_index` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`, `user_payment_agency`, `sort_index`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场支付机构关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_release_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_release_log`;
CREATE TABLE `cf_car_park_release_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carpark_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `carpark_use_log_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车记录id',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车牌号',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人',
  `device_serial_number` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列号',
  `application_time` bigint(19) UNSIGNED NOT NULL COMMENT '申请时间',
  `application_reason` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请原因',
  `execution_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '执行时间',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-待执行/1-执行成功/2-执行失败)',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '放行类型(1-正常放行/2-异常放行)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_serial_number`(`device_serial_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场放行记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_special_car
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_special_car`;
CREATE TABLE `cf_car_park_special_car`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `type_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆类型',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '结束时间',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `remarks` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `car_owner_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车主名称',
  `group_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分组',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-禁用/1-正常)',
  `remaining_park_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '剩余停车时间',
  `auto_give_away` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动赠送(0-否/1-是)',
  `auto_cleared` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动清理(0-否/1-是)',
  `auto_give_away_date` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '自动赠送日期',
  `auto_give_away_amount` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '自动赠送额度',
  `auto_give_away_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '自动赠送执行时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `_copy_4`(`car_park_id`) USING BTREE,
  INDEX `_copy_3`(`number_plate`) USING BTREE,
  INDEX `_copy_2`(`start_time`) USING BTREE,
  INDEX `_copy_1`(`end_time`) USING BTREE,
  INDEX `_copy_7`(`phone`) USING BTREE,
  INDEX `auto_give_away_date`(`auto_give_away_date`, `auto_give_away_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场特殊车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_use_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_use_log`;
CREATE TABLE `cf_car_park_use_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户id(使用场景:申请临时通行时会标记用户)',
  `in_small_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '进场小图',
  `out_small_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出场小图',
  `in_big_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '进场大图',
  `out_big_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出场大图',
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '停车场id',
  `subscribe_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '预约时间',
  `cancel_subscribe_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '取消预约时间',
  `in_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '进场时间',
  `out_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '出场时间',
  `in_release_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '入场放行方式(0-未知/1-自动抬杆/2-人工抬杆/3-手机放行，断电断网时)',
  `out_release_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '出场放行方式(0-未知/1-自动抬杆/2-人工抬杆/3-手机放行，断电断网时)',
  `in_check_point_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '入口id',
  `out_check_point_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出口id',
  `create_position` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产生该停车记录的位置(out-外场/in-内场)',
  `pay_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付时间',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `in_handle_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '入场处理者id(例如:值班人id)',
  `out_handle_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出场处理者id(例如:值班人id)',
  `count_fee_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '计费状态(0-实时计算/1-按已存在的出场时间计算)',
  `remarks` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `car_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆类型',
  `car_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '车辆状态(0-禁用/1-正常/2-已过期)，此状态包含套餐，特殊车辆状态',
  `visit_unit` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '到访单元',
  `give_away_park_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '赠送的停车时间',
  `car_number_plate_color` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车辆车牌颜色(0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色)',
  `car_brand` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆品牌',
  `parking_space_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车位编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `number_plate`(`number_plate`) USING BTREE,
  INDEX `car_park_id`(`car_park_id`) USING BTREE,
  INDEX `subscribe_time`(`subscribe_time`) USING BTREE,
  INDEX `in_time`(`in_time`) USING BTREE,
  INDEX `out_time`(`out_time`) USING BTREE,
  INDEX `pay_time`(`pay_time`, `out_handle_uid`) USING BTREE,
  INDEX `create_time`(`create_time`) USING BTREE,
  INDEX `car_type`(`car_type`) USING BTREE,
  INDEX `visit_unit`(`visit_unit`) USING BTREE,
  INDEX `car_number_plate_color`(`car_number_plate_color`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆出入记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_visit
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_visit`;
CREATE TABLE `cf_car_park_visit`  (
  `id` bigint(20) NOT NULL,
  `car_park_id` bigint(20) UNSIGNED NOT NULL COMMENT '停车场id',
  `plate_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `from_uid` bigint(20) UNSIGNED NOT NULL COMMENT '申请者',
  `to_uid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '受访者',
  `process_uid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核员',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '申请时间',
  `process_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核时间',
  `car_park_use_log_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '停车记录',
  `visit_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '到访时间',
  `process_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核状态(0-待审核/1-已审核/2-已到访)',
  `expiration_time` bigint(20) UNSIGNED NOT NULL COMMENT '过期时间',
  `destination` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '目的地',
  `reason` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '到访原因',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `from_uid`(`from_uid`) USING BTREE,
  INDEX `to_uid`(`to_uid`) USING BTREE,
  INDEX `car_prak_id`(`car_park_id`, `plate_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆到访申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_car_park_whitelist_issued_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_car_park_whitelist_issued_log`;
CREATE TABLE `cf_car_park_whitelist_issued_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `device_sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备序列号',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `issued_time` bigint(20) UNSIGNED NOT NULL COMMENT '白名单下发时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_sn`(`device_sn`, `number_plate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '停车场车辆白名单下发记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_port
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_port`;
CREATE TABLE `cf_charging_port`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `port_number` tinyint(3) UNSIGNED NOT NULL COMMENT '充电口编号',
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站编号',
  `charging_device_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电设备id',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-空闲/1-已连接/2-充电中)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_device_id`(`charging_device_id`, `port_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电口表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station`;
CREATE TABLE `cf_charging_station`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `station_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站名称',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `station_type` tinyint(3) UNSIGNED NOT NULL COMMENT '充电站类型(1-电动车充电站/2-电动汽车充电站)',
  `free_park_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '免费停车时间',
  `start_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '开始价格',
  `has_bathroom` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否有洗手间(0-否/1-是)',
  `has_lounge` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否有休息室(0-否/1-是)',
  `has_dinning_room` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否有餐厅(0-否/1-是)',
  `has_shop` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否有商店(0-否/1-是)',
  `slow_charge_number` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '慢充数',
  `fast_charge_number` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '快充数',
  `super_fast_charge_number` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '超级快充数',
  `used_slow_charge_number` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已使用慢充数',
  `used_fast_charge_number` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已使用快充数',
  `used_super_fast_charge_number` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已使用超级快速数',
  `floor` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '楼层',
  `indoor_or_outdoor` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '室内或者室外(1-室外/2-室内)',
  `position_x` decimal(17, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(17, 12) NOT NULL COMMENT '纬度',
  `country_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '国家id',
  `province_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省份id',
  `state_or_city_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '州或城市id',
  `zone_or_county_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '区或县id',
  `township_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '乡镇id',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `start_business_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始营业时间',
  `end_business_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束营业时间',
  `station_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-停止营业/1正常营业)',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '联系电话',
  `service_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '服务费',
  `car_park_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车场id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_device
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_device`;
CREATE TABLE `cf_charging_station_device`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  `bar_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备条形码',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `model` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '型号',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0-已下线/1-正常/2-故障维护',
  `last_online_time` bigint(20) UNSIGNED NOT NULL COMMENT '最近上线时间',
  `link_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '连接模式(poll-轮询/socket-长连接)',
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '1-充电桩',
  `checkpoint_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关卡(出入口)id',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品id',
  `play_contents` varchar(5120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示屏显示规则',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备ip',
  `video_address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备视频流地址',
  `history_video_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备视频回放地址',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录密码',
  `index_no` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `noticed` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已经通知了设备掉线(0-否/1-是)',
  `rows` tinyint(3) UNSIGNED NOT NULL DEFAULT 4 COMMENT '行数(显示屏内容行数)',
  `mac_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备mac地址',
  `power` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '功率(单位：瓦-w)',
  `power_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '功率类型(1-慢充/2-快充/3-特快充)',
  `alias_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '别名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_station_id`(`charging_station_id`) USING BTREE,
  INDEX `_copy_3`(`bar_code`, `brand`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_device_link_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_device_link_user`;
CREATE TABLE `cf_charging_station_device_link_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `device_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备id',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `device_id`(`device_id`) USING BTREE,
  INDEX `_copy_1`(`charging_station_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电设备关联用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_device_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_device_type`;
CREATE TABLE `cf_charging_station_device_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag_key` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键字',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `flag_key`(`flag_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站设备类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_link_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_link_user`;
CREATE TABLE `cf_charging_station_link_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `allow_edit` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许编辑(0-否/1-是)',
  `allow_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许删除(0-否/1-是)',
  `creater` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为创建者(0-否/1-是)',
  `check_point_ids` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '绑定的通道id(多个,半角逗号隔开)',
  `start_duty_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始值班时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_station_id`(`charging_station_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站与用户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_payment_agency
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_payment_agency`;
CREATE TABLE `cf_charging_station_payment_agency`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  `user_payment_agency` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户与支付机构的关联表id',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_station_id`(`charging_station_id`, `user_payment_agency`, `sort_index`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站支付机构关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_station_rules
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_station_rules`;
CREATE TABLE `cf_charging_station_rules`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '结束时间',
  `fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '实时单价',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) UNSIGNED NOT NULL COMMENT '更新时间',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-弃用/1-启用)',
  `charging_device_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '适用充电设备类型',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型(unit_of_time-单位时间/each-每次)',
  `group_flag` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分组标识',
  `fee_upper_limit` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '费用上限',
  `service_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '服务费',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_station_id`(`charging_station_id`, `start_time`, `end_time`, `charging_device_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电站计费规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_charging_use_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_charging_use_log`;
CREATE TABLE `cf_charging_use_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `charging_station_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站id',
  `charging_device_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电站设备id',
  `charging_port` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充电口',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束时间',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `charging_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '充电费',
  `service_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '服务费',
  `plan_charging_fee` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '计划充电费用',
  `charginged_kwh` float(10, 6) UNSIGNED NOT NULL DEFAULT 0.000000 COMMENT '已充电度数',
  `plan_charging_kwh` float(8, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '计划充电度数',
  `charging_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '充电价格',
  `charging_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '充电状态(1‐正准备开始充电/2‐充电进行中/3‐充电结束/4‐启动失败/5‐系统故障(不能给汽车充电)',
  `end_reason` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '结束原因',
  `service_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '服务费价格',
  `charging_power` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '充电功率',
  `plan_charging_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '计划充电时长',
  `charging_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '充电类型(0-未知/1-两轮电动车/2-四轮电动汽车)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `charging_station_id`(`charging_station_id`) USING BTREE,
  INDEX `start_time`(`start_time`) USING BTREE,
  INDEX `end_time`(`end_time`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `charging_device_id`(`charging_device_id`, `charging_port`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_coupon
-- ----------------------------
DROP TABLE IF EXISTS `cf_coupon`;
CREATE TABLE `cf_coupon`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '受赠用户id',
  `from_uid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发放者id',
  `scenes` tinyint(2) UNSIGNED NOT NULL COMMENT '使用场景(0-通用/1-停车场/2-传统商城)',
  `shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '店铺id(为空时表示不限店铺使用)',
  `goods_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品id(留空这表示不限商品)',
  `denomination` decimal(16, 2) UNSIGNED NOT NULL COMMENT '优惠券面额(该面额可能时毫秒时间戳,金钱数,剩余使用次数)',
  `threshold_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '门槛价',
  `effective_time` bigint(19) UNSIGNED NOT NULL COMMENT '生效时间',
  `expire_time` bigint(19) UNSIGNED NOT NULL COMMENT '失效时间',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态(0-已使用/1-未使用/2-锁定)',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `use_time` bigint(19) UNSIGNED NOT NULL COMMENT '使用时间',
  `amount_used` decimal(16, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '已使用金额',
  `coupon_type` tinyint(3) UNSIGNED NOT NULL COMMENT '优惠券类型(1-次数券/2-金额券/3-时长券)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `to_uid`(`to_uid`, `effective_time`, `expire_time`, `scenes`) USING BTREE,
  INDEX `goods_id`(`goods_id`, `denomination`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_coupon_activity
-- ----------------------------
DROP TABLE IF EXISTS `cf_coupon_activity`;
CREATE TABLE `cf_coupon_activity`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标题',
  `subtitle` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '副标题',
  `image` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '活动图片',
  `introduction` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '活动简介',
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '0-通用/1-停车场/2-传统商城',
  `start_time` bigint(16) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(16) UNSIGNED NOT NULL COMMENT '结束时间',
  `main_body_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动主体id',
  `creater_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者id(发起者id)',
  `denomination` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '优惠券面额',
  `threshold_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '门槛价',
  `goods_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '指定商品id(为空则不指定)',
  `total_issue_quantity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总发行量',
  `issued_quantity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已发行量',
  `unit_of_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单位时间',
  `unit_of_time_total_issue_quantity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单位时间发行量',
  `unit_of_time_total_issued_quantity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单位时间已发行量',
  `unit_of_time_issue_gradient` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单位时间发行梯度',
  `last_issue_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最近发行时间',
  `user_condition` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '筛选用户条件',
  `repeat_times` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '允许重复领取次数',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-暂停/1-正常/2-待支付)',
  `create_time` bigint(16) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
  `show_in_carpark_list` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否显示在停车场列表中(0-否/1-是)',
  `total_issue_quota` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '总发行额度',
  `issued_quota` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '已发行额度',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `recharge_ratio` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 1.00 COMMENT '充值比例，例如比例为10充10得100',
  `shopkeeper_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '店主名称',
  `project_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '项目名称',
  `trade_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '行业',
  `coupon_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 2 COMMENT '优惠券类型(1-次数券/2-金额券/3-时长券)',
  `auto_give_away` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动赠送(0-否/1-是)',
  `auto_cleared` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动清理(0-否/1-是)',
  `auto_give_away_date` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '自动赠送日期',
  `auto_give_away_quota` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '自动赠送金额',
  `auto_give_away_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '自动赠送执行时间',
  `auto_give_away_overage_quota` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '自动赠送剩余额度',
  `remaining_times` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '剩余次数(次数券)',
  `remaining_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '剩余时长(时长券)',
  `times_coupon_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '次数券价格',
  `time_coupon_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '时长券价格',
  `amount_daily_limit` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '金额券每日上限，默认为0不限制',
  `times_daily_limit` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '次数券每日上限，默认为0不限制',
  `time_daily_limit` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '时长券每日上限，默认为0不限制，单位毫秒',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type`(`type`, `start_time`, `end_time`, `main_body_id`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE,
  INDEX `trade_type`(`trade_type`) USING BTREE,
  INDEX `auto_give_away_date`(`auto_give_away_date`, `auto_give_away_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券发行活动表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_coupon_activity_coupon_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_coupon_activity_coupon_type`;
CREATE TABLE `cf_coupon_activity_coupon_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coupon_activity_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券活动id',
  `fixed_extension_time` bigint(16) UNSIGNED NOT NULL COMMENT '固定延长时间(当前时间起往后延长)',
  `denomination` decimal(15, 2) UNSIGNED NOT NULL COMMENT '面额',
  `coupon_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 2 COMMENT '优惠券类型(1-次数券/2-金额券/3-时长券)',
  `require_using` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否要求在服务中(0-否/1-是)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `coupon_activity_id`(`coupon_activity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券活动优惠券类型(用于员工可发券的面额和有效期)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_coupon_activity_link_shop
-- ----------------------------
DROP TABLE IF EXISTS `cf_coupon_activity_link_shop`;
CREATE TABLE `cf_coupon_activity_link_shop`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coupon_activity_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券id',
  `shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺id(商店/停车场等)',
  `scene` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场景(停车场carpark/店铺/shop)',
  `main_shop` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为主要店铺(0-否/1-是)',
  `require_using` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否要求在服务中(0-否/1-是)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `coupon_activity_id`(`coupon_activity_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券活动覆盖店面表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_coupon_link_shop
-- ----------------------------
DROP TABLE IF EXISTS `cf_coupon_link_shop`;
CREATE TABLE `cf_coupon_link_shop`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coupon_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券id',
  `shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺id(商店/停车场等)',
  `scene` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场景(carpark-停车场/shop店铺商店)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `coupon_id`(`coupon_id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_daily_income_statistics
-- ----------------------------
DROP TABLE IF EXISTS `cf_daily_income_statistics`;
CREATE TABLE `cf_daily_income_statistics`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `shop_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '店铺id',
  `goods_type` tinyint(3) UNSIGNED NOT NULL COMMENT '商品类型',
  `year` smallint(4) UNSIGNED NOT NULL COMMENT '年份',
  `month` tinyint(2) UNSIGNED NOT NULL COMMENT '月份',
  `date` tinyint(2) UNSIGNED NOT NULL COMMENT '日期',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '开始统计时间',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '结束统计时间',
  `payment_agency_short_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付机构缩写',
  `amounts_payable` decimal(10, 2) UNSIGNED NOT NULL COMMENT '应付金额',
  `amount_actually_paid` decimal(10, 2) UNSIGNED NOT NULL COMMENT '实付金额',
  `refund_amount` decimal(10, 2) UNSIGNED NOT NULL COMMENT '退款金额',
  `pay_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付笔数',
  `counts_time` bigint(20) UNSIGNED NOT NULL COMMENT '统计时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  INDEX `start_time`(`start_time`, `end_time`) USING BTREE,
  INDEX `goods_type`(`goods_type`) USING BTREE,
  INDEX `payment_agency_short_name`(`payment_agency_short_name`) USING BTREE,
  INDEX `year`(`year`) USING BTREE,
  INDEX `month`(`month`) USING BTREE,
  INDEX `date`(`date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '每日收入统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_daily_parking_statistcs
-- ----------------------------
DROP TABLE IF EXISTS `cf_daily_parking_statistcs`;
CREATE TABLE `cf_daily_parking_statistcs`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `carpark_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '停车场id',
  `year` smallint(4) UNSIGNED NOT NULL COMMENT '年份',
  `month` tinyint(3) UNSIGNED NOT NULL COMMENT '月份',
  `date` tinyint(3) UNSIGNED NOT NULL COMMENT '日期',
  `start_time` bigint(20) NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '结束时间',
  `parking_counts` int(10) UNSIGNED NOT NULL COMMENT '总停车次数',
  `parking_temporary_counts` int(10) UNSIGNED NOT NULL COMMENT '总临时车停车次数',
  `parking_space` int(10) UNSIGNED NOT NULL COMMENT '总车位数',
  `parking_used_space` int(10) UNSIGNED NOT NULL COMMENT '总已使用车位数',
  `parking_not_in_time_counts` int(10) UNSIGNED NOT NULL COMMENT '总无入场时间记录数',
  `parking_abnormal_release_counts` int(10) UNSIGNED NOT NULL COMMENT '总异常放行记录数',
  `parking_package_renewal_counts` int(10) UNSIGNED NOT NULL COMMENT '总月卡记录数',
  `parking_time_counts` bigint(20) UNSIGNED NOT NULL COMMENT '总的停车时间',
  `counts_time` bigint(20) UNSIGNED NOT NULL COMMENT '统计时间',
  `yellow_number_plate_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '黄牌车辆数量统计',
  `blue_number_plate_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '蓝色车牌数量统计',
  `green_number_plate_counts` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '绿色车牌数量统计',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `carpark_id`(`carpark_id`) USING BTREE,
  INDEX `start_time`(`start_time`, `end_time`) USING BTREE,
  INDEX `year`(`year`) USING BTREE,
  INDEX `month`(`month`) USING BTREE,
  INDEX `date`(`date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '每日停车统计报表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_department
-- ----------------------------
DROP TABLE IF EXISTS `cf_department`;
CREATE TABLE `cf_department`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '部门图标',
  `sort_index` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '顺序序号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_history_order
-- ----------------------------
DROP TABLE IF EXISTS `cf_history_order`;
CREATE TABLE `cf_history_order`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺id',
  `order_time` bigint(20) UNSIGNED NOT NULL COMMENT '账单日期',
  `park_fee_amounts_payable` decimal(10, 2) UNSIGNED NOT NULL COMMENT '停车缴费应付金额',
  `park_fee_amount_actually_paid` decimal(10, 2) UNSIGNED NOT NULL COMMENT '停车缴费实付金额',
  `park_package_amounts_payable` decimal(10, 2) UNSIGNED NOT NULL COMMENT '停车套餐应付金额',
  `park_package_amount_actually_paid` decimal(10, 2) UNSIGNED NOT NULL COMMENT '停车套餐实付金额',
  `cash_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '现金支付',
  `weixin_h5_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '微信h5支付',
  `weixin_min_pay` decimal(10, 2) NOT NULL COMMENT '微信小程序支付',
  `weixin_app_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '微信APP支付',
  `ali_h5_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '支付宝h5支付',
  `ali_min_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '支付宝小程序支付',
  `ali_app_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '支付宝APP支付',
  `park_package_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '停车套餐支付',
  `bbc_pay` decimal(10, 2) UNSIGNED NOT NULL COMMENT '建行支付',
  `recharge_amounts_payable` decimal(10, 2) UNSIGNED NOT NULL COMMENT '充值应付金额',
  `recharge_amount_actually_paid` decimal(10, 2) UNSIGNED NOT NULL COMMENT '充值实付金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_id`(`shop_id`, `order_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '历史账单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_car_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_car_type`;
CREATE TABLE `cf_logistics_car_type`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `car_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆类型名称',
  `flag_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识符',
  `sort_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序标识符',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `flag_key`(`flag_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流汽车类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_cargo_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_cargo_type`;
CREATE TABLE `cf_logistics_cargo_type`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `cargo_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货物名称',
  `flag_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识符',
  `sort_index` smallint(5) UNSIGNED NOT NULL COMMENT '排序序号',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `flag_key`(`flag_key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流货物类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_factory
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_factory`;
CREATE TABLE `cf_logistics_factory`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `factory_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工厂名称',
  `position_x` decimal(16, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '纬度',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '仓库地址',
  `principal` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '负责人电话',
  `sign_in_range` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '签到范围(单位/米)',
  `wx_mp_appid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信小程序appid',
  `wx_pub_appid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '微信公众号appid',
  `car_park_ids` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '关联的停车场id，英文逗号隔开',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE,
  INDEX `factory_name`(`factory_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流工厂表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_led_device
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_led_device`;
CREATE TABLE `cf_logistics_led_device`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `queuing_area_id` bigint(20) UNSIGNED NOT NULL COMMENT '排队区域id',
  `serial_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '序列号',
  `brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `model` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '型号',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '0-已下线/1-正常/2-故障维护',
  `last_online_time` bigint(20) UNSIGNED NOT NULL COMMENT '最近上线时间',
  `link_mode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '连接模式(poll-轮询/socket-长连接)',
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '1-led主板',
  `product_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '产品id',
  `play_contents` varchar(5120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '显示屏显示规则',
  `ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备ip',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备登录密码',
  `index_no` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `noticed` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已经通知了设备掉线(0-否/1-是)',
  `rows` tinyint(3) UNSIGNED NOT NULL DEFAULT 4 COMMENT '行数(显示屏内容行数)',
  `mac_address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '设备mac地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `queuing_area_id`(`queuing_area_id`) USING BTREE,
  INDEX `_copy_3`(`serial_number`) USING BTREE,
  INDEX `_copy_2`(`last_online_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流led设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_queue
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_queue`;
CREATE TABLE `cf_logistics_queue`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `use_log_id` bigint(20) UNSIGNED NOT NULL COMMENT '预约id',
  `sort_index` smallint(5) UNSIGNED NOT NULL COMMENT '排队序号',
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `logistics_platform_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '月台id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `use_log_id`(`use_log_id`) USING BTREE,
  INDEX `sort_index`(`sort_index`) USING BTREE,
  INDEX `logistics_platform_id`(`logistics_platform_id`) USING BTREE,
  INDEX `logistics_storehouse_id`(`logistics_storehouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流排队队列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_queuing_area
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_queuing_area`;
CREATE TABLE `cf_logistics_queuing_area`  (
  `id` bigint(20) NOT NULL,
  `area_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域名字',
  `queue_capacity` int(10) UNSIGNED NOT NULL COMMENT '队列容量',
  `used_queue_capacity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已使用队列容量',
  `position_x` decimal(16, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '纬度',
  `area_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-关闭/1-正常开放)',
  `factory_id` bigint(20) UNSIGNED NOT NULL COMMENT '工厂id',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序序号',
  `group_flag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '分组标识符',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `area_name`(`area_name`) USING BTREE,
  INDEX `used_queue_capacity`(`used_queue_capacity`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `sort_index`(`sort_index`) USING BTREE,
  INDEX `group_flag`(`group_flag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流排队区' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_queuing_area_platform
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_queuing_area_platform`;
CREATE TABLE `cf_logistics_queuing_area_platform`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `queuing_area_id` bigint(20) UNSIGNED NOT NULL COMMENT '排队区域id',
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `logistics_storehouse_platform_id` bigint(20) UNSIGNED NOT NULL COMMENT '月台id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `logistics_storehouse_platform_id`(`logistics_storehouse_platform_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '排队区域关联月台表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_storehouse`;
CREATE TABLE `cf_logistics_storehouse`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `storehouse_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库名称',
  `country_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '国家id',
  `province_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '省份id',
  `state_or_city_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '州或城市id',
  `zone_or_county_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '区或县id',
  `township_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '乡镇id',
  `position_x` decimal(16, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '纬度',
  `start_business_hours` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始营业时间',
  `end_business_hours` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '结束营业时间',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '仓库地址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `wx_appid` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '绑定的appid，用于推送微信通知',
  `factory_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '工厂id',
  `principal` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '负责人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE,
  INDEX `storehouse_name`(`storehouse_name`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_storehouse_cargo_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_storehouse_cargo_type`;
CREATE TABLE `cf_logistics_storehouse_cargo_type`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `cargo_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货物类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `logistics_storehouse_id`(`logistics_storehouse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库货物类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_storehouse_link_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_storehouse_link_user`;
CREATE TABLE `cf_logistics_storehouse_link_user`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `allow_edit` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许编辑(0-否/1-是)',
  `allow_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许删除(0-否/1-是)',
  `creater` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否为创建者(0-否/1-是)',
  `check_point_ids` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '绑定的通道id(多个,半角逗号隔开)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_id`(`logistics_storehouse_id`, `uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流仓库关联用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_storehouse_platform
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_storehouse_platform`;
CREATE TABLE `cf_logistics_storehouse_platform`  (
  `id` bigint(20) NOT NULL,
  `platform_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '月台名称',
  `storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `position_x` decimal(16, 12) NOT NULL COMMENT '经度',
  `position_y` decimal(16, 12) NOT NULL COMMENT '纬度',
  `queue_capacity` int(10) UNSIGNED NOT NULL COMMENT '队列容量',
  `used_queue_capacity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已使用队列容量',
  `platform_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(0-关闭/1-正常/2-爆满)',
  `sort_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序序号',
  `handle_uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '值班人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `storehouse_id`(`storehouse_id`) USING BTREE,
  INDEX `position_x`(`position_x`, `position_y`) USING BTREE,
  INDEX `sort_index`(`sort_index`) USING BTREE,
  INDEX `handle_uid`(`handle_uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库月台表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_storehouse_platform_cargo_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_storehouse_platform_cargo_type`;
CREATE TABLE `cf_logistics_storehouse_platform_cargo_type`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL COMMENT '仓库id',
  `logistics_storehouse_platform_id` bigint(20) UNSIGNED NOT NULL COMMENT '月台id',
  `cargo_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货物类型',
  `factory_id` bigint(20) UNSIGNED NOT NULL COMMENT '工厂id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `logistics_storehouse_platform_id`(`logistics_storehouse_platform_id`) USING BTREE,
  INDEX `cargo_type`(`cargo_type`) USING BTREE,
  INDEX `logistics_storehouse_id`(`logistics_storehouse_id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库月台货物类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_task
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_task`;
CREATE TABLE `cf_logistics_task`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `task_title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务标题',
  `pid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级任务id',
  `editer_uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) NOT NULL COMMENT '结束时间',
  `update_time` bigint(20) UNSIGNED NOT NULL COMMENT '更新时间',
  `origin` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '始发地',
  `destination` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '目的地',
  `cargo_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货物类型',
  `car_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆类型',
  `vehicles_required` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所需车辆数',
  `reserved_vehicles` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '已预约车辆数',
  `res_each` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '货物数量',
  `weight` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '重量：单位：克',
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '仓库id',
  `task_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务状态(0-等待预约，1-装/卸货中，2-已结束)',
  `task_type` tinyint(3) UNSIGNED NOT NULL COMMENT '任务类型(0-拉货/1-送货)',
  `factory_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '工厂id',
  `supplier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '供应商',
  `waybill_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '运单号',
  `emergency_level` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '紧急程度(0-一般/1-紧急)',
  `children_task_counts` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '子任务数',
  `sort_index` int(10) UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序序号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_time`(`create_time`) USING BTREE,
  INDEX `start_time`(`start_time`, `end_time`) USING BTREE,
  INDEX `cargo_type`(`cargo_type`) USING BTREE,
  INDEX `car_type`(`car_type`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `logistics_storehouse_id`(`logistics_storehouse_id`) USING BTREE,
  INDEX `waybill_number`(`waybill_number`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `sort_index`(`sort_index`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_task_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_task_log`;
CREATE TABLE `cf_logistics_task_log`  (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级id',
  `task_id` bigint(20) UNSIGNED NOT NULL COMMENT '任务id',
  `deliver_uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '送货员id',
  `receipt_uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '收货员id',
  `checker_uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '核对人id',
  `task_log_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-已预约/1-已签到/2-排队中/3-装卸货中/4-待核对/5-已结束)',
  `reserve_quantity` int(10) UNSIGNED NOT NULL COMMENT '预约数量',
  `finally_quantity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最终数量',
  `reserve_weight` bigint(20) UNSIGNED NOT NULL COMMENT '预约重量',
  `finally_weight` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最终重量',
  `queue_index` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排队序号',
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `delivery_note_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '进货单条码',
  `delivery_note_image` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '进货单图片',
  `inbound_delivery_note_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '内向交货单号',
  `purchase_order_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '采购订单号',
  `item_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '物料号',
  `item_description` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '物料描述',
  `category` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类别',
  `requested_delivery_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '要求送达时间',
  `exempt_from_inspection` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否免检(0-否/1-是)',
  `earliest_delivery_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最早送达时间',
  `latest_delivery_date` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最迟送达时间',
  `shelf_life` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '保质期',
  `notify_driver_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '通知司机时间',
  `logistics_storehouse_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '仓库id',
  `logistics_platform_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '月台id',
  `check_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '核对时间',
  `emergency_level` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '紧急程度(0-一般/1-紧急)',
  `queuing_area_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排队区域id',
  `start_queuing_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '开始排队时间',
  `call_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '叫号时间',
  `factory_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '工厂id',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `task_id`(`task_id`) USING BTREE,
  INDEX `deliver_uid`(`deliver_uid`) USING BTREE,
  INDEX `checker_uid`(`checker_uid`) USING BTREE,
  INDEX `task_log_status`(`task_log_status`) USING BTREE,
  INDEX `queue_index`(`queue_index`) USING BTREE,
  INDEX `number_plate`(`number_plate`) USING BTREE,
  INDEX `delivery_note_code`(`delivery_note_code`) USING BTREE,
  INDEX `item_number`(`item_number`) USING BTREE,
  INDEX `category`(`category`) USING BTREE,
  INDEX `notify_driver_time`(`notify_driver_time`) USING BTREE,
  INDEX `logistics_storehouse_id`(`logistics_storehouse_id`) USING BTREE,
  INDEX `logistics_platform_id`(`logistics_platform_id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `queuing_area_id`(`queuing_area_id`) USING BTREE,
  INDEX `factory_id`(`factory_id`) USING BTREE,
  INDEX `create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务执行记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_logistics_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `cf_logistics_vehicle`;
CREATE TABLE `cf_logistics_vehicle`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `number_plate` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `vehicle_owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆所属者',
  `vehicle_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆类型',
  `vehicle_vin` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车架号',
  `vehicle_size` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '车辆尺寸(单位mm)',
  `approved_load` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '核定载重',
  `number_plate_color` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '车牌颜色(0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色)',
  `road_transport_certificate_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '道路运输证号',
  `operating_license_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '营运证号',
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '所属用户id',
  `action_uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作者id',
  `create_time` bigint(20) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) UNSIGNED NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `vehicle_vin`(`vehicle_vin`) USING BTREE,
  INDEX `number_plate`(`number_plate`) USING BTREE,
  INDEX `vehicle_owner`(`vehicle_owner`) USING BTREE,
  INDEX `vehicle_type`(`vehicle_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物流车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_order
-- ----------------------------
DROP TABLE IF EXISTS `cf_order`;
CREATE TABLE `cf_order`  (
  `id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `random_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '随机码id(用于解决微信/支付宝频繁多次提交未支付导致最后无法支付的问题)',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户id',
  `goods_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称(快照)',
  `goods_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `goods_image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品图(快照)',
  `goods_type` tinyint(3) UNSIGNED NOT NULL COMMENT '商品类型(1-停车/2-充值或提现/3-商城/4-转账或收款/5-停车套餐/6-车位预订/7-优惠券活动充值)',
  `shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '店铺id',
  `amounts_payable` decimal(10, 2) UNSIGNED NOT NULL COMMENT '应付金额',
  `amount_actually_paid` decimal(10, 2) UNSIGNED NOT NULL COMMENT '实付金额',
  `refund_amount` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '退款金额',
  `coupon_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '优惠券id',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态(0-待支付/1-已支付/2-已发货/3-已取消/4-一退款中/5-已退款/6-退货中/7-已退货/8-交易成功/9-售后中/10-售后已结束)',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
  `pay_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付时间',
  `refund_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '退款时间',
  `cancel_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '取消时间',
  `payment_agency_short_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '支付机构(缩写之类的)',
  `user_payment_agency_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '使用进行支付的商户收款账号id',
  `third_party_order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '第三方订单id',
  `effect_object` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '使用(作用)对象',
  `score_paid` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '实付积分',
  `score_key_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '支付的积分类型(积分标识符)',
  `coupon_paid` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '优惠券抵扣的金额',
  `score_money` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '积分抵扣的金额',
  `manual_offer` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '手动优惠金额',
  `manual_offer_set_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '手动设置优惠时间',
  `purchase_quantity` int(10) UNSIGNED NOT NULL DEFAULT 1 COMMENT '购买数量',
  `handle_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作员',
  `collection_shop_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '代收店铺id',
  `collection_order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '代收订单id',
  `collection_amount` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '代收金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`, `goods_type`) USING BTREE,
  INDEX `user_payment_agency_id`(`user_payment_agency_id`) USING BTREE,
  INDEX `effect_object`(`effect_object`) USING BTREE,
  INDEX `shop_id_goods_type`(`shop_id`, `goods_type`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `handle_uid`(`handle_uid`) USING BTREE,
  INDEX `collection_shop_id`(`collection_shop_id`) USING BTREE,
  INDEX `collection_order_id`(`collection_order_id`) USING BTREE,
  INDEX `update_time`(`update_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_payment_agency
-- ----------------------------
DROP TABLE IF EXISTS `cf_payment_agency`;
CREATE TABLE `cf_payment_agency`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `short_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简称(唯一标识符)',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `sort_index` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序值',
  `score_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `short_name`(`short_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_qr_code
-- ----------------------------
DROP TABLE IF EXISTS `cf_qr_code`;
CREATE TABLE `cf_qr_code`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二维码类型',
  `source_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源id(例如这个二维码是领优惠券的二维码，那这个id就是优惠券活动id)',
  `creater_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者id(分享券者id)',
  `from_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '赠券人(商家，店铺id)',
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '受赠，使用者id，如果存在则表示该二维码已被使用',
  `image` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二维码图片',
  `create_time` bigint(16) UNSIGNED NOT NULL COMMENT '创建时间',
  `effective_time` bigint(16) UNSIGNED NOT NULL COMMENT '到期时间',
  `source_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 2 COMMENT '资源类型(例如资源类型为优惠券时1-次数全/2-金额券/3-时长券)',
  `quantity` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '数量，如果是资源，表示资源数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `code_type`(`code_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '二维码表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_role
-- ----------------------------
DROP TABLE IF EXISTS `cf_role`;
CREATE TABLE `cf_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `flag_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色关键字(英文名)',
  `department_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门(组)',
  `role_level` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '权限水平(用于同等角色或者不同角色具有相同权限时是否操作对方信息)',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色图标',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `cf_role_auth`;
CREATE TABLE `cf_role_auth`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 角色id',
  `auth_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_score_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_score_type`;
CREATE TABLE `cf_score_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分名称',
  `key_flag` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识符',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `currency_unit` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货币单位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `key_flag`(`key_flag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_sms
-- ----------------------------
DROP TABLE IF EXISTS `cf_sms`;
CREATE TABLE `cf_sms`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '短信类型(1-注册/2-身份验证/3-通知)',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未使用/1-已使用',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `expire_time` bigint(19) UNSIGNED NOT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `phone`(`phone`, `expire_time`) USING BTREE,
  INDEX `phone_2`(`phone`, `code`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '短信发送记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_staff
-- ----------------------------
DROP TABLE IF EXISTS `cf_staff`;
CREATE TABLE `cf_staff`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `employer_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '雇主id',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工id',
  `note` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` bigint(16) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employer_id`(`employer_id`, `staff_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_staff_coupon_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_staff_coupon_log`;
CREATE TABLE `cf_staff_coupon_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coupon_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券id',
  `coupon_activity_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券活动id',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工id',
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '受赠人id(领取优惠券人id)',
  `denomination` decimal(16, 2) UNSIGNED NOT NULL COMMENT '优惠券面额',
  `create_time` bigint(16) UNSIGNED NOT NULL COMMENT '创建时间',
  `recipient_body` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '受赠体',
  `coupon_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 2 COMMENT '优惠券类型(1-次数券/2-金额券/3-时长券)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `coupon_activity_id`(`coupon_activity_id`, `staff_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工发放优惠券记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_staff_coupon_setting
-- ----------------------------
DROP TABLE IF EXISTS `cf_staff_coupon_setting`;
CREATE TABLE `cf_staff_coupon_setting`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `same_day_quota` decimal(22, 2) UNSIGNED NOT NULL COMMENT '当日发券额度',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工id',
  `coupon_activity_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券活动id',
  `coupon_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 2 COMMENT '优惠券类型(1-次数券/2-金额券/3-时长券)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `staff_id`(`staff_id`, `coupon_activity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工发放优惠券设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_subscribe_message_template
-- ----------------------------
DROP TABLE IF EXISTS `cf_subscribe_message_template`;
CREATE TABLE `cf_subscribe_message_template`  (
  `id` bigint(20) UNSIGNED NOT NULL,
  `appid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小程序appid',
  `message_scenes` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息场景',
  `template_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板id',
  `template_contents` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '模板内容',
  `template_notes` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '模板备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `appid`(`appid`, `message_scenes`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订阅通知消息模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_system_config
-- ----------------------------
DROP TABLE IF EXISTS `cf_system_config`;
CREATE TABLE `cf_system_config`  (
  `en_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置键名',
  `zh_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置中文名',
  `value` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置内容(配置值)',
  `note` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置注释',
  PRIMARY KEY (`en_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_tax_account
-- ----------------------------
DROP TABLE IF EXISTS `cf_tax_account`;
CREATE TABLE `cf_tax_account`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tax_agency` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '税务机构缩写名',
  `image` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `config_params` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '其它配置参数',
  `create_time` bigint(13) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) UNSIGNED NOT NULL COMMENT '更新时间',
  `access_token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电子发票平台的access_token',
  `access_token_expired_time` bigint(13) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'access_token过期时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tax_agency`(`tax_agency`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '税务账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_third_party_login
-- ----------------------------
DROP TABLE IF EXISTS `cf_third_party_login`;
CREATE TABLE `cf_third_party_login`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `appid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '应用appid',
  `openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `unionid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `platform` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '平台(wx_mp-微信小程序/wx_wb-微信公众号/wx_app-微信app/toutiao-今日头条)',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `main_body_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主体id(每个主体账号id，例如在自己平台管理中的公众号id)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `platform`(`platform`, `appid`, `unionid`) USING BTREE,
  INDEX `uid`(`uid`, `platform`, `appid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '第三方用户认证记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_third_party_platform_application
-- ----------------------------
DROP TABLE IF EXISTS `cf_third_party_platform_application`;
CREATE TABLE `cf_third_party_platform_application`  (
  `appid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第三方应用平台appid',
  `application_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名称',
  `public_key` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公钥',
  `private_key` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '私钥',
  `platform` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '平台(wx_web-微信公众号/wx_mp-微信小程序/wx_app-微信app/ali_web-阿里公众号/ali_mp-阿里小程序/ali_app-阿里app)',
  `auth_token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '例如支付宝第三方应用授权token',
  `aes_encryption` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '例如支付宝\"接口内容加密方式\"值',
  `original_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '原始id',
  PRIMARY KEY (`appid`) USING BTREE,
  INDEX `platform`(`platform`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '第三方应用开发者账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_third_party_system_call_keys
-- ----------------------------
DROP TABLE IF EXISTS `cf_third_party_system_call_keys`;
CREATE TABLE `cf_third_party_system_call_keys`  (
  `key_id` bigint(20) NOT NULL,
  `use_scenes` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用场景',
  `key_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密钥值',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '密钥开始有效时间',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '密钥失效时间',
  `company_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '企业单位名称',
  `key_notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '注释',
  PRIMARY KEY (`key_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '第三方系统调用本系统密钥表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_transfer_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_transfer_log`;
CREATE TABLE `cf_transfer_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '转账用户id',
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收款用户id',
  `value` decimal(10, 2) NOT NULL COMMENT '金额',
  `status` tinyint(2) UNSIGNED NOT NULL COMMENT '状态(0-已取消/1-进行中/2-已完成/3-已取消/4-失败)',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '产生时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `from_uid`(`from_uid`) USING BTREE,
  INDEX `to_uid`(`to_uid`) USING BTREE,
  INDEX `create_time`(`create_time`, `value`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '转账记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_user`;
CREATE TABLE `cf_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户主键id',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户类型',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `true_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `birthday` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '生日，用户计算年龄',
  `sex` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别(0-保密/1-男/2-女)',
  `sign` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '个性签名',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `last_login_time` bigint(16) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户最近登录时间',
  `id_card_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '身份证状态(0-未上传/1-已经上传但未审核/2-已通过审核)',
  `driver_license_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '驾驶证状态(0-未上传/1-已经上传但未审核/2-已通过审核)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_name`(`user_name`) USING BTREE,
  INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_auth
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_auth`;
CREATE TABLE `cf_user_auth`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员id',
  `auth_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_driver_license
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_driver_license`;
CREATE TABLE `cf_user_driver_license`  (
  `id` bigint(20) NOT NULL,
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint(3) UNSIGNED NOT NULL COMMENT '性别(0-女/1-男/2-未知)',
  `nationality` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '国籍',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '地址',
  `birthday_year` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '生日-年',
  `birthday_month` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '生日-月',
  `birthday_day` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '生日-日',
  `first_issue_year` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '初次领证日期-年',
  `first_issue_month` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '初次领证日期-月',
  `first_issue_day` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '初次领证日期-日',
  `car_class` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '准驾车型',
  `start_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '有效期起',
  `end_time` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '有效期止',
  `certificate_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '证号(例如身份证号)',
  `issuing_authority` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '签发机关',
  `file_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '档案编号',
  `internship_period_ends` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '实习期截至',
  `images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `check_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核状态(0-待审核/1-已审核)',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `qualification_certificate_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '从业资格证件号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `certificate_number`(`certificate_number`) USING BTREE,
  INDEX `phone`(`phone`) USING BTREE,
  INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户驾驶证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_friend
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_friend`;
CREATE TABLE `cf_user_friend`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `friend_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '朋友id',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户好友表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_friend_add_log
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_friend_add_log`;
CREATE TABLE `cf_user_friend_add_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 申请者记录',
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '目标用户id',
  `group_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '群id',
  `create_time` bigint(19) UNSIGNED NOT NULL,
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-等待处理/1-已通过/2-已拒绝3-已忽略)',
  `remark` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '添加备注',
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '记录类型(1-主动申请/2-邀请)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `from_uid`(`from_uid`, `to_uid`, `create_time`) USING BTREE,
  INDEX `from_uid_2`(`from_uid`, `group_id`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '好友(群)申请记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_group
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_group`;
CREATE TABLE `cf_user_group`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群名称',
  `avatar` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '群头像',
  `announcement` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群公告或描述',
  `people` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '群人数',
  `people_cap` smallint(5) UNSIGNED NOT NULL DEFAULT 500 COMMENT '群成员上限',
  `level` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '群等级(星级)',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '群状态(0-正常/1-存在违规内容/2-封群)',
  `creater_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者uid',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '聊天群' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_group_member
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_group_member`;
CREATE TABLE `cf_user_group_member`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群组id',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `level` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '群内等级/职位(0-普通成员/1-管理员/2-群主)',
  `nick_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '群昵称',
  `join_type` tinyint(1) UNSIGNED NOT NULL COMMENT '入群方式(0-创建者自动入驻/1-主动申请/2-邀请)',
  `join_time` bigint(19) UNSIGNED NOT NULL COMMENT '入群时间',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态(1-正常/2-已退群/3-被踢出群)',
  `muted_deadline` bigint(19) NOT NULL DEFAULT 0 COMMENT '禁言截止时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '群成员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_id_card
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_id_card`;
CREATE TABLE `cf_user_id_card`  (
  `id` bigint(20) NOT NULL,
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint(3) UNSIGNED NOT NULL COMMENT '性别(0-女/1-男/2-未知)',
  `nationality` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '民族',
  `birthday_year` smallint(5) UNSIGNED NOT NULL COMMENT '生日-年',
  `birthday_month` tinyint(3) UNSIGNED NOT NULL COMMENT '生日-月',
  `birthday_day` tinyint(3) UNSIGNED NOT NULL COMMENT '生日-日',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `identity_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份号',
  `issuing_authority` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '签发机关',
  `start_time` bigint(20) UNSIGNED NOT NULL COMMENT '有效期起',
  `end_time` bigint(20) UNSIGNED NOT NULL COMMENT '有效期止',
  `images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `check_status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '审核状态(0-待审核/1-已审核)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `identity_number`(`identity_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户身份证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_message
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_message`;
CREATE TABLE `cf_user_message`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `from_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送者',
  `to_uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收者id',
  `group_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组id',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态(0-未读/1-已读/2-已撤回/3-违规消息)',
  `contents` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '消息类型(0-文本/1-文件/2-视频/3-链接)',
  `client` tinyint(1) UNSIGNED NOT NULL COMMENT '客户端类型(0-app/1-PC/2-PC浏览器/3-手机web)',
  `ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '发送ip',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  `receive_time` int(11) NOT NULL COMMENT '接收的时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `from_uid`(`from_uid`, `to_uid`, `status`, `create_time`) USING BTREE,
  INDEX `group_id`(`group_id`, `status`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_payment_agency
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_payment_agency`;
CREATE TABLE `cf_user_payment_agency`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 机构名称',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `payment_agency_short_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构缩写',
  `pay_key` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'key私钥',
  `secret` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `appid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `sub_appid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '子商户appid',
  `account_number_note` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号备注',
  `mch_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商户号',
  `sub_mch_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '子商户号',
  `cert_path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '证书路径',
  `pay_notify_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付通知地址',
  `refund_pay_notify_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付退款通知地址',
  `use_scenes` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '使用场景(wx_web微信网页/wx_mp微信小程序/app/ali_web阿里网页/web-网页通用)',
  `auth_token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '授权token，例如支付宝第三方应用授权token',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uid`(`uid`, `payment_agency_short_name`, `use_scenes`) USING BTREE,
  INDEX `use_scenes`(`use_scenes`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户支付机构表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for cf_user_role
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_role`;
CREATE TABLE `cf_user_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_user_source
-- ----------------------------
DROP TABLE IF EXISTS `cf_user_source`;
CREATE TABLE `cf_user_source`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `source_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源id',
  `source_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源类型(carpark-停车场/order-订单)',
  `uid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `allow_edit` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许编辑(0-否/1-是)',
  `allow_delete` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否允许删除(0-否/1-是)',
  `creater_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `source_id`(`source_id`, `source_type`, `uid`, `creater_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户资源放行表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cf_weixin_config
-- ----------------------------
DROP TABLE IF EXISTS `cf_weixin_config`;
CREATE TABLE `cf_weixin_config`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `en_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '英文名(唯一标识符)',
  `zh_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '中文名',
  `use_scenes` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用场景',
  `value` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置值',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `create_time` bigint(19) UNSIGNED NOT NULL COMMENT '创建时间',
  `update_time` bigint(19) UNSIGNED NOT NULL COMMENT '更新时间',
  `expire_time` bigint(19) UNSIGNED NOT NULL DEFAULT 0 COMMENT '到期时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `en_name`(`en_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '微信配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL,
  `refresh_token` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
