# SSM项目接口文档

## 1.课程模块

### 1.1 查询&条件查询

**接口地址**: http://localhost:8080/ssm-web/course/findAllCourse

**请求方式**: POST

**接口描述**: 分页获取课程列表数据&多条件查询

**请求参数**:

| 参数名称    | 参数说明 | in   | 是否必须 | 数据类型       | schema |
| ----------- | -------- | ---- | -------- | -------------- | ------ |
| currentPage |          |      | false    | integer(int32) |        |
| pageSize    |          |      | false    | integer(int32) |        |
| courseName  |          |      | false    | string         |        |
| status      |          |      | false    | integer(int32) |        |

**请求示例**:

```json
{
	"currentPage": 1,
	"pageSize": 5,
	"courseName": "Vue.js 3.0 核心源码解析",
	"status": 1
}
```

**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例**:

```json
{
	"success": true,
	"state": 0,
	"message": "响应成功",
	"content": {课程数据}
}
```

### 1.2 图片上传接口

**接口地址**: http://localhost:8080/ssm-web/course/courseUpload

**请求方式**: POST

**接口描述**: 课程模块图片上传

**请求参数:**

```
file=1597112871741.JPG
```

**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例:**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "fileName": "1597112871741.JPG",
        "filePath": "http://localhost:8080/upload/1597112871741.JPG"
    }
}
```

### 1.3 新建&修改课程接口

**接口地址**: http://localhost:8080/ssm-web/course/saveOrUpdateCourse 

**请求方式**: POST

**接口描述**: 新建课程或修改课程

**请求参数**: 

| 字段                         | 说明        | 类型   | 是否必需 | 备注                                 |
| ---------------------------- | ----------- | ------ | -------- | ------------------------------------ |
| id                           | 课程id      | int    | 否       | 添加操作不用携带, 修改操作必须携带ID |
| courseName                   | 课程名称    | String | 是       |                                      |
| brief                        | 课程简介    | String | 是       | 一句话介绍课程                       |
| teacherName                  | 讲师名称    | String | 是       |                                      |
| description                  | 讲师介绍    | String | 是       |                                      |
| position                     | 讲师职位    | String | 是       |                                      |
| previewFirstField            | 课程概述1   | String | 是       | 第一段描述 例如: 课程共15讲          |
| previewSecondField           | 课程概述2   | String | 是       | 第二段描述 例如: 每周五更新          |
| discounts                    | 售卖价格    | double | 是       | 课程的售卖价格                       |
| price                        | 商品原价    | double | 是       | 课程的原销售价                       |
| discountsTag                 | 活动标签    | String | 是       | 例如: 立即抢购                       |
| courseImgUrl                 | 课程图片url | String | 是       |                                      |
| courseListImg                | 封面图url   | String | 是       |                                      |
| sortNum                      | 课程排序    | int    | 是       |                                      |
| course_description_mark_down | 课程描述    | String | 是       |                                      |
| sales                        | 销量        | int    | 是       |                                      |

**请求示例**

```json
//新增
{
    "courseName":"大数据云计算",
    "brief":"海量大数据课程",
    "teacherName":"维尼",
    "description":"多年企业实战经验",
    "position":"高级讲师",
    "previewFirstField":"共10讲",
    "previewSecondField":"每周四更新",
    "discounts":66.6,
    "price":88,
    "discountsTag":"先到先得",
    "courseImgUrl":"http://localhost:8080/upload/1596520226925.jpg",
    "courseListImg":"http://localhost:8080/upload/1596520226925.jpg",
    "sortNum":1,
    "courseDescriptionMarkDown":"介绍当前流行大数据技术，数据技术原理，并介绍其思想，介绍大数据技术培训课程，概要介绍。",
    "sales":100
}

//修改
{
	"id":15,
    "courseName":"全栈工程师",
    "brief":"掌握多种技能，胜任前端与后端",
    "teacherName":"药水哥",
    "description":"多年企业实战经验",
    "position":"高级讲师",
    "previewFirstField":"共10讲",
    "previewSecondField":"每周四更新",
    "discounts":66.6,
    "price":88,
    "discountsTag":"先到先得",
    "courseImgUrl":"http://localhost:8080/upload/1596520226925.jpg",
    "courseListImg":"http://localhost:8080/upload/1596520226925.jpg",
    "sortNum":1,
    "courseDescriptionMarkDown":"介绍当前流行大数据技术，数据技术原理，并介绍其思想，介绍大数据技术培训课程，概要介绍。",
    "sales":100
}
```



**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": null
}
```

### 1.4 根据id查询课程信息

- 名称: **findCourseById**
- 描述: 根据id查询课程信息
- URL: http://localhost:8080/ssm-web/course/findCourseById
- 请求方式: GET
- 请求实例：http://localhost:8080/ssm-web/course/findCourseById?id=16
- 请求参数

| 字段 | 说明   | 类型 | 是否必需 | 备注 |
| ---- | ------ | ---- | -------- | ---- |
| id   | 课程id | int  | 是       |      |

