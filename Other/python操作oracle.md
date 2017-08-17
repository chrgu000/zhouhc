##基于windows64位环境Python2.7操作oracle数据库
###使用cx_Oracle
####1：下载cx_Oracle-5.2.1-11g.win-amd64-py27.exe
####2：添加环境变量ORACLE_HOME,变量内容为64位oracle客户端安装位置
####3：添加环境变量 LD\_LIBRARY_PATH 变量值为：
	%LD_LIBRARY_PATH%;%ORACLE_HOME%
####4：安装cx_Oracle
####5：引用cx_Oracle 
	import cx_Oracle
####6:连接Oracle
	dsn=cx_Oracle.makedsn("120.77.2.93", 1521, "orcl11g")
	ora_conn=cx_Oracle.connect(username,password,dsn)
####7：获得数据库游标
	ora_cur=ora_conn.cursor()  


###注意：
####1：可以在oracle客户端主目录\NETWORK\ADMIN添加tnsnames.ora，在文件里面配置dns，步骤5中可以直接用dsn
####2：不要把oci.dll移到site-packages