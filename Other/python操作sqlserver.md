##基于windows64位环境Python2.7操作sqlserver数据库
###使用pymssql
####1.下载pymssql-2.1.3-cp27-cp27m-win_amd64.whl
####2：打开cmd切换到pymssql目录,安装pumssql
	pip install pymssql-2.1.3-cp27-cp27m-win_amd64.whl
####3： 添加pymssql包
1. 点击File -> Settings
2. Project:test -> Project Interpreter
3. 双击pymssql,点击Install Package

####4：引用pymssql 
	import pymssql
####5:连接sqlserver
	ms_conn = pymssql.connect(host='10.1.1.40:1433',
    user='sa', password='ak1234!', database='spd')
####6：获得数据库游标
	ms_cur=ms_conn.cursor()  