- 响应结果示例

```
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": 课程信息
}
```



### 1.5 课程状态管理

**接口地址**: http://localhost:8080/ssm-web/course/updateCourseStatus

**请求方式**: GET

**接口描述**: 修改课程状态

**请求参数**: 

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | 备注         |
| -------- | -------- | ---- | -------- | -------- | ------------ |
| id       | 课程id   |      | true     | int      |              |
| status   | 课程状态 |      | true     | int      | 最新的状态值 |

**请求示例:**

```
http://localhost:8080/ssm-web/course/updateCourseStatus?status=1&id=15
```

**响应参数:**

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例:**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "status": 1
    }
}
```



### 1.6 课程内容展示

**接口地址**: http://localhost:8080/ssm-web/courseContent/findSectionAndLesson

**请求方式**: GET

**接口描述**: 根据课程ID查询章节与课时信息

**请求参数**: 

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| courseId | 课程id   |      | true     | int      |        |

- 请求示例

```
http://localhost:8080/ssm-web/courseContent/findSectionAndLesson?courseId=7
```



- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": [
        {
            "id": 7,
            "courseId": 7,
            "sectionName": "开篇词 | 从小白到文案高手，手把手教你写出爆款文案",
            "description": "你好，我是兔妈！第一次见面，我用几句话简单介绍下自己",
            "createTime": null,
            "updateTime": null,
            "isDe": 0,
            "orderNum": 1,
            "status": 2,
            "lessonList": [
                {
                    "id": 9,
                    "courseId": 7,
                    "sectionId": 7,
                    "theme": "手把手教你写出爆款文案",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 1,
                    "status": 2
                },
                {
                    "id": 8,
                    "courseId": 7,
                    "sectionId": 7,
                    "theme": "从小白到文案高手",
                    "duration": 0,
                    "isFree": 1,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 1,
                    "status": 2
                }
            ]
        },
        {
            "id": 8,
            "courseId": 7,
            "sectionName": "重点内容总结",
            "description": "重点内容总结",
            "createTime": null,
            "updateTime": null,
            "isDe": 0,
            "orderNum": 2,
            "status": 2,
            "lessonList": [
                {
                    "id": 11,
                    "courseId": 7,
                    "sectionId": 8,
                    "theme": "内容总结",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 2,
                    "status": 2
                },
                {
                    "id": 10,
                    "courseId": 7,
                    "sectionId": 8,
                    "theme": "重点内容",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 2,
                    "status": 2
                }
            ]
        }
    ]
}
```

### 1.7 回显章节对应的课程信息

- 名称: **findCourseById**
- 描述:  回显章节对应的课程信息
- URL: http://localhost:8080/ssm-web/courseContent/findCourseByCourseId
- 请求方式: GET
- 请求参数

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| courseId | 课程id   |      | true     | int      |        |

- 请求示例

```
http://localhost:8080/ssm-web/courseContent/findCourseByCourseId?courseId=15
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "id": 19,
        "courseName": "全栈工程师",
    }
}
```

### 1.8 新建&修改章节信息

- 名称: **saveOrUpdateSection**
- 描述: 保存和修改章节信息
- URL: http://localhost:8080/ssm-web/courseContent/saveOrUpdateSection
- 请求方式: POST
- 请求参数

| 字段         | 说明     | 类型   | 是否必需 | 备注                                 |
| ------------ | -------- | ------ | -------- | ------------------------------------ |
| id           | 章节ID   | int    | 否       | 添加操作不携带id, 修改操作必须携带ID |
| course_id    | 课程ID   | int    | 是       |                                      |
| section_name | 章节名称 | String | 是       |                                      |
| description  | 章节描述 | String | 是       |                                      |
| order_num    | 章节排序 | int    | 是       |                                      |

- 请求参数示例

```json
//新增
{
    "courseId":8,
    "sectionName":"Vue脚手架",
    "description":"快速搭建Vue项目",
    "orderNum":2
}

//修改
{
	"id":13,
    "sectionName":"Vue路由",
    "description":"单页面应用导航",
    "orderNum":0
}
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": null
}
```

### 1.9 修改章节状态

- 名称: **updateSectionStatus**
- 描述: 修改章节状态
- URL: http://localhost:8080/ssm-web/courseContent/updateSectionStatus
- 请求方式: GET
- 请求参数

| 字段   | 说明     | 类型 | 是否必需 | 备注                               |
| ------ | -------- | ---- | -------- | ---------------------------------- |
| id     | 章节ID   | int  | 是       |                                    |
| status | 章节状态 | int  | 是       | 状态，0:隐藏；1：待更新；2：已发布 |

- 请求示例

```
http://localhost:8080/ssm-web/courseContent/updateSectionStatus?id=7&status=1
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "status": 1
    }
}
```

### 2.0 新建课时信息

- 名称: **saveOrUpdateLesson**
- 描述: 保存和修改课时信息
- URL: http://localhost:8080/ssm-web/courseContent/saveLesson 
- 请求方式: POST
- 请求参数

