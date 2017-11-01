

-- Create table
create table USER_INFO
(
  USER_ID       NUMBER(11) not null,
  USER_NAME     VARCHAR2(32) not null,
  BIRTHDAY      DATE,
  SEX           CHAR(2),
  ADDRESS       VARCHAR2(256),
  AGE           NUMBER(10),
  USER_PASSWORD VARCHAR2(100) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 8
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table USER_INFO
  is '�û� ';
-- Add comments to the columns 
comment on column USER_INFO.USER_NAME
  is '�û�����';
comment on column USER_INFO.BIRTHDAY
  is '����';
comment on column USER_INFO.SEX
  is '�Ա�';
comment on column USER_INFO.ADDRESS
  is '��ַ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_INFO
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
