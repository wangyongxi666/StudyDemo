import listModel from '../constructor/list'
import * as tbbrandService from 'services/tbbrand'

const namespace = 'tbbrand'
const getPage = tbbrandService.getPage

export default listModel({
    // 上面三个是一定要的，一个主键去获取
    namespace,
    primaryKey: 'name',
    getPage,
    state: {
        columns: [
                {title:id,key:id,show:true},
                {title:品牌名称,key:name,show:true},
                {title:品牌首字母,key:firstChar,show:true},
                ],
        // 高级查询的时候的条件过滤
        filters: {
        },
    },

    effects: {
    },
    reducers: {
    },
})