| 字段      | 说明                   | 类型   | 是否必需 | 备注                                 |
| --------- | ---------------------- | ------ | -------- | ------------------------------------ |
| id        | 课时ID                 | int    | 否       | 添加操作不携带id, 修改操作必须携带ID |
| courseId  | 课程ID                 | int    | 是       |                                      |
| sectionId | 章节ID                 | int    | 是       |                                      |
| theme     | 课时名称               | String | 是       |                                      |
| duration  | 课时时长(分钟)         | int    | 是       |                                      |
| isFree    | 是否免费,0 免费,1 付费 | int    | 是       |                                      |
| orderNum  | 排序字段               | int    | 是       |                                      |

- 请求示例

```json
//新建
{
    "courseId":7,
    "sectionId":7,
    "theme":"文案高手养成",
    "duration":15,
    "isFree":0,
    "orderNum":2
}


```



## 2.广告模块

### 2.1 广告位列表查询

**接口地址**: <http://localhost:8080/ssm-web/PromotionSpace/findAllPromotionSpace>

**请求方式**: GET

**接口描述**: 获取广告位列表数据

**请求示例:**

```
http://localhost:8080/ssm-web/PromotionSpace/findAllPromotionSpace
```

**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

 **响应示例**: 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": [{
		"id": 1,
		"name": "首页顶部推荐位",
		"spaceKey": "666",
		"createTime": 1594703011000,
		"updateTime": 1594962801000,
		"isDel": 0
	},
	{
		"id": 2,
		"name": "首页侧边广告位",
		"spaceKey": "888",
		"createTime": 1594703011000,
		"updateTime": 1594957982000,
		"isDel": 0
	}......
}
```



### 2.2 添加&修改广告位

**接口地址**: <http://localhost:8080/ssm-web/PromotionSpace/saveOrUpdatePromotionSpace>

**请求方式**: POST

**接口描述**: 添加&修改广告位

**请求参数**:

| 参数名称 | 参数说明   | in   | 是否必须 | 数据类型 | 备注           |
| -------- | ---------- | ---- | -------- | -------- | -------------- |
| id       | 广告位ID   |      | 否       |          | 修改必须携带ID |
| name     | 广告位名称 |      | 是       |          |                |

```java
// 新增
{
	"name": "页面头部广告位"
}
// 更新
{
    "id":173,
	"name": "页面头部广告位"
}
```



**响应参数**: 

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

 **响应示例**: 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": null
}
```



### 2.3 回显广告位名称

**接口地址**: <http://localhost:8080/ssm-web/PromotionSpace/findPromotionSpaceById>

**请求方式**: GET

**接口描述**: 修改操作,回显广告位名称

**请求参数**:

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | 备注           |
| -------- | -------- | ---- | -------- | -------- | -------------- |
| id       | 广告位ID |      | 否       |          | 修改必须携带ID |

**响应结果:** 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"id": 1,
		"name": "首页顶部推荐位",
		"spaceKey": null,
		"createTime": null,
		"updateTime": null,
		"isDel": null
	}
}
```



### 2.4 广告分页查询

**接口地址**:  <http://localhost:8080/ssm-web/PromotionAd/findAllPromotionAdByPage

**请求方式**: GET

**接口描述**: 分页获取广告列表数据

**请求参数**:

| 参数名称    | 参数说明     | in   | 是否必须 | 数据类型       | schema |
| ----------- | ------------ | ---- | -------- | -------------- | ------ |
| currentPage | 当前页       |      | false    | integer(int32) |        |
| pageSize    | 每页显示条数 |      | false    | integer(int32) |        |

**请求示例**: 

```
http://localhost:8080/ssm-web/PromotionAd/findAllPromotionAdByPage?currentPage=1&pageSize=5
```

**响应结果示例: **

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"pageNum": 1,
		"pageSize": 5,
		"size": 5,
		"orderBy": null,
		"startRow": 1,
		"endRow": 5,
		"total": 17,
		"pages": 4,
		"list": [{
			"id": 1074,
			"name": "java高级训练营",
			"spaceId": 1,
			"keyword": null,
			"htmlContent": null,
			"text": "Java高级训练营 Java高级训练营 Java高级训练营",
			"link": "https://localhost:8080/upload",
			"startTime": 1597634487000,
			"endTime": 1597741425000,
			"status": 0,
			"createTime": 1594708114000,
			"updateTime": 1597636191000,
			"priority": 0,
			"img": "http://localhost:8080/upload/1597634499619.jpg"
		}......
}
```

### 2.5 图片上传接口

**接口地址**: <http://localhost:8080/ssm-web/PromotionAd/PromotionAdUpload>

**请求方式**: POST

**接口描述**: 广告模块图片上传

**请求参数:**

```
file
```

