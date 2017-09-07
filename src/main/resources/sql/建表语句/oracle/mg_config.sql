
DROP TABLE mg_config;
CREATE TABLE mg_config
(
  ID          VARCHAR2(32) NOT NULL,
  classify        VARCHAR2(128),
  code_name  VARCHAR2(512) ,
  code_value VARCHAR2(512),
  enabled VARCHAR2(32),
  memo VARCHAR2(2048) ,
  create_user_name     VARCHAR2(64) ,
  create_date          date ,
  update_user_name     VARCHAR2(64),
  update_date          date ,
  PRIMARY KEY (ID)
) 
;

COMMENT on table mg_config is '配置表'; 
COMMENT on column mg_config.classify is  '分类';
COMMENT on column mg_config.code_name is  '名称';
COMMENT  on column mg_config.code_value is '值';
COMMENT on column mg_config.enabled is  '是否有效 1有效 0无效';
COMMENT on column mg_config.memo is  '备注';
COMMENT on column mg_config.create_user_name is '创建人';
COMMENT on column mg_config.create_date is  '创建日期';
COMMENT on column mg_config.update_user_name is '修改人';
COMMENT on column mg_config.update_date is  '修改日期';

