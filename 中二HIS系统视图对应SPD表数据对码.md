## 中二HIS系统视图对应SPD表数据对码

### 一、视图名： view\_pis\_druginfo   /   药品主数据视图

| 列名                      | 解释     | SPD                            | 解释     | 说明   |
| ----------------------- | ------ | ------------------------------ | ------ | ---- |
| HIS\_CODE               | 编码     | YDS\_GOODS.goods\_code         | 编码     |      |
| HIS\_VMNO               | 自定义码   | YDS\_GOODS.mCode               | 助记码    |      |
| HIS\_INN                | 通用名    | YDS\_GOODS.ware\_name          | 名称     |      |
| HIS\_TRADE\_NAME        | 商品名    | YDS\_GOODS.goods\_name         | 通用名    |      |
| HIS\_PRODUCE\_NAME      | 产品名    | YDS\_GOODS.GOODS\_FORMAT\_NAME | 格式化名称  |      |
| HIS\_SPECIFICATION      | 规格     | YDS\_GOODS.goods\_spec         | 规格/型号  |      |
| DRUG\_FORM              | 剂型     | YDS\_GOODS.goods\_Model        | 剂型     |      |
| MANUFACTORY\_CODE       | 生产厂家编码 |                                |        |      |
| MANUFACTORY\_NAME       | 生产厂家名称 | YDS\_GOODS.fact\_Name          | 厂家     |      |
| LICENSE\_NUMBER         | 批准文号   | YDS\_GOODS.ath\_Doc            | 批准文号   |      |
| BUY\_PRICE              | 采购价    |                                |        |      |
| RET\_PRICE              | 零售价    | YDS\_GOODS.MARKET\_PRICE       | 市场价    |      |
| FIX\_PRICE              | 批发价    |                                |        |      |
| MIN\_UNIT               | 最小单位   | YDS\_GOODS.UNIT\_BASE\_NAME    |        |      |
| PACK\_UNIT              | 包装单位   | YDS\_GOODS.UNIT\_MIN\_NAME     |        |      |
| PURCHASE\_UNIT          | 采购单位   | YDS\_GOODS.PURCH\_UNIT\_LV     |        |      |
| PACK\_UNIT\_RATIO       | 包装系数   | YDS\_GOODS.UNIT\_MIN\_SUM      |        |      |
| PURCHAS\_UNIT\_RATIO    | 采购系数   |                                |        |      |
| COMMON\_DOSAGE\_QUATITY | 常规剂量   |                                |        |      |
| DOSAGE\_UNIT            | 剂量     |                                |        |      |
| DRUG\_TYPE              | 药品类型   | YDS\_GOODS.GOODS\_TYPE         | 药品类型   |      |
| DRUG\_PHAMAC\_CLASS     | 药理类别   |                                |        |      |
| DRUG\_SOURCE            | 药品来源   |                                |        |      |
| DRUG\_CLASS             | 药品分类   |                                |        |      |
| POISON\_CLASS           | 毒性分类   |                                |        |      |
| OTC\_MARK               | 是否OTC  |                                |        |      |
| IS\_EMERGENCY           | 是否     |                                |        |      |
| IS\_VALUABLE            | 是否贵重   |                                |        |      |
| IS\_TEMPORARY           | 是否临时用药 |                                |        |      |
| IS\_SPECIAL             | 是否特殊   |                                |        |      |
| IS\_PUBLIC\_DRUG        | 是否公药   |                                |        |      |
| IS\_POISON              | 是否毒药   |                                |        |      |
| IS\_OWN\_EXPRNSE        | 是否自费   |                                |        |      |
| IS\_ONE\_INGREDIENT     |        |                                |        |      |
| IS\_MORE\_INGREDIENTS   |        |                                |        |      |
| GMP\_MARK               | 是否GMP  |                                |        |      |
| IS\_USE                 | 是否启用   | YDS\_GOODS.ENABLED             | 是否启用   |      |
| CREATE\_DATE            | 创建时间   | YDS\_GOODS.CREATE\_DATE        | 药品创建时间 |      |
| UPDATE\_DATE            | 更新时间   | YDS\_GOODS.LAST\_DATE          | 药品更改时间 |      |

