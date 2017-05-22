##  一、 登录服务器 

## 二 、 查看磁盘空间是否够大df -h

#### 1.-h更具目前磁盘空间和使用情况 以更易读的方式显示**

    [root@rac1 ~]# df -h
    Filesystem Size Used Avail Use% Mounted on
    /dev/sda1 2.9G 2.3G 521M 82% /
    none 209M 0 209M 0% /dev/shm
    /dev/sda2 4.5G 1.8G 2.5G 42% /u01
    /dev/sde1 512M 80M 433M 16% /ocfs
 
####  2.-H根上面的-h参数相同,不过在根式化的时候,采用1000而不是1024进行容量转换

    [root@rac1 ~]# df -H
    Filesystem Size Used Avail Use% Mounted on
    /dev/sda1 3.1G 2.4G 546M 82% /
    none 219M 0 219M 0% /dev/shm
    /dev/sda2 4.8G 1.9G 2.7G 42% /u01
    /dev/sde1 537M 84M 454M 16% /ocfs

####   3.-k以单位显示磁盘的使用情况
    [root@rac1 ~]# df -k
    Filesystem 1K-blocks Used Available Use% Mounted on
    su - oracle              切换到oracle用户（linux的一个用户名）
### 三 、 在/home/oracle/oradata 目录下新建一个文件夹，后面创建表空间需要用到
     cd /home/oracle/oradata
     mkdir abc
## 四 、以dba身份登录数据库， 系统的超级用户
    sqlplus “/ as sysdba” 

## 五 、创建临时表空间

#### 1. 创建用户前必须要先创建临时表空间和数据库表空间两个表空间，否则用系统默认的表空间不好。
 
#####  create temporary tablespace abc_temp tempfile'/home/oracle/oradata/abc/abc__temp.dbf' size 1024m autoextend on next 100m maxsize 10240m extent management local;
####2.说明：

        1)abc_temp 临时表空间名字
        2)/home/oracle/oradata/abc 存放数据库文件的地方，一般是安装数据库后有控制文件，数据文件和日志文件的文件夹，再加上要创建表空间的名字+dbf （数据文件）
        3)1024m     表空间的初始大小
        4)100m       表空间的自动增长大小
        5)10240m     表空间最大的大小
 
## 六 、创建数据表空间
    create tablespace abc logging datafile'/home/oracle/oradata/abc/abc.dbf' size 1024m autoextend on next 100m maxsize 10240m extent management local;
 
## 七 、创建用户并指定表空间
    create user abc identified by abc default tablespace abc temporary tablespace abc_temp;
    注：create standardtable.sql   创建表
## 八 、给用户授予权限
    grant dba to abc; （给abc 用户授予了dba 所有权限）
 
## 九 、删除用户以及用户所有的对象

     drop user zfmi cascade;

  cascade 参数是级联删除该用户所有对象，经常遇到如用户有对象而未加此参数则用户删不了的问题，所以习惯性的加此参数
 
    删除oracle 用户nim 出现下面的错误:
      
     SQL> drop user nim cascade;
     drop user nim cascade
     ERROR 位于第 1 行:
     ORA-00604: 递归 SQL 层 1 出现错误
     ORA-24005: 必须使用 DBMS_AQADM.DROP_QUEUE_TABLE 删除队列表

    处理方式：
     先执行这条语句：alter session set events'10851 trace name context forever,level 2';
     再执行：drop user nim cascade; 删除用户nim
## 十、删除表空间
    前提：删除表空间之前要确认该表空间没有被其他用户使用之后再做删除
#### drop tablespace nimeng including contents and datafiles cascade constraints ;
    including contents 删除表空间中的内容，如果删除表空间之前表空间中有内容，而未加此参数，表空间删不掉，所以习惯性的加此参数
    including datafiles 删除表空间中的数据文件
    cascade constraints 同时删除 tablespace 中表的外键参照

#### 如果在清除表空间之前，先删除了表空间对应的数据文件，会造成数据库无法正常启动和关闭。可使用如下方法恢复：
    下面的过程中， filename 是已经被删除的数据文件，如果有多个，则需要多次执行； tablespace_name 是相应的表空间的名称。
    $ sqlplus /nolog
    SQL> conn / as sysdba;
    如果数据库已经启动，则需要先执行下面这行：
    SQL> shutdown abort
    SQL> startup mount
    SQL> alter database datafile 'filename' offline drop;
    SQL> alter database open;
    SQL> drop tablespace tablespace_name including contents;