**响应参数**: 

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应结果示例:**

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"fileName": "1597730889723.jpg",
		"filePath": "http://localhost:8080/upload/1597730889723.jpg"
	}
}
```

### 2.6 新建&修改广告接口

**接口地址**: <http://localhost:8080/ssm-web/PromotionAd/saveOrUpdatePromotionAd>

**请求方式**: POST

**接口描述**: 新建&修改广告接口

**请求参数**: 

| 字段      | 说明      | 类型   | 是否必需 | 备注                                 |
| --------- | --------- | ------ | -------- | ------------------------------------ |
| id        | 广告id    | int    | 否       | 添加操作不用携带, 修改操作必须携带ID |
| name      | 广告名称  | String | 是       |                                      |
| spaceId   | 广告位置  | String | 否       |                                      |
| startTime | 开始时间  | Date   | 是       |                                      |
| endTime   | 到期时间  | Date   | 是       |                                      |
| status    | 上线/下线 | int    | 否       |                                      |
| img       | 广告图片  | String | 否       |                                      |
| link      | 广告链接  | String | 是       |                                      |
| text      | 广告备注  | String | 否       |                                      |

**请求示例:** 

```json
//新增
{
	name: "Python高级训练营",
	img: "http://localhost:8080/upload/1597731135966.jpg",
	link: "www.xxxx.com",
	sort: 0,
	spaceId: 1,
	startTime: "2020-08-18T06:12:08.000Z",
	endTime: "2020-08-19T16:00:00.000Z",
	status: 1,
	text: "大家一起学Python"
}

//修改
{
	id: 1091,
	img: "http://localhost:8080/upload/1597731135966.jpg",
	link: "www.xxxx.com",
	name: "Python高级训练营01",
	status: 1,
	spaceId: 2,
	startTime: 1597731128000,
	endTime: 1597852800000,
	text: "大家一起学Python1111" 
}
```

### 2.7 修改回显广告信息接口

**接口地址**: <http://localhost:8080/ssm-web/PromotionAd/findPromotionAdById>

**请求方式**: GET

**接口描述**: 接收广告ID,返回广告详细信息

**请求参数**: 

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| id       | 广告id   |      | true     | int      |        |

**请求示例**

```
http://10.1.194.181:8080/ssm-web/PromotionAd/findPromotionAdById?id=1091
```

**响应结果示例** 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"id": 1091,
		"name": "Python高级训练营",
		"spaceId": 1,
		"keyword": null,
		"htmlContent": null,
		"text": "大家一起学Python",
		"link": "www.xxxx.com",
		"startTime": 1597731128000,
		"endTime": 1597852800000,
		"status": 1,
		"createTime": null,
		"updateTime": null,
		"priority": null,
		"img": "http://localhost:8080/upload/1597731135966.jpg"
	}
}
```

### 2.8 广告状态上下线

**接口地址**: <http://localhost:8080/ssm-web/PromotionAd/updatePromotionAdStatus>

**请求方式**: GET

**接口描述**: 修改广告上下线状态

**请求参数**:

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| id       | 广告id   |      | true     | int      |        |
| status   | 课程状态 |      | true     | int      |        |

**请求参数示例**

```
http://localhost:8080/ssm-web/PromotionAd/updatePromotionAdStatus?id=1074&status=1
```

**响应示例:** 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"status": 1
	}
}
```

## 3.用户模块

### 3.1 用户分页&条件查询

**接口地址**:  http://localhost:8080/ssm-web/user/findAllUserByPage

**请求方式**: POST

**接口描述**: 分页获取用户数据&条件查询用户数据

**请求参数**:

| 参数名称        | 参数说明     | in   | 是否必须 | 数据类型       | 备注           |
| --------------- | ------------ | ---- | -------- | -------------- | -------------- |
| currentPage     | 当前页       |      | false    | integer(int32) |                |
| pageSize        | 每页显示条数 |      | false    | integer(int32) |                |
| username        | 用户名       |      | false    | String         | 输入手机号即可 |
| startCreateTime | 注册起始时间 |      | false    | Date           |                |
| endCreateTime   | 注册结束时间 |      | false    | Date           |                |

**请求参数示例**:

```json
{
	"currentPage": "1",
	"pageSize": "10",
	"endCreateTime": "2020-07-13",
	"startCreateTime": "2020-07-09",
	"username": "15321919577"
}
```

### 3.2 用户状态设置

**接口地址**: http://localhost:8080/ssm-web/user/updateUserStatus

**请求方式**: GET

**接口描述**: 修改用户状态

**请求参数**:

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型       | 备注                                    |
| -------- | -------- | ---- | -------- | -------------- | --------------------------------------- |
| id       | 用户id   |      | 是       | integer(int32) |                                         |
| status   | 用户状态 |      | 是       | String         | 用户状态：ENABLE能登录，DISABLE不能登录 |

**请求参数示例:**

```
http://10.1.194.181:8080/ssm-web/user/updateUserStatus?id=100030011&status=ENABLE
```

**响应参数示例:**

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": "DISABLE"
}
```

## 4.权限模块

### 4.1 角色模块