### 二、视图名：view\_pis\_deptinfo   /  部门主数据

| 列名                 | 解释    | SPD                    | 解释     | 说明          |
| ------------------ | ----- | ---------------------- | ------ | ----------- |
| HIS\_DEPT\_CODE    | 部门编码  | PCS\_DEPT.DEPT\_CODE   | 部门编码   |             |
| HIS\_DEPT\_NAME    | 部门名称  | PCS\_DEPT.DEPT\_NAME   | 部门名称   |             |
| HIS\_STORAGE\_CODE | 库存地编码 | PCS\_DEPOT.DEPOT\_CODE | 仓库地址编码 | SEC该字段是否增加？ |
| IS\_USE            | 是否启用  | PCS\_DEPT.ENABLED      | 是否启用   |             |
| CREATE\_DATE       | 创建时间  | PCS\_DEPT.CREATE\_DATE | 创建时间   |             |
| UPDATE\_DATE       | 更新时间  | PCS\_DEPT.LAST\_DATE   | 最后修改时间 |             |

### 三、视图名：view\_pis\_supplyer    /   供应商主数据

| 列名             | 解释    | SPD                   | 解释     | 说明   |
| -------------- | ----- | --------------------- | ------ | ---- |
| SUPPLYER\_CODE | 供应商编码 | PCS\_ORG.ORG\_CODE    | 机构编码   |      |
| SUPPLYER\_NAME | 供应商名称 | PCS\_ORG.ORG\_NAME    | 机构名称   |      |
| IS\_USE        | 是否启用  | PCS\_ORG.ENABLED      | 是否启用   |      |
| CREATE\_DATE   | 创建时间  | PCS\_ORG.CREATE\_DATE | 机构创建时间 |      |
| UPDATE\_DATE   | 更新时间  | PCS\_ORG.LAST\_DATE   | 最后修改时间 |      |



### 四、视图名：view\_pis\_order\_instore      /    入库单

| 列名                  | 解释     | SPD                              | 解释    | 说明   |
| ------------------- | ------ | -------------------------------- | ----- | ---- |
| BATCH\_CODE         | 批号     | SPD\_RECEIVE\_ITEM.LOT\_NO       |       |      |
| BUY\_CAL\_PRICE     | 采购金额   | SPD\_RECEIVE\_ITEM.PLAN\_AMOUNT  |       |      |
| BUY\_PRICE          | 采购价    | SPD\_RECEIVE\_ITEM.unit\_Price   |       |      |
| EFF\_DATE           | 效期     | SPD\_RECEIVE\_ITEM.LOT\_VALIDITY |       |      |
| HIS\_DRUG\_CODE     | 药品编码   | YDS\_GOODS.goods\_code           |       |      |
| HIS\_INN            | 药品通用名  | YDS\_GOODS.goods\_name           |       |      |
| HIS\_SPECIFICATION  | 规格     | YDS\_GOODS.goods\_spec           |       |      |
| HIS\_TRADE\_NAME    | 商品名    | YDS\_GOODS.ware\_name            |       |      |
| IN\_AMOUNT          | 入库数量   | SPD\_RECEIVE\_ITEM.check\_Qty    |       |      |
| IN\_UNIT            | 入库单位   | SPD\_RECEIVE\_ITEM.UNIT\_NAME    |       |      |
| INSTORE\_DATE       | 入库时间   | SPD\_RECEIVE.CFM\_RECEIVE\_DATE  |       |      |
| INSTORE\_DEPT\_CODE | 入库部门编码 | PCS\_DEPT.DEPT\_CODE             | 部门编码  |      |
| INSTORE\_ITEM\_ID   | 入库行ID  |                                  |       |      |
| INSTORE\_NO         | 入库单号   | SPD\_RECRIVE.RECEIVE\_CODE       | 收货单号  |      |
| INSTORE\_TYPE       | 入库类型   | SPD\_RECRIVE.RECEIVE\_TYPE       | 收货单类型 |      |
| INVOICE\_DATE       | 发票时间   | SPD\_RECRIVE.CREATE\_DATE        | 创建时间  |      |
| INVOICE\_NO         | 发票号    | SPD\_RECRIVE\_ITEM.FAX\_NO       | 发票号   |      |
| INVOICE\_PRICE      | 发票金额   | SPD\_RECRIVE\_ITEM.CHECK\_AMOUNT | 确认金额  |      |
| LICENSE\_NUMBER     | 批准文号   | YDS\_GOODS.ath\_Doc              | 批准文号  |      |
| MANUFACTORY\_CODE   | 厂家编码   |                                  |       |      |
| MANUFACTORY\_NAME   | 厂家名称   | YDS\_GOODS.fact\_Name            | 生产厂家  |      |
| RET\_PRICE          | 零售价    |                                  |       |      |
| STORAGE\_ROOM\_CODE | 库存地    | PCS\_DEPOT.DEPOT\_NAME           | 仓库地址  |      |
| SUPPLYER\_CODE      | 供应商编码  |                                  |       |      |
| SUPPLYER\_NAME      | 供应商名称  | PCS\_ORG.ORG\_NAME               | 供应商名  |      |