## 十一 、导出/ 导入
### 导出
#####  1) 将数据库 TEST 完全导出 , 用户名 system 密码 manager 导出到 D:daochu.dmp 中
     exp system/manager@TEST file=d: / daochu.dmp full=y
##### 2) 将数据库中 system 用户与 sys 用户的表导出
    exp system/manager@TEST file=d: / daochu.dmp owner=(system,sys)
##### 3) 将数据库中的表 inner_notify 、 notify_staff_relat 导出
    exp aichannel/aichannel@TESTDB2 file= d: / datanewsmgnt.dmp tables=(inner_notify,notify_staff_relat)
##### 4) 将数据库中的表 table1 中的字段 filed1 以 "00" 打头的数据导出
    exp system/manager@TEST file=d:daochu.dmp tables=(table1) query=" where filed1 like '00%'"
上面是常用的导出，对于压缩，既用 winzip 把 dmp 文件可以很好的压缩。
也可以在上面命令后面 加上 compress=y 来实现。
### 导入
##### 1) 将 D:daochu.dmp 中的数据导入 TEST 数据库中。
    imp system/manager@TEST file=d:daochu.dmp
    imp aichannel/aichannel@HUST full=y file=d:datanewsmgnt.dmp ignore=y
    上面可能有点问题，因为有的表已经存在，然后它就报错，对该表就不进行导入。在后面加上 ignore=y 就可以了。
#### 2) 将 d:daochu.dmp 中的表 table1 导入
    imp system/manager@TEST file=d:daochu.dmp tables=(table1)
基本上上面的导入导出够用了。不少情况要先是将表彻底删除，然后导入。
##### 注意：
 操作者要有足够的权限，权限不够它会提示。
  数据库时可以连上的。可以用 tnsping TEST 来获得数据库 TEST 能否连上。 
## 十二 、 给用户增加导入数据权限的操作

#### 1) 启动 sql*puls

#### 2) 以 system/manager 登陆

#### 3)create user 用户名 IDENTIFIED BY 密码

#### 4)GRANT CREATE USER,DROP USER,ALTER USER,CREATE ANY VIEW，DROP ANY VIEW,EXP_FULL_DATABASE,IMP_FULL_DATABASE,DBA,CONNECT,RESOURCE,CREATE SESSION TO 用户名字

#### 5) 进入 dmp 文件所在的目录 
    imp userid=system/manager full=y file=*.dmp
    或者 imp userid=system/manager full=y file=filename.dmp

## 十三、修改用户所属表的默认表空间

### 第一步：将表迁移到目标表空间
 * 使用如下语句，可以将需要移动的表空间语句在pl/sql中列出来，
 
        select 'alter table ' ||table_name || ' move tablespace 目标表空间名称;' from user_all_tables where tablespace_name='源表空间名称'
   * 例如：登录数据库用户TEST。将TEST所有表从SYSTEM表空间迁移到USERS表空间。
    
            select 'alter table ' ||table_name || ' move tablespace users;' from user_all_tables where tablespace_name='SYSTEM';
将PL/SQL中列出来的语句执行一次，就完成表的迁移。

   * 将上面语句的结果拷贝到sql文件1.sql中
* 第二步：重新生成索引：
  * 1)使用如下语句，生成重新编译索引语句：
  
            SELECT 'alter index ' || index_name || ' rebuild tablespace users;' FROM user_indexes WHERE index_type = 'NORMAL' AND table_owner = 'SDHY_DEV' AND dropped = 'NO';
  * 注意：index_type包括两种类型'NORMAL'为普通表，'LOB'为blob或者clob字段生成的索引，<br> 在这里要排除掉DROPPED包括YES和NO两种类型，为YES时是废弃的索引
  * 将上面语句的结果拷贝到sql文件2.sql中
* 第三步：批量执行操作：
  * 将第一步与第二步列出的语句放在SQL执行窗口中执行，就可以实现表数据及索引迁移


## 十四、oracle索引修复
    select index_name ,status  from user_indexes where Status = 'UNUSABLE' ;


    select 'alter index ' || index_name || ' rebuild;' from user_indexes where Status = 'UNUSABLE' ;





## 十四、ORACLE使用

    查询表空间所有表：select table_name from all_tables where TABLESPACE_NAME='表空间' 表空间名字一定要大写。

    查询表所在的表空间：select * from user_tables where table_name=‘表名';表名一定要大写；