#### 4.1.1 角色列表查询&条件查询

- 名称: **findAllRole**
- 描述: 查询菜单列表
- URL: http://localhost:8080/ssm-web/role/findAllRole
- 请求方式: POST
- 请求参数

```
{name:"角色名称"}
```

- 响应结果示例

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": [{
		"id": 1,
		"code": "ADMIN",
		"name": "超级管理员",
		"description": "后台管理员，初始拥有权限管理功能",
		"createdTime": 1595230889000,
		"updatedTime": 1595230889000,
		"createdBy": "system",
		"updatedBy": "system"
	}
	......
}
```

#### 4.1.2 添加&修改角色

- 名称: **saveOrUpdateRole**
- 描述: 根据菜单ID 查询菜单信息
- URL: http://localhost:8080/ssm-web/role/saveOrUpdateRole
- 请求方式: POST
- 请求参数

| 参数名称    | 参数说明 | in   | 是否必须 | 数据类型 | 备注           |
| ----------- | -------- | ---- | -------- | -------- | -------------- |
| id          | 角色ID   |      | false    | int      | 修改操作携带ID |
| name        | 角色名称 |      | true     | String   |                |
| code        | 角色编码 |      | true     | String   |                |
| description | 角色描述 |      | true     | String   |                |

- 请求参数示例

```json
// 添加
{
	"name":"资源管理员",
	"code": "RE_MANAGER",
	"description": "管理资源"
}

// 更新
{
	"id":"6"
	"name":"资源管理员",
	"code": "RE_MANAGER",
	"description": "管理资源"
}
```

- **响应参数:**

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

- **响应示例:**

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": ""
}
```

#### 4.1.3 分配菜单

##### 接口1 查询所有菜单列表

- 名称: **findAllMenu**
- 描述: 为角色分配菜单
- URL: http://localhost:8080/ssm-web/role/findAllMenu
- 请求方式: GET
- 请求参数示例:

```
http://localhost:8080/ssm-web/role/findAllMenu
```

- 响应结果示例

content内容为 前端所需的JSON格式菜单数据, 方便在树形空间中展示

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"parentMenuList": [{
			"id": 1,
			"parentId": -1,
			"href": "",
			"icon": "lock",
			"name": "权限管理",
			"description": "管理系统角色、菜单、资源",
			"orderNum": 1,
			"shown": 1,
			"level": 0,
			"createdTime": 1595230898000,
			"updatedTime": 1595230898000,
			"createdBy": "system",
			"updatedBy": "system",
			"subMenuList": [{
				"id": 2,
				"parentId": 1,
				"href": "Role",
				"icon": "lock",
				"name": "角色列表",
				"description": "管理系统角色",
				"orderNum": 1,
				"shown": 1,
				"level": 1,
				"createdTime": 1595230898000,
				"updatedTime": 1595230898000,
				"createdBy": "system",
				"updatedBy": "system",
				"subMenuList": []
			}]
}]
```

##### 接口2  根据角色ID查询关联菜单ID

- 名称: **findMenuByRoleId**
- 描述: 根据角色信息查询关联菜单
- URL: http://localhost:8080/ssm-web/role/findMenuByRoleId?roleId=4
- 请求方式: GET
- 请求示例:

```
http://10.1.194.181:8080/ssm-web/role/findMenuByRoleId?roleId=1
```

- 响应结果示例

content中的内容为: 当前角色关联的菜单ID

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": ["1","2","3","4","10"]
}
```

##### 接口3 为角色分配菜单列表

- 名称: RoleContextMenu
- 描述: 为角色分配菜单
- URL: http://localhost:8080/ssm-web/role/RoleContextMenu
- 请求方式: POST
- 请求参数:

| 参数名称   | 参数说明         | 是否必须 | 数据类型 | 备注 |
| ---------- | ---------------- | -------- | -------- | ---- |
| roleId     | 角色id           | true     | int      |      |
| menuIdList | 所选的菜单列表id | true     | List     |      |

- 请求参数示例:

```json
{
	"roleId": 4, 
	"menuIdList": [7, 8, 9, 15, 16, 17, 18]
}
```

- 响应参数示例: 

```json
{"success":true,"state":200,"message":"响应成功","content":""}
```

#### 4.1.4 删除角色

- 名称: **deleteRole**
- 描述: 删除角色
- URL: <http://localhost:8080/ssm-web/role/deleteRole?id=5>
- 请求方式: GET
- 请求示例

```
http://localhost:8080/ssm-web/role/deleteRole?id=5
```

- 响应示例:

```
{"success":true,"state":200,"message":"响应成功","content":""}
```

### 4.2 菜单模块

#### 4.2.1 菜单列表查询

- 名称: **findAllMenu**
- 描述: 查询菜单列表
- URL: <http://localhost:8080/ssm-web/menu/findAllMenu> 
- 请求方式: GET
- 请求参数示例

```
http://10.1.194.181:8080/ssm-web/menu/findAllMenu?currentPage=1&pageSize=10
```

