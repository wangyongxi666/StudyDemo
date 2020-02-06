import formModel from '../constructor/form'
import Utils from 'utils'
import * as tbbrandService from 'services/tbbrand'

export default formModel({
    primaryKey:'name',
    namespace: 'tbbrandEdit',
    state:{
        collapse:[
            {key:'base',label:'基本信息',defaultActive:true},
        ]
    },
    effects: {
        *getBaseData({payload}, {call, put, select}){
            const infoRes = yield tbbrandService.getInfo(payload);
            if (!infoRes.hasError) {
                yield put({
                    type: 'setFormData',
                    payload: infoRes.dto
                })
            }
        },
    }
})
