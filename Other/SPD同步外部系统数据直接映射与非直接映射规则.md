## SPD同步外部系统数据直接映射与非直接映射规则

### 直接映射

#### 对应表：

#### **SPD表：**YDS_GOODS

**HIS表：**view\_pis\_druginfo

| 字段         | 字段名  | HIS表字段             | HIS表字段名 | 说明   |      |
| ---------- | ---- | ------------------ | ------- | ---- | ---- |
| GOODS_CODE | 药品编码 | IS\_CODE           | 编码      |      |      |
| M_CODE     | 助记码  | HIS\_VMNO          | 自定义码    |      |      |
|            | 通用名  | HIS\_INN           | 通用名     |      |      |
|            |      | HIS\_TRADE\_NAME   | 商品名     |      |      |
|            |      | HIS\_PRODUCE\_NAME | 产品名     |      |      |
|            |      | HIS\_SPECIFICATION | 规格      |      |      |
|            |      | DRUG\_FORM         | 剂型      |      |      |
|            |      | MANUFACTORY\_NAME  | 生产厂家名称  |      |      |
|            |      | LICENSE\_NUMBER    | 批准文号    |      |      |
|            |      | BUY\_PRICE         | 采购价     |      |      |
|            |      | RET\_PRICE         | 零售价     |      |      |
|            |      | FIX\_PRICE         | 批发价     |      |      |
|            |      | MIN\_UNIT          | 最小单位    |      |      |
|            |      | PACK\_UNIT         | 包装单位    |      |      |
|            |      | PURCHASE\_UNIT     | 采购单位    |      |      |
|            |      | PACK\_UNIT\_RATIO  | 包装系数    |      |      |
|            |      | DRUG\_TYPE         | 药品类型    |      |      |
|            |      | IS\_USE            | 是否启用    |      |      |
|            |      | CREATE\_DATE       | 创建时间    |      |      |
|            |      | UPDATE\_DATE       | 更新时间    |      |      |



**SPD表：**PCS_ORG

**HIS表：**view\_pis\_supplyer

| 字段           | 字段名    | HIS表字段         | HIS表字段名 | 说明   |
| ------------ | ------ | -------------- | ------- | ---- |
| ORG\_CODE    | 机构编码   | SUPPLYER\_CODE | 供应商编码   |      |
| ORG\_NAME    | 机构名    | SUPPLYER\_NAME | 供应商名称   |      |
| ORG\_ABBR    | 简称     | SUPPLYER\_NAME | 供应商名称   |      |
| ENABLED      | 禁用标记   | IS\_USE        | 是否使用    |      |
| CREATE\_DATE | 创建时间   | CREATE\_DATE   | 创建时间    |      |
| LAST\_DATE   | 最后修改时间 | UPDATE\_DATE   | 更新时间    |      |



### 非直接映射

#### 对应表

**SPD表：**PCS_ORG

| 字段                | 字段名       | 字段属性默认值    | 说明   |      |
| ----------------- | --------- | ---------- | ---- | ---- |
| ORG\_ID           | 机构ID      | 自动生成       |      |      |
| USER\_COUNT       | 允许账户个数    | 2          |      |      |
| ORG\_REG\_NO      | 组织机构代码号   | 0000       |      |      |
| ORG\_TAX\_NO      | 税务登记号     | 0000       |      |      |
| ORG\_C\_ADDRESS   | 注册地址      | 待完善        |      |      |
| ORG\_O\_ADDRESS   | 办公地址      | 待完善        |      |      |
| ORG\_TYPE\_NAME   | 企业类型：字典选择 | 国有企业       |      |      |
| ORG\_LEGAL        | 法人代表      | 待完善        |      |      |
| ORG\_SCOPE        | 经营范围      | 医药配送       |      |      |
| ORG\_CREATE\_DATE | 注册日期      | 2000-01-01 |      |      |
| ORG\_EXP\_DATE    | 注册证有效期    | 2099-12-31 |      |      |
| IS\_SALER\_FLAG   | IS 卖方     | 1          |      |      |
| IS\_BUYER\_FLAG   | IS 买方     | 0          |      |      |
| IS\_STORAGE\_FLAG | IS 仓储     | 0          |      |      |
| IS\_TRANS\_FLAG   | IS 物流     | 1          |      |      |
| IS\_AGENT\_FLAG   | IS 代理     | 0          |      |      |
| IS\_GOV\_FLAG     | IS 政府     | 0          |      |      |
| IS\_BANK\_FLAG    | IS 银行     | 0          |      |      |
| IS\_MAIN\_FLAG    | IS 应用场主机构 | 0          |      |      |
| YARD\_ID          | 业务场ID     | 626        |      |      |
| CHECK\_STATE      | 状态        | 2          |      |      |
| CREATE\_USER      | 创建用户      | 626        |      |      |
| CREATE\_YARD      | 创建业务场     | 626        |      |      |
| CREATE\_ORG       | 创建机构      | 626        |      |      |
| LAST\_USER        | 修改用户      | 626        |      |      |
| LAST\_YARD        | 修改业务场     | null       |      |      |
| LAST\_ORG         | 修改机构      | null       |      |      |
| SYNC\_DATE        | 同步时间      | null       |      |      |
| CLEAN\_DATE       |           | null       |      |      |
| DESCRIBE          | 备注        | null       |      |      |