- 响应结果示例 

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"pageNum": 1,
		"pageSize": 10,
		"size": 10,
		"orderBy": null,
		"startRow": 1,
		"endRow": 10,
		"total": 26,
		"pages": 3,
		"list": [{
			"id": 1,
			"parentId": -1,
			"href": "",
			"icon": "lock",
			"name": "权限管理",
			"description": "管理系统角色、菜单、资源",
			"orderNum": 1,
			"shown": 1,
			"level": 0,
			"createdTime": 1595230898000,
			"updatedTime": 1595230898000,
			"createdBy": "system",
			"updatedBy": "system",
			"subMenuList": []
		},
		{
			"id": 2,
			"parentId": 1,
			"href": "Role",
			"icon": "lock",
			"name": "角色列表",
			"description": "管理系统角色",
			"orderNum": 1,
			"shown": 1,
			"level": 1,
			"createdTime": 1595230898000,
			"updatedTime": 1595230898000,
			"createdBy": "system",
			"updatedBy": "system",
			"subMenuList": []
		}......]
	}
}
```

#### 4.2.2 查询菜单信息(回显)

- 名称: **findMenuInfoById**
- 描述: 根据菜单ID 查询菜单信息
- URL: http://localhost:8080/ssm-web/menu/findMenuInfoById
- 请求方式: GET
- 请求参数

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | 备注                                                        |
| -------- | -------- | ---- | -------- | -------- | ----------------------------------------------------------- |
| id       | 菜单id   |      | true     | int      | 如果是新增菜单,则id值为 -1, <br>修改菜单 则为当前选择的id值 |

- 响应结果

| 参数名称       | 参数说明     | 类型           | 备注                       |
| -------------- | ------------ | -------------- | -------------------------- |
| success        |              | boolean        |                            |
| state          |              | integer(int32) |                            |
| message        |              | string         |                            |
| content        |              | object         |                            |
| menuInfo       | 菜单信息     | Menu           | 修改操作需要回显的菜单信息 |
| parentMenuList | 菜单列表信息 | List<Menu      | 所有的父子菜单列表信息     |

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "menuInfo": {
            "id": 7,
            "parentId": -1,
            "href": "",
            "icon": "setting",
            "name": "广告管理",
            "description": "广告、广告位管理",
            "orderNum": 4,
            "shown": 1,
            "level": 0,
            "createdTime": 1595230898000,
            "updatedTime": 1595230898000,
            "createdBy": "system",
            "updatedBy": "system",
            "subMenuList": []
        },
        "parentMenuList": [
            {
                "id": 1,
                "parentId": -1,
                "href": "",
                "icon": "lock",
                "name": "权限管理",
                "description": "管理系统角色、菜单、资源",
                "orderNum": 1,
                "shown": 1,
                "level": 0,
                "createdTime": 1595230898000,
                "updatedTime": 1595230898000,
                "createdBy": "system",
                "updatedBy": "system",
                "subMenuList": [
                    {
                        "id": 2,
                        "parentId": 1,
                        "href": "Role",
                        "icon": "lock",
                        "name": "角色列表",
                        "description": "管理系统角色",
                        "orderNum": 1,
                        "shown": 1,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 3,
                        "parentId": 1,
                        "href": "Menu",
                        "icon": "lock",
                        "name": "菜单列表",
                        "description": "管理系统菜单",
                        "orderNum": 2,
                        "shown": 1,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 4,
                        "parentId": 1,
                        "href": "Resource",
                        "icon": "lock",
                        "name": "资源列表",
                        "description": "管理系统资源",
                        "orderNum": 3,
                        "shown": 1,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 10,
                        "parentId": 1,
                        "href": "AllocMenu",
                        "icon": "setting",
                        "name": "给角色分配菜单页面",
                        "description": "给角色分配菜单页面路由",
                        "orderNum": 4,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 11,
                        "parentId": 1,
                        "href": "AllocResource",
                        "icon": "setting",
                        "name": "给角色分配资源页面",
                        "description": "给角色分配资源页面路由",
                        "orderNum": 5,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 12,
                        "parentId": 1,
                        "href": "AddMenu",
                        "icon": "setting",
                        "name": "添加菜单页面",
                        "description": "添加菜单页路由",
                        "orderNum": 6,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 13,
                        "parentId": 1,
                        "href": "UpdateMenu",
                        "icon": "setting",
                        "name": "更新菜单页面",
                        "description": "更新菜单页路由",
                        "orderNum": 7,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 14,
                        "parentId": 1,
                        "href": "ResourceCategory",
                        "icon": "setting",
                        "name": "资源分类列表页面",
                        "description": "资源分类列表页面路由",
                        "orderNum": 8,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    }
                ]
            },
            {
                "id": 5,
                "parentId": -1,
                "href": "Courses",
                "icon": "film",
                "name": "课程管理",
                "description": "课程的新增、修改、查看、发布、上下架",
                "orderNum": 2,
                "shown": 1,
                "level": 0,
                "createdTime": 1595230898000,
                "updatedTime": 1595230898000,
                "createdBy": "system",
                "updatedBy": "system",
                "subMenuList": [
                    {
                        "id": 19,
                        "parentId": 5,
                        "href": "CourseItem",
                        "icon": "setting",
                        "name": "课程详情页面",
                        "description": "课程详情页面路由",
                        "orderNum": 1,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 20,
                        "parentId": 5,
                        "href": "CourseSections",
                        "icon": "setting",
                        "name": "课时信息页面",
                        "description": "课时信息页面路由",
                        "orderNum": 2,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 21,
                        "parentId": 5,
                        "href": "VideoOptions",
                        "icon": "setting",
                        "name": "课时上传视频",
                        "description": "课时上传视频页面路由",
                        "orderNum": 3,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    }
                ]
            },
            {
                "id": 6,
                "parentId": -1,
                "href": "Users",
                "icon": "user",
                "name": "用户管理",
                "description": "用户的查询、禁用、启用",
                "orderNum": 3,
                "shown": 1,
                "level": 0,
                "createdTime": 1595230898000,
                "updatedTime": 1595230898000,
                "createdBy": "system",
                "updatedBy": "system",
                "subMenuList": []
            },
            {
                "id": 7,
                "parentId": -1,
                "href": "",
                "icon": "setting",
                "name": "广告管理",
                "description": "广告、广告位管理",
                "orderNum": 4,
                "shown": 1,
                "level": 0,
                "createdTime": 1595230898000,
                "updatedTime": 1595230898000,
                "createdBy": "system",
                "updatedBy": "system",
                "subMenuList": [
                    {
                        "id": 8,
                        "parentId": 7,
                        "href": "Advertise",
                        "icon": "setting",
                        "name": "广告列表",
                        "description": "广告管理",
                        "orderNum": 1,
                        "shown": 1,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 9,
                        "parentId": 7,
                        "href": "AdvertiseSpace",
                        "icon": "setting",
                        "name": "广告位列表",
                        "description": "广告位管理",
                        "orderNum": 2,
                        "shown": 1,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 15,
                        "parentId": 7,
                        "href": "AddAdvertise",
                        "icon": "setting",
                        "name": "添加广告页面",
                        "description": "添加广告页面路由",
                        "orderNum": 3,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 16,
                        "parentId": 7,
                        "href": "UpdateAdvertise",
                        "icon": "setting",
                        "name": "编辑广告页面",
                        "description": "编辑广告页面路由",
                        "orderNum": 4,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 17,
                        "parentId": 7,
                        "href": "AddAdvertiseSpace",
                        "icon": "setting",
                        "name": "添加广告位页面",
                        "description": "添加广告位页面路由",
                        "orderNum": 5,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    },
                    {
                        "id": 18,
                        "parentId": 7,
                        "href": "UpdateAdvertiseSpace",
                        "icon": "setting",
                        "name": "更新广告位页面",
                        "description": "更新广告位页面路由",
                        "orderNum": 6,
                        "shown": 0,
                        "level": 1,
                        "createdTime": 1595230898000,
                        "updatedTime": 1595230898000,
                        "createdBy": "system",
                        "updatedBy": "system",
                        "subMenuList": []
                    }
                ]
            }
        ]
    }
}
```



