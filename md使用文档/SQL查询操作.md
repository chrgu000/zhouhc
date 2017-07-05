SQL查询操作

~~~sql lite
select g.goods_code,g.goods_name ,s.shelf_name from yds_goods g ,spd_depot_card c ,pcs_depot_shelf s where g.goods_id=c.goods_id and c.shelf_id= s.shelf_id and c.depot_id='ff8080815bf15034015bf15dd88f09c8';
~~~

