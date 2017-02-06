#### IP地址：120.77.2.93
#### 用户名：root
#### 密码：0p;(OL8ik






# Oracle数据库Linux下的导入IMP
---
### EXP相对应的用了如下的导入方法。

[oracle@localhost ~]$ **imp**

Import: Release 11.2.0.1.0 - Production on Fri Sep 26 16:17:48 2014

Copyright (c) 1982, 2009, Oracle and/or its affiliates. All rights reserved.

Username: yard_dev
Password:ak123456

Connected to: Oracle Database 11g Enterprise Edition Release 11.2.0.1.0 - 64bit Production
With the Partitioning, OLAP, Data Mining and Real Application Testing options

#### Import data only (yes/no): no >【回车】-----选择默认的意思

#### Import file: expdat.dmp > tachiai.dmp

IMP-00002: failed to open tachiai.dmp for read -----这里出了个错误，于是我指定了绝对路径
Import file: expdat.dmp > /opt/oracle/tachiai.dmp

#### Enter insert buffer size (minimum is 8192) 30720>【回车】-----选择默认的意思

Export file created by EXPORT:V11.02.00 via conventional path
import done in US7ASCII character set and AL16UTF16 NCHAR character set
import server uses JA16SJIS character set (possible charset conversion)
#### List contents of import file only (yes/no): no >【回车】-----选择默认的意思

#### Ignore create error due to object existence (yes/no): no >YES【回车】-----选择默认的意思

#### Import grants (yes/no): yes >【回车】-----选择默认的意思

#### Import table data (yes/no): yes >【回车】-----选择默认的意思

#### Import entire export file (yes/no): no > 【回车】-----选择默认的意思
#### Username: yard_biz

Enter table(T) or partition(T:P) names. Null list means all tables for user
Enter table(T) or partition(T:P) name or . if done:【回车】-----选择默认的意思

 


<br><br/>
<br><br/>
<br><br/>
<br><br/>



### 修改客户端导出的字符集

set NLS_LANG=american_america.AL32UTF8



### 查询数据字符集
select * from v$nls_parameters



三. 客户端关于Oracle的字符集编码设置
 

客户端与服务器端字符集不一致时可能导致cmd或者shell显示乱码：

Windows:
# 常用中文字符集
set NLS_LANG=american_america.AL32UTF8(仅在此cmd窗口立即生效)
# 常用unicode字符集
set NLS_LANG=american_america.AL32UTF8
可以通过修改注册表键值永久设置
HKEY_LOCAL_MACHINE/SOFTWARE/ORACLE/KEY_OraDb11g_home1/NLS_LANG(任何窗口生效，但是需要重启系统生效)

#通过属性-高级系统设置-环境变量加入

NLS_LANG=american_america.AL32UTF8环境变量(此环境变量优先级高于注册表环境变量)

 

Unix:
# 常用unicode字符集
export NLS_LANG=american_america.AL32UTF8
# 常用中文字符集
export NLS_LANG="Simplified Chinese_china".ZHS16GBK
可以编辑 bash_profile文件进行永久设置
vi .bash_profile
export NLS_LANG=american_america.AL32UTF8

# 使 bash_profile设置生效
source .bash_profile


## **文件部署网页格式本地测试**
generate-md --layout mixu-gray --input ./input --output .\output