### 五、视图名：view\_pis\_claim   / 请领单

| 列名                 | 解释    | SPD                              | 说明      |
| ------------------ | ----- | -------------------------------- | ------- |
| CLAIM\_ITEM\_ID    | 请领行ID | SPD\_APPLY\_REQ.APPLY\_REQ\_ID   | 请领计划单ID |
| CLAIM\_NO          | 请领单号  | SPD\_APPLY\_REQ.APPLY\_REQ\_CODE | 请领计划单编码 |
| WRITE\_DEPT\_CODE  | 写入部门  |                                  |         |
| CLAIM\_DEPT\_CODE  | 请领部门  | SPD\_APPLY\_REQ.TO\_DEPT\_ID     | 收货部门    |
| DEAL\_DEPT\_CODE   | 处理部门  | SPD\_APPLY\_REQ.FROM\_DEPT\_ID   | 发货部门    |
| CLAIM\_USER\_ID    | 请领人ID | SPD\_APPLY\_REQ.CREATE\_USER     | 创建用户 ID |
| CLAIM\_USER\_NAME  | 请领人姓名 | PCS\_USER.USER\_NAME             | 创建用户名   |
| CLAIM\_DATE        | 请领日期  | SPD\_APPLY\_REQ.CREATE\_DATE     | 创建时间    |
| HIS\_DRUG\_CODE    | 药品编码  | YDS\_GOODS.GOODS\_CODE           |         |
| HIS\_INN           | 药品通用名 | YDS\_GOODS.goods\_name           |         |
| HIS\_TRADE\_NAME   | 商品名   | YDS\_GOODS.ware\_name            |         |
| HIS\_SPECIFICATION | 规格    | YDS\_GOODS.goods\_spec           |         |
| IN\_UNIT           | 请领单位  | PCS\_ORG.ORG\_NAME               | 机构名     |
| IN\_AMOUNT         | 请领数量  | SPD\_APPLY\_REQ.PLAN\_QTY        | 计划数量    |
| BUY\_PRICE         | 采购价   | SPD\_APPLY\_REQ.UNIT\_PRICE      |         |
| BUY\_CAL\_PRICE    | 采购金额  |                                  |         |
| RET\_PRICE         | 零售价   |                                  |         |
| LICENSE\_NUMBER    | 批准文号  | YDS\_GOODS.ath\_Doc              |         |
| MANUFACTORY\_CODE  | 厂家编码  |                                  |         |
| MANUFACTORY\_NAME, | 厂家名称  | YDS\_GOODS.fact\_Name            |         |
| BillNo             | 原单号   |                                  |         |







待完善