#### 4.2.3 添加&修改菜单

- 名称: **saveOrUpdateMenu**
- 描述: 保存和修改菜单
- URL: <http://localhost:8080/ssm-web/menu/saveOrUpdateMenu>
- 请求方式: POST
- 请求参数

| 参数名称    | 参数说明         | 是否必须 | 数据类型 | 备注                              |
| ----------- | ---------------- | -------- | -------- | --------------------------------- |
| id          | 菜单列表id       | 否       | int      | 修改操作必须携带id,插入不需要携带 |
| name        | 菜单名称         | 是       | string   |                                   |
| href        | 菜单路径         | 是       | string   |                                   |
| parentId    | 父菜单id         | 是       | int      |                                   |
| description | 描述             | 是       | string   |                                   |
| icon        | 菜单图标         | 是       | string   |                                   |
| shown       | 是否展示         | 是       | int      |                                   |
| orderNum    | 排序号           | 是       | int      |                                   |
| level       | 菜单层级,从0开始 | 是       | int      |                                   |
| createdTime | 创建时间         | 是       | date     |                                   |
| updatedTime | 更新时间         | 是       | date     |                                   |
| createdBy   | 创建人           | 是       | string   |                                   |
| updatedBy   | 更新人           | 是       | string   |                                   |

- 请求示例 

