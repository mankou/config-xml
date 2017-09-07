
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

COMMENT on table mg_config is '���ñ�'; 
COMMENT on column mg_config.classify is  '����';
COMMENT on column mg_config.code_name is  '����';
COMMENT  on column mg_config.code_value is 'ֵ';
COMMENT on column mg_config.enabled is  '�Ƿ���Ч 1��Ч 0��Ч';
COMMENT on column mg_config.memo is  '��ע';
COMMENT on column mg_config.create_user_name is '������';
COMMENT on column mg_config.create_date is  '��������';
COMMENT on column mg_config.update_user_name is '�޸���';
COMMENT on column mg_config.update_date is  '�޸�����';

