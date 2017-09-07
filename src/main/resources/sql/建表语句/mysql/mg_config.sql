
DROP TABLE IF EXISTS mg_config;
CREATE TABLE mg_config
(
  ID          VARCHAR(32) NOT NULL,
  classify        VARCHAR(128) COMMENT '分类',
  code_name  VARCHAR(512) COMMENT '名称',
  code_value VARCHAR(512) COMMENT '值',
  enabled VARCHAR(32) COMMENT '是否有效 1有效 0无效',
  memo VARCHAR(2048) COMMENT '备注',
  create_user_name     VARCHAR(64) COMMENT '创建人',
  create_date          DATETIME COMMENT '创建日期',
  update_user_name     VARCHAR(64) COMMENT '修改人',
  update_date          DATETIME COMMENT '修改日期',
  PRIMARY KEY (ID)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT='配置表'
;