```json
//新增
{
	"description": "设置课程状态",
	"href": "updateStatus",
	"icon": "lock",
	"name": "课程管理状态",
	"orderNum": 3,
	"parentId": 5,
	"shown": 0,
	"level":0,
	"createdTime":"2020-08-10 20:32:41",
	"updatedTime":"2020-08-10 20:32:41",
	"createdBy":"system",
	"updatedBy":"system"
}

//修改
{
	"id":23,
	"description": "设置课程状态修改",
	"href": "updateStatus修改",
	"icon": "lock",
	"name": "课程管理状态修改",
	"orderNum": 3,
	"parentId": 5,
	"shown": 1,
	"level":1,
	"createdTime":"2020-08-10 20:32:41",
	"updatedTime":"2020-08-10 20:32:41",
	"createdBy":"system",
	"updatedBy":"system"
}
```



### 4.3 资源模块

#### 4.3.1 查询资源分类信息

- 名称: **findAllResourceCategory**
- 描述: 查询资源分类信息列表
- URL: http://localhost:8080/ssm-web/ResourceCategory/findAllResourceCategory
- 请求方式: GET
- 请求参数

```
无
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": [
        {
            "id": 1,
            "code": "ADMIN",
            "name": "超级管理员",
            "description": "后台管理员，初始拥有权限管理功能",
            "createdTime": 1595230889000,
            "updatedTime": 1595230889000,
            "createdBy": "system",
            "updatedBy": "system"
        },
        {
            "id": 2,
            "code": "AUTHORITY_MANAGER",
            "name": "权限管理员",
            "description": "管理权限相关数据，如角色、菜单、资源。可以给用户分配角色。",
            "createdTime": 1595202475000,
            "updatedTime": 1595202475000,
            "createdBy": "15510792994",
            "updatedBy": "15510792994"
        },
        {
            "id": 3,
            "code": "COURSE_MANAGER",
            "name": "课程管理员",
            "description": "管理课程信息，对课程、课时、章节进行管理。",
            "createdTime": 1595202724000,
            "updatedTime": 1595202724000,
            "createdBy": "15510792994",
            "updatedBy": "15510792994"
        },
        {
            "id": 4,
            "code": "AD_MANAGER",
            "name": "广告管理员",
            "description": "管理广告、广告位信息",
            "createdTime": 1595202956000,
            "updatedTime": 1595202956000,
            "createdBy": "15510792994",
            "updatedBy": "15510792994"
        }
    ]
}
```



#### 4.3.2 资源信息分页&条件查询

- 名称: **findAllResource**
- 描述: 资源信息分页&条件查询
- URL: http://localhost:8080/ssm-web/resource/findAllResource
- 请求方式: POST
- 请求参数

| 参数名称    | 参数说明     | 类型   | 备注 |
| ----------- | ------------ | ------ | ---- |
| currentPage | 当前页       | int    |      |
| pageSize    | 每页显示条数 | int    |      |
| name        | 资源名称     | string |      |
| categoryId  | 资源分类id   | int    |      |
| url         | 资源路径     | string |      |

- 请求参数示例

```
{
	categoryId: 1,
	currentPage: 1,
	name: "获取所有角色",
	pageSize: 5,
	url: "/boss/role/all"
}
```

- 响应结果示例

```json
{
	"success": true,
	"state": 200,
	"message": "响应成功",
	"content": {
		"pageNum": 1,
		"pageSize": 5,
		"size": 1,
		"orderBy": null,
		"startRow": 1,
		"endRow": 1,
		"total": 1,
		"pages": 1,
		"list": [{
			"id": 1,
			"name": "获取所有角色",
			"url": "/boss/role/all",
			"categoryId": 1,
			"description": "获取所有角色",
			"createdTime": 1595230917000,
			"updatedTime": 1595230917000,
			"createdBy": "system",
			"updatedBy": "system"
		}]
	}
}
```

#### 4.3.3 添加&更新资源信息

- 名称: **saveOrUpdateResource**
- 描述: 添加&更新资源信息
- URL: http://localhost:8080/ssm-web/resource/saveOrUpdateResource
- 请求方式: POST
- 请求参数

| 参数名称    | 参数说明     | in   | 是否必须 | 数据类型 | 备注               |
| ----------- | ------------ | ---- | -------- | -------- | ------------------ |
| id          | 资源id       |      | false    |          | 修改操作需要携带ID |
| name        | 资源名称     |      | true     | String   |                    |
| url         | 资源路径     |      | true     | String   |                    |
| categoryId  | 所属资源分类 |      | true     | Integer  |                    |
| description | 资源描述     |      | true     | String   |                    |

**请求示例:**

```json
// 添加
{
	"name":"获取所有角色2",
	"url": "/boss/role/all",
	"categoryId":"1",
	"description":"获取所有角色1"
}

// 更新
{
	"id":"53",
	"name":"获取所有角色2",
	"url": "/boss/role/all",
	"categoryId":"1",
	"description":"获取所有角色1"

}
```

**响应参数:**

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

#### 4.3.4 删除资源信息

- 名称: **deleteResource**
- 描述: 删除角色
- URL: http://localhost:8080/ssm-web/resource/deleteResource?id=5
- 请求方式: GET

- 请求示例

```
http://localhost:8080/ssm-web/resource/deleteResource?id=5
```

**响应参数:**

## 









































